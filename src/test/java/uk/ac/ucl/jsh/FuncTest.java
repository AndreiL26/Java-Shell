package uk.ac.ucl.jsh;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.Scanner;

abstract class FuncTest {
    protected static PipedInputStream in;
    protected static PipedOutputStream out;
    protected static Scanner scn;

    FuncTest() throws Exception {
        in = new PipedInputStream();
        out = new PipedOutputStream(in);
        scn = new Scanner(in);
    }

}