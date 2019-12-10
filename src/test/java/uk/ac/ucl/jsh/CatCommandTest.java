package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.CatCommand;
import uk.ac.ucl.jsh.Utilities.CommandManager;
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


public class CatCommandTest {
    private static CatCommand catCommand;
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> commandArguments;
    private String lineSeparator = System.getProperty("line.separator");
    
    @BeforeClass
    public static void setClass() {
        commandArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
        catCommand = new CatCommand(fileSystem, writer);
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
    public void testInvalidPath() throws IOException {
        commandArguments.add("/InvalidPath");
        try {
            catCommand.runCommand(commandArguments);
            fail("cat did not throw an invalid path exception");
        } catch(RuntimeException e) {
           String expectedMessage = "cat: file does not exist";
           assertEquals(expectedMessage, e.getMessage());
         }
    }

    @Test
    public void testDirectoryPath() throws IOException {
        commandArguments.add("Documents");
        try {
            catCommand.runCommand(commandArguments);
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
        commandArguments.add(CommandManager.encodePath("/tmp/Documents/Ware"));
        catCommand.runCommand(commandArguments);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }  
    
    @Test
    public void testFileRelativePath() throws IOException {
        commandArguments.add(CommandManager.encodePath("Documents/Ware"));
        catCommand.runCommand(commandArguments);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testMultipleFiles() throws IOException {
        commandArguments.add(CommandManager.encodePath("Documents/Ware"));
        commandArguments.add(CommandManager.encodePath("/tmp/Soft"));
        catCommand.runCommand(commandArguments);
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