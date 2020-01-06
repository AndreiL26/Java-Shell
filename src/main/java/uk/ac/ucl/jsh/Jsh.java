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

    public static ApplicationManager applicationManager = new ApplicationManager();   // Might want to make this final as well if Outputstream will always remain System.out
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
            cmdTree.accept(new EvalVisitor(applicationManager), null, outputStream);
        } catch (JshException e) {
            System.err.println(e.getMessage());
        }
    }

    public static void main(String[] args) {
        if (args.length > 0) {
            if (args.length != 2) {
                System.err.println("jsh: wrong number of arguments");
                return;
            }
            if (!args[0].equals("-c")) {
                System.err.println("jsh: " + args[0] + ": unexpected argument");
                return;
            }
            
            eval(args[1], System.out);
        } else {
            System.out.println("Hello World!");
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    String prompt = FileSystem.getInstance().getWorkingDirectoryPath() + "> ";
                    System.out.print(prompt);
                    
                    String cmdline = input.nextLine();
                    history.add(cmdline);
                    eval(cmdline, System.out);   
                }
            } finally {
                input.close();
            }
        }
    }

}
