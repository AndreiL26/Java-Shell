package uk.ac.ucl.jsh.Parser;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import uk.ac.ucl.jsh.Jsh;
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
        if (ctx.LT() != null) {
            result.add("<");
        }
        if (ctx.GT() != null) {
            result.add(">");
        }

        if (ctx.arguments() != null) {
            result.addAll(visit(ctx.arguments()));
        }

        return result;
    }

    @Override 
    public ArrayList<String> visitArgument(CallParserParser.ArgumentContext ctx) {
        ArrayList<String> result = new ArrayList<>();

        if (ctx.quoted() != null) {
            appendArgument(result, visit(ctx.quoted()));
        }
        else {
            appendArgument(result, new ArrayList<>(Arrays.asList(ctx.non_quote.getText())));
        }

        if (ctx.argument() != null) {
            appendArgument(result, visit(ctx.argument()));
        }

        return result;
    }

    @Override 
    public ArrayList<String> visitQuoted(CallParserParser.QuotedContext ctx) { 
        return visitChildren(ctx); 
    }
	
    @Override 
    public ArrayList<String> visitSingle_quoted(CallParserParser.Single_quotedContext ctx) {
        return new ArrayList<>(List.of(ctx.squote_content().getText()));
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
        String cmdSubstitutionString = ctx.content.getText();
        if (cmdSubstitutionString == "") {
            return new ArrayList<>(List.of(""));
        }
        
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        Jsh.eval(cmdSubstitutionString, outputStream);

        return new ArrayList<String>(Arrays.asList(outputStream.toString().trim().split(Jsh.lineSeparator)));
    }

    private void appendArgument(ArrayList<String> result, ArrayList<String> arrToAppend) {
        if (result.isEmpty()) {
            result.addAll(arrToAppend);
            return;
        }

        if (arrToAppend.isEmpty()) {
            return;
        }

        result.set(result.size()-1, result.get(result.size()-1) + arrToAppend.get(0));
        result.addAll(arrToAppend.subList(1, arrToAppend.size()));
    }
}