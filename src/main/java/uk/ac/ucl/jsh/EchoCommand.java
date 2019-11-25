package uk.ac.ucl.jsh;

import java.io.OutputStreamWriter;
import java.io.IOException;

public class EchoCommand extends Command {
    
    public EchoCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() throws IOException{
        checkArguments();
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

    public void checkArguments() {
        
    }
}