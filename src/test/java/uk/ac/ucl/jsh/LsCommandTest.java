package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.LsCommand;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;


public class LsCommandTest {
    private static LsCommand lsCommand;
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
        lsCommand = new LsCommand(fileSystem, writer);
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
        commandArguments.add("/");
        commandArguments.add("..");
        try {
            lsCommand.runCommand(commandArguments);
            fail("ls did not throw a too many arguments exception");
        } catch(RuntimeException e) {
           String expectedMessage = "ls: too many arguments";
           assertEquals(expectedMessage, e.getMessage());
         }
    }

    @Test
    public void testCurrentDirectory() throws IOException {
        // The filesystem's current working directory will be /tmp/Documents
        fileSystem.setWorkingDirectory("/tmp/Documents");
        lsCommand.runCommand(commandArguments);
        String expectedOutput = "Ware" + "\t" + "Proj.txt" + "\t" + "Eng" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testArgumentDirectoryRelativePath() throws IOException {
        // The filesystem's current working directory will be /tmp, but the argument will point to /tmp/Documents
        commandArguments.add("Documents"); 
        lsCommand.runCommand(commandArguments);
        String expectedOutput = "Ware" + "\t" + "Proj.txt" + "\t" + "Eng" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testArgumentDirectoryAbsolutePath() throws IOException {
        commandArguments.add("/tmp/Documents/Eng");
        lsCommand.runCommand(commandArguments);
        String expectedOutput = "Code" + "\t" + "Test" + "\t" + "Plan" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testIgnoreDotFiles() throws IOException {
        commandArguments.add("/tmp/Other");
        lsCommand.runCommand(commandArguments);
        String expectedOutput = "Oth1" + "\t" + "Empty" + "\t" + "Oth2" + lineSeparator;
        assertEqualStrings(expectedOutput, outputStream.toString());
    }

    @Test
    public void testEmptyDirectory() throws IOException {
        commandArguments.add("/tmp/Other/Empty");
        lsCommand.runCommand(commandArguments);
        assertEqualStrings("", outputStream.toString());
    }

    private void assertEqualStrings(String expectedString, String actualString) {
        ArrayList<String> expectedTokens = new ArrayList<>(Arrays.asList(expectedString.trim().split("\t")));
        ArrayList<String> actualTokens = new ArrayList<>(Arrays.asList(actualString.trim().split("\t")));
        Collections.sort(expectedTokens);
        Collections.sort(actualTokens);
        assertEquals(expectedTokens, actualTokens);
    }
}