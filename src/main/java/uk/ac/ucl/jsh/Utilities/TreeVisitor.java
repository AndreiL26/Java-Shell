package uk.ac.ucl.jsh.Utilities;

import uk.ac.ucl.jsh.Parser.SeqNode;
import uk.ac.ucl.jsh.Parser.PipeNode;
import uk.ac.ucl.jsh.Parser.CallNode;

public interface TreeVisitor {
    void visit(SeqNode seqNode);
    void visit(PipeNode pipeNode);
    void visit(CallNode callNode);
}