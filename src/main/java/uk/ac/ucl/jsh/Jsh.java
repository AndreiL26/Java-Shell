package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Parser.BuildCmdTree;
import uk.ac.ucl.jsh.Parser.Node;
import uk.ac.ucl.jsh.Utilities.*;
import uk.ac.ucl.jsh.antlr.CmdLineParser.CmdLineParserLexer;
import uk.ac.ucl.jsh.antlr.CmdLineParser.CmdLineParserParser;


import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;


public class Jsh {
    public static final FileSystem fileSystem = new FileSystem();
    private static CommandManager commandManager;

    public static Node getCmdTree(String cmdLine) {
        //System.out.println(cmdLine);
        CmdLineParserLexer parserLexer = new CmdLineParserLexer(CharStreams.fromString(cmdLine));
        CmdLineParserParser parserParser = new CmdLineParserParser(new CommonTokenStream(parserLexer));
        CmdLineParserParser.CompileUnitContext compileUnit = parserParser.compileUnit();
        return new BuildCmdTree().visitCompileUnit(compileUnit);
    }

    public static void eval(String cmdline, OutputStream output) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(output);
        commandManager = new CommandManager(fileSystem, writer);
        Node cmdTree = getCmdTree(cmdline);
        cmdTree.accept(new EvalVisitor(commandManager));
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args.length != 2) {
                System.out.println("jsh: wrong number of arguments");
                return;
            }
            if (!args[0].equals("-c")) {
                System.out.println("jsh: " + args[0] + ": unexpected argument");
            }
            try {
                eval(args[1], System.out);
            } catch (Exception e) {
                System.out.println("jsh: " + e.getMessage());
            }
        } else {
            System.out.println("Hello World!");
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    String prompt = fileSystem.getWorkingDirectoryPath() + "> ";
                    System.out.print(prompt);
                    try {
                        String cmdline = input.nextLine();
                        eval(cmdline, System.out);
                    } catch (Exception e) {
                        System.out.println("jsh: " + e.getMessage());
                    }
                }
            } finally {
                input.close();
            }
        }
    }

}
