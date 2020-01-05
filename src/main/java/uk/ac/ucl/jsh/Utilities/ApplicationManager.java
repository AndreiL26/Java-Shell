package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Applications.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.InputStream;
import java.io.OutputStream;

public class ApplicationManager {
    private HashMap<String, Application> applicationMap;

    public ApplicationManager() {
        applicationMap = new HashMap<>();
        createApplications();
    }

    public void executeApplication(ArrayList<String> tokens, InputStream inputStream, OutputStream outputStream) throws JshException {
        String applicationName = tokens.get(0).toLowerCase();
        boolean unsafeVersion = false;
        ArrayList<String> applicationArguments = new ArrayList<String>(tokens.subList(1, tokens.size()));
        
        if(applicationName.startsWith("_")) {
            applicationName = applicationName.subSequence(1, applicationName.length()).toString();
            unsafeVersion = true;
        }
        if(applicationMap.containsKey(applicationName)) {
            Application currentApplication = applicationMap.get(applicationName);
            if(unsafeVersion) {
                UnsafeApplicationDecorator unsafeApplication = new UnsafeApplicationDecorator(currentApplication);
                unsafeApplication.execute(applicationArguments, inputStream, outputStream);
            }
            else {
                currentApplication.execute(applicationArguments, inputStream, outputStream);
            }
        } 
        else {
            throw new JshException(applicationName + ": unknown application");
        }
    }
    
    private  void createApplications() {
        applicationMap.put("pwd",     new Pwd());
        applicationMap.put("cd",      new Cd());
        applicationMap.put("ls",      new Ls());
        applicationMap.put("cat",     new Cat());
        applicationMap.put("echo",    new Echo());
        applicationMap.put("head",    new Head());
        applicationMap.put("tail",    new Tail());
        applicationMap.put("grep",    new Grep());
        applicationMap.put("sed",     new Sed());
        applicationMap.put("find",    new Find());
        applicationMap.put("history", new History());
        applicationMap.put("wc",      new Wc());
    }

    /*
    public static String encodePath(String path) {
        // replaces all the / with a file separator for JUnit tests
        return path.replaceAll("/", System.getProperty("file.separator"));
    }*/
}