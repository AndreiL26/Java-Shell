package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.SeqNode;
import uk.ac.ucl.jsh.Parser.PipeNode;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;

public interface TreeVisitor<T> {
    T visit(SeqNode seqNode,   InputStream inputStream, OutputStream outputStream) throws JshException;
    T visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream) throws JshException;
    T visit(CallNode callNode, InputStream inputStream, OutputStream outputStream) throws JshException;
}