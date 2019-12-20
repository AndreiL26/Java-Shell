package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Cat;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;


public class CatTest {
    private static Cat catApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");
    private String fileSeparator = System.getProperty("file.separator");
    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        catApplication = new Cat(fileSystem);
    }

    @Before
    // Create the test hierarchy
    public void beforeTest() throws IOException {
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
    public void testInvalidPath() throws IOException {
        applicationArguments.add("/InvalidPath");
        try {
            catApplication.execute(applicationArguments, System.in, outputStream);
            fail("cat did not throw an invalid path exception");
        } catch(RuntimeException e) {
           String expectedMessage = "cat: file does not exist";
           assertEquals(expectedMessage, e.getMessage());
         }
    }

    @Test
    public void testDirectoryPath() throws IOException {
        applicationArguments.add("Documents");
        try {
            catApplication.execute(applicationArguments, System.in, outputStream);
            fail("cat did not throw a directory path exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cat: " + "Documents" + " is a directory";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    /*
    @Test
    public void testStandardInput () throws IOException {

    }
    */

    @Test
    public void testFileAbsolutePath() throws IOException {
        applicationArguments.add(fileSeparator + "tmp" + fileSeparator + "Documents" + fileSeparator + "Ware");
        catApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }  
    
    @Test
    public void testFileRelativePath() throws IOException {
        applicationArguments.add("Documents" + fileSeparator + "Ware");
        catApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMultipleFiles() throws IOException {
        applicationArguments.add("Documents" + fileSeparator + "Ware");
        applicationArguments.add(fileSeparator + "tmp" + fileSeparator + "Soft");
        catApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

}