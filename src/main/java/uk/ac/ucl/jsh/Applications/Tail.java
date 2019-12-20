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
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public class Tail extends Application {

    public Tail(FileSystem fileSystem) {
        super(fileSystem);
    }

    private void readAndWriteLast(BufferedReader reader, OutputStreamWriter writer, int tailLines) {
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
            throw new RuntimeException("tail: cannot read input");
        }       
    }
    
    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        checkArguments(applicationArguments, inputStream, outputStream);
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
                throw new RuntimeException("tail: wrong argument " + applicationArguments.get(1));
            }
        }


        if(applicationArguments.size() == 1 || applicationArguments.size() == 3) {
            tailArg = applicationArguments.get(applicationArguments.size() - 1);
            if (tailArg.startsWith(System.getProperty("file.separator"))) {
                tailFile = new File(tailArg);
            }
            else {
                tailFile = new File(fileSystem.getWorkingDirectoryPath() + System.getProperty("file.separator") + tailArg);
            }
            if(tailFile.exists()) {
                Path filePath = Paths.get(tailFile.getAbsolutePath());
                try (BufferedReader reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8)) {
                    readAndWriteLast(reader, writer, tailLines);
                }
                catch (IOException e) {
                    throw new RuntimeException("tail: cannot open" + tailArg);
                }
            }
            else {
                throw new RuntimeException("tail: " + tailArg + " does not exist");
            }
        }
        else {
            readAndWriteLast(new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8)), writer, tailLines);
        }
    }
    
    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if ((applicationArguments.isEmpty() || applicationArguments.size() == 2) && inputStream == null)  {
            throw new RuntimeException("tail: missing arguments");
        }
        if (applicationArguments.size() > 1 && !applicationArguments.get(0).equals("-n")) {
            throw new RuntimeException("tail: wrong argument " + applicationArguments.get(0));
        }
        if (applicationArguments.size() > 3) {
            throw new RuntimeException("tail: too many arguments");
        }
    }
}