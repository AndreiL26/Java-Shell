package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.PwdCommand;
import uk.ac.ucl.jsh.Utilities.FileSystem;

import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;
import java.util.ArrayList;


public class PwdCommandTest {
    private static PwdCommand pwdCommand;
    private static FileSystem fileSystem;
    private static OutputStreamWriter writer;
    private static ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

    
    @BeforeClass
    public static void setClass() {
        fileSystem = new FileSystem(System.getProperty("java.io.tmpdir"));
        System.setOut(new PrintStream(outputStream));
        writer = new OutputStreamWriter(System.out);
        pwdCommand = new PwdCommand(fileSystem, writer);
    }

    @Before
    // Create the Test
    public void createHierarchy() throws IOException {
       fileSystem.createTestFileHierarchy();
       fileSystem.deleteTestFileHierarchy();
    }


    @Test
    public void test() throws IOException{
        ArrayList<String> commandArguments = new ArrayList<>();
        pwdCommand.runCommand(commandArguments);
        assertEquals("/tmp" + System.getProperty("line.separator"), outputStream.toString());
    }
    
    
}