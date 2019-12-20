// Generated from uk/ac/ucl/jsh/antlr/CmdLineParser/CmdLineParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CmdLineParser;
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link CmdLineParserParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface CmdLineParserVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link CmdLineParserParser#compileUnit}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCompileUnit(CmdLineParserParser.CompileUnitContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdLineParserParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCommand(CmdLineParserParser.CommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipeBase}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeBase(CmdLineParserParser.PipeBaseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code pipeRecursive}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPipeRecursive(CmdLineParserParser.PipeRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqRecursive}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqRecursive(CmdLineParserParser.SeqRecursiveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code seqBase}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitSeqBase(CmdLineParserParser.SeqBaseContext ctx);
	/**
	 * Visit a parse tree produced by {@link CmdLineParserParser#call}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCall(CmdLineParserParser.CallContext ctx);
}