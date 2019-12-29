package uk.ac.ucl.jsh.Parser;

import java.util.ArrayList;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;

import uk.ac.ucl.jsh.antlr.CallParser.CallParserLexer;
import uk.ac.ucl.jsh.antlr.CallParser.CallParserParser;
import uk.ac.ucl.jsh.antlr.CmdLineParser.CmdLineParserLexer;
import uk.ac.ucl.jsh.antlr.CmdLineParser.CmdLineParserParser;

public class Parser {
    public static Node parserCmdLine(String cmdLine) {
        CmdLineParserLexer parserLexer = new CmdLineParserLexer(CharStreams.fromString(cmdLine));
        CmdLineParserParser parserParser = new CmdLineParserParser(new CommonTokenStream(parserLexer));
        CmdLineParserParser.CompileUnitContext compileUnit = parserParser.compileUnit();
        return new BuildCmdTree().visitCompileUnit(compileUnit); 
    }

    public static ArrayList<String> parseCallCommand(String callCommand) {
        CallParserLexer parserLexer = new CallParserLexer(CharStreams.fromString(callCommand));
        CallParserParser parserParser = new CallParserParser(new CommonTokenStream(parserLexer));
        CallParserParser.CompileUnitContext compileUnit = parserParser.compileUnit();
        ArrayList<String> tokens = new BuildCallCommand().visitCompileUnit(compileUnit);
        return tokens;
    }
}