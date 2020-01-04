package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.PipeNode;
import uk.ac.ucl.jsh.Parser.SeqNode;

public class ToStringVisitor implements TreeVisitor<String> {
    private StringBuilder shiftSB = new StringBuilder("");
    
    public String visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        return shiftSB.toString() + "Call node: " + callNode.getCmdString() + Jsh.lineSeparator;
    }

    public String visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        StringBuilder result = new StringBuilder();
        result.append(shiftSB.toString() + "Pipe Node" + Jsh.lineSeparator);
        shiftSB.append("\t");
        result.append(pipeNode.getLeft().accept(this, inputStream, outputStream));
        result.append(pipeNode.getRight().accept(this, inputStream, outputStream));
        shiftSB.setLength(shiftSB.length()-1);

        return result.toString();
    }

    public String visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        StringBuilder result = new StringBuilder();
        result.append(shiftSB.toString() + "Seq Node" + Jsh.lineSeparator);
        shiftSB.append("\t");
        result.append(seqNode.getLeft().accept(this, inputStream, outputStream));
        result.append(seqNode.getRight().accept(this, inputStream, outputStream));
        shiftSB.setLength(shiftSB.length()-1);

        return result.toString();
    }
}
