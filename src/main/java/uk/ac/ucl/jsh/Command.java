package uk.ac.ucl.jsh;
import java.io.IOException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public abstract class Command {
    protected FileSystem fileSystem;
    protected OutputStreamWriter writer;
    protected ArrayList<String> commandArguments;

    public Command(FileSystem fileSystem, OutputStreamWriter writer) {
        this.fileSystem = fileSystem;
        this.writer = writer;
    }

    public void setCommandArguments(ArrayList<String> commandArguments) {
        this.commandArguments = commandArguments;
    }

    public abstract void runCommand() throws IOException;
    
    public abstract void checkArguments(); 


}