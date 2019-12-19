package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.SeqNode;
import uk.ac.ucl.jsh.Parser.PipeNode;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;

public interface TreeVisitor {
    void visit(SeqNode seqNode,   InputStream inputStream, OutputStream outputStream);
    void visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream);
    void visit(CallNode callNode, InputStream inputStream, OutputStream outputStream);
}