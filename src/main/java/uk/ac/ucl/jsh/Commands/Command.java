package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.IOException;
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public abstract class Command {
    protected FileSystem fileSystem;
    protected OutputStreamWriter writer;

    public Command(FileSystem fileSystem, OutputStreamWriter writer) {
        this.fileSystem = fileSystem;
        this.writer = writer;
    }

    public abstract void runCommand(ArrayList<String> commandArguments) throws IOException;
    
    public abstract void checkArguments(ArrayList<String> commandArguments); 


}