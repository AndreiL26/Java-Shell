package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Parser.Node;
import uk.ac.ucl.jsh.Utilities.*;
import uk.ac.ucl.jsh.Parser.Parser;
import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.util.Scanner;

public class Jsh {
    private static FileSystem fileSystem = new FileSystem();
    private static String currentDirectory = System.getProperty("user.dir");
    private static CommandManager commandManager;

    public static void eval(String cmdline, OutputStream output) throws IOException {
        OutputStreamWriter writer = new OutputStreamWriter(output);
        commandManager = new CommandManager(fileSystem, writer);
        Node cmdTree = Parser.getCmdTree(cmdline);
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
                    String prompt = currentDirectory + "> ";
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
