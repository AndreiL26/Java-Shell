package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Echo;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


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

    @Before
    // Create the File Hierarchy
    public void createHierarchy() throws IOException {
        fileSystem.createTestFileHierarchy();
        fileSystem.setWorkingDirectory(System.getProperty("java.io.tmpdir"));
    }

      @After
     // Delete the test hierarchy, reset the command arguments and reset the outputstream
     public void afterTest() throws IOException {
         fileSystem.deleteTestFileHierarchy();
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

    @Test
    public void testMultipleArgumentsFromGlobbing() throws IOException {
        fileSystem.setWorkingDirectory(System.getProperty("file.separator") + "tmp" + System.getProperty("file.separator") + "Other");
        System.out.println(fileSystem.getWorkingDirectoryPath());
        applicationArguments.add("*");
        echoApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings(".test Oth1 Oth2 Empty", outputStream.toString());
    }

    private void assertEqualStrings(String expectedString, String actualString) {
        ArrayList<String> expectedTokens = new ArrayList<>(Arrays.asList(expectedString.trim().split(" ")));
        ArrayList<String> actualTokens = new ArrayList<>(Arrays.asList(actualString.trim().split(" ")));
        Collections.sort(expectedTokens);
        Collections.sort(actualTokens);
        assertEquals(expectedTokens, actualTokens);
    }
}