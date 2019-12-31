package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Tail;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class TailTest {
    private static Tail tailApplication;
    private static FileSystem fileSystem = Jsh.getFileSystem();
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");

    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        outputStream = new ByteArrayOutputStream();
        tailApplication = new Tail(fileSystem);
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
    public void testInvalidNumberOfArgumentsTooMany() {
        try {
            applicationArguments.add("one");
            applicationArguments.add("two");
            applicationArguments.add("three");
            applicationArguments.add("four");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw a too many arguments exception");
        } catch (JshException e) {
           assertEquals("tail: too many arguments", e.getMessage());
        }
    }

    @Test
    public void testMissingInput() {
        try {
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw a missing input exception");
        } catch (JshException e) {
            assertEquals("tail: missing input", e.getMessage());
        }
    }

    @Test
    public void testMissingInputTwoArguments() {
        try {
            applicationArguments.add("-n");
            applicationArguments.add("15");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw a missing input exception");
        } catch (JshException e) {
            assertEquals("tail: missing input", e.getMessage());
        }
    }

    @Test
    public void testInvalidFirstArgumentMissingDashn() {
        try {
            applicationArguments.add("15");
            applicationArguments.add("FilePath");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw an invalid argument exception");
        } catch (JshException e) {
            assertEquals("tail: wrong argument " + "15", e.getMessage());
        }
    }

    @Test
    public void testInvalidFirsArgumentNotANumber() {
        try {
            applicationArguments.add("-n");
            applicationArguments.add("I'm not a number!");
            applicationArguments.add("FilePath");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw a wrong argument exception");
        } catch (JshException e) {
            assertEquals("tail: wrong argument " + "I'm not a number!", e.getMessage());
        }
    }

    @Test  
    public void testInvalidFilePath() {
        try {
            applicationArguments.add("-n");
            applicationArguments.add("15");
            applicationArguments.add("InvalidPath");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw an invalig argument exception");
        } catch (JshException e) {
            assertEquals("tail: " + "InvalidPath" + " does not exist", e.getMessage());
        }
    }

    @Test
    public void testValidPathToDirectoryNotFile() {
        try {
            applicationArguments.add("-n");
            applicationArguments.add("6");
            applicationArguments.add("/tmp/Documents/Eng");
            tailApplication.execute(applicationArguments, null, outputStream);
            fail("tail did not throw a cannot read input exception");
        } catch (JshException e) {
            assertEquals("tail: cannot read input", e.getMessage());
        }
    }

    @Test
    public void testDefaultNumberOfLinesFromAbsolutePath() throws JshException {
        applicationArguments.add("/tmp/Documents/Eng/Test");
        String expectedOutput = new String();
        for(int i = 10; i < 20; ++ i) {
            expectedOutput += "Line number: " + Integer.toString(i) + lineSeparator;
        }
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDefaultNumberOfLinesFromRelativePath() throws JshException {
        fileSystem.setWorkingDirectory("/tmp/Documents/Eng");
        applicationArguments.add("Test");
        String expectedOutput = new String();
        for(int i = 10; i < 20; ++ i) {
            expectedOutput += "Line number: " + Integer.toString(i) + lineSeparator;
        }
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testCustomNumberOfLinesLessThanInFile() throws JshException {
        applicationArguments.add("-n");
        applicationArguments.add("15");
        applicationArguments.add("/tmp/Documents/Eng/Test");
        String expectedOutput = new String();
        for(int i = 5; i < 20; ++ i) {
            expectedOutput += "Line number: " + Integer.toString(i) + lineSeparator;
        }
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testCustomNumberOfLinesMoreThanInFile() throws JshException {
        applicationArguments.add("-n");
        applicationArguments.add("55");
        applicationArguments.add("/tmp/Documents/Eng/Test");
        String expectedOutput = new String();
        for(int i = 0; i < 20; ++ i) {
            expectedOutput += "Line number: " + Integer.toString(i) + lineSeparator;
        }
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testCustomNumberOfLinesNegativeNumber() throws JshException {
        applicationArguments.add("-n");
        applicationArguments.add("-15");
        applicationArguments.add("/tmp/Documents/Eng/Test");
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void testReadFromEmptyFile() throws JshException {
        applicationArguments.add("/tmp/Documents/Proj.txt");
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals("", outputStream.toString());
    }

    @Test
    public void testReadFromInputStream() throws IOException, JshException {
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        String expectedOutput = "Hello world" + lineSeparator + "I am here!" + lineSeparator;
        writer.write(expectedOutput);
        writer.flush();
        writer.close();
        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        tailApplication.execute(applicationArguments, testInput, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testReadFromInputStreamWithCustomNumberOfLines() throws IOException, JshException {
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        String expectedOutput = "First line" + lineSeparator;
        expectedOutput += "Second line" + lineSeparator;
        expectedOutput += "Third line" + lineSeparator;
        expectedOutput += "Fourth line" + lineSeparator;
        writer.write(expectedOutput);
        writer.flush();
        writer.close();
        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        applicationArguments.add("-n");
        applicationArguments.add("2");
        tailApplication.execute(applicationArguments, testInput, outputStream);
        assertEquals("Third line" + lineSeparator + "Fourth line" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testFromGlobbedPath() throws JshException {
        applicationArguments.add("/tmp/Doc*ts/Eng/Test");
        String expectedOutput = new String();
        for(int i = 10; i < 20; ++ i) {
            expectedOutput += "Line number: " + Integer.toString(i) + lineSeparator;
        }
        tailApplication.execute(applicationArguments, null, outputStream);
        assertEquals(expectedOutput, outputStream.toString());
    }
}