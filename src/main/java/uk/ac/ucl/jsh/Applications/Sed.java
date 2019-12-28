package uk.ac.ucl.jsh.Applications;

import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

public class Sed implements Application {
    private FileSystem fileSystem;
    private String regex;
    private String replacement;

    public Sed(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private boolean isValid(String argument) { 
        if(argument == "") {
            return false;
        }

        if(argument.charAt(0) != 's') {
            return false;
        }
        char delimiter = argument.charAt(1);
        
        if(argument.charAt(argument.length() - 1) != delimiter && argument.charAt(argument.length()-1) != 'g') {
            return false;
        }

        if(argument.charAt(argument.length() - 1) == 'g' && argument.charAt(argument.length() - 2) != delimiter) {
            return false;
        }

        if(delimiter == 's') {
            if(argument.codePoints().filter(ch -> ch == delimiter).count() != 4) {
                return false;
            }
        }

        if(delimiter == 'g') {
            if(argument.codePoints().filter(ch -> ch == delimiter).count() != 3 && argument.codePoints().filter(ch -> ch == delimiter).count() != 4) {
                return false;
            }
        }

        if(delimiter != 's' && delimiter != 'g') {
            if(argument.codePoints().filter(ch -> ch == delimiter).count() != 3) {
                return false;
            }
        }

        int firstDelimiterIndex;
        if(delimiter != 's') {
            firstDelimiterIndex = argument.indexOf(delimiter);
        }
        else {
            firstDelimiterIndex = argument.indexOf(delimiter, 1);
        }

        int secondDelimiterIndex = argument.indexOf(delimiter, firstDelimiterIndex + 1);
        int thirdDelimiterIndex = argument.indexOf(delimiter, secondDelimiterIndex + 1);

        this.regex = argument.substring(firstDelimiterIndex + 1, secondDelimiterIndex);
        this.replacement = argument.substring(secondDelimiterIndex + 1, thirdDelimiterIndex);

        if(regex.compareTo("") == 0) {
            return false;
        }
        return true;
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        int numberOfArguments = applicationArguments.size();
        if (numberOfArguments <= 0) {
            throw new RuntimeException("sed: missing arguments");
        }   

        if (numberOfArguments > 2){
            throw new RuntimeException("sed: too many arguments");
        }

        if (numberOfArguments == 1 && inputStream == null) {
            throw new RuntimeException("sed: missing input");
        }

        if(isValid(applicationArguments.get(0)) == false) {
            throw new RuntimeException("sed: invalid first argument");
        } 
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        checkArguments(applicationArguments, inputStream, outputStream);
        boolean replaceAll = false;
        File sedFile = null;
        BufferedReader reader;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        if(applicationArguments.get(0).endsWith("g")) {
            replaceAll = true;
        }

        if(applicationArguments.size() == 2){
            String filePath = applicationArguments.get(1);
            if(filePath.startsWith(System.getProperty("file.separator"))) {
                sedFile = new File(applicationArguments.get(1));
            }
            else {
                sedFile = new File(fileSystem.getWorkingDirectoryPath() + System.getProperty("file.separator") + filePath);
            }

            if(!sedFile.exists()) {
                throw new RuntimeException("sed: cannot open " + filePath);
            }
        }
    
        if(sedFile != null)  {
            Path filePath = Paths.get(sedFile.getAbsolutePath());
            reader = Files.newBufferedReader(filePath,StandardCharsets.UTF_8);
        }
        else {
            reader = new BufferedReader(new InputStreamReader(inputStream, StandardCharsets.UTF_8));
        }
        try {
            String line = null;
            while((line = reader.readLine()) != null) {
                if(replaceAll == true) {
                    writer.write(line.replaceAll(regex, replacement) + System.getProperty("line.separator"));
                }
                else {
                    writer.write(line.replaceFirst(regex, replacement) + System.getProperty("line.separator"));
                }
                writer.flush();
            }
        } catch (IOException e) {
            throw new RuntimeException("sed: cannot read input");
        }
    }

}