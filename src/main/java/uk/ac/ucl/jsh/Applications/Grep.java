package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Grep extends Application {
   
    public Grep(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        checkArguments(commandArguments, inputStream, outputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        Pattern grepPattern = Pattern.compile(commandArguments.get(0));
        int numOfFiles = commandArguments.size() - 1;
        Path filePath;
        Path[] filePathArray = new Path[numOfFiles];
        Path currentDir = Paths.get(fileSystem.getWorkingDirectoryPath());
        for (int i = 0; i < numOfFiles; i++) {
            filePath = currentDir.resolve(commandArguments.get(i + 1));
            if (Files.notExists(filePath) || Files.isDirectory(filePath) || 
                !Files.exists(filePath) || !Files.isReadable(filePath)) {
                throw new RuntimeException("grep: wrong file argument");
            }
            filePathArray[i] = filePath;
        }
        for (int j = 0; j < filePathArray.length; j++) {
            Charset encoding = StandardCharsets.UTF_8;
            try (BufferedReader reader = Files.newBufferedReader(filePathArray[j], encoding)) {
                String line = null;
                while ((line = reader.readLine()) != null) {
                    Matcher matcher = grepPattern.matcher(line);
                    if (matcher.find()) {
                        writer.write(line + System.getProperty("line.separator"));
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("grep: cannot open " + commandArguments.get(j + 1));
            }
        }
    }

    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        if (commandArguments.size() < 2) {
            throw new RuntimeException("grep: wrong number of arguments");
        }
    }
}