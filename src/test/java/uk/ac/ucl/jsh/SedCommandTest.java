package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.SedCommand;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;


public class SedCommandTest {
    private static SedCommand sedCommand;
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    
    @BeforeClass
    public static void setClass() {
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
        sedCommand = new SedCommand(fileSystem, writer);
    }

    @Before
    // Create the File Hierarchy
    public void createHierarchy() throws IOException {
       fileSystem.createTestFileHierarchy();
    }

    @After
    // Delete the File Hierarchy
    public void deleteHierarchy() throws IOException {
        fileSystem.deleteTestFileHierarchy();
    }


    @Test
    public void test() throws IOException{
        ArrayList<String> commandArguments = new ArrayList<>();
        commandArguments.add("s/test/repl/g");
        commandArguments.add("Soft");
        sedCommand.runCommand(commandArguments);
        String resultString = new String();
        resultString += "This is a repl\n";
        resultString += "This is a repl of another repl\n";
        resultString += "\n";
        resultString += "Have more lines inside this file!\n";
        resultString += "Anoter strange line!\n";
        
        assertEquals(resultString, outputStream.toString());
        
    }
    
    
}