package uk.ac.ucl.jsh.Utilities;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import uk.ac.ucl.jsh.Parser.*;
import uk.ac.ucl.jsh.antlr.CallParser.CallParserLexer;
import uk.ac.ucl.jsh.antlr.CallParser.CallParserParser;

public class EvalVisitor implements TreeVisitor {
    private CommandManager commandManager;

    public EvalVisitor(CommandManager commandManager) {
        this.commandManager = commandManager;
    }

    public void visit(CallNode callNode) {
        CallParserLexer parserLexer = new CallParserLexer(CharStreams.fromString(callNode.getCmdString()));
        CallParserParser parserParser = new CallParserParser(new CommonTokenStream(parserLexer));
        CallParserParser.CompileUnitContext compileUnit = parserParser.compileUnit();
        ArrayList<String> tokens = new BuildCallCommand().visitCompileUnit(compileUnit);
        commandManager.executeCommand(tokens);
    }

    public void visit(PipeNode pipeNode) {
        pipeNode.getLeft().accept(this);
        pipeNode.getRight().accept(this);
    }

    public void visit(SeqNode seqNode) {
        seqNode.getLeft().accept(this);
        if (seqNode.getRight() != null) {
            seqNode.getRight().accept(this);
        }
    }
}