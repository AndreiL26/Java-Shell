package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.*;
import java.io.IOException;
import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor {
    private CommandManager commandManager;

    public EvalVisitor(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void visit(CallNode callNode) {
        try {
            ArrayList<String> tokens = Parser.getTokens(callNode.getCmdString(), commandManager.getFileSystem().getWorkingDirectoryPath());
            commandManager.executeCommand(tokens);
        }
        catch (IOException ioException) {
            throw new RuntimeException(callNode + " could not be executed");
        }
    }

    public void visit(PipeNode pipeNode) {
        pipeNode.getLeft().accept(this);
        pipeNode.getRight().accept(this);
    }

    public void visit(SeqNode seqNode) {
        seqNode.getLeft().accept(this);
        seqNode.getRight().accept(this);
    }
}