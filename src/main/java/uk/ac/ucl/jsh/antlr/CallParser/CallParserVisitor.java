// Generated from uk/ac/ucl/jsh/antlr/CallParser/CallParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CallParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CallParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CallParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CallParserParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(CallParserParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#application}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitApplication(CallParserParser.ApplicationContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#pwd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPwd(CallParserParser.PwdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#cd}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCd(CallParserParser.CdContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#ls}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLs(CallParserParser.LsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#cat}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCat(CallParserParser.CatContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#echo}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEcho(CallParserParser.EchoContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#head}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitHead(CallParserParser.HeadContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#tail}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTail(CallParserParser.TailContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#grep}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGrep(CallParserParser.GrepContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#sed}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSed(CallParserParser.SedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#find}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFind(CallParserParser.FindContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#wc}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWc(CallParserParser.WcContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#arguments}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArguments(CallParserParser.ArgumentsContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#argument}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitArgument(CallParserParser.ArgumentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#non_quoted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNon_quoted(CallParserParser.Non_quotedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#quoted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitQuoted(CallParserParser.QuotedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#single_quoted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSingle_quoted(CallParserParser.Single_quotedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#squote_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSquote_content(CallParserParser.Squote_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#double_quoted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDouble_quoted(CallParserParser.Double_quotedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#dquote_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDquote_content(CallParserParser.Dquote_contentContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#backquoted}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBackquoted(CallParserParser.BackquotedContext ctx);
	/**
	 * Visit a parse tree produced by {@link CallParserParser#bquote_content}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBquote_content(CallParserParser.Bquote_contentContext ctx);
}