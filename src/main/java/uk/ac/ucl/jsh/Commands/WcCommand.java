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

public class WcCommand extends Command{
    
    public WcCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) {
        checkArguments(commandArguments);
        
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        Charset encoding = StandardCharsets.UTF_8;
        
        String flag = commandArguments.get(0);
        String filename = commandArguments.get(1);
        String filepathString = currentDirectoryPath + File.separator + filename;

        File currFile = new File(filepathString);
        if (currFile.exists()) {
            Path filePath = Paths.get(filepathString);
            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {             
                int wordCount = 0; 
                int charCount = 0; 
                int lineCount = 0; 
                      
                String line; 
                while((line = reader.readLine()) != null) { 
                    lineCount++;   
                    if (!line.equals("")) {
                        charCount += line.length();                                                       
                        String[] words = line.split("\\s+");                             
                        wordCount += words.length; 
                    }   
                } 
   
                switch (flag) {
                    case ("-m"):
                        printCount(charCount);
                        break;
                    case ("-w"):
                        printCount(wordCount);
                        break;
                    case ("-l"):
                        printCount(lineCount);
                        break;
                }
                                    
            } catch (IOException e) {
                throw new RuntimeException("wc: cannot open " + filename);
            }
        } else {
            throw new RuntimeException("wc: file does not exist");
        }
        
    }

    private void printCount(int count) {
        try {
            writer.write(String.valueOf(count));
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("wc: cannot write count to output");
        } 
    }
    
    private void checkArguments(ArrayList<String> commandArguments) {
        System.out.println(commandArguments);
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("wc: missing arguments");
        }
        if (commandArguments.size() != 2) {
            throw new RuntimeException("wc: wrong arguments");
        }

        String flag = commandArguments.get(0);
        if (!flag.equals("-l") && !flag.equals("-m") && !flag.equals("-w")) {
            throw new RuntimeException("wc: wrong argument " + commandArguments.get(0));
        }
    } 
}