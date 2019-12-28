package uk.ac.ucl.jsh.Parser;
import uk.ac.ucl.jsh.antlr.CmdLineParser.*;


public class BuildCmdTree extends CmdLineParserBaseVisitor<Node> {
    @Override
    public Node visitCompileUnit(CmdLineParserParser.CompileUnitContext ctx) {
        if (ctx.seq() != null) {
            return visit(ctx.seq());
        }

        return visit(ctx.command());
    }
    
    @Override 
    public Node visitCommand(CmdLineParserParser.CommandContext ctx) { 
        if (ctx.pipe() != null) {
            return visit(ctx.pipe());
        }

        return visit(ctx.call());
    }

    @Override
    public Node visitPipeBase(CmdLineParserParser.PipeBaseContext ctx) { 
        return new PipeNode(visit(ctx.call1), visit(ctx.call2));
    }

    @Override 
    public Node visitPipeRecursive(CmdLineParserParser.PipeRecursiveContext ctx) { 
        return new PipeNode(visit(ctx.pipe()), visit(ctx.call()));
    }

    @Override 
    public Node visitSeqRecursive(CmdLineParserParser.SeqRecursiveContext ctx) { 
        return new SeqNode(visit(ctx.seq()), visit(ctx.command()));
    }

    @Override 
    public Node visitSeqBase(CmdLineParserParser.SeqBaseContext ctx) { 
        return new SeqNode(visit(ctx.cmd1), visit(ctx.cmd2));
    }

    public Node visitSimpleCall(CmdLineParserParser.SimpleCallContext ctx) {
        return new CallNode(ctx.getText());
    }
	
}
