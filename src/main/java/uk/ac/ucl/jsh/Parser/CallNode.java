package uk.ac.ucl.jsh.Parser;

import uk.ac.ucl.jsh.Utilities.TreeVisitor;

public class CallNode implements Node {
    private String cmdString;

    public CallNode(String cmdString) {
        this.cmdString = cmdString;
    }

    public String getCmdString() {
        return cmdString;
    }

    public void accept(TreeVisitor treeVisitor) {
        treeVisitor.visit(this);
    }
}