package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Echo;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class EchoTest {
    private static Echo echoApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");

    private static String initialWorkingDirectoryPath;
  
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        echoApplication = new Echo(fileSystem);

        fileSystem = FileSystem.getInstance();
        initialWorkingDirectoryPath = fileSystem.getWorkingDirectoryPath();
        fileSystem.setWorkingDirectory("java.io.tmpdir");
    }

    @After
    // Reset the command arguments and reset the outputstream
    public void afterTest() throws IOException {
        applicationArguments.clear();
        outputStream.reset();
    }   

    @AfterClass
    public static void afterClass() {
        fileSystem.setWorkingDirectory(initialWorkingDirectoryPath);
    }

    @Test
    public void testOneArgument() throws JshException {
        applicationArguments.add("hello world");
        echoApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals("hello world" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testMultipleArguments() throws JshException {
        applicationArguments.add("first");
        applicationArguments.add("second");
        applicationArguments.add("third");
        echoApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals("first second third" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testNoArguments() throws JshException {
        echoApplication.execute(applicationArguments, null, outputStream);
        assertEquals("", outputStream.toString());
    }
}