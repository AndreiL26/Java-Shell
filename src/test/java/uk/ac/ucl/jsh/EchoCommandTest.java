package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Commands.EchoCommand;
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


public class EchoCommandTest {
    private static EchoCommand echoCommand;
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
        echoCommand = new EchoCommand(fileSystem, writer);
    }

    @After
    // Reset the command arguments and reset the outputstream
    public void afterTest() throws IOException {
        commandArguments.clear();
        outputStream.reset();
    }   

    @Test
    public void testOneArgument() throws IOException {
        commandArguments.add("hello world");
        echoCommand.runCommand(commandArguments);
        assertEquals("hello world" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testMultipleArguments() throws IOException {
        commandArguments.add("first");
        commandArguments.add("second");
        commandArguments.add("third");
        echoCommand.runCommand(commandArguments);
        assertEquals("first second third" + lineSeparator, outputStream.toString());
    }

    @Test
    public void testNoArguments() throws IOException {
        echoCommand.runCommand(commandArguments);
        assertEquals("", outputStream.toString());
    }

}