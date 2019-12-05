package uk.ac.ucl.jsh.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;


public class FileSystem {
    private String workingDirectoryPath;


    private void deleteDirectory(File crtDirectory) {
        File[] files = crtDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteDirectory(file);
            }
         }
        crtDirectory.delete();
    }

    private String generateFileText () {
        String resultString = new String();
        
        resultString += "This is a test\n";
        resultString += "This is a test of another test\n";
        resultString += "\n";
        resultString += "Have more lines inside this file!\n";
        resultString += "Anoter strange line!\n";

        return resultString;
    }

    public FileSystem(String workingDirectoryPath) {
        this.setWorkingDirectory(workingDirectoryPath);

    }

    public String getWorkingDirectoryPath() {
        return this.workingDirectoryPath;
    }

    public void setWorkingDirectory(String workingDirectoryPath) {
        this.workingDirectoryPath = workingDirectoryPath;
    }

    public void createTestFileHierarchy() throws IOException {
         // Create two utilities Strings
         String tmpPath = System.getProperty("java.io.tmpdir");
         String fileSeparator = System.getProperty("file.separator");
 
         // Create tmp's children
         Path documentsPath = Files.createDirectory(Paths.get(tmpPath + fileSeparator + "Documents"));
         Path otherPath = Files.createDirectory(Paths.get(tmpPath + fileSeparator + "Other"));
         Path softFilePath = Files.createFile(Paths.get(tmpPath + fileSeparator + "Soft"));

         // Create Documents's children
         Path engPath = Files.createDirectory(Paths.get(documentsPath + fileSeparator + "Eng"));
         Path wareFilePath = Files.createFile(Paths.get(documentsPath + fileSeparator + "Ware"));
         Path projFilePath = Files.createFile(Paths.get(documentsPath + fileSeparator + "Proj"));
         
         // Create Eng's children
         Path testFilePath = Files.createFile(Paths.get(engPath + fileSeparator + "Test"));
         Path codeFilePath = Files.createFile(Paths.get(engPath + fileSeparator + "Code"));
         Path planFilePath = Files.createFile(Paths.get(engPath + fileSeparator + "Plan"));
 
         // Create Other's children
         Path oth1FilePath = Files.createFile(Paths.get(otherPath + fileSeparator + "Oth1"));
         Path oth2FilePath = Files.createFile(Paths.get(otherPath + fileSeparator + "Oth2"));

         // Write to the created files
         Files.write(softFilePath, generateFileText().getBytes(), StandardOpenOption.APPEND);
         Files.write(wareFilePath, generateFileText().getBytes(), StandardOpenOption.APPEND);
    }

    public void deleteTestFileHierarchy() throws IOException {
        // Or should we have a function called deleteAddedFiles that removes all the files in tmp except the one that is already there
        String tmpPath = System.getProperty("java.io.tmpdir");
        String fileSeparator = System.getProperty("file.separator");

        deleteDirectory(new File(tmpPath+fileSeparator+"Documents"));
        deleteDirectory(new File(tmpPath+fileSeparator+"Other"));
        Files.deleteIfExists(Paths.get(tmpPath + fileSeparator + "Soft"));
    }
}