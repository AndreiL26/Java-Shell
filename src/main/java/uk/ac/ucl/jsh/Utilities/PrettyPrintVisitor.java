package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.InRedirectionNode;
import uk.ac.ucl.jsh.Parser.OutRedirectionNode;
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
        shiftSB.append("\t");
        pipeNode.getLeft().accept(this, inputStream, outputStream);
        pipeNode.getRight().accept(this, inputStream, outputStream);
        shiftSB.setLength(shiftSB.length()-1);

        return null;
    }

    public Void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "Seq Node");
        shiftSB.append("\t");
        seqNode.getLeft().accept(this, inputStream, outputStream);
        seqNode.getRight().accept(this, inputStream, outputStream);
        shiftSB.setLength(shiftSB.length()-1);

        return null;
    }

    public Void visit(InRedirectionNode inRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "InRedirection Node");
        shiftSB.append("\t");
        inRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        System.out.println(shiftSB.toString() + "File: " + inRedirectionNode.getFile());
        shiftSB.setLength(shiftSB.length()-1);

        return null;
    }

    public Void visit(OutRedirectionNode outRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        System.out.println(shiftSB.toString() + "OutRedirection Node");
        shiftSB.append("\t");
        outRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        System.out.println(shiftSB.toString() + "File: " + outRedirectionNode.getFile());
        shiftSB.setLength(shiftSB.length()-1);

        return null;
    }
    
}
