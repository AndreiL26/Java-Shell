package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;
import java.io.OutputStreamWriter;

public class Tail implements Application {
    private int tailLines;

    private void readAndWrite(Scanner scanner, OutputStreamWriter writer) throws JshException {
        ArrayList<String> storage = new ArrayList<>();
        try {
            while (scanner.hasNextLine()) {
                storage.add(scanner.nextLine());
            }

            int index = 0;
            if (tailLines > storage.size()) {
                index = 0;
            } else {
                index = storage.size() - tailLines;
            }
            for (int i = index; i < storage.size(); i++) {
                writer.write(storage.get(i) + Jsh.lineSeparator);
                writer.flush();
            }     
            scanner.close();
        } catch (IOException e) {
            scanner.close();
            throw new JshException("tail: " + e.getMessage());
        }       
    }
    
    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if (applicationArguments.isEmpty() && inputStream == null)  {
            throw new JshException("tail: missing input");
        }
        if (applicationArguments.size() > 3) {
            throw new JshException("tail: too many arguments");
        }
        if (applicationArguments.size() > 1 && !applicationArguments.get(0).equals("-n")) {
            throw new JshException("tail: wrong argument " + applicationArguments.get(0));
        }
        if (applicationArguments.size() == 2 && inputStream == null) {
            throw new JshException("tail: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        tailLines = 10;
        if (applicationArguments.size() > 1) {
            try {
                tailLines = Integer.parseInt(applicationArguments.get(1));
                if (tailLines <= 0) {
                    throw new JshException("tail: illegal line count -- " + tailLines);
                }
            } catch (NumberFormatException e) {
                throw new JshException("tail: " + e.getMessage());
            }
        }


        if(applicationArguments.size() == 1 || applicationArguments.size() == 3) {
            String filePath = applicationArguments.get(applicationArguments.size() - 1);
                
            Scanner scanner;
            try {
                scanner = new Scanner(FileSystem.getInstance().getFile(filePath));
            } catch (FileNotFoundException e) {
                throw new JshException("tail: " + e.getMessage());
            }

            readAndWrite(scanner, writer);
        }
        else {
            readAndWrite(new Scanner(inputStream), writer);
        }
    }
    
}