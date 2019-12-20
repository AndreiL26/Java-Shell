package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public class CallNode implements Node {
    private String cmdString;

    public CallNode(String cmdString) {
        this.cmdString = cmdString;
    }

    public String getCmdString() {
        return cmdString;
    }

    public void accept(TreeVisitor treeVisitor, InputStream inputStream, OutputStream outputStream) {
        treeVisitor.visit(this, inputStream, outputStream);
    }
}