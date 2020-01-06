package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Parser.Node;
import uk.ac.ucl.jsh.Parser.Parser;
import uk.ac.ucl.jsh.Utilities.*;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jsh {
    public final static String fileSeparator = System.getProperty("file.separator");
    public final static String lineSeparator = System.getProperty("line.separator");

    private static ArrayList<String> history = new ArrayList<>();

    public static ArrayList<String> getHistory() {
        return history;
    }

    public static void clearHistory() {
        history.clear();
    }

    public static void eval(String cmdline, OutputStream outputStream) {
        Node cmdTree = Parser.parserCmdLine(cmdline);
        try {
            cmdTree.accept(new EvalVisitor(), null, outputStream);
        } catch (JshException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) throws Exception {
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
                System.out.println(e.getMessage());
            }
            //eval(args[1], System.out);
        } else {
            System.out.println("Hello World!");
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    String prompt = FileSystem.getInstance().getWorkingDirectoryPath() + "> ";
                    System.out.print(prompt);
                    try {
                        String cmdline = input.nextLine();
                        history.add(cmdline);
                        eval(cmdline, System.out);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                }
            } finally {
                input.close();
            }
        }
    }

}
