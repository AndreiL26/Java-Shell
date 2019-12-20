package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Find extends Application {
    private String fileSeparator = System.getProperty("file.separator");
    private String lineSeparator = System.getProperty("line.separator");
    private PathMatcher matcher;

    public Find(FileSystem fileSystem) {
        super(fileSystem);
    }

    private void find(String searchRootDirectory, String currentSearchPath, OutputStreamWriter writer) throws IOException {
        File currentFile;
        if (currentSearchPath != "") {
            currentFile = new File(searchRootDirectory + fileSeparator + currentSearchPath);
        }
        else {
            currentFile = new File(searchRootDirectory);
        }
        File[] fileArray = currentFile.listFiles();
        for(File file: fileArray) {
            if(file.isFile() && matcher.matches(Paths.get(file.getName()))) {
                if(currentSearchPath != "") {
                    writer.write(currentSearchPath + fileSeparator + file.getName() + lineSeparator);
                }
                else {
                    writer.write(file.getName() + lineSeparator);
                }
                writer.flush();
            }
            
            if(file.isDirectory()) {
                find(searchRootDirectory, currentSearchPath + fileSeparator + file.getName(), writer);
            }
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws IOException {
        String searchRootDirectory;
        checkArguments(applicationArguments, inputStream, outputStream);
        OutputStreamWriter writer = new OutputStreamWriter(outputStream);

        if(applicationArguments.size() == 2) {
            searchRootDirectory = fileSystem.getWorkingDirectoryPath();
        }
        else {
            if(applicationArguments.get(0).startsWith(fileSeparator)) {
                searchRootDirectory = applicationArguments.get(0);
            }
            else {
                searchRootDirectory = fileSystem.getWorkingDirectoryPath() + fileSeparator + applicationArguments.get(0);
            }
        }
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + applicationArguments.get(applicationArguments.size() - 1));
        find(searchRootDirectory, "", writer);
    }

    public void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) {
        if(applicationArguments.size() < 2) {
            throw new RuntimeException("find: missing arguments");
        }
        if(applicationArguments.size() == 2) {
            if(applicationArguments.get(0).compareTo("-name") != 0) {
                throw new RuntimeException("find: wrong argument");
            }
        }
        if(applicationArguments.size() == 3) {
            File rootSearchDirectory;
            if(applicationArguments.get(0).startsWith(fileSeparator)) {
                rootSearchDirectory = new File(applicationArguments.get(0));
            }
            else {
                rootSearchDirectory = new File(fileSystem.getWorkingDirectoryPath() + fileSeparator + applicationArguments.get(0));
            }
            if(!rootSearchDirectory.exists() || !rootSearchDirectory.isDirectory()) {
                throw new RuntimeException("find: could not open " + applicationArguments.get(0));
            }
            if(applicationArguments.get(1).compareTo("-name") != 0) {
                throw new RuntimeException("find: wrong argument");
            }
        }
        if(applicationArguments.size() > 3) {
            throw new RuntimeException("find: too many arguments");
        }
    }
}