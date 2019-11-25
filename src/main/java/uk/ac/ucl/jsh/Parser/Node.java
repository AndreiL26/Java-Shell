package uk.ac.ucl.jsh.Parser;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public interface Node {
    public void accept(TreeVisitor treeVisitor);
}