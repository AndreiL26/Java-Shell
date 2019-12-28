package uk.ac.ucl.jsh.Applications;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public interface Application {

    public abstract void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws IOException;
    
}