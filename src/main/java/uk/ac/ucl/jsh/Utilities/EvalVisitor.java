package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.*;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;

import java.util.ArrayList;
import java.util.Collections;

import netscape.javascript.JSException;

public class EvalVisitor implements TreeVisitor<Void> {
    private ApplicationManager applicationManager;

    public EvalVisitor(ApplicationManager applicationManager) {
        this.applicationManager = applicationManager;
    }

    private InputStream getInputStream(ArrayList<String> tokens, InputStream inputStream) throws JshException {
        if (Collections.frequency(tokens, "<") > 1) {
            throw new JshException("Too many files for input redirection");
        }

        try {
            int inIndex = tokens.indexOf("<");
            if (inIndex != -1 && inIndex + 1 < tokens.size()) {
                inputStream = new FileInputStream(FileSystem.getInstance().getFile(tokens.get(inIndex+1)));
                tokens.subList(inIndex, inIndex + 2).clear();
            }
        } catch (FileNotFoundException e) {
            throw new JshException(e.getMessage());
        }

        return inputStream;
    }

    private OutputStream getOutputStream(ArrayList<String> tokens, OutputStream outputStream) throws JshException {
        if (Collections.frequency(tokens, ">") > 1) {
            throw new JSException("Too many files for output redirection");
        }

        try {
            int outIndex = tokens.indexOf(">");
            if (outIndex != -1 && outIndex + 1 < tokens.size()) {
                outputStream = new FileOutputStream(FileSystem.getInstance().getFile(tokens.get(outIndex+1)));
                tokens.subList(outIndex, outIndex + 2).clear();
            }
        } catch (FileNotFoundException e) {
            throw new JshException(e.getMessage());
        }

        return outputStream;
    }

    public Void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) throws JshException {
        ArrayList<String> tokens = Parser.parseCallCommand(callNode.getCmdString());
        
        inputStream = getInputStream(tokens, inputStream);
        outputStream = getOutputStream(tokens, outputStream);
        applicationManager.executeApplication(tokens, inputStream, outputStream);
        
        return null;
    }

    public Void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) throws JshException {
        ByteArrayOutputStream newStream = new ByteArrayOutputStream();
        pipeNode.getLeft().accept(this, inputStream, newStream);
        ByteArrayInputStream newInputStream = new ByteArrayInputStream(newStream.toByteArray());
        pipeNode.getRight().accept(this, newInputStream, outputStream);

        return null;
    }

    public Void visit(SeqNode seqNode, InputStream inputStream, OutputStream outputStream) throws JshException {
        seqNode.getLeft().accept(this, inputStream, outputStream);
        if(seqNode.getRight() != null) {
            seqNode.getRight().accept(this, inputStream,  outputStream);
        }

        return null;
    }
}