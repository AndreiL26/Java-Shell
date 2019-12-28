package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Head extends Application{
    public Head(FileSystem fileSystem) {
        super(fileSystem);
    }

    private void readAndWrite(BufferedReader reader, OutputStreamWriter writer, int headLines) {
        int count = 0;
        try {
            String line = null;
            while ((line = reader.readLine()) != null && count < headLines) {
                ++ count;
                writer.write(line + System.getProperty("line.separator"));
                writer.flush();
            }
        }
        catch (IOException e) {
            throw new RuntimeException("head: cannot read input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        applicationArguments = this.globArguments(applicationArguments);
        checkArguments(applicationArguments, inputStream, outputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        File headFile;
        Path filePath;
        int headLines = 10;
        String headArg;
        if (applicationArguments.size() > 1) {
            try {
                headLines = Integer.parseInt(applicationArguments.get(1));
                if(headLines < 0) {
                    /// What to do in tbis case, throw an error or let it execute, not printing anything?
                } 
            } catch (Exception e) {
                throw new RuntimeException("head: wrong argument " + applicationArguments.get(1));
            }
        }    
        
        if(applicationArguments.size() == 1 || applicationArguments.size() == 3) {
            headArg = applicationArguments.get(applicationArguments.size() - 1); 
            if (headArg.startsWith(System.getProperty("file.separator"))) {
                headFile = new File(headArg);
            }
            else {
                headFile = new File(fileSystem.getWorkingDirectoryPath() + File.separator + headArg);
            }
            if(headFile.exists()) {
                filePath = Paths.get(headFile.getAbsolutePath());
                try(BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                    readAndWrite(reader, writer, headLines);
                }
                catch (IOException e) {
                    throw new RuntimeException("head: cannot open file");
                }
            }
            else {
                throw new RuntimeException("head: " + headArg + " does not exist");
            }
        } else {
            readAndWrite(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)), writer, headLines);
        }
    }

    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if ((applicationArguments.isEmpty()) && inputStream == null) {
            throw new RuntimeException("head: missing input");
        }
        if (applicationArguments.size() > 3) {
            throw new RuntimeException("head: too many arguments");
        } 
        if (applicationArguments.size() > 1 && !applicationArguments.get(0).equals("-n")) {
            throw new RuntimeException("head: wrong argument " + applicationArguments.get(0));
        }
        if (applicationArguments.size() == 2 && inputStream == null) {
            throw new RuntimeException("head: missing input");
        }
       
       
    }
}