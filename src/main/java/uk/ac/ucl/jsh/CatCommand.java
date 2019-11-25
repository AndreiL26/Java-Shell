package uk.ac.ucl.jsh;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class CatCommand extends Command{
    
    public CatCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() {
        checkArguments();
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();

        for (String arg : commandArguments) {
            Charset encoding = StandardCharsets.UTF_8;
            File currFile = new File(currentDirectoryPath + File.separator + arg);
            if (currFile.exists()) {
                Path filePath = Paths.get(currentDirectoryPath + File.separator + arg);
                try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {
                    String line = null;
                    while ((line = reader.readLine()) != null) {
                        writer.write(String.valueOf(line));
                        writer.write(System.getProperty("line.separator"));
                        writer.flush();
                    }
                } catch (IOException e) {
                    throw new RuntimeException("cat: cannot open " + arg);
                }
            } else {
                throw new RuntimeException("cat: file does not exist");
            }
        }
    }
    

    public void checkArguments() {
        if(commandArguments.isEmpty())
            throw new RuntimeException("cat: missing arguments");
    }
   
}