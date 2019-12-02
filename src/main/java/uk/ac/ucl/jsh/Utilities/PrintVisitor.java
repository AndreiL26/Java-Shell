package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.PipeNode;
import uk.ac.ucl.jsh.Parser.SeqNode;

public class PrintVisitor implements TreeVisitor {
    private StringBuilder shiftSB = new StringBuilder("");

    public void visit(CallNode callNode) {
        System.out.println(shiftSB.toString() + "Call node: " + callNode.getCmdString());
    }

    public void visit(PipeNode pipeNode) {
        System.out.println(shiftSB.toString() + "Pipe Node");
        shiftSB.append("   ");
        pipeNode.getLeft().accept(this);
        pipeNode.getRight().accept(this);
        shiftSB.setLength(shiftSB.length()-3);
    }

    public void visit(SeqNode seqNode) {
        System.out.println(shiftSB.toString() + "Seq Node");
        shiftSB.append("   ");
        seqNode.getLeft().accept(this);
        seqNode.getRight().accept(this);
        shiftSB.setLength(shiftSB.length()-3);
    }
}