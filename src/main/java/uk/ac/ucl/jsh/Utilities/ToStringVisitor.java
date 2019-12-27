package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.PipeNode;
import uk.ac.ucl.jsh.Parser.SeqNode;

public class ToStringVisitor implements TreeVisitor<String> {
    public String visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        String fString = seqNode.getLeft().accept(this, inputStream, outputStream);
        String sString = seqNode.getRight().accept(this, inputStream, outputStream);
        return "SeqNode (" + fString + ", " + sString + ")";
    }

    public String visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        String fString = pipeNode.getLeft().accept(this, inputStream, outputStream);
        String sString = pipeNode.getRight().accept(this, inputStream, outputStream);
        return "PipeNode (" + fString + ", " + sString + ")";
    }

    public String visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        return callNode.getCmdString();
    }
}