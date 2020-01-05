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

public class Cat implements Application{
    private void readAndWrite(Scanner scanner, OutputStreamWriter writer) throws JshException {
        try {
            while (scanner.hasNextLine()) {
                writer.write(scanner.nextLine());
                writer.write(Jsh.lineSeparator);
                writer.flush();
            }
        } catch (IOException e) {
            throw new JshException("cat: " + e.getMessage());
        }
    }
    
    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if(applicationArguments.isEmpty() && inputStream == null) {
            throw new JshException("cat: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        
        if(applicationArguments.size() == 0) {
            readAndWrite(new Scanner(inputStream), writer);
        }
        else {
            for (String filePath : applicationArguments) {
                Scanner scanner;
                try {
                    scanner = new Scanner(FileSystem.getInstance().getFile(filePath));
                } catch (FileNotFoundException e) {
                    throw new JshException("cat: " + e.getMessage());
                }

                readAndWrite(scanner, writer);
            }
        }
        
    }
   
}