package uk.ac.ucl.jsh.Utilities;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


public class FileSystem {
    private String workingDirectoryPath;

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
         Files.createFile(Paths.get(tmpPath + fileSeparator + "Soft"));

         // Create Documents's children
         Path engPath = Files.createDirectory(Paths.get(documentsPath + fileSeparator + "Eng"));
         Files.createFile(Paths.get(documentsPath + fileSeparator + "Ware"));
         Files.createFile(Paths.get(documentsPath + fileSeparator + "Proj"));
         
         // Create Eng's children
         Files.createFile(Paths.get(engPath + fileSeparator + "Test"));
         Files.createFile(Paths.get(engPath + fileSeparator + "Code"));
         Files.createFile(Paths.get(engPath + fileSeparator + "Plan"));
 
         // Create Other's children
         Files.createFile(Paths.get(otherPath + fileSeparator + "Oth1"));
         Files.createFile(Paths.get(otherPath + fileSeparator + "Oth2"));
    }

    public void deleteTestFileHierarchy() throws IOException {

        /// REFACTORING -> ADD A RECURSIVE METHOD TO DELETE A DIRECTORY PLEASE!

        String tmpPath = System.getProperty("java.io.tmpdir");
        String fileSeparator = System.getProperty("file.separator");

        Path documentsPath = Paths.get(tmpPath + fileSeparator + "Documents");
        Path otherPath = Paths.get(tmpPath + fileSeparator + "Other");
        Path engPath = Paths.get(documentsPath + fileSeparator + "Eng");

        Files.deleteIfExists(Paths.get(tmpPath + fileSeparator + "Soft"));

        Files.deleteIfExists(Paths.get(otherPath + fileSeparator + "Oth1"));
        Files.deleteIfExists(Paths.get(otherPath + fileSeparator + "Oth2"));
        Files.deleteIfExists(otherPath);

        Files.deleteIfExists(Paths.get(engPath + fileSeparator + "Test"));
        Files.deleteIfExists(Paths.get(engPath + fileSeparator + "Code"));
        Files.deleteIfExists(Paths.get(engPath + fileSeparator + "Plan"));
        Files.deleteIfExists(engPath);


        Files.deleteIfExists(Paths.get(documentsPath + fileSeparator + "Ware"));
        Files.deleteIfExists(Paths.get(documentsPath + fileSeparator + "Proj"));
        Files.deleteIfExists(documentsPath);
    }
}