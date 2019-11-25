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
    public static Node getCmdTree(String cmdline) {
        Node cmdTreeRoot = buildCmdTree(new StringBuilder(cmdline));
        return cmdTreeRoot;
    }

    private static Node buildCmdTree(StringBuilder stringBuilder) {
         if (hasDelimiter(stringBuilder, ';')) {
            StringBuilder firstPart = extractFirstPart(stringBuilder, ';');
            return new SeqNode(buildCmdTree(firstPart), buildCmdTree(stringBuilder));
         }

         if (hasDelimiter(stringBuilder, '|')) {
            StringBuilder firstPart = extractFirstPart(stringBuilder, '|');
            return new PipeNode(buildCmdTree(firstPart), buildCmdTree(stringBuilder));
         }
        
         return new CallNode(stringBuilder.toString());
    }

    private static boolean hasDelimiter(StringBuilder cmdStringBuilder, char delimiter) {
        int closingPairIndex, prevDelimiterIndex = 0, splitIndex = 0;
		for (splitIndex = 0; splitIndex < cmdStringBuilder.length(); splitIndex++) {
            char ch = cmdStringBuilder.charAt(splitIndex);
			if (ch == delimiter) {
				return true;
			} else if (ch == '\'' || ch == '\"') {
				closingPairIndex = cmdStringBuilder.indexOf(String.valueOf(ch), splitIndex + 1);
				if (closingPairIndex == -1) {
					continue;
				} else {
					splitIndex = closingPairIndex;
				}
			}
        }

        return false;
    }

    private static StringBuilder extractFirstPart(StringBuilder cmdStringBuilder, char delimiter) {
        int closingPairIndex, prevDelimiterIndex = 0, splitIndex = 0;
		for (splitIndex = 0; splitIndex < cmdStringBuilder.length(); splitIndex++) {
            char ch = cmdStringBuilder.charAt(splitIndex);
			if (ch == delimiter) {
                String command = cmdStringBuilder.substring(prevDelimiterIndex, splitIndex).trim();
                cmdStringBuilder.delete(0, splitIndex + 1);
				return new StringBuilder(command);
			} else if (ch == '\'' || ch == '\"') {
				closingPairIndex = cmdStringBuilder.indexOf(String.valueOf(ch), splitIndex + 1);
				if (closingPairIndex == -1) {
					continue;
				} else {
					splitIndex = closingPairIndex;
				}
			}
        }
        
        String command = cmdStringBuilder.toString();
        cmdStringBuilder = null;
        return new StringBuilder(command);
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
                System.out.println(nonQuote);
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