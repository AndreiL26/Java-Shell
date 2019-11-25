package uk.ac.ucl.jsh;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
 
public class CdCommand extends Command {

    public CdCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() throws IOException {
        checkArguments();
        String dirString = commandArguments.get(0);
        File dir;
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        
        if(dirString.charAt(0) == '/') {
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

    public void checkArguments() {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("cd: missing argument");
        } else if (commandArguments.size() > 1) {
            throw new RuntimeException("cd: too many arguments");
        }
    }
}