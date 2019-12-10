package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor {
    private CommandManager commandManager;

    public EvalVisitor(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void visit(CallNode callNode) {
        try {
            ArrayList<String> tokens = Parser.getTokens(callNode.getCmdString(), 
                                                        commandManager.getFileSystem().getWorkingDirectoryPath());
            commandManager.executeCommand(tokens);
        }
        catch (IOException ioException) {
            throw new RuntimeException(callNode + " could not be executed");
        }
    }

    public void visit(PipeNode pipeNode) {
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        try {
            Jsh.commandManager.setWriterStream(new PrintStream(outputStream));
        } catch (IOException e) {
            throw new RuntimeException("jsh: could not create print stream");
        }
        System.setOut(new PrintStream(outputStream));
        pipeNode.getLeft().accept(this);
        try {
            Jsh.commandManager.setWriterStream(System.out);
        } catch (IOException e) {
            throw new RuntimeException("jsh: could not create print stream");
        }
        System.setIn(new ByteArrayInputStream(outputStream.toByteArray()));
        pipeNode.getRight().accept(this);
    }

    public void visit(SeqNode seqNode) {
        seqNode.getLeft().accept(this);
        seqNode.getRight().accept(this);
    }
}