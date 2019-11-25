package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.util.ArrayList;

public class EchoCommand extends Command {
    
    public EchoCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) throws IOException{
        checkArguments(commandArguments);
        boolean atLeastOnePrinted = false;
        for (String arg : commandArguments) {
            writer.write(arg + " ");
            writer.flush();
            atLeastOnePrinted = true;
        }
        if (atLeastOnePrinted) {
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        }
    }

    public void checkArguments(ArrayList<String> commandArguments) {
        
    }
}