package uk.ac.ucl.jsh.Parser;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

import uk.ac.ucl.jsh.Jsh;
import uk.ac.ucl.jsh.Utilities.JshException;
import uk.ac.ucl.jsh.antlr.CallParser.*;

public class BuildCallCommand extends CallParserBaseVisitor<ArrayList<String>> {
    @Override 
    public ArrayList<String> visitCompileUnit(CallParserParser.CompileUnitContext ctx) { 
        return visit(ctx.arguments()); 
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
        return visit(ctx.dquote_content());
    }

    @Override 
    public ArrayList<String> visitDquote_content(CallParserParser.Dquote_contentContext ctx) { 
        StringBuilder stringBuilder = new StringBuilder();
        if (ctx.backquoted() != null) {
            stringBuilder.append(visit(ctx.backquoted()).get(0));
        }
        else if (ctx.content != null) {
            stringBuilder.append(ctx.content.getText());
        }

        if (ctx.dquote_content() != null) {
            stringBuilder.append(visit(ctx.dquote_content()).get(0));
        }

        return new ArrayList<>(List.of(stringBuilder.toString()));
    }
	
    @Override 
    public ArrayList<String> visitBackquoted(CallParserParser.BackquotedContext ctx) { 
        String cmdSubstitutionStirng = ctx.content.getText();
        if (cmdSubstitutionStirng == "") {
            return new ArrayList<>(List.of(""));
        }
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        ArrayList<String> tokens = Parser.parseCallCommand(cmdSubstitutionStirng);
        try {
            Jsh.applicationManager.executeApplication(tokens, null, outputStream);
        } catch (JshException e) {
            throw new RuntimeException(e.getMessage());
        }
        return new ArrayList<>(List.of(outputStream.toString().trim()));
    }
}