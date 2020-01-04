package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public class CallNode extends Node {
    private String cmdString;

    public CallNode(String cmdString) {
        this.cmdString = cmdString;
    }

    public String getCmdString() {
        return cmdString;
    }

    public <T> T accept(TreeVisitor<T> treeVisitor, InputStream inputStream, OutputStream outputStream) {
        return treeVisitor.visit(this, inputStream, outputStream);
    }
}