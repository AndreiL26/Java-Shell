package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public class OutRedirectionNode implements Node {
    private Node cmdNode;
    private String file;

    public OutRedirectionNode(Node cmdNode, String file) {
        this.cmdNode = cmdNode;
        this.file = file;
    }

    public Node getCmdNode() {
        return cmdNode;
    }

    public String getFile() {
        return file;
    }

    public <T> T accept(TreeVisitor<T> treeVisitor, InputStream inputStream, OutputStream outputStream) {
        return treeVisitor.visit(this, inputStream, outputStream);
    }
}