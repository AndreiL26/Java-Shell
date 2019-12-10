package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Commands.*;
import java.util.HashMap;
import java.util.ArrayList;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintStream;

public class CommandManager {
    private HashMap<String, Command> commandMap;
    private FileSystem fileSystem;
    OutputStreamWriter writer;

    public CommandManager(FileSystem fileSystem, OutputStreamWriter writer) {
        commandMap = new HashMap<>();
        this.fileSystem = fileSystem;
        this.writer = writer;
        createCommands();
    }

    public FileSystem getFileSystem() {
        return fileSystem;
    }

    public void setWriterStream(PrintStream writerStream) throws IOException {
        writer.close();
        writer = new OutputStreamWriter(writerStream);

        for (HashMap.Entry mapEntry : commandMap.entrySet()) {  
            Command cmd = (Command)mapEntry.getValue();
            cmd.setWriter(writer);
        } 
    } 

    public void executeCommand(ArrayList<String> tokens) {
        String commandName = tokens.get(0);
        ArrayList<String> commandArguments = new ArrayList<String>(tokens.subList(1, tokens.size()));
        try {
            if(commandMap.containsKey(commandName)) {
                Command currentCommand = commandMap.get(commandName);
                currentCommand.runCommand(commandArguments);
            } else {
                throw new RuntimeException(commandName + ": unknown application");
            }
        }catch (IOException e) {
            throw new RuntimeException(commandName + ": can't execute!");
        }
    }

    private  void createCommands() {
        commandMap.put("pwd", new PwdCommand(fileSystem, writer));
        commandMap.put("cd", new CdCommand(fileSystem, writer));
        commandMap.put("ls", new LsCommand(fileSystem, writer));
        commandMap.put("cat", new CatCommand(fileSystem, writer));
        commandMap.put("echo", new EchoCommand(fileSystem, writer));
        commandMap.put("head", new HeadCommand(fileSystem, writer));
        commandMap.put("tail", new TailCommand(fileSystem, writer));
        commandMap.put("grep", new GrepCommand(fileSystem, writer));
        commandMap.put("sed", new SedCommand(fileSystem, writer));
    }
}