package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;

public class EvalVisitor implements TreeVisitor<Void> {
    private ApplicationManager applicationManager;

    public EvalVisitor(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    public Void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) {
        ArrayList<String> tokens = Parser.parseCallCommand(callNode.getCmdString());
        applicationManager.executeApplication(tokens, inputStream, outputStream);
        
        return null;
    }

    public Void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) {
        ByteArrayOutputStream newStream = new ByteArrayOutputStream();
        pipeNode.getLeft().accept(this, inputStream, newStream);
        ByteArrayInputStream newInputStream = new ByteArrayInputStream(newStream.toByteArray());
        pipeNode.getRight().accept(this, newInputStream, outputStream);

        return null;
    }

    public Void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) {
        seqNode.getLeft().accept(this, inputStream, outputStream);
        if(seqNode.getRight() != null) {
            seqNode.getRight().accept(this, inputStream,  outputStream);
        }

        return null;
    }

    public Void visit(InRedirectionNode inRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        try {
            inputStream = new FileInputStream(inRedirectionNode.getFile());
            inRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            System.out.println(fileNotFoundException.toString());
            throw new RuntimeException("File not found: " + inRedirectionNode.getFile());
        }

        return null;
    }

    public Void visit(OutRedirectionNode outRedirectionNode, InputStream inputStream, OutputStream outputStream) {
        try {
            outputStream = new FileOutputStream(outRedirectionNode.getFile());
            outRedirectionNode.getCmdNode().accept(this, inputStream, outputStream);
        } catch (FileNotFoundException fileNotFoundException) {
            throw new RuntimeException("Could not write to file: " + outRedirectionNode.getFile());
        }

        return null;
    }
}