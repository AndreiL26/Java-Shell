package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.nio.charset.Charset;
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

public class Cat implements Application{
    private FileSystem fileSystem;
    
    public Cat(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void readAndWrite(BufferedReader reader, OutputStreamWriter writer) throws JshException {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                writer.write(String.valueOf(line));
                writer.write(System.getProperty("line.separator"));
                writer.flush();
            }
        } catch (IOException e) {
            throw new JshException("cat: cannot read input");
        }

    }
    
    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if(applicationArguments.isEmpty() && inputStream == null) {
            throw new JshException("cat: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream);
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        
        if(applicationArguments.size() == 0) {
            readAndWrite(new BufferedReader(new InputStreamReader(inputStream)), writer);
        }
        else {
            for (String arg : applicationArguments) {
                Charset encoding = StandardCharsets.UTF_8;
                File currFile;
                if(arg.startsWith(System.getProperty("file.separator"))) {
                    currFile = new File(arg);
                } 
                else {
                    currFile = new File(currentDirectoryPath + File.separator + arg);
                }
                if (currFile.exists()) {
                    if(currFile.isFile()) { 
                        Path filePath = Paths.get(currFile.getPath());
                        try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {
                            readAndWrite(reader, writer);
                        } 
                        catch (IOException e) {
                            throw new JshException("cat: cannot open " + arg);
                        }
                    } 
                    else {
                        throw new JshException("cat: " + arg + " is a directory");
                    }
                } 
                else {
                    throw new JshException("cat: file does not exist");
                }
            }
        }
        
    }
   
}