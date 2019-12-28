package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Pwd implements Application {
    private FileSystem fileSystem;

    public Pwd(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if(!applicationArguments.isEmpty()) {
            throw new RuntimeException("pwd: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
       checkArguments(applicationArguments, inputStream, outputStream);
       OutputStreamWriter writer = new OutputStreamWriter(outputStream);
       writer.write(fileSystem.getWorkingDirectoryPath() + System.getProperty("line.separator"));
       writer.flush();
    }
    
}