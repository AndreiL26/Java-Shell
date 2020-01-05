package uk.ac.ucl.jsh.Utilities;

import java.io.File;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Jsh;

public class Globbing {
    private static String fileSeparator = Jsh.fileSeparator;
    private static ArrayList<String> globbedArguments;

    private static void globArgument(String currentGlobbedPath, String unglobbedPath, String startingPath) {
        if(unglobbedPath != "") {
            String globbingPattern, remainingUnglobbedPath;
            if(unglobbedPath.contains(fileSeparator)) {
                globbingPattern = unglobbedPath.substring(0, unglobbedPath.indexOf(fileSeparator));
                remainingUnglobbedPath = unglobbedPath.substring(unglobbedPath.indexOf(fileSeparator) + 1, unglobbedPath.length());
            } 
            else {
                globbingPattern = unglobbedPath;
                remainingUnglobbedPath = "";
            }

            if(globbingPattern.contains("*")) {
                File currentFile = new File(currentGlobbedPath);
                File[] fileArray = currentFile.listFiles();
                PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + globbingPattern);
                for(File file: fileArray) {
                    if(matcher.matches(Paths.get(file.getName()))) {
                        globArgument(currentGlobbedPath + fileSeparator + file.getName(), remainingUnglobbedPath, startingPath);
                    }
                }
            }
            else {
                globArgument(currentGlobbedPath + fileSeparator + globbingPattern, remainingUnglobbedPath, startingPath);
            }

        }
        else {
            String resultingGlobbedPath = Paths.get(startingPath).relativize(Paths.get(currentGlobbedPath)).toString();
            if (startingPath.equals(fileSeparator)) {
                resultingGlobbedPath = fileSeparator + resultingGlobbedPath;
            }
            globbedArguments.add(resultingGlobbedPath);
        }
    }

    public static ArrayList<String> globArguments(ArrayList<String> applicationArguments, int ignoreIndex) {
        globbedArguments = new ArrayList<String>();
        if(applicationArguments.size() == 0) {
            return globbedArguments;
        }
        
        for(int i = 0; i < applicationArguments.size(); ++ i) {
            String currentArgument = applicationArguments.get(i);
            if(i == ignoreIndex) {
                globbedArguments.add(currentArgument);
                continue;
            }

            int globbedArgumentsSize = globbedArguments.size();
            if(currentArgument.contains("*")) {
                if(currentArgument.startsWith(fileSeparator)) {
                    globArgument("", currentArgument, fileSeparator);
                }
                else {
                    globArgument(FileSystem.getInstance().getWorkingDirectoryPath(), currentArgument, FileSystem.getInstance().getWorkingDirectoryPath());
                }

                if(globbedArgumentsSize == globbedArguments.size()) {
                    globbedArguments.add(currentArgument);
                }
            }
            else {
                globbedArguments.add(currentArgument);
            }
        }
        return globbedArguments;
    }
}