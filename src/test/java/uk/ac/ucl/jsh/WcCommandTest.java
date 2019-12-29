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
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }

    @Test
    public void testFlagW() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }

    @Test
    public void testFlagL() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }
    
    @Test
    public void testInvalidFlag() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-q");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
            fail("fail, accepts wrong flag");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testUppercaseFlagM() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-M");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
            fail("fail, uppercase flag not allowed");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testFilenameIsFlag() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "m");
        array.add(1, CommandManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array);
        } catch (RuntimeException e) {
            fail("wc should not throw an exception");
        }
    }

    @Test
    public void testFileDoesNotExistNoFlag() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "w");
        try {
            command.runCommand(array);
            fail("wc should throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: file does not exist";
            assertEquals(expectedOutput, e.getMessage());
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
            expectedOutput += "6" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
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
            expectedOutput += "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
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
            expectedOutput += "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of lines");
        }
    }

    @Test
    public void testNoFlagsAsInput() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "6" + " " + "1" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testNoFlagsAsInputWare() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, CommandManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "47" + " " + "11" + " " + "3" + " " + CommandManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testCharacterAndWordCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "6" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testCharacterAndLineCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, "-l");
        array.add(2, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "6" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testWordAndLineCount() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, "-w");
        array.add(2, CommandManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "1" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testTwoFiles() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, CommandManager.encodePath("Documents/test.txt"));
        array.add(3, "-m");
        array.add(4, CommandManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "6" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator + "47" + " " + CommandManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testTwoFilesSecondVersion() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, CommandManager.encodePath("Documents/test.txt"));
        array.add(3, CommandManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.runCommand(array);
            expectedOutput += "6" + " " + "1" + " " + CommandManager.encodePath("Documents/test.txt") + lineSeparator + "47" + " " + "11" + " " + "3" + " " + CommandManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    // need redirection to test

    // @Test
    // public void testMissingArgumentsStdin() throws IOException{
    //     WcCommand command = new WcCommand(fileSystem, writer);
    //     ArrayList<String> array = new ArrayList<String>();
    //     try {
    //         command.checkArguments(array);
    //     } catch (RuntimeException e) {
    //         fail("wc should give stdin");
    //     }
    // }


    @Test
    public void fileDoesNotExist() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, CommandManager.encodePath("Documents/NotExist"));
        try {
            command.runCommand(array);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: file does not exist";
            assertEquals(expectedOutput, e.getMessage());
        }
    }


    @Test
    public void checkInvalidFileName() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, CommandManager.encodePath("-test.txt"));
        try {
            command.checkArguments(array);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testCannotOpenFile() throws IOException{
        WcCommand command = new WcCommand(fileSystem, writer);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "");
        array.add(1, CommandManager.encodePath("Documents/cannotopen.txt"));
        ArrayList<String> flags = new ArrayList<String>();
        flags.add(0, "-m");
        flags.add(1, "-w");
        flags.add(2, "-l");
        for (String flag : flags) {
            array.set(0, flag);
            try {
                command.runCommand(array);
                fail("wc did not throw an exception");
            } catch (RuntimeException e) {
                String expectedOutput = "wc: cannot read " + CommandManager.encodePath("Documents/cannotopen.txt");
                assertEquals(expectedOutput, e.getMessage());
            }
        }
    }

}