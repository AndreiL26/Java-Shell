package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Ls;
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


public class LsTest {
    private static Ls lsApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");
    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        lsApplication = new Ls(fileSystem);
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
    public void testMoreArguments() throws IOException {
        applicationArguments.add("/");
        applicationArguments.add("..");
        try {
            lsApplication.execute(applicationArguments, System.in, outputStream);
            fail("ls did not throw a too many arguments exception");
        } catch(RuntimeException e) {
           assertEquals("ls: too many arguments", e.getMessage());
        }
    }

    @Test
    public void testCurrentDirectory() throws IOException {
        // The filesystem's current working directory will be /tmp/Documents
        fileSystem.setWorkingDirectory("/tmp/Documents");
        lsApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = "Ware" + "\t" + "Proj.txt" + "\t" + "Eng" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testArgumentDirectoryRelativePath() throws IOException {
        // The filesystem's current working directory will be /tmp, but the argument will point to /tmp/Documents
        applicationArguments.add("Documents"); 
        lsApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = "Ware" + "\t" + "Proj.txt" + "\t" + "Eng" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testArgumentDirectoryAbsolutePath() throws IOException {
        applicationArguments.add("/tmp/Documents/Eng");
        lsApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = "Code" + "\t" + "Test" + "\t" + "Plan" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testIgnoreDotFiles() throws IOException {
        applicationArguments.add("/tmp/Other");
        lsApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = "Oth1" + "\t" + "Empty" + "\t" + "Oth2" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testEmptyDirectory() throws IOException {
        applicationArguments.add("/tmp/Other/Empty");
        lsApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals("", outputStream.toString());
    }

}