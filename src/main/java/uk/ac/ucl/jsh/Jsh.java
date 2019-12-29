package uk.ac.ucl.jsh;

import uk.ac.ucl.jsh.Parser.Node;
import uk.ac.ucl.jsh.Parser.Parser;
import uk.ac.ucl.jsh.Utilities.*;


import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Jsh {
    private static final FileSystem fileSystem =  new FileSystem(System.getProperty("user.dir"));;
    public static ApplicationManager applicationManager = new ApplicationManager(fileSystem);   // Might want to make this final as well if Outputstream will always remain System.out
    
    private static ArrayList<String> history = new ArrayList<>();

    public static ArrayList<String> getHistory() {
        return history;
    }

    public static void clearHistory() {
        history.clear();
    }

    public static void eval(String cmdline, OutputStream output) throws IOException {
        Node cmdTree = Parser.parserCmdLine(cmdline);
        cmdTree.accept(new EvalVisitor(applicationManager), null, System.out);
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
                System.out.println("jsh: " + e.getMessage());
            }
            //eval(args[1], System.out);
        } else {
            System.out.println("Hello World!");
            Scanner input = new Scanner(System.in);
            try {
                while (true) {
                    String prompt = fileSystem.getWorkingDirectoryPath() + "> ";
                    System.out.print(prompt);
                    try {
                        String cmdline = input.nextLine();
                        history.add(cmdline);
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
