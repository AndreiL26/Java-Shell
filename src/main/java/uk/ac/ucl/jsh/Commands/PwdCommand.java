package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class PwdCommand extends Command {


    public PwdCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) throws IOException {
       checkArguments(commandArguments);
       writer.write(fileSystem.getWorkingDirectoryPath() + System.getProperty("line.separator"));
       writer.flush();
    }
    
    public void checkArguments(ArrayList<String> commandArguments) {
        if(!commandArguments.isEmpty()) {
            throw new RuntimeException("pwd: too many arguments");
        }
    }
  
}