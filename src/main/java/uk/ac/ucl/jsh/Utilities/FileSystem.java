package uk.ac.ucl.jsh.Utilities;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import uk.ac.ucl.jsh.Jsh;


public final class FileSystem {
    private static final FileSystem INSTANCE = new FileSystem(System.getProperty("user.dir"));
    private String workingDirectoryPath;

    public static FileSystem getInstance() {
        return INSTANCE;
    }

    private void deleteDirectory(File crtDirectory) {
        File[] files = crtDirectory.listFiles();
        if (files != null) {
            for (File file : files) {
                deleteDirectory(file);
            }
         }
        crtDirectory.delete();
    }

    private String generateFileText() {
        String resultString = new String();
        resultString += "This is a test" + Jsh.lineSeparator;
        resultString += "This is a test of another test" + Jsh.lineSeparator;
        resultString += Jsh.lineSeparator;
        return resultString;
    }

    private String generateLongFileText(int lines) {
        String resultString = new String();
        for(int i = 0; i < lines; ++ i) {
            resultString += "Line number: " + Integer.toString(i) + Jsh.lineSeparator;
        }
        return resultString;
    }

    private FileSystem(String workingDirectoryPath) {
        this.setWorkingDirectory(workingDirectoryPath);
    }

    public String getWorkingDirectoryPath() {
        return this.workingDirectoryPath;
    }

    public void setWorkingDirectory(String workingDirectoryPath) {
        this.workingDirectoryPath = workingDirectoryPath;
    }

    public File getFile(String filePath) {
        return new File(getFilePath(filePath));
    }

    public String getFilePath(String filePath) {
        if(filePath.startsWith(Jsh.fileSeparator)) {
            return filePath;
        }
        
        return workingDirectoryPath + Jsh.fileSeparator + filePath;
    }

    public void createTestFileHierarchy() throws IOException {
         // Create two utilities Strings
         String tmpPath = System.getProperty("java.io.tmpdir");
         String fileSeparator = Jsh.fileSeparator;
 
         // Create tmp's children
         Path documentsPath = Files.createDirectory(Paths.get(tmpPath + fileSeparator + "Documents"));
         Path otherPath = Files.createDirectory(Paths.get(tmpPath + fileSeparator + "Other"));
         Path softFilePath = Files.createFile(Paths.get(tmpPath + fileSeparator + "Soft"));

         // Create Documents's children
         Path engPath = Files.createDirectory(Paths.get(documentsPath + fileSeparator + "Eng"));
         Path wareFilePath = Files.createFile(Paths.get(documentsPath + fileSeparator + "Ware"));
         Files.createFile(Paths.get(documentsPath + fileSeparator + "Proj.txt"));
         
         // Create Eng's children
         Path testFilePath = Files.createFile(Paths.get(engPath + fileSeparator + "Test"));
         Files.createFile(Paths.get(engPath + fileSeparator + "Code"));
         Files.createFile(Paths.get(engPath + fileSeparator + "Plan"));
 
         // Create Other's children
         Path oth1FilePath = Files.createFile(Paths.get(otherPath + fileSeparator + "Oth1"));
         Path oth2FilePath = Files.createFile(Paths.get(otherPath + fileSeparator + "Oth2"));
         Files.createFile(Paths.get(otherPath + fileSeparator + ".test"));
         Files.createDirectory(Paths.get(otherPath + fileSeparator + "Empty"));

         // Write to the created files
         Files.write(softFilePath, generateFileText().getBytes(),     StandardOpenOption.APPEND);
         Files.write(wareFilePath, generateFileText().getBytes(),     StandardOpenOption.APPEND);
         Files.write(oth1FilePath, generateFileText().getBytes(),     StandardOpenOption.APPEND);
         Files.write(oth2FilePath, generateFileText().getBytes(),     StandardOpenOption.APPEND);
         Files.write(testFilePath, generateLongFileText(20).getBytes(), StandardOpenOption.APPEND);
        
    }

    public void deleteTestFileHierarchy() throws IOException {
        String tmpPath = System.getProperty("java.io.tmpdir");

        deleteDirectory(new File(tmpPath+Jsh.fileSeparator+"Documents"));
        deleteDirectory(new File(tmpPath+Jsh.fileSeparator+"Other"));
        Files.deleteIfExists(Paths.get(tmpPath + Jsh.fileSeparator + "Soft"));
    }


}
