package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Echo implements Application {
    
    public Echo(FileSystem fileSystem) {
        
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException{
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        boolean atLeastOnePrinted = false;
        for (String arg : applicationArguments) {
            writer.write(arg);
            if(applicationArguments.get(applicationArguments.size() - 1).compareTo(arg) != 0) {
                writer.write(" ");
            }
            writer.flush();
            atLeastOnePrinted = true;
        }
        if (atLeastOnePrinted) {
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        }
    }

}