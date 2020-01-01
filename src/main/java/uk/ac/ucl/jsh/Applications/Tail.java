package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

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
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public class Tail implements Application {
    private FileSystem fileSystem;

    public Tail(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void readAndWriteLast(BufferedReader reader, OutputStreamWriter writer, int tailLines) throws JshException {
        ArrayList<String> storage = new ArrayList<>();
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                storage.add(line);
            }
            int index = 0;
            if (tailLines > storage.size()) {
                index = 0;
            } else {
                index = storage.size() - tailLines;
            }
            for (int i = index; i < storage.size(); i++) {
                writer.write(storage.get(i) + System.getProperty("line.separator"));
                writer.flush();
            }     
        } catch (IOException e) {
            throw new JshException("tail: cannot read input");
        }       
    }
    
    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if ((applicationArguments.isEmpty()) && inputStream == null)  {
            throw new JshException("tail: missing input");
        }
        if (applicationArguments.size() > 3) {
            throw new JshException("tail: too many arguments");
        }
        if (applicationArguments.size() > 1 && !applicationArguments.get(0).equals("-n")) {
            throw new JshException("tail: wrong argument " + applicationArguments.get(0));
        }
        if (applicationArguments.size() == 2 && inputStream == null) {
            throw new JshException("tail: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream);
        int tailLines = 10;
        String tailArg;
        File tailFile;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        if (applicationArguments.size() > 1) {
            try {
                tailLines = Integer.parseInt(applicationArguments.get(1));
                if (tailLines < 0) {
                    /// What to do here?
                }
            } catch (Exception e) {
                throw new JshException("tail: wrong argument " + applicationArguments.get(1));
            }
        }


        if(applicationArguments.size() == 1 || applicationArguments.size() == 3) {
            tailArg = applicationArguments.get(applicationArguments.size() - 1);
            tailFile = FileSystem.getInstance().getFile(tailArg);
            
            if(tailFile.exists()) {
                Path filePath = Paths.get(tailFile.getAbsolutePath());
                try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                    readAndWriteLast(reader, writer, tailLines);
                }
                catch (IOException e) {
                    throw new JshException("tail: cannot open" + tailArg);
                }
            }
            else {
                throw new JshException("tail: " + tailArg + " does not exist");
            }
        }
        else {
            readAndWriteLast(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)), writer, tailLines);
        }
    }
    
}