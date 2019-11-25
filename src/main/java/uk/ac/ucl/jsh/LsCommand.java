package uk.ac.ucl.jsh;
import java.io.File;
import java.io.IOException;
import java.io.OutputStreamWriter;


public class LsCommand extends Command {
    private File currDir;

    public LsCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand() throws IOException {
        checkArguments();
        try {
            File[] listOfFiles = currDir.listFiles();
            boolean atLeastOnePrinted = false;
            for (File file : listOfFiles) {
                if (!file.getName().startsWith(".")) {
                    writer.write(file.getName() + "\t");
                    writer.flush();
                    atLeastOnePrinted = true;
                }
            }
            if (atLeastOnePrinted) {
                writer.write(System.getProperty("line.separator"));
                writer.flush();
            }
        } catch (NullPointerException e) {
            throw new RuntimeException("ls: no such directory");
        }
    }

    public void checkArguments() {
        if (commandArguments.isEmpty()) {
            currDir = new File(fileSystem.getWorkingDirectoryPath());
        } else if (commandArguments.size() == 1) {
            currDir = new File(commandArguments.get(0));
        } else {
            throw new RuntimeException("ls: too many arguments");
        }
    }
}