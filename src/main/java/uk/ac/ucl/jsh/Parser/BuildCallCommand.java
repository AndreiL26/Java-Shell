package uk.ac.ucl.jsh.Parser;

import java.util.ArrayList;
import java.util.List;
import uk.ac.ucl.jsh.antlr.CallParser.*;

public class BuildCallCommand extends CallParserBaseVisitor<ArrayList<String>> {
    @Override 
    public ArrayList<String> visitCompileUnit(CallParserParser.CompileUnitContext ctx) { 
        return visit(ctx.application()); 
    }
	
    @Override 
    public ArrayList<String> visitPwd(CallParserParser.PwdContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("pwd"));
        return result;
    }
	
    @Override 
    public ArrayList<String> visitCd(CallParserParser.CdContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("cd"));
        if (ctx.argument() != null) {
            result.addAll(visit(ctx.argument()));
        }

        return result;
    }
    
    @Override 
    public ArrayList<String> visitLs(CallParserParser.LsContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("ls"));
        if (ctx.argument() != null) {
            result.addAll(visit(ctx.argument()));
        }

        return result;
    }
	
    @Override 
    public ArrayList<String> visitCat(CallParserParser.CatContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("cat"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }
	
    @Override 
    public ArrayList<String> visitEcho(CallParserParser.EchoContext ctx) {
        ArrayList<String> result = new ArrayList<>(List.of("echo"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }

    @Override 
    public ArrayList<String> visitHead(CallParserParser.HeadContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("head"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }
	
    @Override 
    public ArrayList<String> visitTail(CallParserParser.TailContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("tail"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }

    @Override 
    public ArrayList<String> visitGrep(CallParserParser.GrepContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("grep"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }  

        return result;
    }
	
    @Override 
    public ArrayList<String> visitSed(CallParserParser.SedContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("sed"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result; 
    }
	
    @Override 
    public ArrayList<String> visitFind(CallParserParser.FindContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("find"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }
	
    @Override 
    public ArrayList<String> visitWc(CallParserParser.WcContext ctx) { 
        ArrayList<String> result = new ArrayList<>(List.of("wc"));
        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }
	
    @Override 
    public ArrayList<String> visitArguments(CallParserParser.ArgumentsContext ctx) {
        ArrayList<String> result = new ArrayList<>();
        result.addAll(visit(ctx.argument()));

        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }

    @Override 
    public ArrayList<String> visitArgument(CallParserParser.ArgumentContext ctx) {
        StringBuilder stringBuilder = new StringBuilder();

        if (ctx.quoted() != null) {
            stringBuilder.append(visit(ctx.quoted()).get(0));
        }
        else {
            
            stringBuilder.append(ctx.non_quote.getText());
        }

        if (ctx.argument() != null) {
            stringBuilder.append(visit(ctx.argument()).get(0));
        }

        return new ArrayList<>(List.of(stringBuilder.toString()));
    }

    @Override 
    public ArrayList<String> visitQuoted(CallParserParser.QuotedContext ctx) { 
        return visitChildren(ctx); 
    }
	
    @Override 
    public ArrayList<String> visitSingle_quoted(CallParserParser.Single_quotedContext ctx) { 
        return new ArrayList<>(List.of(ctx.content.getText()));
    }
	
    @Override 
    public ArrayList<String> visitDouble_quoted(CallParserParser.Double_quotedContext ctx) {
        return new ArrayList<>(List.of(ctx.content.getText()));
    }
	
    @Override 
    public ArrayList<String> visitBackquoted(CallParserParser.BackquotedContext ctx) { 
        //String commandSubstitutionStirng = ctx.content.getText();
        return new ArrayList<>(List.of(ctx.content.getText()));
    }
}