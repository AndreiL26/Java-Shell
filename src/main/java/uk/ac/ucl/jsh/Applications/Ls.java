package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Ls implements Application {
    private void checkArguments(ArrayList<String> applicationArguments) throws JshException {
        if(applicationArguments.size() > 1) {
            throw new JshException("ls: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        File currDir;
        if (applicationArguments.isEmpty()) {
            currDir = FileSystem.getInstance().getFile(FileSystem.getInstance().getWorkingDirectoryPath());
        } 
        else {
            currDir = FileSystem.getInstance().getFile(applicationArguments.get(0));
        }

        try {
            File[] listOfFiles = currDir.listFiles();
            boolean atLeastOnePrinted = false;
            try {
                int index = 0;
                for (File file : listOfFiles) {
                    if (!file.getName().startsWith(".")) {
                        writer.write(file.getName());
                        if(index + 1 < listOfFiles.length) {
                            writer.write("\t");
                        }
                        writer.flush();
                        atLeastOnePrinted = true;
                    }

                    index += 1;
                }    

                if (atLeastOnePrinted) {
                    writer.write(Jsh.lineSeparator);
                    writer.flush();
                } 
            } catch (IOException e) {
                throw new JshException("ls: " + e.getMessage());
            }
        } catch (NullPointerException e) {
            throw new JshException("ls: " + e.getMessage());
        }
    }

}