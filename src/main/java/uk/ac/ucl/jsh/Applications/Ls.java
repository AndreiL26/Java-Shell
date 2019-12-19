package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ls extends Application {
    private File currDir;
    
    public Ls(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        checkArguments(commandArguments, inputStream, outputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        if (commandArguments.isEmpty()) {
            currDir = new File(fileSystem.getWorkingDirectoryPath());
        } 
        else {
            if(commandArguments.get(0).startsWith(System.getProperty("file.separator"))) {
                currDir = new File(commandArguments.get(0));
            }
            else {
                currDir = new File(fileSystem.getWorkingDirectoryPath(), commandArguments.get(0));
            }
        }
        try {
            File[] listOfFiles = currDir.listFiles();
            boolean atLeastOnePrinted = false;
            for (File file : listOfFiles) {
                if (!file.getName().startsWith(".")) {
                    writer.write(file.getName());
                    if(file.compareTo(listOfFiles[listOfFiles.length - 1]) != 0) {
                        writer.write("\t");
                    }
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

    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        if(commandArguments.size() > 1) {
            throw new RuntimeException("ls: too many arguments");
        }
    }
}