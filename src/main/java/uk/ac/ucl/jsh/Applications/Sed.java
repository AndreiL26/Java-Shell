package uk.ac.ucl.jsh.Applications;

import java.io.OutputStreamWriter;
import java.nio.charset.Charset;
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

public class Sed extends Application {
    private File sedFile;

    public Sed(FileSystem fileSystem) {
        super(fileSystem);
    }

    private boolean isValid(String argument) { /// MIGHT STILL BE WRONG I THINK?
        if(argument.charAt(0) != 's') {
            return false;
        }
        char delimiter = argument.charAt(1);

        if(argument.charAt(argument.length() - 1) != delimiter && argument.charAt(argument.length()-1) != 'g') {
            return false;
        }

        if(argument.codePoints().filter(ch -> ch == delimiter).count() != 3) {
            return false;
        }

        String regex = getRegex(argument);
        if(regex.compareTo("") == 0) {
            return false;
        }

        return true;
    }

    private String getRegex(String argument) {
        char delimiter = argument.charAt(1);
        int firstDelimiterIndex = argument.indexOf(delimiter);
        int secondDelimiterIndex = argument.indexOf(delimiter, firstDelimiterIndex + 1);

        String regex = argument.substring(firstDelimiterIndex+1, secondDelimiterIndex);
        return regex;
    }

    private String getReplacement(String argument) {
        char delimiter = argument.charAt(1);
        int firstDelimiterIndex = argument.indexOf(delimiter);
        int secondDelimiterIndex = argument.indexOf(delimiter, firstDelimiterIndex + 1);
        int thirdDelimiterIndex = argument.indexOf(delimiter, secondDelimiterIndex + 1);
        String replacement = argument.substring(secondDelimiterIndex+1, thirdDelimiterIndex);

        return replacement;
    }


    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        checkArguments(commandArguments, inputStream, outputStream);
        String regex = getRegex(commandArguments.get(0));
        String replacement  = getReplacement(commandArguments.get(0));
        boolean replaceAll = false;
        Charset encoding = StandardCharsets.UTF_8;
        BufferedReader reader;
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        if(commandArguments.get(0).endsWith("g")) {
            replaceAll = true;
        }
        
        if(sedFile != null)  {
            Path filePath = Paths.get(sedFile.getAbsolutePath());
            reader = Files.newBufferedReader(filePath,encoding);
        }
        else {
            reader = new BufferedReader(new InputStreamReader(inputStream));
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
            throw new RuntimeException("sed: cannot open " + commandArguments.get(1));
        }
    }

    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputStream) {
        int numberOfArguments = commandArguments.size();
        if(numberOfArguments == 0)
            throw new RuntimeException("sed: missing arguments!");
        if(numberOfArguments >= 1) {
            if(isValid(commandArguments.get(0)) == false) {
                throw new RuntimeException("sed: invalid first argument!");
            } 
        }

        if(numberOfArguments == 2){
            String filePath = commandArguments.get(1);
            
            if(filePath.charAt(0) == '/') {
                sedFile = new File(commandArguments.get(1));
            }
            else {
                sedFile = new File(fileSystem.getWorkingDirectoryPath() + System.getProperty("file.separator") + filePath);
            }

            if(!sedFile.exists()) {
                throw new RuntimeException("sed: cannot open " + filePath);
            }
        }
        else if (numberOfArguments > 2){
            throw new RuntimeException("sed: too many arguments!");
        }
    }

}