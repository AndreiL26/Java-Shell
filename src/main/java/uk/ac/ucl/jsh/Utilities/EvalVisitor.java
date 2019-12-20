package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor {
    private ApplicationManager applicationManager;

    public EvalVisitor(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    public void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        ArrayList<String> tokens = Parser.parseCallCommand(callNode.getCmdString());
        applicationManager.executeApplication(tokens, inputStream, outputStream);
    }

    public void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream newStream = new ByteArrayOutputStream();
        pipeNode.getLeft().accept(this, inputStream, newStream);
        ByteArrayInputStream newInputStream = new ByteArrayInputStream(newStream.toByteArray());
        pipeNode.getRight().accept(this, newInputStream, outputStream);
    }

    public void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        seqNode.getLeft().accept(this, inputStream, outputStream);
        if(seqNode.getRight() != null) {
            seqNode.getRight().accept(this, inputStream,  outputStream);
        }
    }
}