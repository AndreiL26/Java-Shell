package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public class SeqNode implements Node {
    private Node left;
    private Node right; 

    public SeqNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    /**
     * @return the left
     */
    public Node getLeft() {
        return left;
    }

    /**
     * @return the right
     */
    public Node getRight() {
        return right;
    }
    
    public <T> T accept(TreeVisitor<T> testVisitor, InputStream inputStream, OutputStream outputStream) {
        return testVisitor.visit(this, inputStream, outputStream);
    }
}