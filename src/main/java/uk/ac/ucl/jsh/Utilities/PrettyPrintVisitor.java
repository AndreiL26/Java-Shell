package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.PipeNode;
import uk.ac.ucl.jsh.Parser.SeqNode;

public class PrettyPrintVisitor implements TreeVisitor<Void> {
    private StringBuilder shiftSB = new StringBuilder("");
    
    public Void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "Call node: " + callNode.getCmdString());

        return null;
    }

    public Void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "Pipe Node");
        shiftSB.append("   ");
        pipeNode.getLeft().accept(this, null, null);
        pipeNode.getRight().accept(this, null, null);
        shiftSB.setLength(shiftSB.length()-3);

        return null;
    }

    public Void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "Seq Node");
        shiftSB.append("   ");
        seqNode.getLeft().accept(this, null, null);
        seqNode.getRight().accept(this, null, null);
        shiftSB.setLength(shiftSB.length()-3);

        return null;
    }
    
}
