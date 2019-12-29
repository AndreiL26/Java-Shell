package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Find;
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
import java.util.Arrays;
import java.util.Collections;



public class FindTest {
    private static Find findApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String fileSeparator = System.getProperty("file.separator");
    private String lineSeparator = System.getProperty("line.separator");
    
    private void assertEqualStrings(String expectedString, String actualString) {
        ArrayList<String> expectedTokens = new ArrayList<>(Arrays.asList(expectedString.trim().split(lineSeparator)));
        ArrayList<String> actualTokens = new ArrayList<>(Arrays.asList(actualString.trim().split(lineSeparator)));
        Collections.sort(expectedTokens);
        Collections.sort(actualTokens);
        assertEquals(expectedTokens, actualTokens);
    }

    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        findApplication = new Find(fileSystem);
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
    public void testMissingArguments() throws IOException {
        try {
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw a missing arguments exception");
        } catch (RuntimeException e) {
           assertEquals("find: missing arguments", e.getMessage());
        }
    }

    @Test 
    public void testMissingPattern() throws IOException {
        try {
            applicationArguments.add("/lib");
            applicationArguments.add("-name");
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw a wrong argument exception");
        } catch (RuntimeException e) {
            assertEquals("find: wrong argument", e.getMessage());
        }
    }

    @Test
    public void testTooManyArguments() throws IOException {
        try {
            applicationArguments.add("one");
            applicationArguments.add("two");
            applicationArguments.add("three");
            applicationArguments.add("four");
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw a too many arguments exception");
        } catch (RuntimeException e) {
            assertEquals("find: too many arguments", e.getMessage());
        }
    }
    
    @Test
    public void testFindFromInvalidPath() throws IOException {
        try {
            applicationArguments.add("InvalidPath");
            applicationArguments.add("-name");
            applicationArguments.add("Invalid");
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw a cannot open directory exception");
        } catch (RuntimeException e) {
            assertEquals("find: could not open InvalidPath", e.getMessage());
        }
    }

    @Test
    public void testFindFromFilePath() throws IOException {
        try {
            applicationArguments.add("Soft");
            applicationArguments.add("-name");
            applicationArguments.add("Invalid");
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw a cannot open directory exception");
        } catch (RuntimeException e) {
            assertEquals("find: could not open " + "Soft", e.getMessage());
        }
    }

    @Test
    public void testInvalidArgumentsMissingDashName() throws IOException {
        try {
            applicationArguments.add("Documents");
            applicationArguments.add("NotName");
            applicationArguments.add("FindMe");
            findApplication.execute(applicationArguments, null, outputStream);
            fail("find did not throw an invalid argument exception");
        } catch (RuntimeException e) {
            assertEquals("find: invalid argument " + "NotName", e.getMessage());
        }
    }

    @Test
    public void testFindOneFileFromCurrentDirectory() throws IOException {
        applicationArguments.add("-name");
        applicationArguments.add("Soft");
        findApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings("." + fileSeparator + "Soft" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testFindDirectoryFromCurrentDirectory() throws IOException {
        applicationArguments.add("-name");
        applicationArguments.add("Documents");
        findApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings("", outputStream.toString());
    }

    @Test 
    public void testFindMultipleFilesFromRelativePath() throws IOException {
        applicationArguments.add("Other");
        applicationArguments.add("-name");
        applicationArguments.add("Oth*");
        findApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "Other" + fileSeparator + "Oth1" + lineSeparator;
        expectedOutput += "Other" + fileSeparator + "Oth2" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testPatterMatching() throws IOException {
        applicationArguments.add("Other");
        applicationArguments.add("-name");
        applicationArguments.add("*h*");
        findApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "Other" + fileSeparator + "Oth1" + lineSeparator;
        expectedOutput += "Other" + fileSeparator + "Oth2" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testFindFileFromAbsolutePath() throws IOException {
        applicationArguments.add(fileSeparator + "tmp" + fileSeparator + "Documents" + fileSeparator + "Eng");
        applicationArguments.add("-name");
        applicationArguments.add("T*");
        findApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings(fileSeparator + "tmp" + fileSeparator + "Documents" + fileSeparator + "Eng" + fileSeparator + "Test" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testNoMatchingFile() throws IOException {
        applicationArguments.add("-name");
        applicationArguments.add("NoMatch!");
        findApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings("", outputStream.toString());
    }

    @Test
    public void testFindFileFromLowerLeverInTree() throws IOException {
        applicationArguments.add("-name");
        applicationArguments.add("Code");
        findApplication.execute(applicationArguments, null, outputStream);
        assertEqualStrings("." + fileSeparator + "Documents" + fileSeparator + "Eng"  + fileSeparator + "Code" + lineSeparator, outputStream.toString());
    }

}