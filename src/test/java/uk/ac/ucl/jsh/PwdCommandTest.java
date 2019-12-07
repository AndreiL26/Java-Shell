package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.PwdCommand;
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


public class PwdCommandTest {
    private static PwdCommand pwdCommand;
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> commandArguments;
    private String fileSeparator = System.getProperty("file.separator");
    private String lineSeparator = System.getProperty("line.separator");
    
    @BeforeClass
    public static void setClass() {
        commandArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
        pwdCommand = new PwdCommand(fileSystem, writer);
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
    public void testInvalidNumberOfArguments() throws IOException {
        commandArguments.add("unwantedParameter");
        try {
            pwdCommand.runCommand(commandArguments);
            fail("pwd did not throw a too many arguments exception");
        } catch(RuntimeException e) {
           String expectedMessage = "pwd: too many arguments";
           assertEquals(expectedMessage, e.getMessage());
         }

    }

    @Test
    public void testRootDirectory() throws IOException {
        fileSystem.setWorkingDirectory(fileSeparator);
        pwdCommand.runCommand(commandArguments);
        String expectedOutput = fileSeparator + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }
    
    @Test
    public void testRandomDirectory() throws IOException {
        fileSystem.setWorkingDirectory(fileSeparator + "tmp" + fileSeparator + "Other");
        pwdCommand.runCommand(commandArguments);
        String expectedOutput = fileSeparator + "tmp" + fileSeparator + "Other" + lineSeparator;
        assertEquals(expectedOutput , outputStream.toString());
    }

}