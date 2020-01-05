package uk.ac.ucl.jsh.Applications;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Utilities.Globbing;
import uk.ac.ucl.jsh.Utilities.JshException;

public interface Application {
    void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outpustream) throws JshException;

    static ArrayList<String> globArguments(ArrayList<String> applicationArguments, int ignoreIndex) {
        return Globbing.globArguments(applicationArguments, ignoreIndex);
    }
}