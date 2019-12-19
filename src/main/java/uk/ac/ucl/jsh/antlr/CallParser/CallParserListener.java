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
	 * Enter a parse tree produced by {@link CallParserParser#pwd}.
	 * @param ctx the parse tree
	 */
	void enterPwd(CallParserParser.PwdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#pwd}.
	 * @param ctx the parse tree
	 */
	void exitPwd(CallParserParser.PwdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#cd}.
	 * @param ctx the parse tree
	 */
	void enterCd(CallParserParser.CdContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#cd}.
	 * @param ctx the parse tree
	 */
	void exitCd(CallParserParser.CdContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#ls}.
	 * @param ctx the parse tree
	 */
	void enterLs(CallParserParser.LsContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#ls}.
	 * @param ctx the parse tree
	 */
	void exitLs(CallParserParser.LsContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#cat}.
	 * @param ctx the parse tree
	 */
	void enterCat(CallParserParser.CatContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#cat}.
	 * @param ctx the parse tree
	 */
	void exitCat(CallParserParser.CatContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#echo}.
	 * @param ctx the parse tree
	 */
	void enterEcho(CallParserParser.EchoContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#echo}.
	 * @param ctx the parse tree
	 */
	void exitEcho(CallParserParser.EchoContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#head}.
	 * @param ctx the parse tree
	 */
	void enterHead(CallParserParser.HeadContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#head}.
	 * @param ctx the parse tree
	 */
	void exitHead(CallParserParser.HeadContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#tail}.
	 * @param ctx the parse tree
	 */
	void enterTail(CallParserParser.TailContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#tail}.
	 * @param ctx the parse tree
	 */
	void exitTail(CallParserParser.TailContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#grep}.
	 * @param ctx the parse tree
	 */
	void enterGrep(CallParserParser.GrepContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#grep}.
	 * @param ctx the parse tree
	 */
	void exitGrep(CallParserParser.GrepContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#sed}.
	 * @param ctx the parse tree
	 */
	void enterSed(CallParserParser.SedContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#sed}.
	 * @param ctx the parse tree
	 */
	void exitSed(CallParserParser.SedContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#find}.
	 * @param ctx the parse tree
	 */
	void enterFind(CallParserParser.FindContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#find}.
	 * @param ctx the parse tree
	 */
	void exitFind(CallParserParser.FindContext ctx);
	/**
	 * Enter a parse tree produced by {@link CallParserParser#wc}.
	 * @param ctx the parse tree
	 */
	void enterWc(CallParserParser.WcContext ctx);
	/**
	 * Exit a parse tree produced by {@link CallParserParser#wc}.
	 * @param ctx the parse tree
	 */
	void exitWc(CallParserParser.WcContext ctx);
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