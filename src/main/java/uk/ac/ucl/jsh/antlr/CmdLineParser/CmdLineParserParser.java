// Generated from uk/ac/ucl/jsh/antlr/CmdLineParser/CmdLineParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CmdLineParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmdLineParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, WS=4, NON_KEYWORD=5, SEMI=6, PIPE=7, GT=8, LT=9;
	public static final int
		RULE_compileUnit = 0, RULE_command = 1, RULE_pipe = 2, RULE_seq = 3, RULE_call = 4, 
		RULE_inRedirection = 5, RULE_outRedirection = 6, RULE_inoutRedirection = 7, 
		RULE_call_content = 8, RULE_single_quoted = 9, RULE_squote_content = 10, 
		RULE_double_quoted = 11, RULE_dquote_content = 12, RULE_backquoted = 13, 
		RULE_bquote_content = 14, RULE_keyword = 15;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "command", "pipe", "seq", "call", "inRedirection", "outRedirection", 
			"inoutRedirection", "call_content", "single_quoted", "squote_content", 
			"double_quoted", "dquote_content", "backquoted", "bquote_content", "keyword"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "'\"'", "'`'", null, null, "';'", "'|'", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "WS", "NON_KEYWORD", "SEMI", "PIPE", "GT", "LT"
		};
	}
	private static final String[] _SYMBOLIC_NAMES = makeSymbolicNames();
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}

	@Override
	public String getGrammarFileName() { return "CmdLineParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CmdLineParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompileUnitContext extends ParserRuleContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CmdLineParserParser.EOF, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		try {
			setState(38);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,0,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(32);
				seq(0);
				setState(33);
				match(EOF);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(35);
				command();
				setState(36);
				match(EOF);
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class CommandContext extends ParserRuleContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitCommand(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_command);
		try {
			setState(42);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,1,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(40);
				pipe(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(41);
				call();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class PipeContext extends ParserRuleContext {
		public PipeContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pipe; }
	 
		public PipeContext() { }
		public void copyFrom(PipeContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PipeBaseContext extends PipeContext {
		public CallContext call1;
		public CallContext call2;
		public TerminalNode PIPE() { return getToken(CmdLineParserParser.PIPE, 0); }
		public List<CallContext> call() {
			return getRuleContexts(CallContext.class);
		}
		public CallContext call(int i) {
			return getRuleContext(CallContext.class,i);
		}
		public PipeBaseContext(PipeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitPipeBase(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class PipeRecursiveContext extends PipeContext {
		public PipeContext pipe() {
			return getRuleContext(PipeContext.class,0);
		}
		public TerminalNode PIPE() { return getToken(CmdLineParserParser.PIPE, 0); }
		public CallContext call() {
			return getRuleContext(CallContext.class,0);
		}
		public PipeRecursiveContext(PipeContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitPipeRecursive(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PipeContext pipe() throws RecognitionException {
		return pipe(0);
	}

	private PipeContext pipe(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		PipeContext _localctx = new PipeContext(_ctx, _parentState);
		PipeContext _prevctx = _localctx;
		int _startState = 4;
		enterRecursionRule(_localctx, 4, RULE_pipe, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new PipeBaseContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(45);
			((PipeBaseContext)_localctx).call1 = call();
			setState(46);
			match(PIPE);
			setState(47);
			((PipeBaseContext)_localctx).call2 = call();
			}
			_ctx.stop = _input.LT(-1);
			setState(54);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new PipeRecursiveContext(new PipeContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_pipe);
					setState(49);
					if (!(precpred(_ctx, 1))) throw new FailedPredicateException(this, "precpred(_ctx, 1)");
					setState(50);
					match(PIPE);
					setState(51);
					call();
					}
					} 
				}
				setState(56);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,2,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class SeqContext extends ParserRuleContext {
		public SeqContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_seq; }
	 
		public SeqContext() { }
		public void copyFrom(SeqContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class SeqRecursiveContext extends SeqContext {
		public SeqContext seq() {
			return getRuleContext(SeqContext.class,0);
		}
		public TerminalNode SEMI() { return getToken(CmdLineParserParser.SEMI, 0); }
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public SeqRecursiveContext(SeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitSeqRecursive(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SeqBaseContext extends SeqContext {
		public CommandContext cmd1;
		public CommandContext cmd2;
		public TerminalNode SEMI() { return getToken(CmdLineParserParser.SEMI, 0); }
		public List<CommandContext> command() {
			return getRuleContexts(CommandContext.class);
		}
		public CommandContext command(int i) {
			return getRuleContext(CommandContext.class,i);
		}
		public SeqBaseContext(SeqContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitSeqBase(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SeqContext seq() throws RecognitionException {
		return seq(0);
	}

	private SeqContext seq(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		SeqContext _localctx = new SeqContext(_ctx, _parentState);
		SeqContext _prevctx = _localctx;
		int _startState = 6;
		enterRecursionRule(_localctx, 6, RULE_seq, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new SeqBaseContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(58);
			((SeqBaseContext)_localctx).cmd1 = command();
			setState(59);
			match(SEMI);
			setState(60);
			((SeqBaseContext)_localctx).cmd2 = command();
			}
			_ctx.stop = _input.LT(-1);
			setState(67);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new SeqRecursiveContext(new SeqContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_seq);
					setState(62);
					if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
					setState(63);
					match(SEMI);
					setState(64);
					command();
					}
					} 
				}
				setState(69);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,3,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class CallContext extends ParserRuleContext {
		public Call_contentContext call_content() {
			return getRuleContext(Call_contentContext.class,0);
		}
		public InRedirectionContext inRedirection() {
			return getRuleContext(InRedirectionContext.class,0);
		}
		public OutRedirectionContext outRedirection() {
			return getRuleContext(OutRedirectionContext.class,0);
		}
		public InoutRedirectionContext inoutRedirection() {
			return getRuleContext(InoutRedirectionContext.class,0);
		}
		public CallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CallContext call() throws RecognitionException {
		CallContext _localctx = new CallContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_call);
		try {
			setState(74);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,4,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(70);
				call_content();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(71);
				inRedirection();
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(72);
				outRedirection();
				}
				break;
			case 4:
				enterOuterAlt(_localctx, 4);
				{
				setState(73);
				inoutRedirection();
				}
				break;
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InRedirectionContext extends ParserRuleContext {
		public Call_contentContext cmd;
		public Call_contentContext file;
		public TerminalNode LT() { return getToken(CmdLineParserParser.LT, 0); }
		public List<Call_contentContext> call_content() {
			return getRuleContexts(Call_contentContext.class);
		}
		public Call_contentContext call_content(int i) {
			return getRuleContext(Call_contentContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public InRedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inRedirection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitInRedirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InRedirectionContext inRedirection() throws RecognitionException {
		InRedirectionContext _localctx = new InRedirectionContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_inRedirection);
		try {
			int _alt;
			setState(89);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case WS:
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(76);
				((InRedirectionContext)_localctx).cmd = call_content();
				setState(77);
				match(LT);
				setState(78);
				((InRedirectionContext)_localctx).file = call_content();
				}
				break;
			case LT:
				enterOuterAlt(_localctx, 2);
				{
				setState(80);
				match(LT);
				setState(81);
				((InRedirectionContext)_localctx).file = call_content();
				setState(83); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(82);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(85); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,5,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(87);
				((InRedirectionContext)_localctx).cmd = call_content();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class OutRedirectionContext extends ParserRuleContext {
		public Call_contentContext cmd;
		public Call_contentContext file;
		public TerminalNode GT() { return getToken(CmdLineParserParser.GT, 0); }
		public List<Call_contentContext> call_content() {
			return getRuleContexts(Call_contentContext.class);
		}
		public Call_contentContext call_content(int i) {
			return getRuleContext(Call_contentContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public OutRedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_outRedirection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitOutRedirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final OutRedirectionContext outRedirection() throws RecognitionException {
		OutRedirectionContext _localctx = new OutRedirectionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_outRedirection);
		try {
			int _alt;
			setState(104);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case WS:
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(91);
				((OutRedirectionContext)_localctx).cmd = call_content();
				setState(92);
				match(GT);
				setState(93);
				((OutRedirectionContext)_localctx).file = call_content();
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 2);
				{
				setState(95);
				match(GT);
				setState(96);
				((OutRedirectionContext)_localctx).file = call_content();
				setState(98); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(97);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(100); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(102);
				((OutRedirectionContext)_localctx).cmd = call_content();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class InoutRedirectionContext extends ParserRuleContext {
		public Call_contentContext file;
		public InRedirectionContext inRedirection() {
			return getRuleContext(InRedirectionContext.class,0);
		}
		public TerminalNode GT() { return getToken(CmdLineParserParser.GT, 0); }
		public Call_contentContext call_content() {
			return getRuleContext(Call_contentContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public InoutRedirectionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_inoutRedirection; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitInoutRedirection(this);
			else return visitor.visitChildren(this);
		}
	}

	public final InoutRedirectionContext inoutRedirection() throws RecognitionException {
		InoutRedirectionContext _localctx = new InoutRedirectionContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_inoutRedirection);
		try {
			int _alt;
			setState(119);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case T__1:
			case T__2:
			case WS:
			case NON_KEYWORD:
			case LT:
				enterOuterAlt(_localctx, 1);
				{
				setState(106);
				inRedirection();
				setState(107);
				match(GT);
				setState(108);
				((InoutRedirectionContext)_localctx).file = call_content();
				}
				break;
			case GT:
				enterOuterAlt(_localctx, 2);
				{
				setState(110);
				match(GT);
				setState(111);
				((InoutRedirectionContext)_localctx).file = call_content();
				setState(113); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(112);
						match(WS);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(115); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,9,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				setState(117);
				inRedirection();
				}
				break;
			default:
				throw new NoViableAltException(this);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Call_contentContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CmdLineParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CmdLineParserParser.NON_KEYWORD, i);
		}
		public List<Single_quotedContext> single_quoted() {
			return getRuleContexts(Single_quotedContext.class);
		}
		public Single_quotedContext single_quoted(int i) {
			return getRuleContext(Single_quotedContext.class,i);
		}
		public List<Double_quotedContext> double_quoted() {
			return getRuleContexts(Double_quotedContext.class);
		}
		public Double_quotedContext double_quoted(int i) {
			return getRuleContext(Double_quotedContext.class,i);
		}
		public List<BackquotedContext> backquoted() {
			return getRuleContexts(BackquotedContext.class);
		}
		public BackquotedContext backquoted(int i) {
			return getRuleContext(BackquotedContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public Call_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_call_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitCall_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Call_contentContext call_content() throws RecognitionException {
		Call_contentContext _localctx = new Call_contentContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_call_content);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(126); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					setState(126);
					_errHandler.sync(this);
					switch (_input.LA(1)) {
					case NON_KEYWORD:
						{
						setState(121);
						match(NON_KEYWORD);
						}
						break;
					case T__0:
						{
						setState(122);
						single_quoted();
						}
						break;
					case T__1:
						{
						setState(123);
						double_quoted();
						}
						break;
					case T__2:
						{
						setState(124);
						backquoted();
						}
						break;
					case WS:
						{
						setState(125);
						match(WS);
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(128); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,12,_ctx);
			} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Single_quotedContext extends ParserRuleContext {
		public Squote_contentContext squote_content() {
			return getRuleContext(Squote_contentContext.class,0);
		}
		public Single_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_quoted; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitSingle_quoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_quotedContext single_quoted() throws RecognitionException {
		Single_quotedContext _localctx = new Single_quotedContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_single_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(130);
			match(T__0);
			setState(131);
			squote_content();
			setState(132);
			match(T__0);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Squote_contentContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CmdLineParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CmdLineParserParser.NON_KEYWORD, i);
		}
		public List<KeywordContext> keyword() {
			return getRuleContexts(KeywordContext.class);
		}
		public KeywordContext keyword(int i) {
			return getRuleContext(KeywordContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public Squote_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squote_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitSquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Squote_contentContext squote_content() throws RecognitionException {
		Squote_contentContext _localctx = new Squote_contentContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_squote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(141);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << SEMI) | (1L << PIPE) | (1L << GT) | (1L << LT))) != 0)) {
				{
				setState(139);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NON_KEYWORD:
					{
					setState(134);
					match(NON_KEYWORD);
					}
					break;
				case SEMI:
				case PIPE:
				case GT:
				case LT:
					{
					setState(135);
					keyword();
					}
					break;
				case WS:
					{
					setState(136);
					match(WS);
					}
					break;
				case T__1:
					{
					setState(137);
					match(T__1);
					}
					break;
				case T__2:
					{
					setState(138);
					match(T__2);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(143);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Double_quotedContext extends ParserRuleContext {
		public Dquote_contentContext dquote_content() {
			return getRuleContext(Dquote_contentContext.class,0);
		}
		public Double_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_quoted; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitDouble_quoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_quotedContext double_quoted() throws RecognitionException {
		Double_quotedContext _localctx = new Double_quotedContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_double_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(144);
			match(T__1);
			setState(145);
			dquote_content();
			setState(146);
			match(T__1);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Dquote_contentContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CmdLineParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CmdLineParserParser.NON_KEYWORD, i);
		}
		public List<KeywordContext> keyword() {
			return getRuleContexts(KeywordContext.class);
		}
		public KeywordContext keyword(int i) {
			return getRuleContext(KeywordContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public List<BackquotedContext> backquoted() {
			return getRuleContexts(BackquotedContext.class);
		}
		public BackquotedContext backquoted(int i) {
			return getRuleContext(BackquotedContext.class,i);
		}
		public Dquote_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_dquote_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitDquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dquote_contentContext dquote_content() throws RecognitionException {
		Dquote_contentContext _localctx = new Dquote_contentContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_dquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(155);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << SEMI) | (1L << PIPE) | (1L << GT) | (1L << LT))) != 0)) {
				{
				setState(153);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NON_KEYWORD:
					{
					setState(148);
					match(NON_KEYWORD);
					}
					break;
				case SEMI:
				case PIPE:
				case GT:
				case LT:
					{
					setState(149);
					keyword();
					}
					break;
				case WS:
					{
					setState(150);
					match(WS);
					}
					break;
				case T__0:
					{
					setState(151);
					match(T__0);
					}
					break;
				case T__2:
					{
					setState(152);
					backquoted();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class BackquotedContext extends ParserRuleContext {
		public Bquote_contentContext content;
		public Bquote_contentContext bquote_content() {
			return getRuleContext(Bquote_contentContext.class,0);
		}
		public BackquotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_backquoted; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitBackquoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BackquotedContext backquoted() throws RecognitionException {
		BackquotedContext _localctx = new BackquotedContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_backquoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(158);
			match(T__2);
			setState(159);
			((BackquotedContext)_localctx).content = bquote_content();
			setState(160);
			match(T__2);
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class Bquote_contentContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CmdLineParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CmdLineParserParser.NON_KEYWORD, i);
		}
		public List<KeywordContext> keyword() {
			return getRuleContexts(KeywordContext.class);
		}
		public KeywordContext keyword(int i) {
			return getRuleContext(KeywordContext.class,i);
		}
		public List<TerminalNode> WS() { return getTokens(CmdLineParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CmdLineParserParser.WS, i);
		}
		public Bquote_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bquote_content; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitBquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bquote_contentContext bquote_content() throws RecognitionException {
		Bquote_contentContext _localctx = new Bquote_contentContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_bquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(169);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << WS) | (1L << NON_KEYWORD) | (1L << SEMI) | (1L << PIPE) | (1L << GT) | (1L << LT))) != 0)) {
				{
				setState(167);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NON_KEYWORD:
					{
					setState(162);
					match(NON_KEYWORD);
					}
					break;
				case SEMI:
				case PIPE:
				case GT:
				case LT:
					{
					setState(163);
					keyword();
					}
					break;
				case WS:
					{
					setState(164);
					match(WS);
					}
					break;
				case T__1:
					{
					setState(165);
					match(T__1);
					}
					break;
				case T__0:
					{
					setState(166);
					match(T__0);
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(171);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public static class KeywordContext extends ParserRuleContext {
		public TerminalNode SEMI() { return getToken(CmdLineParserParser.SEMI, 0); }
		public TerminalNode PIPE() { return getToken(CmdLineParserParser.PIPE, 0); }
		public TerminalNode GT() { return getToken(CmdLineParserParser.GT, 0); }
		public TerminalNode LT() { return getToken(CmdLineParserParser.LT, 0); }
		public KeywordContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_keyword; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CmdLineParserVisitor ) return ((CmdLineParserVisitor<? extends T>)visitor).visitKeyword(this);
			else return visitor.visitChildren(this);
		}
	}

	public final KeywordContext keyword() throws RecognitionException {
		KeywordContext _localctx = new KeywordContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_keyword);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(172);
			_la = _input.LA(1);
			if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << SEMI) | (1L << PIPE) | (1L << GT) | (1L << LT))) != 0)) ) {
			_errHandler.recoverInline(this);
			}
			else {
				if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
				_errHandler.reportMatch(this);
				consume();
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			exitRule();
		}
		return _localctx;
	}

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 2:
			return pipe_sempred((PipeContext)_localctx, predIndex);
		case 3:
			return seq_sempred((SeqContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean pipe_sempred(PipeContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 1);
		}
		return true;
	}
	private boolean seq_sempred(SeqContext _localctx, int predIndex) {
		switch (predIndex) {
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\13\u00b1\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\5\2)\n\2\3\3\3\3\5\3-\n\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4"+
		"\3\4\7\4\67\n\4\f\4\16\4:\13\4\3\5\3\5\3\5\3\5\3\5\3\5\3\5\3\5\7\5D\n"+
		"\5\f\5\16\5G\13\5\3\6\3\6\3\6\3\6\5\6M\n\6\3\7\3\7\3\7\3\7\3\7\3\7\3\7"+
		"\6\7V\n\7\r\7\16\7W\3\7\3\7\5\7\\\n\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\6\b"+
		"e\n\b\r\b\16\bf\3\b\3\b\5\bk\n\b\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\tt\n\t"+
		"\r\t\16\tu\3\t\3\t\5\tz\n\t\3\n\3\n\3\n\3\n\3\n\6\n\u0081\n\n\r\n\16\n"+
		"\u0082\3\13\3\13\3\13\3\13\3\f\3\f\3\f\3\f\3\f\7\f\u008e\n\f\f\f\16\f"+
		"\u0091\13\f\3\r\3\r\3\r\3\r\3\16\3\16\3\16\3\16\3\16\7\16\u009c\n\16\f"+
		"\16\16\16\u009f\13\16\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\7\20"+
		"\u00aa\n\20\f\20\16\20\u00ad\13\20\3\21\3\21\3\21\2\4\6\b\22\2\4\6\b\n"+
		"\f\16\20\22\24\26\30\32\34\36 \2\3\3\2\b\13\2\u00c1\2(\3\2\2\2\4,\3\2"+
		"\2\2\6.\3\2\2\2\b;\3\2\2\2\nL\3\2\2\2\f[\3\2\2\2\16j\3\2\2\2\20y\3\2\2"+
		"\2\22\u0080\3\2\2\2\24\u0084\3\2\2\2\26\u008f\3\2\2\2\30\u0092\3\2\2\2"+
		"\32\u009d\3\2\2\2\34\u00a0\3\2\2\2\36\u00ab\3\2\2\2 \u00ae\3\2\2\2\"#"+
		"\5\b\5\2#$\7\2\2\3$)\3\2\2\2%&\5\4\3\2&\'\7\2\2\3\')\3\2\2\2(\"\3\2\2"+
		"\2(%\3\2\2\2)\3\3\2\2\2*-\5\6\4\2+-\5\n\6\2,*\3\2\2\2,+\3\2\2\2-\5\3\2"+
		"\2\2./\b\4\1\2/\60\5\n\6\2\60\61\7\t\2\2\61\62\5\n\6\2\628\3\2\2\2\63"+
		"\64\f\3\2\2\64\65\7\t\2\2\65\67\5\n\6\2\66\63\3\2\2\2\67:\3\2\2\28\66"+
		"\3\2\2\289\3\2\2\29\7\3\2\2\2:8\3\2\2\2;<\b\5\1\2<=\5\4\3\2=>\7\b\2\2"+
		">?\5\4\3\2?E\3\2\2\2@A\f\4\2\2AB\7\b\2\2BD\5\4\3\2C@\3\2\2\2DG\3\2\2\2"+
		"EC\3\2\2\2EF\3\2\2\2F\t\3\2\2\2GE\3\2\2\2HM\5\22\n\2IM\5\f\7\2JM\5\16"+
		"\b\2KM\5\20\t\2LH\3\2\2\2LI\3\2\2\2LJ\3\2\2\2LK\3\2\2\2M\13\3\2\2\2NO"+
		"\5\22\n\2OP\7\13\2\2PQ\5\22\n\2Q\\\3\2\2\2RS\7\13\2\2SU\5\22\n\2TV\7\6"+
		"\2\2UT\3\2\2\2VW\3\2\2\2WU\3\2\2\2WX\3\2\2\2XY\3\2\2\2YZ\5\22\n\2Z\\\3"+
		"\2\2\2[N\3\2\2\2[R\3\2\2\2\\\r\3\2\2\2]^\5\22\n\2^_\7\n\2\2_`\5\22\n\2"+
		"`k\3\2\2\2ab\7\n\2\2bd\5\22\n\2ce\7\6\2\2dc\3\2\2\2ef\3\2\2\2fd\3\2\2"+
		"\2fg\3\2\2\2gh\3\2\2\2hi\5\22\n\2ik\3\2\2\2j]\3\2\2\2ja\3\2\2\2k\17\3"+
		"\2\2\2lm\5\f\7\2mn\7\n\2\2no\5\22\n\2oz\3\2\2\2pq\7\n\2\2qs\5\22\n\2r"+
		"t\7\6\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5\f\7\2"+
		"xz\3\2\2\2yl\3\2\2\2yp\3\2\2\2z\21\3\2\2\2{\u0081\7\7\2\2|\u0081\5\24"+
		"\13\2}\u0081\5\30\r\2~\u0081\5\34\17\2\177\u0081\7\6\2\2\u0080{\3\2\2"+
		"\2\u0080|\3\2\2\2\u0080}\3\2\2\2\u0080~\3\2\2\2\u0080\177\3\2\2\2\u0081"+
		"\u0082\3\2\2\2\u0082\u0080\3\2\2\2\u0082\u0083\3\2\2\2\u0083\23\3\2\2"+
		"\2\u0084\u0085\7\3\2\2\u0085\u0086\5\26\f\2\u0086\u0087\7\3\2\2\u0087"+
		"\25\3\2\2\2\u0088\u008e\7\7\2\2\u0089\u008e\5 \21\2\u008a\u008e\7\6\2"+
		"\2\u008b\u008e\7\4\2\2\u008c\u008e\7\5\2\2\u008d\u0088\3\2\2\2\u008d\u0089"+
		"\3\2\2\2\u008d\u008a\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008c\3\2\2\2\u008e"+
		"\u0091\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\27\3\2\2"+
		"\2\u0091\u008f\3\2\2\2\u0092\u0093\7\4\2\2\u0093\u0094\5\32\16\2\u0094"+
		"\u0095\7\4\2\2\u0095\31\3\2\2\2\u0096\u009c\7\7\2\2\u0097\u009c\5 \21"+
		"\2\u0098\u009c\7\6\2\2\u0099\u009c\7\3\2\2\u009a\u009c\5\34\17\2\u009b"+
		"\u0096\3\2\2\2\u009b\u0097\3\2\2\2\u009b\u0098\3\2\2\2\u009b\u0099\3\2"+
		"\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009b\3\2\2\2\u009d"+
		"\u009e\3\2\2\2\u009e\33\3\2\2\2\u009f\u009d\3\2\2\2\u00a0\u00a1\7\5\2"+
		"\2\u00a1\u00a2\5\36\20\2\u00a2\u00a3\7\5\2\2\u00a3\35\3\2\2\2\u00a4\u00aa"+
		"\7\7\2\2\u00a5\u00aa\5 \21\2\u00a6\u00aa\7\6\2\2\u00a7\u00aa\7\4\2\2\u00a8"+
		"\u00aa\7\3\2\2\u00a9\u00a4\3\2\2\2\u00a9\u00a5\3\2\2\2\u00a9\u00a6\3\2"+
		"\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00a8\3\2\2\2\u00aa\u00ad\3\2\2\2\u00ab"+
		"\u00a9\3\2\2\2\u00ab\u00ac\3\2\2\2\u00ac\37\3\2\2\2\u00ad\u00ab\3\2\2"+
		"\2\u00ae\u00af\t\2\2\2\u00af!\3\2\2\2\25(,8ELW[fjuy\u0080\u0082\u008d"+
		"\u008f\u009b\u009d\u00a9\u00ab";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}