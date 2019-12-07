package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class CatCommand extends Command{
    
    public CatCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) throws IOException{
        checkArguments(commandArguments);
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        
        if(commandArguments.size() == 0) {
           Scanner scanner = new Scanner(System.in);
           String line = null;
           try {
                while ((line = scanner.nextLine()) != null) {
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
            for (String arg : commandArguments) {
                Charset encoding = StandardCharsets.UTF_8;
                File currFile;
                if(arg.startsWith(System.getProperty("file.separator"))) {
                    currFile = new File(arg);
                } 
                else {
                    currFile = new File(currentDirectoryPath + File.separator + arg);
                }
                if (currFile.exists()) {
                    if(currFile.isFile()) { // Should this if else exist or not (it was not here before, I added it to throw a more explicit error message)
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

    public void checkArguments(ArrayList<String> commandArguments) {

    }
   
}