package uk.ac.ucl.jsh.Commands;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;

public class WcCommand extends Command {

    public WcCommand(FileSystem fileSystem, OutputStreamWriter writer) {
        super(fileSystem, writer);
    }

    @Override
    public void runCommand(ArrayList<String> commandArguments) {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("wc: missing arguments");
        }
        ArrayList<String> flags = new ArrayList<String>();
        for (String commandArgument : commandArguments) {
            if (stringIsAValidFileName(commandArgument)) {
                runOnce(flags, commandArgument);
                flags.clear();
            } else {
                flags.add(commandArgument);
            }
        }
        if (!flags.isEmpty()) {
            runOnce(flags, "");
        }
    }

    public void runOnce(ArrayList<String> flags, String filename) {
        ArrayList<String> commandArguments = copyArray(flags, 0, flags.size());
        commandArguments.add(filename);
        checkArguments(commandArguments);

        String currentDirectoryPath = fileSystem.getWorkingDirectoryPath();
        Charset encoding = StandardCharsets.UTF_8;

        String filepathString = currentDirectoryPath + File.separator + filename;

        File currFile = new File(filepathString);
        if (currFile.exists()) {
            Path filePath = Paths.get(filepathString);
            int charCount = 0;
            int wordCount = 0;
            int lineCount = 0;

            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {

                int characterRead;
                while ((characterRead = reader.read()) != -1) {
                    charCount++;
                }
            } catch (IOException e) {
                throw new RuntimeException("wc: cannot open " + filename);
            }

            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    if (!line.equals("")) {
                        String[] words = line.split("\\s+");
                        for (String word : words) {
                            if (stringIsWord(word)) {
                                wordCount++;
                            }
                        }
                    }

                }
            } catch (IOException e) {
                throw new RuntimeException("wc: cannot open " + filename);
            }

            try (BufferedReader reader = Files.newBufferedReader(filePath, encoding)) {

                String line;
                while ((line = reader.readLine()) != null) {
                    lineCount++;
                }
            } catch (IOException e) {
                throw new RuntimeException("wc: cannot open " + filename);
            }

            printCount(charCount, wordCount, lineCount, flags, filename);

        } else {
            throw new RuntimeException("wc: file does not exist");
        }

    }

    private boolean arrayContains(ArrayList<String> array, String element) {
        for (String check : array) {
            if (check.equals(element)) {
                return true;
            }
        }
        return false;
    }

    private void printCount(int charCount, int wordCount, int lineCount, ArrayList<String> flags, String filename) {
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
        return (name.charAt(0) != '-');
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

    public void checkArguments(ArrayList<String> commandArguments) {
        if (commandArguments.isEmpty()) {
            throw new RuntimeException("wc: missing arguments");
        }

        ArrayList<String> flags = copyArray(commandArguments, 0, commandArguments.size() - 1);
        String filename = commandArguments.get(commandArguments.size() - 1);

        for (String flag : flags) {
            if (!stringIsValidFlag(flag)) {
                throw new RuntimeException("wc: invalid flag");
            }
        }
        if (!stringIsAValidFileName(filename)) {
            throw new RuntimeException("wc: invalid file name");
        }
    }
}