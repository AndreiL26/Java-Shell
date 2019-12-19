package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor {
    private ApplicationManager applicationManager;

    public EvalVisitor(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    public void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        try {
            ArrayList<String> tokens = Parser.getTokens(callNode.getCmdString(), 
                                                        applicationManager.getFileSystem().getWorkingDirectoryPath());
            applicationManager.executeApplication(tokens, inputStream, outputStream); 
        }
        catch (IOException ioException) {
            throw new RuntimeException(callNode + " could not be executed");
        }
    }

    public void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream newStream = new ByteArrayOutputStream();
        pipeNode.getLeft().accept(this, inputStream, newStream);
        ByteArrayInputStream newInputStream = new ByteArrayInputStream(newStream.toByteArray());
        pipeNode.getRight().accept(this, newInputStream, outputStream);
    }

    public void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        seqNode.getLeft().accept(this, inputStream, outputStream);
        seqNode.getRight().accept(this, inputStream,  outputStream);
    }
}