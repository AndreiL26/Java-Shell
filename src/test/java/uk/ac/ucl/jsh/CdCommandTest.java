package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.CdCommand;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import java.util.ArrayList;


public class CdCommandTest {
    private static CdCommand cdCommand;
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> commandArguments;
    private String fileSeparator = System.getProperty("file.separator");
    
    @BeforeClass
    public static void setClass() {
        commandArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
        cdCommand = new CdCommand(fileSystem, writer);
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
        commandArguments.clear();
        outputStream.reset();
    }   

    @Test 
    public void testMoreArguments() throws IOException {
        commandArguments.add("..");
        commandArguments.add("..");
        try {
            cdCommand.runCommand(commandArguments);
            fail("cd did not throw a too many arguments exception");

        } catch(RuntimeException e) {
           String expectedMessage = "cd: too many arguments";
           assertEquals(expectedMessage, e.getMessage());
         }
         
    }

	@Test
    public void testLessArguments() throws IOException {
        try {
            cdCommand.runCommand(commandArguments);
            fail("cd did not throw a missing argument exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cd: missing argument";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test 
    public void testInvalidPath() throws IOException {
        commandArguments.add("invalid" + fileSeparator + "Path");
        try {
            cdCommand.runCommand(commandArguments);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cd: " + "invalid" + fileSeparator + "Path" + " is not an existing directory";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test 
    public void testFilePath() throws IOException {
        commandArguments.add(fileSeparator + "Soft");
        try {
            cdCommand.runCommand(commandArguments);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cd: " + fileSeparator + "Soft" + " is not an existing directory";
            assertEquals(expectedMessage, e.getMessage());
        }
    }

    @Test
    public void testDotsInterpretation() throws IOException {
        commandArguments.add("...");
        try {
            cdCommand.runCommand(commandArguments);
            fail("cd did not throw an invalid path exception");
        } catch(RuntimeException e) {
            String expectedMessage = "cd: " + "..." + " is not an existing directory";
            assertEquals(expectedMessage, e.getMessage());
        }
    }
 
    @Test
    public void testGoingUpFromRoot() throws IOException {
        commandArguments.add("..");
        fileSystem.setWorkingDirectory(fileSeparator);
        cdCommand.runCommand(commandArguments);
        assertEquals(fileSeparator, fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testCurrentDirectory() throws IOException {
        commandArguments.add(".");
        cdCommand.runCommand(commandArguments);
        assertEquals(fileSeparator + "tmp", fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testParentDirectory() throws IOException {
        commandArguments.add("..");
        cdCommand.runCommand(commandArguments);
        assertEquals(fileSeparator, fileSystem.getWorkingDirectoryPath());
    }

    @Test
    public void testRelativePathToDirectory() throws IOException {
        commandArguments.add("Documents" + fileSeparator + "Eng");
        cdCommand.runCommand(commandArguments);
        String expectedOutput = System.getProperty("java.io.tmpdir") + fileSeparator + "Documents" + fileSeparator + "Eng";
        assertEquals(expectedOutput, fileSystem.getWorkingDirectoryPath());
    }

    @Test
   public void testAbsolutePathToDirectory() throws IOException {
       commandArguments.add(fileSeparator + "tmp" + fileSeparator + "Other");
       cdCommand.runCommand(commandArguments);
       String expectedOutput = fileSeparator + "tmp" + fileSeparator + "Other";
       assertEquals(expectedOutput, fileSystem.getWorkingDirectoryPath());
   }

}