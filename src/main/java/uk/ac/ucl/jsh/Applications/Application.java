package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

public abstract class Application {
    protected FileSystem fileSystem;

    public Application(FileSystem fileSystem) {
        this.fileSystem = fileSystem;     
    }

    protected ArrayList<String> globArguments(ArrayList<String> applicationArguments) {
        ArrayList<String> globbedArguments = new ArrayList<String>();
        globbedArguments.add(applicationArguments.get(0)); // The command added in special case to avoid bugs where * would match a file with a command name
        File currentFile = new File(fileSystem.getWorkingDirectoryPath());
        File[] fileArray = currentFile.listFiles();
        for(int i = 1; i < applicationArguments.size(); ++ i) {
            if(applicationArguments.get(i).contains("*")) {
                PathMatcher matcher = FileSystems.getDefault().getPathMatcher("glob:" + applicationArguments.get(i));
                for(File file: fileArray) {
                    if(matcher.matches(Paths.get(file.getName()))) {
                        globbedArguments.add(file.getName());
                    }
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