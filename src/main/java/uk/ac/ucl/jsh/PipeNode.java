package uk.ac.ucl.jsh;

public class PipeNode implements Node {
    private Node left;
    private Node right; 

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

    public PipeNode(Node left, Node right) {
        this.left = left;
        this.right = right;
    }

    public void accept(TreeVisitor testVisitor) {
        testVisitor.visit(this);
    }
}