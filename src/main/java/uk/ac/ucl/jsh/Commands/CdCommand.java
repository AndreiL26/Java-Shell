package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

 
public class CdCommand extends Command {

    public CdCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) throws IOException {
        checkArguments(commandArguments);
        String dirString = commandArguments.get(0);
        File dir;
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        
        if(dirString.startsWith(System.getProperty("file.separator"))) {
            dir = new File(dirString);
        }
        else {
            dir = new File(currentDirectoryPath, dirString);

        } 
        if (!dir.exists() || !dir.isDirectory()) {
            throw new RuntimeException("cd: " + dirString + " is not an existing directory");
        }
        currentDirectoryPath = dir.getCanonicalPath();
        fileSystem.setWorkingDirectory(currentDirectoryPath);
    }

    public void checkArguments(ArrayList<String> commandArguments) {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("cd: missing argument");
        } else if (commandArguments.size() > 1) {
            throw new RuntimeException("cd: too many arguments");
        }
    }
}