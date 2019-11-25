package uk.ac.ucl.jsh;

interface TreeVisitor {
    void visit(SeqNode seqNode);
    void visit(PipeNode pipeNode);
    void visit(CallNode callNode);
}