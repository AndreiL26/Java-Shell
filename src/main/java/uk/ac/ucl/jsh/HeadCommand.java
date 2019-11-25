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


public class HeadCommand extends Command{

    public HeadCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() {
        checkArguments();
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        int headLines = 10;
        String headArg;
        if (commandArguments.size() == 3) {
            try {
                headLines = Integer.parseInt(commandArguments.get(1));
            } catch (Exception e) {
                throw new RuntimeException("head: wrong argument " + commandArguments.get(1));
            }
            headArg = commandArguments.get(2);
        } else {
            headArg = commandArguments.get(0);
        }
        File headFile = new File(currentDirectoryPath + File.separator + headArg);
        if (headFile.exists()) {
            Charset encoding = StandardCharsets.UTF_8;
            Path filePath = Paths.get((String) currentDirectoryPath + File.separator + headArg);
            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {
                for (int i = 0; i < headLines; i++) {
                    String line = null;
                    if ((line = reader.readLine()) != null) {
                        writer.write(line + System.getProperty("line.separator"));
                        writer.flush();
                    }
                }
            } catch (IOException e) {
                throw new RuntimeException("head: cannot open " + headArg);
            }
        } else {
            throw new RuntimeException("head: " + headArg + " does not exist");
        }
    }

    public void checkArguments() {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("head: missing arguments");
        }
        if (commandArguments.size() != 1 && commandArguments.size() != 3) {
            throw new RuntimeException("head: wrong arguments");
        }
        if (commandArguments.size() == 3 && !commandArguments.get(0).equals("-n")) {
            throw new RuntimeException("head: wrong argument " + commandArguments.get(0));
        }
    }
}