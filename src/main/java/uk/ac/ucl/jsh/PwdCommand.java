package uk.ac.ucl.jsh;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class PwdCommand extends Command {


    public PwdCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() throws IOException {
       writer.write(fileSystem.getWorkingDirectoryPath() + System.getProperty("line.separator"));
       writer.flush();
    }
    
    public void checkArguments() {

    }
  
}