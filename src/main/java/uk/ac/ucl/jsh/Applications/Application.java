package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.Files;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Application {
    protected FileSystem fileSystem;

    public Application(FileSystem fileSystem) {
        this.fileSystem = fileSystem;     
    }

    private String findGlobbingPath(String argument) {
        String fileSeparator = System.getProperty("file.separator");
        if(argument.startsWith(fileSeparator)) {
            return argument.substring(0, argument.lastIndexOf(fileSeparator, argument.indexOf('*'))).toString();
        }

        return fileSystem.getWorkingDirectoryPath() + fileSeparator + argument.substring(0, argument.lastIndexOf(fileSeparator, argument.indexOf('*'))).toString();
    }


    private void globArgument(String argument, String currentPath, ArrayList<String> globbedArguments) {
        /// Must throw JSH Exception!
        if(argument != "") {
            String currentPart, remainingArgument;
            String fileSeparator = System.getProperty("file.separator");
            if(argument.contains(fileSeparator)) {
                currentPart = argument.substring(0, argument.indexOf(fileSeparator));
                remainingArgument = argument.substring(argument.indexOf(fileSeparator) + 1, argument.length());
            } 
            else {
                currentPart = argument;
                remainingArgument = "";
            }

            if(currentPart.contains("*")) {
                File currentFile = new File(currentPath);
                File[] fileArray = currentFile.listFiles();
                PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + currentPart);
                for(File file: fileArray) {
                    if(matcher.matches(Paths.get(file.getName()))) {
                        globArgument(remainingArgument, currentPath + fileSeparator + file.getName(), globbedArguments);
                    }
                }
            }
            else {
                globArgument(remainingArgument, currentPath, globbedArguments);
            }

        }
        else {
            if(Files.exists(Paths.get(currentPath))) {
                globbedArguments.add(currentPath);
            }
        }
    }

    protected ArrayList<String> globArguments(ArrayList<String> applicationArguments, int ignoreIndex) {
        ArrayList<String> globbedArguments = new ArrayList<String>();
        String fileSeparator = System.getProperty("file.separator");
        fileSystem.setWorkingDirectory("/");

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
                    globArgument(currentArgument, "", globbedArguments);
                }
                else {
                    globArgument(currentArgument, fileSystem.getWorkingDirectoryPath(), globbedArguments);
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

    public abstract void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws IOException;
    
    public abstract void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream); 

}