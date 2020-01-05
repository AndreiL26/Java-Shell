package uk.ac.ucl.jsh;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.IOException;
import java.io.PrintStream;
import java.util.Scanner;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import uk.ac.ucl.jsh.Utilities.FileSystem;
import uk.ac.ucl.jsh.Utilities.JshException;
 
public class JshTest {
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ByteArrayOutputStream errStream;
    private String lineSeparator = Jsh.lineSeparator;
    private String fileSeparator = Jsh.fileSeparator;
    private String initialWorkingDirectoryPath;
    
    @BeforeClass
    public static void setClass() throws IOException {
        fileSystem = FileSystem.getInstance();
        outputStream = new ByteArrayOutputStream();
        errStream = new ByteArrayOutputStream();
        System.setErr(new PrintStream(errStream));
    }

    @Before
    // Create the File Hierarchy
    public void createHierarchy() throws IOException {
        fileSystem.deleteTestFileHierarchy();
        initialWorkingDirectoryPath = fileSystem.getWorkingDirectoryPath();
        fileSystem.createTestFileHierarchy();
        fileSystem.setWorkingDirectory(System.getProperty("java.io.tmpdir"));
     }
 
     @After
     // Delete the test hierarchy, reset the command arguments and reset the outputstream
     public void afterTest() throws IOException {
        fileSystem.deleteTestFileHierarchy();
        errStream.reset();
        outputStream.reset();
        fileSystem.setWorkingDirectory(initialWorkingDirectoryPath);
    }   
 
    @Test
    public void testSimpleSequence() {
        Jsh.eval("echo hello; echo world", outputStream);
        assertEquals("hello" + lineSeparator + "world" + lineSeparator, outputStream.toString());
        assertEquals("", errStream.toString());
    }

