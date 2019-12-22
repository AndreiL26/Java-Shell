// Generated from uk/ac/ucl/jsh/antlr/CallParser/CallParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CallParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CallParserParser}.
 */
public interface CallParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CallParserParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(CallParserParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(CallParserParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#arguments}.
	 * @param ctx the parse tree
	 */
	void enterArguments(CallParserParser.ArgumentsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#arguments}.
	 * @param ctx the parse tree
	 */
	void exitArguments(CallParserParser.ArgumentsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void enterArgument(CallParserParser.ArgumentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#argument}.
	 * @param ctx the parse tree
	 */
	void exitArgument(CallParserParser.ArgumentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#non_quoted}.
	 * @param ctx the parse tree
	 */
	void enterNon_quoted(CallParserParser.Non_quotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#non_quoted}.
	 * @param ctx the parse tree
	 */
	void exitNon_quoted(CallParserParser.Non_quotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#quoted}.
	 * @param ctx the parse tree
	 */
	void enterQuoted(CallParserParser.QuotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#quoted}.
	 * @param ctx the parse tree
	 */
	void exitQuoted(CallParserParser.QuotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#single_quoted}.
	 * @param ctx the parse tree
	 */
	void enterSingle_quoted(CallParserParser.Single_quotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#single_quoted}.
	 * @param ctx the parse tree
	 */
	void exitSingle_quoted(CallParserParser.Single_quotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#squote_content}.
	 * @param ctx the parse tree
	 */
	void enterSquote_content(CallParserParser.Squote_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#squote_content}.
	 * @param ctx the parse tree
	 */
	void exitSquote_content(CallParserParser.Squote_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#double_quoted}.
	 * @param ctx the parse tree
	 */
	void enterDouble_quoted(CallParserParser.Double_quotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#double_quoted}.
	 * @param ctx the parse tree
	 */
	void exitDouble_quoted(CallParserParser.Double_quotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#dquote_content}.
	 * @param ctx the parse tree
	 */
	void enterDquote_content(CallParserParser.Dquote_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#dquote_content}.
	 * @param ctx the parse tree
	 */
	void exitDquote_content(CallParserParser.Dquote_contentContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#backquoted}.
	 * @param ctx the parse tree
	 */
	void enterBackquoted(CallParserParser.BackquotedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#backquoted}.
	 * @param ctx the parse tree
	 */
	void exitBackquoted(CallParserParser.BackquotedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#bquote_content}.
	 * @param ctx the parse tree
	 */
	void enterBquote_content(CallParserParser.Bquote_contentContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#bquote_content}.
	 * @param ctx the parse tree
	 */
	void exitBquote_content(CallParserParser.Bquote_contentContext ctx);
}