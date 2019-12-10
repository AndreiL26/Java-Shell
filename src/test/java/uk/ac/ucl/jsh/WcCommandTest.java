package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.WcCommand;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.CommandManager;

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


public class WcCommandTest {
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private String lineSeparator = System.getProperty("line.separator");

    
    @BeforeClass
    public static void setClass() {
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
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
        outputStream.reset();
    }   

    @Test
    public void testFlagM() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail");
        }
    }

    @Test
    public void testFlagW() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail");
        }
    }

    @Test
    public void testFlagL() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail");
        }
    }
    
    @Test
    public void testFlagWrong() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-q");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
            fail("fail");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testUppercaseFlagM() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-M");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
            fail("fail, uppercase flag not allowed");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testUppercaseFlagW() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-W");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
            fail("fail, uppercase flag not allowed");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testUppercaseFlagL() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-L");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
            fail("fail, uppercase flag not allowed");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testFlagWithoutDash() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "m");
        array.add(1, "jsh/pom.xml");
        try {
            command.checkArguments(array);
            fail("fail, no - in -m");
        } catch (RuntimeException e) {

        }
    }

    @Test
    public void testCharacterCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "44" + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of characters");
        }
    }

    @Test
    public void testWordCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "11" + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of words");
        }
    }

    @Test
    public void testLineCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "3" + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of lines");
        }
    }

    @Test
    public void testMissingArguments() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        try {
            command.checkArguments(array);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: missing arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testTooManyArgumentsCorrectFlag() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, "pom.xml");
        array.add(2, "aaaaaaa");
        try {
            command.checkArguments(array);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: wrong arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testTooManyArgumentsWrongFlag() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "bbbbb");
        array.add(1, "pom.xml");
        array.add(2, "aaaaaaa");
        try {
            command.checkArguments(array);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: wrong argument " + array.get(0);
            assertTrue(expectedOutput.equals(e.getMessage()));
            // assertEquals(expectedOutput, e.getMessage());
        }
    }
}