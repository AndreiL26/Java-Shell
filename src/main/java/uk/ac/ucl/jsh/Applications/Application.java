package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public abstract class Application {
    protected FileSystem fileSystem;

    public Application(FileSystem fileSystem) {
        this.fileSystem = fileSystem;     
    }

    public abstract void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws IOException;
    
    public abstract void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream); 


}