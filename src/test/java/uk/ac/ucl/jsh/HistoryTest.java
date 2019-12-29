package uk.ac.ucl.jsh;

import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.ucl.jsh.Applications.History;
import uk.ac.ucl.jsh.Utilities.FileSystem;

public class HistoryTest {
    private static History historyApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");
    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        historyApplication = new History(fileSystem);
    }

    @Before
    // Create the test hierarchy
    public void beforeTest() throws IOException {
       fileSystem.createTestFileHierarchy();
       fileSystem.setWorkingDirectory(System.getProperty("java.io.tmpdir"));
       Jsh.clearHistory();
    }

    @After
    // Delete the test hierarchy, reset the command arguments and reset the outputstream
    public void afterTest() throws IOException {
        fileSystem.deleteTestFileHierarchy();
        applicationArguments.clear();
        outputStream.reset();
    }  
    
    @Test
    public void zeroArgumentsHistoryTest() throws IOException {
        ArrayList<String> history = Jsh.getHistory();
        history.add("abc");
        history.add("xyz");

        String expectedString = "1. abc" + lineSeparator + "2. xyz" + lineSeparator;
        historyApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedString, outputStream.toString());
    }

    @Test
    public void oneArgumentHistoryTest() throws IOException {
        applicationArguments.add("2");

        ArrayList<String> history = Jsh.getHistory();
        history.add("abc");
        history.add("xyz");
        history.add("mnp");

        String expectedString = "2. xyz" + lineSeparator + "3. mnp" + lineSeparator;
        historyApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedString, outputStream.toString());
    }

    @Test
    public void oneArgumentTooBigHistoryTest() throws IOException {
        applicationArguments.add("10");

        ArrayList<String> history = Jsh.getHistory();
        history.add("abc");
        history.add("xyz");
        history.add("mnp");

        String expectedString = "1. abc" + lineSeparator + "2. xyz" + lineSeparator + "3. mnp" + lineSeparator;
        historyApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedString, outputStream.toString());
    }

}