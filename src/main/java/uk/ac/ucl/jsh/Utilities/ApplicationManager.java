package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Applications.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ApplicationManager {
    private HashMap<String, Application> applicationMap;
    private FileSystem fileSystem;

    public ApplicationManager(FileSystem fileSystem) {
        applicationMap = new HashMap<>();
        this.fileSystem = fileSystem;
        createApplications();
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void executeApplication(ArrayList<String> tokens, InputStream inputStream, OutputStream outputStream) {
        String applicationName = tokens.get(0);
        ArrayList<String> applicationArguments = new ArrayList<String>(tokens.subList(1, tokens.size()));
        try {
            if(applicationMap.containsKey(applicationName)) {
                Application currentApplication = applicationMap.get(applicationName);
                currentApplication.execute(applicationArguments, inputStream, outputStream);
            } else {
                throw new RuntimeException(applicationName + ": unknown application");
            }
        }catch (IOException e) {
            throw new RuntimeException(applicationName + ": can't execute!");
        }
    }

    private  void createApplications() {
        applicationMap.put("pwd",  new Pwd(fileSystem));
        applicationMap.put("cd",   new Cd(fileSystem));
        applicationMap.put("ls",   new Ls(fileSystem));
        applicationMap.put("cat",  new Cat(fileSystem));
        applicationMap.put("echo", new Echo(fileSystem));
        applicationMap.put("head", new Head(fileSystem));
        applicationMap.put("tail", new Tail(fileSystem));
        applicationMap.put("grep", new Grep(fileSystem));
        applicationMap.put("sed",  new Sed(fileSystem));
        applicationMap.put("find", new Find(fileSystem));
    }
}