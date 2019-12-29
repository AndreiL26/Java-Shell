package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.SeqNode;
import uk.ac.ucl.jsh.Parser.PipeNode;

import java.io.InputStream;
import java.io.OutputStream;

import uk.ac.ucl.jsh.Parser.CallNode;
import uk.ac.ucl.jsh.Parser.InRedirectionNode;
import uk.ac.ucl.jsh.Parser.OutRedirectionNode;

public interface TreeVisitor<T> {
    T visit(SeqNode seqNode,   InputStream inputStream, OutputStream outputStream);
    T visit(PipeNode pipeNode, InputStream inputStream, OutputStream outputStream);
    T visit(CallNode callNode, InputStream inputStream, OutputStream outputStream);
    T visit(InRedirectionNode inRedirectionNode, InputStream inputStream, OutputStream outputStream);
    T visit(OutRedirectionNode outRedirectionNode, InputStream inputStream, OutputStream outputStream);
}