    @Test
    public void testSimpleFailedSequenceSafeApplicationFirst() throws IOException {
        Jsh.eval("cat InvalidPath; echo hello", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals("cat: file does not exist" + lineSeparator, errStream.toString());
    }

    @Test
    public void testSimpleFailedSequenceUnsafeApplicationFirst() throws IOException {
        Jsh.eval("_cat InvalidPath; echo hello", outputStream);
        assertEquals("hello" + lineSeparator, outputStream.toString());
        assertEquals("cat: file does not exist" + lineSeparator, errStream.toString());
    }
    
    @Test
    public void testSimpleFailedSequenceFailedSafeApplicationSecond() throws IOException {
        Jsh.eval("echo hello; ls InvalidPath", outputStream);
        assertEquals("hello" + lineSeparator, outputStream.toString());
        assertEquals("ls: no such directory" + lineSeparator, errStream.toString());
    }

    @Test
    public void testSimpleFailedSequenceFailedUnsafeApplicationSecond() throws IOException {
        Jsh.eval("echo hello; _ls InvalidPath", outputStream);
        assertEquals("hello" + lineSeparator, outputStream.toString());
        assertEquals("ls: no such directory" + lineSeparator, errStream.toString());
    }

    @Test
    public void testMultipleCallsSequence() throws IOException {
        Jsh.eval("echo hello; echo world; echo AAA; echo BBB", outputStream);
        assertEquals("hello" + lineSeparator + "world" + lineSeparator + "AAA" + lineSeparator + "BBB" + lineSeparator, outputStream.toString());
        assertEquals("", errStream.toString());
    }

    @Test
    public void testMultipleErrorsInCallSequenceWithSafeApplications() throws IOException {
        Jsh.eval("echo hello; ls InvalidPath; cd InvalidPath; echo world", outputStream);
        assertEquals("hello" + lineSeparator, outputStream.toString());
        String expectedErrorMessages = "";
        expectedErrorMessages += "ls: no such directory" + lineSeparator;
        assertEquals(expectedErrorMessages, errStream.toString());
    }

    @Test
    public void testMultipleErrorsInCallSequenceWithUnsafeApplications() throws IOException {
        Jsh.eval("echo hello; _ls InvalidPath; _cd InvalidPath; echo world", outputStream);
        assertEquals("hello" + lineSeparator + "world" + lineSeparator, outputStream.toString());
        String expectedErrorMessages = "";
        expectedErrorMessages += "ls: no such directory" + lineSeparator;
        expectedErrorMessages += "cd: InvalidPath is not an existing directory" + lineSeparator;
        assertEquals(expectedErrorMessages, errStream.toString());
    }

    @Test
    public void testInterestingSequenceAndCommandSubstitution() {
        Jsh.eval("echo a `echo a`; echo b`b`", outputStream);
        assertEquals("a a" + lineSeparator + "b" + lineSeparator, outputStream.toString());
        assertEquals("b: unknown application" + lineSeparator, errStream.toString());
    }

    @Test
    public void testSimpleInputRedirection() {
        Jsh.eval("cat < Soft", outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
        assertEquals("", errStream.toString());
    }

    @Test
    public void testWrongInputRedirection() {
        Jsh.eval("Soft < cat", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals(fileSeparator + "tmp" + fileSeparator + "cat " + "(No such file or directory)" + lineSeparator, errStream.toString());
    }

    @Test
    public void testMultipleInputRedirectionFiles() {
        Jsh.eval("cat < Soft < Documents" + fileSeparator + "Ware", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals("Too many files for input redirection" + lineSeparator, errStream.toString());
    }

    @Test
    public void testSimpleInputRedirectionInFrontNotation() {
        Jsh.eval("< Soft cat", outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a test" + lineSeparator;
        expectedOutput += "This is a test of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
        assertEquals("", errStream.toString());
    }

    @Test
    public void testSimpleInputRedirectionInFrontNotationWrong() {
        Jsh.eval("< cat Soft", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals(fileSeparator + "tmp" + fileSeparator + "cat " + "(No such file or directory)" + lineSeparator, errStream.toString());
    }

    @Test
    public void testInvalidInputRedirection() {
        Jsh.eval("cat < ", outputStream);
        assertEquals("", outputStream.toString());
        //assertEquals("", errStream.toString());
    }

    @Test
    public void testSimpleOutputRedirection() throws IOException {
        Jsh.eval("echo Hello > output.txt", outputStream);
        try {
            File redirectionFile = fileSystem.getFile("output.txt");
            if(!redirectionFile.exists()) {
                fail("output redirection did not create the output file");
            }
            Scanner scanner = new Scanner(redirectionFile);
            String fileContent = "";
            while(scanner.hasNextLine()) {
                fileContent += scanner.nextLine();
            }
            scanner.close();
            redirectionFile.delete();
            assertEquals("", outputStream.toString());
            assertEquals("Hello", fileContent);
            assertEquals("", errStream.toString());
        } catch (JshException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testMultipleOutputRedirectionFiles() {
        Jsh.eval("echo Hello > output.txt > tooMany.txt", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals("Too many files for output redirection" + lineSeparator, errStream.toString());
        try {
            File outputFile = fileSystem.getFile("output.txt");
            File tooManyFile = fileSystem.getFile("tooMany.txt");
            if(outputFile.exists() || tooManyFile.exists()) {
                fail("Output redirection created useless files");
            }
        } catch (JshException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testInFrontRedirection() throws IOException {
        Jsh.eval("> output.txt echo Hello", outputStream);
        try {
            File redirectionFile = fileSystem.getFile("output.txt");
            if(!redirectionFile.exists()) {
                fail("output redirection did not create the output file");
            }
            Scanner scanner = new Scanner(redirectionFile);
            String fileContent = "";
            while(scanner.hasNextLine()) {
                fileContent += scanner.nextLine();
            }
            scanner.close();
            redirectionFile.delete();
            assertEquals("", outputStream.toString());
            assertEquals("Hello", fileContent);
            assertEquals("", errStream.toString());
        } catch (JshException e) {
            fail(e.getMessage());
        }
    }


    @Test
    public void testInvalidOutputRedirection() {
        Jsh.eval("cat > ", outputStream);
        assertEquals("", outputStream.toString());
        //assertEquals("", errStream.toString());
    }


    @Test
    public void testInFrontRedirectionInvalid() {
        Jsh.eval("> echo Hello output.txt", outputStream);
        try {
            File outputFile = fileSystem.getFile("output.txt");
            if(outputFile.exists()) {
                fail("output redirection created useless files");
            }
            assertEquals("", outputStream.toString());
        } catch (JshException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testInputAndOutputRedirection() throws IOException {
        Jsh.eval("sed s/test/repl/g < Soft > test.txt", outputStream);
        try {
            File redirectionFile = fileSystem.getFile("test.txt");
            if(!redirectionFile.exists()) {
                fail("output redirection did not create the output file");
            }
            Scanner scanner = new Scanner(redirectionFile);
            String fileContent = "";
            while(scanner.hasNextLine()) {
                fileContent += scanner.nextLine();
                fileContent += lineSeparator;
            }
            scanner.close();
            redirectionFile.delete();
            assertEquals("", outputStream.toString());
            assertEquals("", errStream.toString());
            String expectedFileContent = "";
            expectedFileContent += "This is a repl" + lineSeparator;
            expectedFileContent += "This is a repl of another repl" + lineSeparator;
            expectedFileContent += lineSeparator;
            assertEquals(expectedFileContent, fileContent);
        } catch (JshException e) {
            fail(e.getMessage());
        }
    }

    @Test
    public void testInvalidApplicationName() {
        Jsh.eval("invalidname", outputStream);
        assertEquals("", outputStream.toString());
        assertEquals("invalidname: unknown application" + lineSeparator, errStream.toString());
    }

    @Test
    public void testSimplePipe() throws IOException {
        Jsh.eval("echo Hello | sed s/Hello/Bye/", outputStream);
        assertEquals("Bye" + lineSeparator, outputStream.toString());
    }
}