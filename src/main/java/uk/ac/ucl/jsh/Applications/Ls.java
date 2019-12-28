package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ls implements Application {
    private FileSystem fileSystem;
    
    public Ls(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if(applicationArguments.size() > 1) {
            throw new RuntimeException("ls: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        checkArguments(applicationArguments, inputStream, outputStream);
        File currDir = null;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        if (applicationArguments.isEmpty()) {
            currDir = new File(fileSystem.getWorkingDirectoryPath());
        } 
        else {
            if(applicationArguments.get(0).startsWith(System.getProperty("file.separator"))) {
                currDir = new File(applicationArguments.get(0));
            }
            else {
                currDir = new File(fileSystem.getWorkingDirectoryPath(), applicationArguments.get(0));
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

}