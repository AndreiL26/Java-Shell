package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;

import uk.ac.ucl.jsh.Utilities.JshException;

public class Wc implements Application {
    private int charCount;
    private int wordCount;
    private int lineCount;

    private boolean isValidFlag(String argument) {
        if(!argument.startsWith("-")) {
            return false;
        }
        for(int i = 1; i < argument.length(); ++ i) {
            if(argument.charAt(i) != 'm' && argument.charAt(i) != 'w' && argument.charAt(i) != 'l') {
                return false;
            }
        }
        /* Can you have -mmlll like in bash?
        if(argument.length() > 4) {
            return false;
        }
        */
        return true;
    }

    private void updateFlags(String argument, int[] flags) {
        if(argument.contains("m")) {
            flags[0] = 1;
        }
        if(argument.contains("w")) {
            flags[1] = 1;
        }
        if(argument.contains("l")) {
            flags[2] = 1;
        }
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, int[] flags, ArrayList<String> fileNames) throws JshException {
        for(String argument: applicationArguments) {
            if(isValidFlag(argument)) {
                updateFlags(argument, flags);
            }
            else {
                fileNames.add(argument);
            }
        }
        if(fileNames.size() == 0 && inputStream == null) {
            throw new JshException("wc: missing input");
        }
    }

    private void solveForInput(BufferedReader reader, OutputStreamWriter writer) throws JshException {
        try {
            String currentLine = reader.readLine();
            while (currentLine != null) {
                lineCount++;
                charCount += currentLine.length() + 1;    // +1 to account for the newline as being the newline
                String[] words = currentLine.split(" ");
                if(!words[0].equals("")) {
                    wordCount = wordCount + words.length;
                }
                currentLine = reader.readLine();
            }
        } catch (IOException e) {
            throw new JshException("wc: cannot read input");
        }
    }

    private void resetCount() {
        charCount = lineCount = wordCount = 0;
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        resetCount();
        int[] flags = new int[] {0,0,0};  //  indexes correspond to {m, w, l}
        ArrayList<String> fileNames = new ArrayList<>();
        applicationArguments = Application.globArguments(applicationArguments, -1);
        checkArguments(applicationArguments, inputStream, flags, fileNames);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        if(fileNames.size() == 0) {
            solveForInput(new BufferedReader(new InputStreamReader(inputStream)), writer);
        }
        else {
            for(String fileName: fileNames) {
                File currFile = FileSystem.getInstance().getFile(fileName);
                if (currFile.exists()) {
                    if(currFile.isFile()) { 
                        try (BufferedReader reader = Files.newBufferedReader(Paths.get(currFile.getPath()), StandardCharsets.UTF_8)) {
                            solveForInput(reader, writer);
                        } 
                        catch (IOException e) {
                            throw new JshException("wc: cannot open " + fileName);
                        }
                    } 
                    else {
                        throw new JshException("wc: " + fileName + " is a directory");
                    }
                } 
                else {
                    throw new JshException("wc: file does not exist");
                }
            }
        }
        try {
            if(flags[0] == 0 && flags[1] == 0 && flags[2] == 0) {
                writer.write(charCount + " " + wordCount + " " + lineCount + " ");
            }
            else {
                if(flags[2] == 1) {
                    writer.write(lineCount + " ");
                } 
                if(flags[1] == 1) {
                    writer.write(wordCount + " ");
                }
                if(flags[0] == 1) {
                    writer.write(charCount + " ");
                } 
            } 
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        } catch(IOException e) {
            throw new JshException("wc: cannot write output");
        }
    }
}