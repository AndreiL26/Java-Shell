package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

 
public class Cd extends Application {

    public Cd(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        applicationArguments = this.globArguments(applicationArguments);
        checkArguments(applicationArguments, inputStream, outputStream);
        String dirString = applicationArguments.get(0);
        File dir;
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();

        if(dirString.startsWith(System.getProperty("file.separator"))) {
            dir = new File(dirString);
        }
        else {
            dir = new File(currentDirectoryPath, dirString);

        } 
        if (!dir.isDirectory()) {
            throw new RuntimeException("cd: " + dirString + " is not an existing directory");
        }
        currentDirectoryPath = dir.getCanonicalPath();
        fileSystem.setWorkingDirectory(currentDirectoryPath);
    }

    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if (applicationArguments.isEmpty()) {
            throw new RuntimeException("cd: missing argument");
        } else if (applicationArguments.size() > 1) {
            throw new RuntimeException("cd: too many arguments");
        }
    }
}