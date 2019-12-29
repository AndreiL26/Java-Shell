package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Wc;
import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.ApplicationManager;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

import java.util.ArrayList;


public class WcTest {
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
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }

    @Test
    public void testFlagW() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }

    @Test
    public void testFlagL() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
        } catch (RuntimeException e) {
            fail("fail, does not recognise correct flag");
        }
    }
    
    @Test
    public void testInvalidFlag() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-q");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
            fail("fail, accepts wrong flag");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testUppercaseFlagM() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-M");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
            fail("fail, uppercase flag not allowed");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testFilenameIsFlag() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "m");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            command.checkArguments(array, null, null);
        } catch (RuntimeException e) {
            fail("wc should not throw an exception");
        }
    }

    @Test
    public void testFileDoesNotExistNoFlag() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "w");
        try {
            command.execute(array, System.in, System.out);
            fail("wc should throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: file does not exist";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testCharacterCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of characters");
        }
    }

    @Test
    public void testWordCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of words");
        }
    }

    @Test
    public void testLineCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong number of lines");
        }
    }

    @Test
    public void testNoFlagsAsInput() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + "1" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testNoFlagsAsInputWare() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, ApplicationManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "47" + " " + "11" + " " + "3" + " " + ApplicationManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testCharacterAndWordCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testCharacterAndLineCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-m");
        array.add(1, "-l");
        array.add(2, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testWordAndLineCount() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, "-w");
        array.add(2, ApplicationManager.encodePath("Documents/test.txt"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "1" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testTwoFiles() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, ApplicationManager.encodePath("Documents/test.txt"));
        array.add(3, "-m");
        array.add(4, ApplicationManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator + "47" + " " + ApplicationManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    @Test
    public void testTwoFilesSecondVersion() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-w");
        array.add(1, "-m");
        array.add(2, ApplicationManager.encodePath("Documents/test.txt"));
        array.add(3, ApplicationManager.encodePath("Documents/Ware"));
        try {
            String expectedOutput = new String();
            command.execute(array, System.in, System.out);
            expectedOutput += "6" + " " + "1" + " " + ApplicationManager.encodePath("Documents/test.txt") + lineSeparator + "47" + " " + "11" + " " + "3" + " " + ApplicationManager.encodePath("Documents/Ware") + lineSeparator;
            assertEquals(outputStream.toString(), expectedOutput);
        } catch (RuntimeException e) {
            fail("fail: wrong output");
        }
    }

    // need redirection to test

    // @Test
    // public void testMissingArgumentsStdin() throws IOException{
    //     Wc command = new Wc(fileSystem, writer);
    //     ArrayList<String> array = new ArrayList<String>();
    //     try {
    //         command.checkarguments(array, null, null);
    //     } catch (RuntimeException e) {
    //         fail("wc should give stdin");
    //     }
    // }


    @Test
    public void fileDoesNotExist() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, ApplicationManager.encodePath("Documents/NotExist"));
        try {
            command.execute(array, System.in, System.out);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: file does not exist";
            assertEquals(expectedOutput, e.getMessage());
        }
    }


    @Test
    public void checkInvalidFileName() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "-l");
        array.add(1, ApplicationManager.encodePath("-test.txt"));
        try {
            command.checkArguments(array, null, null);
            fail("wc did not throw an exception");
        } catch (RuntimeException e) {
            String expectedOutput = "wc: invalid arguments";
            assertEquals(expectedOutput, e.getMessage());
        }
    }

    @Test
    public void testCannotOpenFile() throws IOException{
        Wc command = new Wc(fileSystem);
        ArrayList<String> array = new ArrayList<String>();
        array.add(0, "");
        array.add(1, ApplicationManager.encodePath("Documents/cannotopen.txt"));
        ArrayList<String> flags = new ArrayList<String>();
        flags.add(0, "-m");
        flags.add(1, "-w");
        flags.add(2, "-l");
        for (String flag : flags) {
            array.set(0, flag);
            try {
                command.execute(array, System.in, System.out);
                fail("wc did not throw an exception");
            } catch (RuntimeException e) {
                String expectedOutput = "wc: cannot read " + ApplicationManager.encodePath("Documents/cannotopen.txt");
                assertEquals(expectedOutput, e.getMessage());
            }
        }
    }

}