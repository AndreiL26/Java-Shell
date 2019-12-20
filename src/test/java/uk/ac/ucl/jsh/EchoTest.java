package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Echo;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
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
  
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        echoApplication = new Echo(fileSystem);
    }

    @After
    // Reset the command arguments and reset the outputstream
    public void afterTest() throws IOException {
        applicationArguments.clear();
        outputStream.reset();
    }   

    @Test
    public void testOneArgument() throws IOException {
        applicationArguments.add("hello world");
        echoApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals("hello world" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testMultipleArguments() throws IOException {
        applicationArguments.add("first");
        applicationArguments.add("second");
        applicationArguments.add("third");
        echoApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals("first second third" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testNoArguments() throws IOException {
        echoApplication.execute(applicationArguments, null, outputStream);
        assertEquals("", outputStream.toString());
    }
}