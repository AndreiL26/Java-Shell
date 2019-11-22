package uk.ac.ucl.jsh;

import java.io.IOException;
import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Parser {
    public static ArrayList<String> getRawCommands(String cmdline) {
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
        
        return rawCommands;
    }
    
    public static ArrayList<String> getTokens(String rawCommand, String currentDirectory) throws IOException {
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
        
        return tokens;
    }
}