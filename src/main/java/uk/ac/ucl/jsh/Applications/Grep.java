package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.Files;
import java.nio.charset.StandardCharsets;
import java.io.BufferedReader;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
import java.util.regex.Matcher;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class Grep implements Application {
    private void readAndMatch(BufferedReader reader, OutputStreamWriter writer, Pattern pattern, String fileName) throws JshException {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if(fileName != null) {
                        writer.write(fileName + ": ");
                    }
                    writer.write(line + Jsh.lineSeparator);
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new JshException("grep: cannot read input");
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
        Path filePath;
        Pattern grepPattern;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        int numOfFiles = applicationArguments.size() - 1;
        Path[] filePathArray = new Path[numOfFiles];

        try {
            grepPattern = Pattern.compile(applicationArguments.get(0));
        } catch (PatternSyntaxException e) {
            throw new JshException("grep: " + applicationArguments.get(0) + "is an invalid pattern");
        } 

        if (applicationArguments.size() > 1) {
            for (int i = 0; i < numOfFiles; i++) {
                String currentFileName = applicationArguments.get(i+1);
                filePath = Paths.get(FileSystem.getInstance().getFilePath(currentFileName));
                if (Files.isDirectory(filePath) || !Files.isReadable(filePath)) {
                    throw new JshException("grep: cannot open " + currentFileName);
                }
                filePathArray[i] = filePath;
            }

            for (int j = 0; j < filePathArray.length; j++) {
                try (BufferedReader reader = Files.newBufferedReader(filePathArray[j], StandardCharsets.UTF_8)) {
                    readAndMatch(reader, writer, grepPattern, applicationArguments.get(j+1));
                } catch (IOException e) {
                    throw new JshException("grep: cannot open " + applicationArguments.get(j + 1));
                }
            }
        }
        else {
            readAndMatch(new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8)), writer, grepPattern, null);
        }
    }

}