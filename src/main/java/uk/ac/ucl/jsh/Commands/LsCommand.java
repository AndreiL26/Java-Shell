package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class LsCommand extends Command {
    private File currDir;
    
    public LsCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) throws IOException {
        checkArguments(commandArguments);
        if (commandArguments.isEmpty()) {
            currDir = new File(fileSystem.getWorkingDirectoryPath());
        } 
        else if (commandArguments.size() == 1) {
            // Consider Absolute path vs Relative PAth
            if(commandArguments.get(0).startsWith(System.getProperty("file.separator"))) {
                currDir = new File(commandArguments.get(0));
            }
            else {
                currDir = new File(fileSystem.getWorkingDirectoryPath(), commandArguments.get(0));
            }
        }
        try {
            File[] listOfFiles = currDir.listFiles();
            boolean atLeastOnePrinted = false;
            for (File file : listOfFiles) {
                if (!file.getName().startsWith(".")) {
                    writer.write(file.getName());
                    if(file.compareTo(listOfFiles[listOfFiles.length - 1]) != 0) {
                        writer.write("\t");
                    }
                    writer.flush();
                    atLeastOnePrinted = true;
                }
            }
            if (atLeastOnePrinted) {
                writer.write(System.getProperty("line.separator"));
                writer.flush();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("ls: no such directory");
        }
    }

    public void checkArguments(ArrayList<String> commandArguments) {
        if(commandArguments.size() > 1) {
            throw new RuntimeException("ls: too many arguments");
        }
    }
}