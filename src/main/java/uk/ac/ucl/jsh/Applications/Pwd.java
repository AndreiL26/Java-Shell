package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Pwd extends Application {


    public Pwd(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
       checkArguments(commandArguments, inputStream, outputStream);
       OutputStreamWriter writer = new OutputStreamWriter(outputStream);
       writer.write(fileSystem.getWorkingDirectoryPath() + System.getProperty("line.separator"));
       writer.flush();
    }
    
    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        if(!commandArguments.isEmpty()) {
            throw new RuntimeException("pwd: too many arguments");
        }
    }
  
}