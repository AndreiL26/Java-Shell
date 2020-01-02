package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Pwd implements Application {
    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if(!applicationArguments.isEmpty()) {
            throw new JshException("pwd: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
       applicationArguments = Application.globArguments(applicationArguments, -1);
       checkArguments(applicationArguments, inputStream);
       OutputStreamWriter writer = new OutputStreamWriter(outputStream);
       try {
            writer.write(FileSystem.getInstance().getWorkingDirectoryPath() + System.getProperty("line.separator"));
            writer.flush();
       } catch (IOException e) {
           throw new JshException("pwd: cannot write output");
       }
    }

}