package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.OutputStreamWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class Echo extends Application {
    
    public Echo(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) throws IOException{
        checkArguments(commandArguments, inputStream, outputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        boolean atLeastOnePrinted = false;
        for (String arg : commandArguments) {
            writer.write(arg);
            if(commandArguments.get(commandArguments.size() - 1).compareTo(arg) != 0) {
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

    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        
    }
}