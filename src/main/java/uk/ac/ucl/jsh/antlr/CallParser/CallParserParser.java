// Generated from uk/ac/ucl/jsh/antlr/CallParser/CallParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CallParser;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CallParserParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, PWD=4, CD=5, LS=6, CAT=7, ECHO=8, HEAD=9, TAIL=10, 
		GREP=11, SED=12, FIND=13, WC=14, WS=15, NON_KEYWORD=16, QUOTE_CONTENT=17;
	public static final int
		RULE_compileUnit = 0, RULE_pwd = 1, RULE_cd = 2, RULE_ls = 3, RULE_cat = 4, 
		RULE_echo = 5, RULE_head = 6, RULE_tail = 7, RULE_grep = 8, RULE_sed = 9, 
		RULE_find = 10, RULE_wc = 11, RULE_arguments = 12, RULE_argument = 13, 
		RULE_non_keywords = 14, RULE_quoted = 15, RULE_single_quoted = 16, RULE_squote_content = 17, 
		RULE_double_quoted = 18, RULE_dquote_content = 19, RULE_backquoted = 20, 
		RULE_bquote_content = 21;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "pwd", "cd", "ls", "cat", "echo", "head", "tail", "grep", 
			"sed", "find", "wc", "arguments", "argument", "non_keywords", "quoted", 
			"single_quoted", "squote_content", "double_quoted", "dquote_content", 
			"backquoted", "bquote_content"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "'\"'", "'`'", "'pwd'", "'cd'", "'ls'", "'cat'", "'echo'", 
			"'head'", "'tail'", "'grep'", "'sed'", "'find'", "'wc'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "PWD", "CD", "LS", "CAT", "ECHO", "HEAD", "TAIL", 
			"GREP", "SED", "FIND", "WC", "WS", "NON_KEYWORD", "QUOTE_CONTENT"
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
	public String getGrammarFileName() { return "CallParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public CallParserParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class CompileUnitContext extends ParserRuleContext {
		public PwdContext pwd() {
			return getRuleContext(PwdContext.class,0);
		}
		public CdContext cd() {
			return getRuleContext(CdContext.class,0);
		}
		public LsContext ls() {
			return getRuleContext(LsContext.class,0);
		}
		public CatContext cat() {
			return getRuleContext(CatContext.class,0);
		}
		public EchoContext echo() {
			return getRuleContext(EchoContext.class,0);
		}
		public HeadContext head() {
			return getRuleContext(HeadContext.class,0);
		}
		public TailContext tail() {
			return getRuleContext(TailContext.class,0);
		}
		public GrepContext grep() {
			return getRuleContext(GrepContext.class,0);
		}
		public SedContext sed() {
			return getRuleContext(SedContext.class,0);
		}
		public FindContext find() {
			return getRuleContext(FindContext.class,0);
		}
		public WcContext wc() {
			return getRuleContext(WcContext.class,0);
		}
		public CompileUnitContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_compileUnit; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterCompileUnit(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitCompileUnit(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitCompileUnit(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CompileUnitContext compileUnit() throws RecognitionException {
		CompileUnitContext _localctx = new CompileUnitContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_compileUnit);
		try {
			setState(55);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PWD:
				enterOuterAlt(_localctx, 1);
				{
				setState(44);
				pwd();
				}
				break;
			case CD:
				enterOuterAlt(_localctx, 2);
				{
				setState(45);
				cd();
				}
				break;
			case LS:
				enterOuterAlt(_localctx, 3);
				{
				setState(46);
				ls();
				}
				break;
			case CAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(47);
				cat();
				}
				break;
			case ECHO:
				enterOuterAlt(_localctx, 5);
				{
				setState(48);
				echo();
				}
				break;
			case HEAD:
				enterOuterAlt(_localctx, 6);
				{
				setState(49);
				head();
				}
				break;
			case TAIL:
				enterOuterAlt(_localctx, 7);
				{
				setState(50);
				tail();
				}
				break;
			case GREP:
				enterOuterAlt(_localctx, 8);
				{
				setState(51);
				grep();
				}
				break;
			case SED:
				enterOuterAlt(_localctx, 9);
				{
				setState(52);
				sed();
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 10);
				{
				setState(53);
				find();
				}
				break;
			case WC:
				enterOuterAlt(_localctx, 11);
				{
				setState(54);
				wc();
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

	public static class PwdContext extends ParserRuleContext {
		public TerminalNode PWD() { return getToken(CallParserParser.PWD, 0); }
		public PwdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_pwd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterPwd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitPwd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitPwd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final PwdContext pwd() throws RecognitionException {
		PwdContext _localctx = new PwdContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_pwd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(PWD);
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

	public static class CdContext extends ParserRuleContext {
		public TerminalNode CD() { return getToken(CallParserParser.CD, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public CdContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cd; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterCd(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitCd(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitCd(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CdContext cd() throws RecognitionException {
		CdContext _localctx = new CdContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_cd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(59);
			match(CD);
			setState(61); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(60);
				match(WS);
				}
				}
				setState(63); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(65);
			argument();
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

	public static class LsContext extends ParserRuleContext {
		public TerminalNode LS() { return getToken(CallParserParser.LS, 0); }
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public LsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_ls; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterLs(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitLs(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitLs(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LsContext ls() throws RecognitionException {
		LsContext _localctx = new LsContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_ls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(67);
			match(LS);
			setState(74);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(69); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(68);
					match(WS);
					}
					}
					setState(71); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(73);
				argument();
				}
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

	public static class CatContext extends ParserRuleContext {
		public TerminalNode CAT() { return getToken(CallParserParser.CAT, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public CatContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_cat; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterCat(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitCat(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitCat(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CatContext cat() throws RecognitionException {
		CatContext _localctx = new CatContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_cat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(76);
			match(CAT);
			setState(83);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(77);
					match(WS);
					}
					}
					setState(80); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(82);
				arguments();
				}
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

	public static class EchoContext extends ParserRuleContext {
		public TerminalNode ECHO() { return getToken(CallParserParser.ECHO, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public EchoContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_echo; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterEcho(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitEcho(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitEcho(this);
			else return visitor.visitChildren(this);
		}
	}

	public final EchoContext echo() throws RecognitionException {
		EchoContext _localctx = new EchoContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(85);
			match(ECHO);
			setState(87); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(86);
				match(WS);
				}
				}
				setState(89); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(91);
			arguments();
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

	public static class HeadContext extends ParserRuleContext {
		public TerminalNode HEAD() { return getToken(CallParserParser.HEAD, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public HeadContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_head; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterHead(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitHead(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitHead(this);
			else return visitor.visitChildren(this);
		}
	}

	public final HeadContext head() throws RecognitionException {
		HeadContext _localctx = new HeadContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(93);
			match(HEAD);
			setState(100);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(95); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(94);
					match(WS);
					}
					}
					setState(97); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(99);
				arguments();
				}
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

	public static class TailContext extends ParserRuleContext {
		public TerminalNode TAIL() { return getToken(CallParserParser.TAIL, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public TailContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_tail; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterTail(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitTail(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitTail(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TailContext tail() throws RecognitionException {
		TailContext _localctx = new TailContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(102);
			match(TAIL);
			setState(109);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(103);
					match(WS);
					}
					}
					setState(106); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(108);
				arguments();
				}
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

	public static class GrepContext extends ParserRuleContext {
		public TerminalNode GREP() { return getToken(CallParserParser.GREP, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public GrepContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_grep; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterGrep(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitGrep(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitGrep(this);
			else return visitor.visitChildren(this);
		}
	}

	public final GrepContext grep() throws RecognitionException {
		GrepContext _localctx = new GrepContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_grep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(111);
			match(GREP);
			{
			setState(113); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(112);
				match(WS);
				}
				}
				setState(115); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(117);
			arguments();
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

	public static class SedContext extends ParserRuleContext {
		public TerminalNode SED() { return getToken(CallParserParser.SED, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public SedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_sed; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterSed(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitSed(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitSed(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SedContext sed() throws RecognitionException {
		SedContext _localctx = new SedContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_sed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(119);
			match(SED);
			{
			setState(121); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(120);
				match(WS);
				}
				}
				setState(123); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(125);
			arguments();
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

	public static class FindContext extends ParserRuleContext {
		public TerminalNode FIND() { return getToken(CallParserParser.FIND, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public FindContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_find; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterFind(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitFind(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitFind(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FindContext find() throws RecognitionException {
		FindContext _localctx = new FindContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_find);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(127);
			match(FIND);
			{
			setState(129); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(128);
				match(WS);
				}
				}
				setState(131); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(133);
			arguments();
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

	public static class WcContext extends ParserRuleContext {
		public TerminalNode WC() { return getToken(CallParserParser.WC, 0); }
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public WcContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_wc; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterWc(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitWc(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitWc(this);
			else return visitor.visitChildren(this);
		}
	}

	public final WcContext wc() throws RecognitionException {
		WcContext _localctx = new WcContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_wc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(135);
			match(WC);
			setState(142);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==WS) {
				{
				setState(137); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(136);
					match(WS);
					}
					}
					setState(139); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(141);
				arguments();
				}
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

	public static class ArgumentsContext extends ParserRuleContext {
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public ArgumentsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_arguments; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterArguments(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitArguments(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitArguments(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentsContext arguments() throws RecognitionException {
		ArgumentsContext _localctx = new ArgumentsContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_arguments);
		int _la;
		try {
			setState(153);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(144);
				argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(145);
				argument();
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(146);
					match(WS);
					}
					}
					setState(149); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(151);
				arguments();
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

	public static class ArgumentContext extends ParserRuleContext {
		public Non_keywordsContext non_quote;
		public Non_keywordsContext non_keywords() {
			return getRuleContext(Non_keywordsContext.class,0);
		}
		public ArgumentContext argument() {
			return getRuleContext(ArgumentContext.class,0);
		}
		public QuotedContext quoted() {
			return getRuleContext(QuotedContext.class,0);
		}
		public ArgumentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_argument; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterArgument(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitArgument(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitArgument(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ArgumentContext argument() throws RecognitionException {
		ArgumentContext _localctx = new ArgumentContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_argument);
		int _la;
		try {
			setState(163);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(155);
				((ArgumentContext)_localctx).non_quote = non_keywords();
				setState(157);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(156);
					argument();
					}
				}

				}
				break;
			case T__0:
			case T__1:
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(159);
				quoted();
				setState(161);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(160);
					argument();
					}
				}

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

	public static class Non_keywordsContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CallParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CallParserParser.NON_KEYWORD, i);
		}
		public Non_keywordsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_keywords; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterNon_keywords(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitNon_keywords(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitNon_keywords(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_keywordsContext non_keywords() throws RecognitionException {
		Non_keywordsContext _localctx = new Non_keywordsContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_non_keywords);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(166); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(165);
					match(NON_KEYWORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(168); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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

	public static class QuotedContext extends ParserRuleContext {
		public Single_quotedContext single_quoted() {
			return getRuleContext(Single_quotedContext.class,0);
		}
		public Double_quotedContext double_quoted() {
			return getRuleContext(Double_quotedContext.class,0);
		}
		public BackquotedContext backquoted() {
			return getRuleContext(BackquotedContext.class,0);
		}
		public QuotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_quoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterQuoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitQuoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitQuoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final QuotedContext quoted() throws RecognitionException {
		QuotedContext _localctx = new QuotedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_quoted);
		try {
			setState(173);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				single_quoted();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(171);
				double_quoted();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(172);
				backquoted();
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

	public static class Single_quotedContext extends ParserRuleContext {
		public Squote_contentContext content;
		public Squote_contentContext squote_content() {
			return getRuleContext(Squote_contentContext.class,0);
		}
		public Single_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_single_quoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterSingle_quoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitSingle_quoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitSingle_quoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Single_quotedContext single_quoted() throws RecognitionException {
		Single_quotedContext _localctx = new Single_quotedContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_single_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			match(T__0);
			setState(176);
			((Single_quotedContext)_localctx).content = squote_content();
			setState(177);
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
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CallParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CallParserParser.NON_KEYWORD, i);
		}
		public List<TerminalNode> QUOTE_CONTENT() { return getTokens(CallParserParser.QUOTE_CONTENT); }
		public TerminalNode QUOTE_CONTENT(int i) {
			return getToken(CallParserParser.QUOTE_CONTENT, i);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public Squote_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_squote_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterSquote_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitSquote_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitSquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Squote_contentContext squote_content() throws RecognitionException {
		Squote_contentContext _localctx = new Squote_contentContext(_ctx, getState());
		enterRule(_localctx, 34, RULE_squote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(182);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(179);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(184);
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
		public Dquote_contentContext content;
		public Dquote_contentContext dquote_content() {
			return getRuleContext(Dquote_contentContext.class,0);
		}
		public Double_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_double_quoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterDouble_quoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitDouble_quoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitDouble_quoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Double_quotedContext double_quoted() throws RecognitionException {
		Double_quotedContext _localctx = new Double_quotedContext(_ctx, getState());
		enterRule(_localctx, 36, RULE_double_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(185);
			match(T__1);
			setState(186);
			((Double_quotedContext)_localctx).content = dquote_content();
			setState(187);
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
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CallParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CallParserParser.NON_KEYWORD, i);
		}
		public List<TerminalNode> QUOTE_CONTENT() { return getTokens(CallParserParser.QUOTE_CONTENT); }
		public TerminalNode QUOTE_CONTENT(int i) {
			return getToken(CallParserParser.QUOTE_CONTENT, i);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterDquote_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitDquote_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitDquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Dquote_contentContext dquote_content() throws RecognitionException {
		Dquote_contentContext _localctx = new Dquote_contentContext(_ctx, getState());
		enterRule(_localctx, 38, RULE_dquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(196);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				setState(194);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NON_KEYWORD:
					{
					setState(189);
					match(NON_KEYWORD);
					}
					break;
				case QUOTE_CONTENT:
					{
					setState(190);
					match(QUOTE_CONTENT);
					}
					break;
				case WS:
					{
					setState(191);
					match(WS);
					}
					break;
				case T__0:
					{
					setState(192);
					match(T__0);
					}
					break;
				case T__2:
					{
					setState(193);
					backquoted();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(198);
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
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterBackquoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitBackquoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitBackquoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BackquotedContext backquoted() throws RecognitionException {
		BackquotedContext _localctx = new BackquotedContext(_ctx, getState());
		enterRule(_localctx, 40, RULE_backquoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(199);
			match(T__2);
			setState(200);
			((BackquotedContext)_localctx).content = bquote_content();
			setState(201);
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
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CallParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CallParserParser.NON_KEYWORD, i);
		}
		public List<TerminalNode> QUOTE_CONTENT() { return getTokens(CallParserParser.QUOTE_CONTENT); }
		public TerminalNode QUOTE_CONTENT(int i) {
			return getToken(CallParserParser.QUOTE_CONTENT, i);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
		}
		public Bquote_contentContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_bquote_content; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterBquote_content(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitBquote_content(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitBquote_content(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Bquote_contentContext bquote_content() throws RecognitionException {
		Bquote_contentContext _localctx = new Bquote_contentContext(_ctx, getState());
		enterRule(_localctx, 42, RULE_bquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(206);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(203);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) ) {
				_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				}
				}
				setState(208);
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

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u00d4\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\3\2\3\2\3\2\3\2\3\2"+
		"\3\2\3\2\3\2\3\2\3\2\3\2\5\2:\n\2\3\3\3\3\3\4\3\4\6\4@\n\4\r\4\16\4A\3"+
		"\4\3\4\3\5\3\5\6\5H\n\5\r\5\16\5I\3\5\5\5M\n\5\3\6\3\6\6\6Q\n\6\r\6\16"+
		"\6R\3\6\5\6V\n\6\3\7\3\7\6\7Z\n\7\r\7\16\7[\3\7\3\7\3\b\3\b\6\bb\n\b\r"+
		"\b\16\bc\3\b\5\bg\n\b\3\t\3\t\6\tk\n\t\r\t\16\tl\3\t\5\tp\n\t\3\n\3\n"+
		"\6\nt\n\n\r\n\16\nu\3\n\3\n\3\13\3\13\6\13|\n\13\r\13\16\13}\3\13\3\13"+
		"\3\f\3\f\6\f\u0084\n\f\r\f\16\f\u0085\3\f\3\f\3\r\3\r\6\r\u008c\n\r\r"+
		"\r\16\r\u008d\3\r\5\r\u0091\n\r\3\16\3\16\3\16\6\16\u0096\n\16\r\16\16"+
		"\16\u0097\3\16\3\16\5\16\u009c\n\16\3\17\3\17\5\17\u00a0\n\17\3\17\3\17"+
		"\5\17\u00a4\n\17\5\17\u00a6\n\17\3\20\6\20\u00a9\n\20\r\20\16\20\u00aa"+
		"\3\21\3\21\3\21\5\21\u00b0\n\21\3\22\3\22\3\22\3\22\3\23\7\23\u00b7\n"+
		"\23\f\23\16\23\u00ba\13\23\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25"+
		"\7\25\u00c5\n\25\f\25\16\25\u00c8\13\25\3\26\3\26\3\26\3\26\3\27\7\27"+
		"\u00cf\n\27\f\27\16\27\u00d2\13\27\3\27\2\2\30\2\4\6\b\n\f\16\20\22\24"+
		"\26\30\32\34\36 \"$&(*,\2\4\4\2\4\5\21\23\4\2\3\4\21\23\2\u00e5\29\3\2"+
		"\2\2\4;\3\2\2\2\6=\3\2\2\2\bE\3\2\2\2\nN\3\2\2\2\fW\3\2\2\2\16_\3\2\2"+
		"\2\20h\3\2\2\2\22q\3\2\2\2\24y\3\2\2\2\26\u0081\3\2\2\2\30\u0089\3\2\2"+
		"\2\32\u009b\3\2\2\2\34\u00a5\3\2\2\2\36\u00a8\3\2\2\2 \u00af\3\2\2\2\""+
		"\u00b1\3\2\2\2$\u00b8\3\2\2\2&\u00bb\3\2\2\2(\u00c6\3\2\2\2*\u00c9\3\2"+
		"\2\2,\u00d0\3\2\2\2.:\5\4\3\2/:\5\6\4\2\60:\5\b\5\2\61:\5\n\6\2\62:\5"+
		"\f\7\2\63:\5\16\b\2\64:\5\20\t\2\65:\5\22\n\2\66:\5\24\13\2\67:\5\26\f"+
		"\28:\5\30\r\29.\3\2\2\29/\3\2\2\29\60\3\2\2\29\61\3\2\2\29\62\3\2\2\2"+
		"9\63\3\2\2\29\64\3\2\2\29\65\3\2\2\29\66\3\2\2\29\67\3\2\2\298\3\2\2\2"+
		":\3\3\2\2\2;<\7\6\2\2<\5\3\2\2\2=?\7\7\2\2>@\7\21\2\2?>\3\2\2\2@A\3\2"+
		"\2\2A?\3\2\2\2AB\3\2\2\2BC\3\2\2\2CD\5\34\17\2D\7\3\2\2\2EL\7\b\2\2FH"+
		"\7\21\2\2GF\3\2\2\2HI\3\2\2\2IG\3\2\2\2IJ\3\2\2\2JK\3\2\2\2KM\5\34\17"+
		"\2LG\3\2\2\2LM\3\2\2\2M\t\3\2\2\2NU\7\t\2\2OQ\7\21\2\2PO\3\2\2\2QR\3\2"+
		"\2\2RP\3\2\2\2RS\3\2\2\2ST\3\2\2\2TV\5\32\16\2UP\3\2\2\2UV\3\2\2\2V\13"+
		"\3\2\2\2WY\7\n\2\2XZ\7\21\2\2YX\3\2\2\2Z[\3\2\2\2[Y\3\2\2\2[\\\3\2\2\2"+
		"\\]\3\2\2\2]^\5\32\16\2^\r\3\2\2\2_f\7\13\2\2`b\7\21\2\2a`\3\2\2\2bc\3"+
		"\2\2\2ca\3\2\2\2cd\3\2\2\2de\3\2\2\2eg\5\32\16\2fa\3\2\2\2fg\3\2\2\2g"+
		"\17\3\2\2\2ho\7\f\2\2ik\7\21\2\2ji\3\2\2\2kl\3\2\2\2lj\3\2\2\2lm\3\2\2"+
		"\2mn\3\2\2\2np\5\32\16\2oj\3\2\2\2op\3\2\2\2p\21\3\2\2\2qs\7\r\2\2rt\7"+
		"\21\2\2sr\3\2\2\2tu\3\2\2\2us\3\2\2\2uv\3\2\2\2vw\3\2\2\2wx\5\32\16\2"+
		"x\23\3\2\2\2y{\7\16\2\2z|\7\21\2\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2"+
		"\2\2~\177\3\2\2\2\177\u0080\5\32\16\2\u0080\25\3\2\2\2\u0081\u0083\7\17"+
		"\2\2\u0082\u0084\7\21\2\2\u0083\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085"+
		"\u0083\3\2\2\2\u0085\u0086\3\2\2\2\u0086\u0087\3\2\2\2\u0087\u0088\5\32"+
		"\16\2\u0088\27\3\2\2\2\u0089\u0090\7\20\2\2\u008a\u008c\7\21\2\2\u008b"+
		"\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d\u008e\3\2"+
		"\2\2\u008e\u008f\3\2\2\2\u008f\u0091\5\32\16\2\u0090\u008b\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\31\3\2\2\2\u0092\u009c\5\34\17\2\u0093\u0095\5\34"+
		"\17\2\u0094\u0096\7\21\2\2\u0095\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097"+
		"\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u009a\5\32"+
		"\16\2\u009a\u009c\3\2\2\2\u009b\u0092\3\2\2\2\u009b\u0093\3\2\2\2\u009c"+
		"\33\3\2\2\2\u009d\u009f\5\36\20\2\u009e\u00a0\5\34\17\2\u009f\u009e\3"+
		"\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a6\3\2\2\2\u00a1\u00a3\5 \21\2\u00a2"+
		"\u00a4\5\34\17\2\u00a3\u00a2\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a6\3"+
		"\2\2\2\u00a5\u009d\3\2\2\2\u00a5\u00a1\3\2\2\2\u00a6\35\3\2\2\2\u00a7"+
		"\u00a9\7\22\2\2\u00a8\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00a8\3"+
		"\2\2\2\u00aa\u00ab\3\2\2\2\u00ab\37\3\2\2\2\u00ac\u00b0\5\"\22\2\u00ad"+
		"\u00b0\5&\24\2\u00ae\u00b0\5*\26\2\u00af\u00ac\3\2\2\2\u00af\u00ad\3\2"+
		"\2\2\u00af\u00ae\3\2\2\2\u00b0!\3\2\2\2\u00b1\u00b2\7\3\2\2\u00b2\u00b3"+
		"\5$\23\2\u00b3\u00b4\7\3\2\2\u00b4#\3\2\2\2\u00b5\u00b7\t\2\2\2\u00b6"+
		"\u00b5\3\2\2\2\u00b7\u00ba\3\2\2\2\u00b8\u00b6\3\2\2\2\u00b8\u00b9\3\2"+
		"\2\2\u00b9%\3\2\2\2\u00ba\u00b8\3\2\2\2\u00bb\u00bc\7\4\2\2\u00bc\u00bd"+
		"\5(\25\2\u00bd\u00be\7\4\2\2\u00be\'\3\2\2\2\u00bf\u00c5\7\22\2\2\u00c0"+
		"\u00c5\7\23\2\2\u00c1\u00c5\7\21\2\2\u00c2\u00c5\7\3\2\2\u00c3\u00c5\5"+
		"*\26\2\u00c4\u00bf\3\2\2\2\u00c4\u00c0\3\2\2\2\u00c4\u00c1\3\2\2\2\u00c4"+
		"\u00c2\3\2\2\2\u00c4\u00c3\3\2\2\2\u00c5\u00c8\3\2\2\2\u00c6\u00c4\3\2"+
		"\2\2\u00c6\u00c7\3\2\2\2\u00c7)\3\2\2\2\u00c8\u00c6\3\2\2\2\u00c9\u00ca"+
		"\7\5\2\2\u00ca\u00cb\5,\27\2\u00cb\u00cc\7\5\2\2\u00cc+\3\2\2\2\u00cd"+
		"\u00cf\t\3\2\2\u00ce\u00cd\3\2\2\2\u00cf\u00d2\3\2\2\2\u00d0\u00ce\3\2"+
		"\2\2\u00d0\u00d1\3\2\2\2\u00d1-\3\2\2\2\u00d2\u00d0\3\2\2\2\359AILRU["+
		"cflou}\u0085\u008d\u0090\u0097\u009b\u009f\u00a3\u00a5\u00aa\u00af\u00b8"+
		"\u00c4\u00c6\u00d0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}