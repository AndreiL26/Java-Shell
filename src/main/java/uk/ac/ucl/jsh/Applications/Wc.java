package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.io.InputStreamReader;

public class Wc extends Application {

    public Wc(FileSystem fileSystem) {
        super(fileSystem);
    }

    @Override
    public void execute(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputstream) {
        ArrayList<String> flags = new ArrayList<String>();
        for (String commandArgument : commandArguments) {
            if (stringIsAValidFileName(commandArgument)) {
                runOnce(flags, commandArgument, inputStream, outputstream);
                flags.clear();
            } else {
                flags.add(commandArgument);
            }
        }
        if (!flags.isEmpty() || commandArguments.isEmpty()) {
            runOnce(flags, null, inputStream, outputstream);
        }
    }

    private BufferedReader createBufferedReader(String filename, InputStream inputStream) {
        BufferedReader reader;
        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        String filepathString = currentDirectoryPath + File.separator + filename;
        File currFile = new File(filepathString);
        if (filename == null) {
            InputStreamReader in = new InputStreamReader(inputStream);
            reader = new BufferedReader(in);
        } else {
            if (!currFile.exists()) {
                throw new RuntimeException("wc: file does not exist");
            }
            Path filePath = Paths.get(filepathString);
            try {
                reader = Files.newBufferedReader(filePath, StandardCharsets.UTF_8);
            } catch (Exception e) {
                throw new RuntimeException("wc: cannot open " + filename);
            }
        }
        return reader;
    }

    public void runOnce(ArrayList<String> flags, String filename, InputStream inputStream, OutputStream outputstream) {
        ArrayList<String> commandArguments = copyArray(flags, 0, flags.size());
        commandArguments.add(filename);
        checkArguments(commandArguments, inputStream, outputstream);

        int charCount = 0;
        int wordCount = 0;
        int lineCount = 0;

        BufferedReader reader = createBufferedReader(filename, inputStream);

            int characterRead = 0;
            while (characterRead != -1) {
                try {
                    if ((characterRead = reader.read()) != -1) {
                        charCount++;
                    }
                } catch (Exception e) {
                    break;
                }
            }

        reader = createBufferedReader(filename, inputStream);

            String line = "";
                try {
                    while ((line = reader.readLine()) != null) {
                        lineCount++;
                        if (!line.equals("")) {
                            String[] words = line.split("\\s+");
                            for (String word : words) {
                                if (stringIsWord(word)) {
                                    wordCount++;
                                }
                            }
                        }
                    }
                } catch (Exception e) {
                    throw new RuntimeException("wc: cannot read " + filename);
                }

        printCount(charCount, wordCount, lineCount, flags, filename, outputstream);

    }

    private boolean arrayContains(ArrayList<String> array, String element) {
        for (String check : array) {
            if (check.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void printCount(int charCount, int wordCount, int lineCount, ArrayList<String> flags, String filename, OutputStream outputstream) {
        String output = new String();
        if (arrayContains(flags, "-m") || flags.isEmpty()) {
            output += charCount + " ";
        }
        if (arrayContains(flags, "-w") || flags.isEmpty()) {
            output += wordCount + " ";
        }
        if (arrayContains(flags, "-l") || flags.isEmpty()) {
            output += lineCount + " ";
        }
        output += filename;

        try {
            OutputStreamWriter writer = new OutputStreamWriter(outputstream);
            writer.write(output);
            writer.write(System.getProperty("line.separator"));
            writer.flush();
        } catch (IOException e) {
            throw new RuntimeException("wc: cannot write count to output");
        }
    }

    private boolean stringIsWord(String word) {
        String[] illegalWords = { "", " ", "\n", null };
        for (String illegalWord : illegalWords) {
            if (word.equals(illegalWord)) {
                return false;
            }
        }
        return true;
    }

    private boolean stringIsAValidFileName(String name) {
        // check for null because if there is no file name we use stdin
        return (name == null || name.charAt(0) != '-');
    }

    private boolean stringIsValidFlag(String name) {
        return (name.equals("-m") || name.equals("-w") || name.equals("-l"));
    }

    private ArrayList<String> copyArray(ArrayList<String> array, int start, int end) {
        ArrayList<String> newArray = new ArrayList<String>();
        for (int i = start; i < end; i++) {
            if (i < 0 || i >= array.size()) {
                continue;
            }
            newArray.add(array.get(i));
        }
        return newArray;
    }

    public void checkArguments(ArrayList<String> commandArguments, InputStream inputStream, OutputStream outputstream) {
        for (String commandArgument : commandArguments) {
            if (!stringIsAValidFileName(commandArgument) && !stringIsValidFlag(commandArgument)) {
                throw new RuntimeException("wc: invalid arguments");
            } 
        }
    }
}