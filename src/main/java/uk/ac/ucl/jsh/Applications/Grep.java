package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.FileNotFoundException;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Scanner;

public class Grep implements Application {
    private void readAndMatch(Scanner scanner, OutputStreamWriter writer, Pattern pattern) throws JshException {
        try {
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    writer.write(line + Jsh.lineSeparator);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new JshException("grep: " + e.getMessage());
        }
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream) throws JshException {
        if (applicationArguments.isEmpty()) {
            throw new JshException("grep: missing arguments");
        }
        if (applicationArguments.size() == 1 && inputStream == null) {
            throw new JshException("grep: missing input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        applicationArguments = Application.globArguments(applicationArguments, 0);
        checkArguments(applicationArguments, inputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        Pattern grepPattern;
        try {
            grepPattern = Pattern.compile(applicationArguments.get(0));
        } catch (PatternSyntaxException e) {
            throw new JshException("grep: " + e.getMessage());
        } 

        if (applicationArguments.size() > 1) {
            for (int i = 1; i < applicationArguments.size(); ++i) {
                String filePath = applicationArguments.get(i);
                Scanner scanner;
                try {
                    scanner = new Scanner(FileSystem.getInstance().getFile(filePath));
                } catch (FileNotFoundException e) {
                    throw new JshException("grep: " + e.getMessage());
                }
                readAndMatch(scanner, writer, grepPattern);
            }
        }
        else {
            readAndMatch(new Scanner(inputStream), writer, grepPattern);
        }
    }

}