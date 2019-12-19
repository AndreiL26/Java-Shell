package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Cat extends Application{
    
    public Cat(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException{
        checkArguments(applicationArguments, inputStream, outputStream);
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        
        if(applicationArguments.size() == 0) {
            Scanner scanner = new Scanner(inputStream);
            String line = null;
            try {
                    while (scanner.hasNextLine()) {
                        line = scanner.nextLine();
                        writer.write(line);
                        writer.write(System.getProperty("line.separator"));
                        writer.flush();
                    }
                }
                catch (IOException e) {
                    scanner.close();
                    throw new RuntimeException("cat: cannot write");
                }
                scanner.close();   
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
                            String line = null;
                            while ((line = reader.readLine()) != null) {
                                writer.write(String.valueOf(line));
                                writer.write(System.getProperty("line.separator"));
                                writer.flush();
                            }
                        } 
                        catch (IOException e) {
                            throw new RuntimeException("cat: cannot open " + arg);
                        }
                    } 
                    else {
                        throw new RuntimeException("cat: " + arg + " is a directory");
                    }
                } 
                else {
                    throw new RuntimeException("cat: file does not exist");
                }
            }
        }
        
    }

    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if(applicationArguments.isEmpty() && inputStream == null) {
            throw new RuntimeException("cat: missing argument");
        }
    }
   
}