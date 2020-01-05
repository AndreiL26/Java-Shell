package uk.ac.ucl.jsh.Applications;

import java.io.OutputStreamWriter;
import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.util.ArrayList;
import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class Sed implements Application {
    private String regex;
    private String replacement;

    private boolean isValid(String argument) { 
        if (argument.length() < 5) {
            return false;
        }

        if (argument.charAt(0) != 's') {
            return false;
        }

        char delimiter = argument.charAt(1);
        int delimiterFrequency = (int)argument.substring(1).codePoints().filter(ch -> ch == delimiter).count();

        if (delimiterFrequency == 4 && delimiter != 'g') {
            return false;
        }
        else if (delimiterFrequency != 3 && delimiterFrequency != 4) {
            return false;
        }

        if (argument.charAt(argument.length()-1) != delimiter && argument.charAt(argument.length()-1) != 'g') {
            return false;
        }

        int firstDelimiterIndex = 1;
        int secondDelimiterIndex = argument.indexOf(delimiter, firstDelimiterIndex + 1);
        int thirdDelimiterIndex = argument.indexOf(delimiter, secondDelimiterIndex + 1);

        if (thirdDelimiterIndex != argument.length()-1 && thirdDelimiterIndex != argument.length()-2) {
            return false;
        }

        regex = argument.substring(firstDelimiterIndex + 1, secondDelimiterIndex);
        replacement = argument.substring(secondDelimiterIndex + 1, thirdDelimiterIndex);

        if(regex.compareTo("") == 0) {
            return false;
        }

        return true;
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        int numberOfArguments = applicationArguments.size();
        if (numberOfArguments <= 0) {
            throw new JshException("sed: missing arguments");
        }   

        if (numberOfArguments > 2){
            throw new JshException("sed: too many arguments");
        }

        if (numberOfArguments == 1 && inputStream == null) {
            throw new JshException("sed: missing input");
        }

        if(isValid(applicationArguments.get(0)) == false) {
            throw new JshException("sed: invalid first argument");
        } 
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, 0);
        checkArguments(applicationArguments, inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        boolean replaceAll = false;
        if(applicationArguments.get(0).endsWith("g")) {
            replaceAll = true;
        }

        Scanner scanner;
        if(applicationArguments.size() == 2){
            String filePath = applicationArguments.get(1);
            try {
                scanner = new Scanner(FileSystem.getInstance().getFile(filePath));
            } catch (FileNotFoundException e) {
                throw new JshException("sed: " + e.getMessage());
            }
        }
        else {
            scanner = new Scanner(inputStream);
        }

        try {
            while(scanner.hasNextLine()) {
                String line = scanner.nextLine();
                if(replaceAll == true) {
                    writer.write(line.replaceAll(regex, replacement) + Jsh.lineSeparator);
                }
                else {
                    writer.write(line.replaceFirst(regex, replacement) + Jsh.lineSeparator);
                }
                writer.flush();
            }

            scanner.close();
        } catch (IOException e) {
            scanner.close();
            throw new JshException("sed: " + e.getMessage());
        }
    }

}