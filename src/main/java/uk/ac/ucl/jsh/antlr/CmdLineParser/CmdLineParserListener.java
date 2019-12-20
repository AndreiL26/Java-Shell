// Generated from uk/ac/ucl/jsh/antlr/CmdLineParser/CmdLineParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CmdLineParser;
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link CmdLineParserParser}.
 */
public interface CmdLineParserListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link CmdLineParserParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void enterCompileUnit(CmdLineParserParser.CompileUnitContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdLineParserParser#compileUnit}.
	 * @param ctx the parse tree
	 */
	void exitCompileUnit(CmdLineParserParser.CompileUnitContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdLineParserParser#command}.
	 * @param ctx the parse tree
	 */
	void enterCommand(CmdLineParserParser.CommandContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdLineParserParser#command}.
	 * @param ctx the parse tree
	 */
	void exitCommand(CmdLineParserParser.CommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pipeBase}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 */
	void enterPipeBase(CmdLineParserParser.PipeBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipeBase}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 */
	void exitPipeBase(CmdLineParserParser.PipeBaseContext ctx);
	/**
	 * Enter a parse tree produced by the {@code pipeRecursive}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 */
	void enterPipeRecursive(CmdLineParserParser.PipeRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code pipeRecursive}
	 * labeled alternative in {@link CmdLineParserParser#pipe}.
	 * @param ctx the parse tree
	 */
	void exitPipeRecursive(CmdLineParserParser.PipeRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqRecursive}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeqRecursive(CmdLineParserParser.SeqRecursiveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqRecursive}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeqRecursive(CmdLineParserParser.SeqRecursiveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code seqBase}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 */
	void enterSeqBase(CmdLineParserParser.SeqBaseContext ctx);
	/**
	 * Exit a parse tree produced by the {@code seqBase}
	 * labeled alternative in {@link CmdLineParserParser#seq}.
	 * @param ctx the parse tree
	 */
	void exitSeqBase(CmdLineParserParser.SeqBaseContext ctx);
	/**
	 * Enter a parse tree produced by {@link CmdLineParserParser#call}.
	 * @param ctx the parse tree
	 */
	void enterCall(CmdLineParserParser.CallContext ctx);
	/**
	 * Exit a parse tree produced by {@link CmdLineParserParser#call}.
	 * @param ctx the parse tree
	 */
	void exitCall(CmdLineParserParser.CallContext ctx);
}