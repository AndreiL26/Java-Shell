package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Applications.Sed;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.ArrayList;



public class SedTest {
    private static Sed sedApplication;
    private static FileSystem fileSystem;
    private static ByteArrayOutputStream outputStream;
    private static ArrayList<String> applicationArguments;
    private String lineSeparator = System.getProperty("line.separator");

    
    @BeforeClass
    public static void setClass() {
        applicationArguments = new ArrayList<>();
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        outputStream = new ByteArrayOutputStream();
        sedApplication = new Sed(fileSystem);
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
    public void testInvalidNumberOfArguments() throws IOException {
        try {
            sedApplication.execute(applicationArguments, null, outputStream);
            fail("sed did not throw a missing arguments exception");
        } catch (RuntimeException e) {
           assertEquals("sed: missing arguments", e.getMessage());
        }
    }

    @Test
    public void testMissingInputStreamAndFile() throws IOException {
        applicationArguments.add("s/test/repl/");
        try {
            sedApplication.execute(applicationArguments, null, outputStream);
            fail("sed did not throw a missing input exception");
        } catch (RuntimeException e) {
            assertEquals("sed: missing input", e.getMessage());
        }
    }

    @Test 
    public void testInvalidFirstArgumentEmptyString() throws IOException {
        applicationArguments.add(" ");
        applicationArguments.add("Soft");
        try {
            sedApplication.execute(applicationArguments, null, outputStream);
            fail("sed did not throw an invalid first argument exception");
        } catch (RuntimeException e) {
            assertEquals("sed: invalid first argument", e.getMessage());
        }
    }

    @Test
    public void testInvalidFisrtArgumentEmptyRegex() throws IOException {
        applicationArguments.add("s//Huh/");
        applicationArguments.add("Soft");
        try {
            sedApplication.execute(applicationArguments, null, outputStream);
            fail("sed did not throw an invalid first argument exception");
        } catch (RuntimeException e) {
            assertEquals("sed: invalid first argument", e.getMessage());
        }
    }

    @Test
    public void testInvalidFirstArgumentTooManyDelimiters() throws IOException {
        applicationArguments.add("s/Regex/Replacem/nt/");
        applicationArguments.add("Soft");
        try {
            sedApplication.execute(applicationArguments, null, outputStream);
            fail("sed did not throw an invalid first argument exception");
        } catch (RuntimeException e) {
            assertEquals("sed: invalid first argument", e.getMessage());
        }
    }

    @Test
    public void testReplaceAllOccurences() throws IOException {
        applicationArguments.add("s/test/repl/g");
        applicationArguments.add("Soft");
        sedApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a repl" + lineSeparator;
        expectedOutput += "This is a repl of another repl" + lineSeparator;
        expectedOutput += lineSeparator;
        
        assertEquals(expectedOutput, outputStream.toString());
    }

    @Test
    public void testDifferentDelimiterSymbol() throws IOException {
        applicationArguments.add("s%test%repl%g");
        applicationArguments.add("Soft");
        sedApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += "This is a repl" + lineSeparator;
        expectedOutput += "This is a repl of another repl" + lineSeparator;
        expectedOutput += lineSeparator;
        
        assertEquals(expectedOutput, outputStream.toString());
    }
    
    @Test
    public void testEmptyReplacement() throws IOException {
        applicationArguments.add("s/This is a test//");
        applicationArguments.add("Soft");
        sedApplication.execute(applicationArguments, null, outputStream);
        String expectedOutput = new String();
        expectedOutput += lineSeparator;
        expectedOutput += " of another test" + lineSeparator;
        expectedOutput += lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }
    
    @Test
    public void testNoMatches() throws IOException {
        applicationArguments.add("s/RANDOM STRING/Replaced/g");
        applicationArguments.add("Soft");
        sedApplication.execute(applicationArguments, null, outputStream);
        String exepctedOutput = new String();
        exepctedOutput += "This is a test" + lineSeparator;
        exepctedOutput += "This is a test of another test" + lineSeparator;
        exepctedOutput += lineSeparator;
        assertEquals(exepctedOutput, outputStream.toString());
    }
    
    
    @Test
    public void testReadingFromInputStream() throws IOException {
        ByteArrayOutputStream aux = new ByteArrayOutputStream();
        BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(aux));
        writer.write("Hello world" + lineSeparator);
        writer.write("Hello Hello world!" + lineSeparator);
        writer.write("world" + lineSeparator);
        writer.flush();
        writer.close();

        ByteArrayInputStream testInput = new ByteArrayInputStream(aux.toByteArray());
        applicationArguments.add("s/Hello/Sad/g");
        sedApplication.execute(applicationArguments, testInput, outputStream);
        
        String expectedOutput = "Sad world" + lineSeparator;
        expectedOutput += "Sad Sad world!" + lineSeparator;
        expectedOutput += "world" + lineSeparator;
        assertEquals(expectedOutput, outputStream.toString());
    }
}