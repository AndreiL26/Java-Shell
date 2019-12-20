package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Cd;
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


public class CdTest {
    private static Cd cdApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String fileSeparator = System.getProperty("file.separator");
    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        cdApplication = new Cd(fileSystem);
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
        applicationArguments.add("..");
        applicationArguments.add("..");
        try {
            cdApplication.execute(applicationArguments, System.in, outputStream);
            fail("cd did not throw a too many arguments exception");

        } catch(RuntimeException e) {
           assertEquals("cd: too many arguments", e.getMessage());
         }
         
    }

	@Test
    public void testLessArguments() throws IOException {
        try {
            cdApplication.execute(applicationArguments, System.in, outputStream);
            fail("cd did not throw a missing argument exception");
        } catch(RuntimeException e) {
            assertEquals("cd: missing argument", e.getMessage());
        }
    }

    @Test 
    public void testInvalidPath() throws IOException {
        applicationArguments.add("invalid" + fileSeparator + "Path");
        try {
            cdApplication.execute(applicationArguments, System.in, outputStream);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cd: " + "invalid" + fileSeparator + "Path" + " is not an existing directory";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test 
    public void testFilePath() throws IOException {
        applicationArguments.add(fileSeparator + "Soft");
        try {
            cdApplication.execute(applicationArguments, System.in, outputStream);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            assertEquals("cd: " + fileSeparator + "Soft" + " is not an existing directory", e.getMessage());
        }
    }

    @Test
    public void testDotsInterpretation() throws IOException {
        applicationArguments.add("...");
        try {
            cdApplication.execute(applicationArguments, System.in, outputStream);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            assertEquals("cd: " + "..." + " is not an existing directory", e.getMessage());
        }
    }
 
    @Test
    public void testGoingUpFromRoot() throws IOException {
        applicationArguments.add("..");
        fileSystem.setWorkingDirectory(fileSeparator);
        cdApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals(fileSeparator, fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testCurrentDirectory() throws IOException {
        applicationArguments.add(".");
        cdApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals(fileSeparator + "tmp", fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testParentDirectory() throws IOException {
        applicationArguments.add("..");
        cdApplication.execute(applicationArguments, System.in, outputStream);
        assertEquals(fileSeparator, fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testRelativePathToDirectory() throws IOException {
        applicationArguments.add("Documents" + fileSeparator + "Eng");
        cdApplication.execute(applicationArguments, System.in, outputStream);
        String expectedOutput = System.getProperty("java.io.tmpdir") + fileSeparator + "Documents" + fileSeparator + "Eng";
        assertEquals(expectedOutput, fileSystem.getWorkingDirectoryPath());
    }

    @Test
   public void testAbsolutePathToDirectory() throws IOException {
       applicationArguments.add(fileSeparator + "tmp" + fileSeparator + "Other");
       cdApplication.execute(applicationArguments, System.in, outputStream);
       String expectedOutput = fileSeparator + "tmp" + fileSeparator + "Other";
       assertEquals(expectedOutput, fileSystem.getWorkingDirectoryPath());
   }

}