package uk.ac.ucl.jsh.Applications;

import java.io.File;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

public interface Application {
    private static void globArgument(String currentGlobbedPath, String unglobbedPath, ArrayList<String> globbedArguments, String startingPath) {
        if(unglobbedPath != "") {
            String globbingPattern, remainingUnglobbedPath;
            String fileSeparator = Jsh.fileSeparator;
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
                        globArgument(currentGlobbedPath + fileSeparator + file.getName(), remainingUnglobbedPath, globbedArguments, startingPath);
                    }
                }
            }
            else {
                globArgument(currentGlobbedPath + fileSeparator + globbingPattern, remainingUnglobbedPath, globbedArguments, startingPath);
            }

        }
        else {
            String resultingGlobbedPath = Paths.get(startingPath).relativize(Paths.get(currentGlobbedPath)).toString();
            if (startingPath == "/") {
                resultingGlobbedPath = "/" + resultingGlobbedPath;
            }
            globbedArguments.add(resultingGlobbedPath);
        }
    }

    public static ArrayList<String> globArguments(ArrayList<String> applicationArguments, int ignoreIndex) {
        ArrayList<String> globbedArguments = new ArrayList<String>();
        String fileSeparator = Jsh.fileSeparator;
            
        if(applicationArguments.size() == 0) {
            return globbedArguments;
        }
        int numberOfArguments = applicationArguments.size();
        
        for(int i = 0; i < numberOfArguments; ++ i) {
            int crtSize = globbedArguments.size();
            String currentArgument = applicationArguments.get(i);
            if(i == ignoreIndex) {
                globbedArguments.add(currentArgument);
                continue;
            }

            if(currentArgument.contains("*")) {
                if(currentArgument.startsWith(fileSeparator)) {
                    globArgument("", currentArgument, globbedArguments, "/");
                }
                else {
                    globArgument(FileSystem.getInstance().getWorkingDirectoryPath(), currentArgument, globbedArguments, FileSystem.getInstance().getWorkingDirectoryPath());
                }
                if(crtSize == globbedArguments.size()) {
                    globbedArguments.add(applicationArguments.get(i));
                }
            }
            else {
                globbedArguments.add(applicationArguments.get(i));
            }
        }
        return globbedArguments;
    }

    public abstract void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws JshException;
}