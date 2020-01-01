package uk.ac.ucl.jsh.Applications;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Utilities.JshException;

public interface Application {

    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws JshException; 
}