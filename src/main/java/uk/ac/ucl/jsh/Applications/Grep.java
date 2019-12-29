package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
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

public class Grep extends Application {
    
    public Grep(FileSystem fileSystem) {
        super(fileSystem);
    }

    private void readAndMatch(BufferedReader reader, OutputStreamWriter writer, Pattern pattern, String fileName) {
        String line = null;
        try {
            while ((line = reader.readLine()) != null) {
                Matcher matcher = pattern.matcher(line);
                if (matcher.find()) {
                    if(fileName != null) {
                        writer.write(fileName + ": ");
                    }
                    writer.write(line + System.getProperty("line.separator"));
                    writer.flush();
                }
            }
        } catch (IOException e) {
            throw new RuntimeException("grep: cannot read input");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        checkArguments(applicationArguments, inputStream, outputStream);
        Path filePath;
        Pattern grepPattern;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);
        int numOfFiles = applicationArguments.size() - 1;
        Path[] filePathArray = new Path[numOfFiles];

        try {
            grepPattern = Pattern.compile(applicationArguments.get(0));
        } catch (PatternSyntaxException e) {
            throw new RuntimeException("grep: " + applicationArguments.get(0) + "is an invalid pattern");
        } 

        if (applicationArguments.size() > 1) {
            for (int i = 0; i < numOfFiles; i++) {
                String currentFileName = applicationArguments.get(i+1);
                if (currentFileName.startsWith(System.getProperty("file.separator"))) {
                    filePath = Paths.get(currentFileName);
                }
                else {
                    filePath = Paths.get(fileSystem.getWorkingDirectoryPath() + System.getProperty("file.separator") + currentFileName);
                }
                if (Files.isDirectory(filePath) || !Files.isReadable(filePath)) {
                    throw new RuntimeException("grep: cannot open " + currentFileName);
                }
                filePathArray[i] = filePath;
            }

            for (int j = 0; j < filePathArray.length; j++) {
                try (BufferedReader reader = Files.newBufferedReader(filePathArray[j], StandardCharsets.UTF_8)) {
                    readAndMatch(reader, writer, grepPattern, applicationArguments.get(j+1));
                } catch (IOException e) {
                    throw new RuntimeException("grep: cannot open " + applicationArguments.get(j + 1));
                }
            }
        }
        else {
            readAndMatch(new BufferedReader(new InputStreamReader(inputStream,StandardCharsets.UTF_8)), writer, grepPattern, null);
        }
    }

    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if (applicationArguments.isEmpty()) {
            throw new RuntimeException("grep: missing arguments");
        }
        if (applicationArguments.size() == 1 && inputStream == null) {
            throw new RuntimeException("grep: missing input");
        }
    }
}