package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Echo implements Application {
    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException{
        applicationArguments = Application.globArguments(applicationArguments, -1);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        int index = 0;
        try {
            for (String arg : applicationArguments) {
                writer.write(arg);
                if(index != applicationArguments.size() - 1) {
                    writer.write(" ");
                }
                writer.flush();
                index += 1;
            }
            
            writer.write(Jsh.lineSeparator);
            writer.flush();
        } catch (IOException e) {
            throw new JshException("echo: " + e.getMessage());
        }
    }

}