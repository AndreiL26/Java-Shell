package uk.ac.ucl.jsh.Applications;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.nio.file.FileSystems;
import java.nio.file.PathMatcher;
import java.nio.file.Paths;
import java.util.ArrayList;

public class Find implements Application {
    private FileSystem fileSystem;
    private String fileSeparator = System.getProperty("file.separator");
    private String lineSeparator = System.getProperty("line.separator");
    private PathMatcher matcher;
    private OutputStreamWriter writer;

    public Find(FileSystem fileSystem) {
        this.fileSystem = fileSystem;
    }

    private void find(String currentDirectoryPath, String currentResolvedPath) throws IOException {
        File currentFile = new File(currentDirectoryPath);
        File[] fileArray = currentFile.listFiles();
        for(File file: fileArray) {
            String currentFilePath = currentDirectoryPath + fileSeparator + file.getName();
            if(file.isFile() && matcher.matches(Paths.get(file.getName()))) {
                writer.write(currentResolvedPath + fileSeparator + file.getName() + lineSeparator);
                writer.flush();
            }
            if(file.isDirectory()) {
                find(currentFilePath, currentResolvedPath + fileSeparator + file.getName());
            }
        }
    }

    private void checkArguments(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException{
        if(applicationArguments.size() < 2) {
            throw new JshException("find: missing arguments");
        }
        if(applicationArguments.size() == 2) {
            if(applicationArguments.get(0).compareTo("-name") != 0) {
                throw new JshException("find: wrong argument");
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
            if(!rootSearchDirectory.isDirectory()) {
                throw new JshException("find: could not open " + applicationArguments.get(0));
            }
            if(applicationArguments.get(1).compareTo("-name") != 0) {
                throw new JshException("find: invalid argument " + applicationArguments.get(1));
            }
        }
        if(applicationArguments.size() > 3) {
            throw new JshException("find: too many arguments");
        }
    }

    @Override
    public void execute(ArrayList<String> applicationArguments, InputStream inputStream, OutputStream outputStream) throws JshException {
        String searchRootDirectory;
        String resolvedPath = ".";
        checkArguments(applicationArguments, inputStream, outputStream);
        writer = new OutputStreamWriter(outputStream);

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
            resolvedPath = applicationArguments.get(0);
        }
        matcher = FileSystems.getDefault().getPathMatcher("glob:" + applicationArguments.get(applicationArguments.size() - 1));
        try {
            find(searchRootDirectory, resolvedPath);
        } catch (IOException e) {
            throw new JshException("find: could not write output");
        }
    }

}