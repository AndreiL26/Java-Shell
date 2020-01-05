package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.JshException;
import uk.ac.ucl.jsh.Utilities.ToStringVisitor;
import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public abstract class Node {
    public abstract <T> T accept(TreeVisitor<T> treeVisitor, InputStream inputStream, OutputStream outputStream) throws JshException;

    @Override
    public String toString() {
        try {
            return this.accept(new ToStringVisitor(), null, null);
        } catch (JshException e) {
            return "";
        }
    }
}