package uk.ac.ucl.jsh;

import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor {
    public void visit(CallNode callNode) {
        System.out.println(callNode.getCmdString());
        //ArrayList<String> tokens = Parser.getTokens(callNode.getCmdString());
    }

    public void visit(PipeNode pipeNode) {
        pipeNode.getLeft().accept(this);
        pipeNode.getRight().accept(this);
    }

    public void visit(SeqNode seqNode) {
        seqNode.getLeft().accept(this);
        seqNode.getRight().accept(this);
    }
}