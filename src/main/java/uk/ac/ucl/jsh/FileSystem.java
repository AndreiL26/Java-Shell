package uk.ac.ucl.jsh;

public class FileSystem {
    private String workingDirectoryPath;

    public FileSystem () {
        workingDirectoryPath = System.getProperty("user.dir");
    }

    public String getWorkingDirectoryPath() {
        return this.workingDirectoryPath;
    }

    public void setWorkingDirectory(String workingDirectoryPath) {
        this.workingDirectoryPath = workingDirectoryPath;
    }
}