package uk.ac.ucl.jsh.Parser;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public interface Node {
    public <T> T accept(TreeVisitor<T> treeVisitor, InputStream inputStream, OutputStream outputStream);
}