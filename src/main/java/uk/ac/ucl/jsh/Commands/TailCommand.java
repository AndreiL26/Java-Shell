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
import java.util.ArrayList;
import java.io.OutputStreamWriter;

public class TailCommand extends Command {

    public TailCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }
    
    @Override
    public void runCommand(ArrayList<String> commandArguments) {
        checkArguments(commandArguments);
        int tailLines = 10;
        String tailArg;
        if (commandArguments.size() == 3) {
            try {
                tailLines = Integer.parseInt(commandArguments.get(1));
            } catch (Exception e) {
                throw new RuntimeException("tail: wrong argument " + commandArguments.get(1));
            }
            tailArg = commandArguments.get(2);
        } else {
            tailArg = commandArguments.get(0);
        }
        File tailFile = new File(fileSystem.getWorkingDirectoryPath() + File.separator + tailArg);
        if (tailFile.exists()) {
            Charset encoding = StandardCharsets.UTF_8;
            Path filePath = Paths.get((String) fileSystem.getWorkingDirectoryPath() + File.separator + tailArg);
            ArrayList<String> storage = new ArrayList<>();
            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {
                String line = null;
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
                throw new RuntimeException("tail: cannot open " + tailArg);
            }
        } else {
            throw new RuntimeException("tail: " + tailArg + " does not exist");
        }
    }
    
    public void checkArguments(ArrayList<String> commandArguments) {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("tail: missing arguments");
        }
        if (commandArguments.size() != 1 && commandArguments.size() != 3) {
            throw new RuntimeException("tail: wrong arguments");
        }
        if (commandArguments.size() == 3 && !commandArguments.get(0).equals("-n")) {
            throw new RuntimeException("tail: wrong argument " + commandArguments.get(0));
        }
    }
}