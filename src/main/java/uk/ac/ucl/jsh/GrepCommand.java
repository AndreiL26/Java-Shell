package uk.ac.ucl.jsh;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class GrepCommand extends Command {
   
    public GrepCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() {
        checkArguments();
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

    public void checkArguments() {
        if (commandArguments.size() < 2) {
            throw new RuntimeException("grep: wrong number of arguments");
        }
    }
}