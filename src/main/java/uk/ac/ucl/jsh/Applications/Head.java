package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Head implements Application{
    private int headLines;

    private void readAndWrite(Scanner scanner, OutputStreamWriter writer) throws JshException{
        try {
            int count = 0;
            while (count < headLines && scanner.hasNextLine()) {
                count += 1;
                String line = scanner.nextLine();

                writer.write(line + Jsh.lineSeparator);
                writer.flush();
            }
            scanner.close();
        } catch (IOException e) {
            scanner.close();
            throw new JshException("head: " + e.getMessage());
        }
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if (applicationArguments.isEmpty() && inputStream == null) {
            throw new JshException("head: missing input");
        }
        if (applicationArguments.size() > 3) {
            throw new JshException("head: too many arguments");
        } 
        if (applicationArguments.size() > 1 && !applicationArguments.get(0).equals("-n")) {
            throw new JshException("head: wrong argument " + applicationArguments.get(0));
        }
        if (applicationArguments.size() == 2 && inputStream == null) {
            throw new JshException("head: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException{
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        headLines = 10;
        if (applicationArguments.size() > 1) {
            try {
                headLines = Integer.parseInt(applicationArguments.get(1));
                if(headLines <= 0) {
                    throw new JshException("head: illegal line count -- " + headLines);
                } 
            } catch (NumberFormatException  e) {
                throw new JshException("head: " + e.getMessage());
            }
        } 
        
        if(applicationArguments.size() == 1 || applicationArguments.size() == 3) {
            String filePath = applicationArguments.get(applicationArguments.size() - 1); 
            
            Scanner scanner;
            try {
                scanner = new Scanner(FileSystem.getInstance().getFile(filePath));
            } catch (FileNotFoundException e) {
                throw new JshException("head: " + e.getMessage());
            }

            readAndWrite(scanner, writer);
        } else {
            readAndWrite(new Scanner(inputStream), writer);
        }
    }

}