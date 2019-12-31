package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

 
public class Cd implements Application {
    private FileSystem fileSystem;

    public Cd(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        if (applicationArguments.isEmpty()) {
            throw new JshException("cd: missing argument");
        } else if (applicationArguments.size() > 1) {
            throw new JshException("cd: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        checkArguments(applicationArguments, inputStream, outputStream);
        String dirString = applicationArguments.get(0);
        File dir;
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();

        dir = FileSystem.getInstance().getFile(dirString);
        if (!dir.isDirectory()) {
            throw new JshException("cd: " + dirString + " is not an existing directory");
        }
        
        try {
            currentDirectoryPath = dir.getCanonicalPath();
        } catch (IOException e) {
            throw new JshException("cd: could not get path");
        }

        fileSystem.setWorkingDirectory(currentDirectoryPath);
    }

}