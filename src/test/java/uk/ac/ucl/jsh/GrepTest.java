package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Grep;
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
import java.util.Arrays;
import java.util.Collections;



public class GrepTest {
    private static Grep grepApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");

    private String initialWorkingDirectoryPath;
    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = FileSystem.getInstance();
        outputStream = new ByteArrayOutputStream();
        grepApplication = new Grep(fileSystem);
    }

    @Before
    // Create the File Hierarchy
    public void createHierarchy() throws IOException {
        initialWorkingDirectoryPath = fileSystem.getWorkingDirectoryPath();
        fileSystem.createTestFileHierarchy();
        fileSystem.setWorkingDirectory(System.getProperty("java.io.tmpdir"));
     }
 
     @After
     // Delete the test hierarchy, reset the command arguments and reset the outputstream
     public void afterTest() throws IOException {
         fileSystem.deleteTestFileHierarchy();
         applicationArguments.clear();
         outputStream.reset();
         fileSystem.setWorkingDirectory(initialWorkingDirectoryPath);
    }   
    
    @Test
    public void testInvalidNumberOfArgumentsMissingArguments() {
        try {
            grepApplication.execute(applicationArguments, null, outputStream);
            fail("grep did not throw a missing arguments exception");
        } catch (JshException e) {
           assertEquals("grep: missing arguments", e.getMessage());
        }
    }

    @Test
    public void testMissingInput() {
        try {
            applicationArguments.add("pattern");
            grepApplication.execute(applicationArguments, null, outputStream);
            fail("grep did not throw a missing input exception");
        } catch (JshException e) {
            assertEquals("grep: missing input", e.getMessage());
        }
    }

    @Test
    public void testInvalidArgumentInvalidPath() {
        try {
            applicationArguments.add("pattern");
            applicationArguments.add("InvalidPath");
            grepApplication.execute(applicationArguments, null, outputStream);
            fail("grep did no throw a cannot open exception");
        } catch (JshException e) {
            assertEquals("grep: cannot open " + "InvalidPath", e.getMessage());
        }
    }

    @Test
    public void testReadingFromDirectoryPath() {
        try {
            applicationArguments.add("pattern");
            applicationArguments.add("Documents");
            grepApplication.execute(applicationArguments, null, outputStream);
            fail("grep did not throw a cannot open exception");
        } catch (JshException e) {
            assertEquals("grep: cannot open " + "Documents", e.getMessage());
        }
    }



    @Test
    public void testReadFromEmptyFile() throws JshException {
        applicationArguments.add(".*");
        applicationArguments.add("/tmp/Documents/Eng/Plan");
        grepApplication.execute(applicationArguments, null, outputStream);
        assertEquals("", outputStream.toString());
    }   

    @Test
    public void testReadFromInputStream() throws IOException, JshException {
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        String inputString = "Hello world" + lineSeparator + "Hello there" + lineSeparator + "Bye" + lineSeparator + lineSeparator;
        writer.write(inputString);
        writer.flush();
        writer.close();
        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        applicationArguments.add("Hello");
        grepApplication.execute(applicationArguments, testInput, outputStream);
        String expectedOutput = "Hello world" + lineSeparator + "Hello there" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testReadFromInputStreamWihComplexRegex() throws IOException, JshException {
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        String inputString = "Hello world" + lineSeparator + "Hello there" + lineSeparator + "Bye" + lineSeparator + "Wow, Hello" + lineSeparator + lineSeparator;
        writer.write(inputString);
        writer.flush();
        writer.close();
        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        applicationArguments.add(".+el{2}.{1}");
        grepApplication.execute(applicationArguments, testInput, outputStream);
        String expectedOutput = "Hello world" + lineSeparator + "Hello there" + lineSeparator + "Wow, Hello" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testReadFromFileAbsolutePath() throws JshException {
        applicationArguments.add("Lin.*");
        applicationArguments.add("/tmp/Documents/Eng/Test");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        for(int i = 0; i < 20; ++ i) {
            expectedOutput += "/tmp/Documents/Eng/Test: " + "Line number: " + Integer.toString(i) + lineSeparator;
        }
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testReadFromFileRelativePath() throws JshException {
        applicationArguments.add("test");
        applicationArguments.add("Soft");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "Soft: This is a test" + lineSeparator;
        expectedOutput += "Soft: This is a test of another test" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testReadFromMultipleFiles() throws JshException {
        applicationArguments.add("test");
        applicationArguments.add("/tmp/Soft");
        applicationArguments.add("Documents/Ware");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "/tmp/Soft: This is a test" + lineSeparator;
        expectedOutput += "/tmp/Soft: This is a test of another test" + lineSeparator;
        expectedOutput += "Documents/Ware: This is a test" + lineSeparator;
        expectedOutput += "Documents/Ware: This is a test of another test" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void readFromFileWithInputStreamNotNull() throws IOException, JshException {
        applicationArguments.add("test");
        applicationArguments.add("/tmp/Soft");
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        String inputString = "Hello world" + lineSeparator + "Hello there" + lineSeparator + "Bye" + lineSeparator + lineSeparator;
        writer.write(inputString);
        writer.flush();
        writer.close();
        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        grepApplication.execute(applicationArguments, testInput, outputStream);
        String expectedOutput = new String();
        expectedOutput += "/tmp/Soft: This is a test" + lineSeparator;
        expectedOutput += "/tmp/Soft: This is a test of another test" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }


    @Test
    public void testReadFromGlobbedPath() throws JshException{
        applicationArguments.add("Line");
        applicationArguments.add("/tmp/Docu*s/Eng/Test");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        for(int i = 0; i < 20; ++ i) {
            expectedOutput += "/tmp/Documents/Eng/Test: " + "Line number: " + Integer.toString(i) + lineSeparator;
        }
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testWithGlobbedArguments() throws JshException{
        applicationArguments.add("L*e");
        applicationArguments.add("/tmp/Docu*s/Eng/Test");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        for(int i = 0; i < 20; ++ i) {
            expectedOutput += "/tmp/Documents/Eng/Test: " + "Line number: " + Integer.toString(i) + lineSeparator;
        }
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMultipleFIlesFromGlobbedArgument() throws JshException {
        applicationArguments.add("test");
        applicationArguments.add("/tmp/Other/Oth*");
        grepApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "/tmp/Other/Oth1: This is a test" + lineSeparator;
        expectedOutput += "/tmp/Other/Oth1: This is a test of another test" + lineSeparator;
        expectedOutput += "/tmp/Other/Oth2: This is a test" + lineSeparator;
        expectedOutput += "/tmp/Other/Oth2: This is a test of another test" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    private void assertEqualStrings(String expectedString, String actualString) {
        ArrayList<String> expectedTokens = new ArrayList<>(Arrays.asList(expectedString.trim().split("\t")));
        ArrayList<String> actualTokens = new ArrayList<>(Arrays.asList(actualString.trim().split("\t")));
        Collections.sort(expectedTokens);
        Collections.sort(actualTokens);
        assertEquals(expectedTokens, actualTokens);
    }
}