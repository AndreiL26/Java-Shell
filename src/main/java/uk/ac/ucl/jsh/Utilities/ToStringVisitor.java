package uk.ac.ucl.jsh.Utilities;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.InRedirectionNode;
import uk.ac.ucl.jsh.Parser.OutRedirectionNode;
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

    public String visit(InRedirectionNode inRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        String cmdString = inRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        return "In (" + cmdString + ", " + inRedirectionNode.getFile() + ")";
    }

    public String visit(OutRedirectionNode outRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        String cmdString = outRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        return "Out (" + cmdString + ", " + outRedirectionNode.getFile() + ")";
    }
}