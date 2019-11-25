package uk.ac.ucl.jsh;

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