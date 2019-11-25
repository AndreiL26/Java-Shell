package uk.ac.ucl.jsh;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jsh {

    private static FileSystem fileSystem = new FileSystem();
    private static String currentDirectory = System.getProperty("user.dir");
    private static CommandManager commandManager;
    

    public static void eval(String cmdline, OutputStream output) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(output);

        commandManager = new CommandManager(fileSystem, writer); // TIGANIE!

        ArrayList<String> rawCommands = new ArrayList<String>();
		int closingPairIndex, prevDelimiterIndex = 0, splitIndex = 0;
		for (splitIndex = 0; splitIndex < cmdline.length(); splitIndex++) {
			char ch = cmdline.charAt(splitIndex);
			if (ch == ';') {
				String command = cmdline.substring(prevDelimiterIndex, splitIndex).trim();
				rawCommands.add(command);
				prevDelimiterIndex = splitIndex + 1;
			} else if (ch == '\'' || ch == '\"') {
				closingPairIndex = cmdline.indexOf(ch, splitIndex + 1);
				if (closingPairIndex == -1) {
					continue;
				} else {
					splitIndex = closingPairIndex;
				}
			}
		}
		if (!cmdline.isEmpty() && prevDelimiterIndex != splitIndex) {
			String command = cmdline.substring(prevDelimiterIndex).trim();
			if (!command.isEmpty()) {
				rawCommands.add(command);
			}
		}
        for (String rawCommand : rawCommands) {
            String spaceRegex = "[^\\s\"']+|\"([^\"]*)\"|'([^']*)'";
            ArrayList<String> tokens = new ArrayList<String>();
            Pattern regex = Pattern.compile(spaceRegex);
            Matcher regexMatcher = regex.matcher(rawCommand);
            String nonQuote;
            while (regexMatcher.find()) {
                if (regexMatcher.group(1) != null || regexMatcher.group(2) != null) {
                    String quoted = regexMatcher.group(0).trim();
                    tokens.add(quoted.substring(1,quoted.length()-1));
                } else {
                    nonQuote = regexMatcher.group().trim();
                    ArrayList<String> globbingResult = new ArrayList<String>();
                    Path dir = Paths.get(currentDirectory);
                    DirectoryStream<Path> stream = Files.newDirectoryStream(dir, nonQuote);
                    for (Path entry : stream) {
                        globbingResult.add(entry.getFileName().toString());
                    }
                    if (globbingResult.isEmpty()) {
                        globbingResult.add(nonQuote);
                    }
                    tokens.addAll(globbingResult);
                }
            }
            commandManager.executeCommand(tokens);
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args.length != 2) {
                System.out.println("jsh: wrong number of arguments");
                return;
            }
            if (!args[0].equals("-c")) {
                System.out.println("jsh: " + args[0] + ": unexpected argument");
            }
            try {
                eval(args[1], System.out);
            } catch (Exception e) {
                System.out.println("jsh: " + e.getMessage());
            }
        } else {
            System.out.println("Hello World!");
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    String prompt = currentDirectory + "> ";
                    System.out.print(prompt);
                    try {
                        String cmdline = input.nextLine();
                        eval(cmdline, System.out);
                    } catch (Exception e) {
                        System.out.println("jsh: " + e.getMessage());
                    }
                }
            } finally {
                input.close();
            }
        }
    }

}
