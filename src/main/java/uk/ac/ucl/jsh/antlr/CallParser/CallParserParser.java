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
		RULE_compileUnit = 0, RULE_application = 1, RULE_pwd = 2, RULE_cd = 3, 
		RULE_ls = 4, RULE_cat = 5, RULE_echo = 6, RULE_head = 7, RULE_tail = 8, 
		RULE_grep = 9, RULE_sed = 10, RULE_find = 11, RULE_wc = 12, RULE_arguments = 13, 
		RULE_argument = 14, RULE_non_quoted = 15, RULE_quoted = 16, RULE_single_quoted = 17, 
		RULE_squote_content = 18, RULE_double_quoted = 19, RULE_dquote_content = 20, 
		RULE_backquoted = 21, RULE_bquote_content = 22;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "application", "pwd", "cd", "ls", "cat", "echo", "head", 
			"tail", "grep", "sed", "find", "wc", "arguments", "argument", "non_quoted", 
			"quoted", "single_quoted", "squote_content", "double_quoted", "dquote_content", 
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
		public ApplicationContext application() {
			return getRuleContext(ApplicationContext.class,0);
		}
		public List<TerminalNode> WS() { return getTokens(CallParserParser.WS); }
		public TerminalNode WS(int i) {
			return getToken(CallParserParser.WS, i);
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
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(49);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(46);
				match(WS);
				}
				}
				setState(51);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(52);
			application();
			setState(56);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(53);
				match(WS);
				}
				}
				setState(58);
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

	public static class ApplicationContext extends ParserRuleContext {
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
		public ApplicationContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_application; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterApplication(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitApplication(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitApplication(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ApplicationContext application() throws RecognitionException {
		ApplicationContext _localctx = new ApplicationContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_application);
		try {
			setState(70);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PWD:
				enterOuterAlt(_localctx, 1);
				{
				setState(59);
				pwd();
				}
				break;
			case CD:
				enterOuterAlt(_localctx, 2);
				{
				setState(60);
				cd();
				}
				break;
			case LS:
				enterOuterAlt(_localctx, 3);
				{
				setState(61);
				ls();
				}
				break;
			case CAT:
				enterOuterAlt(_localctx, 4);
				{
				setState(62);
				cat();
				}
				break;
			case ECHO:
				enterOuterAlt(_localctx, 5);
				{
				setState(63);
				echo();
				}
				break;
			case HEAD:
				enterOuterAlt(_localctx, 6);
				{
				setState(64);
				head();
				}
				break;
			case TAIL:
				enterOuterAlt(_localctx, 7);
				{
				setState(65);
				tail();
				}
				break;
			case GREP:
				enterOuterAlt(_localctx, 8);
				{
				setState(66);
				grep();
				}
				break;
			case SED:
				enterOuterAlt(_localctx, 9);
				{
				setState(67);
				sed();
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 10);
				{
				setState(68);
				find();
				}
				break;
			case WC:
				enterOuterAlt(_localctx, 11);
				{
				setState(69);
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
		enterRule(_localctx, 4, RULE_pwd);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
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
		enterRule(_localctx, 6, RULE_cd);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(74);
			match(CD);
			setState(76); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(75);
				match(WS);
				}
				}
				setState(78); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(80);
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
		enterRule(_localctx, 8, RULE_ls);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(82);
			match(LS);
			setState(89);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,5,_ctx) ) {
			case 1:
				{
				setState(84); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(83);
					match(WS);
					}
					}
					setState(86); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(88);
				argument();
				}
				break;
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
		enterRule(_localctx, 10, RULE_cat);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(CAT);
			setState(98);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,7,_ctx) ) {
			case 1:
				{
				setState(93); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(92);
					match(WS);
					}
					}
					setState(95); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(97);
				arguments();
				}
				break;
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
		enterRule(_localctx, 12, RULE_echo);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(100);
			match(ECHO);
			setState(102); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(101);
				match(WS);
				}
				}
				setState(104); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(106);
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
		enterRule(_localctx, 14, RULE_head);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(108);
			match(HEAD);
			setState(115);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
			case 1:
				{
				setState(110); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(109);
					match(WS);
					}
					}
					setState(112); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(114);
				arguments();
				}
				break;
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
		enterRule(_localctx, 16, RULE_tail);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(117);
			match(TAIL);
			setState(124);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
			case 1:
				{
				setState(119); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(118);
					match(WS);
					}
					}
					setState(121); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(123);
				arguments();
				}
				break;
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
		enterRule(_localctx, 18, RULE_grep);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(126);
			match(GREP);
			{
			setState(128); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(127);
				match(WS);
				}
				}
				setState(130); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(132);
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
		enterRule(_localctx, 20, RULE_sed);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(134);
			match(SED);
			{
			setState(136); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(135);
				match(WS);
				}
				}
				setState(138); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(140);
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
		enterRule(_localctx, 22, RULE_find);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(142);
			match(FIND);
			{
			setState(144); 
			_errHandler.sync(this);
			_la = _input.LA(1);
			do {
				{
				{
				setState(143);
				match(WS);
				}
				}
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
			} while ( _la==WS );
			setState(148);
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
		enterRule(_localctx, 24, RULE_wc);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(150);
			match(WC);
			setState(157);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
			case 1:
				{
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					match(WS);
					}
					}
					setState(154); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(156);
				arguments();
				}
				break;
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
		enterRule(_localctx, 26, RULE_arguments);
		int _la;
		try {
			setState(168);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(159);
				argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(160);
				argument();
				setState(162); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(161);
					match(WS);
					}
					}
					setState(164); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(166);
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
		public Non_quotedContext non_quote;
		public Non_quotedContext non_quoted() {
			return getRuleContext(Non_quotedContext.class,0);
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
		enterRule(_localctx, 28, RULE_argument);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case PWD:
			case CD:
			case LS:
			case CAT:
			case ECHO:
			case HEAD:
			case TAIL:
			case GREP:
			case SED:
			case FIND:
			case WC:
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(170);
				((ArgumentContext)_localctx).non_quote = non_quoted();
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << PWD) | (1L << CD) | (1L << LS) | (1L << CAT) | (1L << ECHO) | (1L << HEAD) | (1L << TAIL) | (1L << GREP) | (1L << SED) | (1L << FIND) | (1L << WC) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(171);
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
				setState(174);
				quoted();
				setState(176);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << PWD) | (1L << CD) | (1L << LS) | (1L << CAT) | (1L << ECHO) | (1L << HEAD) | (1L << TAIL) | (1L << GREP) | (1L << SED) | (1L << FIND) | (1L << WC) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(175);
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

	public static class Non_quotedContext extends ParserRuleContext {
		public List<TerminalNode> NON_KEYWORD() { return getTokens(CallParserParser.NON_KEYWORD); }
		public TerminalNode NON_KEYWORD(int i) {
			return getToken(CallParserParser.NON_KEYWORD, i);
		}
		public TerminalNode PWD() { return getToken(CallParserParser.PWD, 0); }
		public TerminalNode CD() { return getToken(CallParserParser.CD, 0); }
		public TerminalNode LS() { return getToken(CallParserParser.LS, 0); }
		public TerminalNode CAT() { return getToken(CallParserParser.CAT, 0); }
		public TerminalNode ECHO() { return getToken(CallParserParser.ECHO, 0); }
		public TerminalNode HEAD() { return getToken(CallParserParser.HEAD, 0); }
		public TerminalNode TAIL() { return getToken(CallParserParser.TAIL, 0); }
		public TerminalNode GREP() { return getToken(CallParserParser.GREP, 0); }
		public TerminalNode SED() { return getToken(CallParserParser.SED, 0); }
		public TerminalNode FIND() { return getToken(CallParserParser.FIND, 0); }
		public TerminalNode WC() { return getToken(CallParserParser.WC, 0); }
		public Non_quotedContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_non_quoted; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).enterNon_quoted(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof CallParserListener ) ((CallParserListener)listener).exitNon_quoted(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof CallParserVisitor ) return ((CallParserVisitor<? extends T>)visitor).visitNon_quoted(this);
			else return visitor.visitChildren(this);
		}
	}

	public final Non_quotedContext non_quoted() throws RecognitionException {
		Non_quotedContext _localctx = new Non_quotedContext(_ctx, getState());
		enterRule(_localctx, 30, RULE_non_quoted);
		try {
			int _alt;
			setState(196);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(181); 
				_errHandler.sync(this);
				_alt = 1;
				do {
					switch (_alt) {
					case 1:
						{
						{
						setState(180);
						match(NON_KEYWORD);
						}
						}
						break;
					default:
						throw new NoViableAltException(this);
					}
					setState(183); 
					_errHandler.sync(this);
					_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
				} while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER );
				}
				break;
			case PWD:
				enterOuterAlt(_localctx, 2);
				{
				setState(185);
				match(PWD);
				}
				break;
			case CD:
				enterOuterAlt(_localctx, 3);
				{
				setState(186);
				match(CD);
				}
				break;
			case LS:
				enterOuterAlt(_localctx, 4);
				{
				setState(187);
				match(LS);
				}
				break;
			case CAT:
				enterOuterAlt(_localctx, 5);
				{
				setState(188);
				match(CAT);
				}
				break;
			case ECHO:
				enterOuterAlt(_localctx, 6);
				{
				setState(189);
				match(ECHO);
				}
				break;
			case HEAD:
				enterOuterAlt(_localctx, 7);
				{
				setState(190);
				match(HEAD);
				}
				break;
			case TAIL:
				enterOuterAlt(_localctx, 8);
				{
				setState(191);
				match(TAIL);
				}
				break;
			case GREP:
				enterOuterAlt(_localctx, 9);
				{
				setState(192);
				match(GREP);
				}
				break;
			case SED:
				enterOuterAlt(_localctx, 10);
				{
				setState(193);
				match(SED);
				}
				break;
			case FIND:
				enterOuterAlt(_localctx, 11);
				{
				setState(194);
				match(FIND);
				}
				break;
			case WC:
				enterOuterAlt(_localctx, 12);
				{
				setState(195);
				match(WC);
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
		enterRule(_localctx, 32, RULE_quoted);
		try {
			setState(201);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(198);
				single_quoted();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(199);
				double_quoted();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(200);
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
		enterRule(_localctx, 34, RULE_single_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(203);
			match(T__0);
			setState(204);
			((Single_quotedContext)_localctx).content = squote_content();
			setState(205);
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
		enterRule(_localctx, 36, RULE_squote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(210);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(207);
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
				setState(212);
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
		enterRule(_localctx, 38, RULE_double_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(213);
			match(T__1);
			setState(214);
			((Double_quotedContext)_localctx).content = dquote_content();
			setState(215);
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
		enterRule(_localctx, 40, RULE_dquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(224);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				setState(222);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case NON_KEYWORD:
					{
					setState(217);
					match(NON_KEYWORD);
					}
					break;
				case QUOTE_CONTENT:
					{
					setState(218);
					match(QUOTE_CONTENT);
					}
					break;
				case WS:
					{
					setState(219);
					match(WS);
					}
					break;
				case T__0:
					{
					setState(220);
					match(T__0);
					}
					break;
				case T__2:
					{
					setState(221);
					backquoted();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(226);
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
		enterRule(_localctx, 42, RULE_backquoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(227);
			match(T__2);
			setState(228);
			((BackquotedContext)_localctx).content = bquote_content();
			setState(229);
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
		enterRule(_localctx, 44, RULE_bquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(234);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(231);
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
				setState(236);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\23\u00f0\4\2\t\2"+
		"\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\3\2\7\2\62"+
		"\n\2\f\2\16\2\65\13\2\3\2\3\2\7\29\n\2\f\2\16\2<\13\2\3\3\3\3\3\3\3\3"+
		"\3\3\3\3\3\3\3\3\3\3\3\3\3\3\5\3I\n\3\3\4\3\4\3\5\3\5\6\5O\n\5\r\5\16"+
		"\5P\3\5\3\5\3\6\3\6\6\6W\n\6\r\6\16\6X\3\6\5\6\\\n\6\3\7\3\7\6\7`\n\7"+
		"\r\7\16\7a\3\7\5\7e\n\7\3\b\3\b\6\bi\n\b\r\b\16\bj\3\b\3\b\3\t\3\t\6\t"+
		"q\n\t\r\t\16\tr\3\t\5\tv\n\t\3\n\3\n\6\nz\n\n\r\n\16\n{\3\n\5\n\177\n"+
		"\n\3\13\3\13\6\13\u0083\n\13\r\13\16\13\u0084\3\13\3\13\3\f\3\f\6\f\u008b"+
		"\n\f\r\f\16\f\u008c\3\f\3\f\3\r\3\r\6\r\u0093\n\r\r\r\16\r\u0094\3\r\3"+
		"\r\3\16\3\16\6\16\u009b\n\16\r\16\16\16\u009c\3\16\5\16\u00a0\n\16\3\17"+
		"\3\17\3\17\6\17\u00a5\n\17\r\17\16\17\u00a6\3\17\3\17\5\17\u00ab\n\17"+
		"\3\20\3\20\5\20\u00af\n\20\3\20\3\20\5\20\u00b3\n\20\5\20\u00b5\n\20\3"+
		"\21\6\21\u00b8\n\21\r\21\16\21\u00b9\3\21\3\21\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\5\21\u00c7\n\21\3\22\3\22\3\22\5\22\u00cc\n\22\3"+
		"\23\3\23\3\23\3\23\3\24\7\24\u00d3\n\24\f\24\16\24\u00d6\13\24\3\25\3"+
		"\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\7\26\u00e1\n\26\f\26\16\26\u00e4"+
		"\13\26\3\27\3\27\3\27\3\27\3\30\7\30\u00eb\n\30\f\30\16\30\u00ee\13\30"+
		"\3\30\2\2\31\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$&(*,.\2\4\4\2\4"+
		"\5\21\23\4\2\3\4\21\23\2\u010d\2\63\3\2\2\2\4H\3\2\2\2\6J\3\2\2\2\bL\3"+
		"\2\2\2\nT\3\2\2\2\f]\3\2\2\2\16f\3\2\2\2\20n\3\2\2\2\22w\3\2\2\2\24\u0080"+
		"\3\2\2\2\26\u0088\3\2\2\2\30\u0090\3\2\2\2\32\u0098\3\2\2\2\34\u00aa\3"+
		"\2\2\2\36\u00b4\3\2\2\2 \u00c6\3\2\2\2\"\u00cb\3\2\2\2$\u00cd\3\2\2\2"+
		"&\u00d4\3\2\2\2(\u00d7\3\2\2\2*\u00e2\3\2\2\2,\u00e5\3\2\2\2.\u00ec\3"+
		"\2\2\2\60\62\7\21\2\2\61\60\3\2\2\2\62\65\3\2\2\2\63\61\3\2\2\2\63\64"+
		"\3\2\2\2\64\66\3\2\2\2\65\63\3\2\2\2\66:\5\4\3\2\679\7\21\2\28\67\3\2"+
		"\2\29<\3\2\2\2:8\3\2\2\2:;\3\2\2\2;\3\3\2\2\2<:\3\2\2\2=I\5\6\4\2>I\5"+
		"\b\5\2?I\5\n\6\2@I\5\f\7\2AI\5\16\b\2BI\5\20\t\2CI\5\22\n\2DI\5\24\13"+
		"\2EI\5\26\f\2FI\5\30\r\2GI\5\32\16\2H=\3\2\2\2H>\3\2\2\2H?\3\2\2\2H@\3"+
		"\2\2\2HA\3\2\2\2HB\3\2\2\2HC\3\2\2\2HD\3\2\2\2HE\3\2\2\2HF\3\2\2\2HG\3"+
		"\2\2\2I\5\3\2\2\2JK\7\6\2\2K\7\3\2\2\2LN\7\7\2\2MO\7\21\2\2NM\3\2\2\2"+
		"OP\3\2\2\2PN\3\2\2\2PQ\3\2\2\2QR\3\2\2\2RS\5\36\20\2S\t\3\2\2\2T[\7\b"+
		"\2\2UW\7\21\2\2VU\3\2\2\2WX\3\2\2\2XV\3\2\2\2XY\3\2\2\2YZ\3\2\2\2Z\\\5"+
		"\36\20\2[V\3\2\2\2[\\\3\2\2\2\\\13\3\2\2\2]d\7\t\2\2^`\7\21\2\2_^\3\2"+
		"\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2bc\3\2\2\2ce\5\34\17\2d_\3\2\2\2de\3"+
		"\2\2\2e\r\3\2\2\2fh\7\n\2\2gi\7\21\2\2hg\3\2\2\2ij\3\2\2\2jh\3\2\2\2j"+
		"k\3\2\2\2kl\3\2\2\2lm\5\34\17\2m\17\3\2\2\2nu\7\13\2\2oq\7\21\2\2po\3"+
		"\2\2\2qr\3\2\2\2rp\3\2\2\2rs\3\2\2\2st\3\2\2\2tv\5\34\17\2up\3\2\2\2u"+
		"v\3\2\2\2v\21\3\2\2\2w~\7\f\2\2xz\7\21\2\2yx\3\2\2\2z{\3\2\2\2{y\3\2\2"+
		"\2{|\3\2\2\2|}\3\2\2\2}\177\5\34\17\2~y\3\2\2\2~\177\3\2\2\2\177\23\3"+
		"\2\2\2\u0080\u0082\7\r\2\2\u0081\u0083\7\21\2\2\u0082\u0081\3\2\2\2\u0083"+
		"\u0084\3\2\2\2\u0084\u0082\3\2\2\2\u0084\u0085\3\2\2\2\u0085\u0086\3\2"+
		"\2\2\u0086\u0087\5\34\17\2\u0087\25\3\2\2\2\u0088\u008a\7\16\2\2\u0089"+
		"\u008b\7\21\2\2\u008a\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008a\3"+
		"\2\2\2\u008c\u008d\3\2\2\2\u008d\u008e\3\2\2\2\u008e\u008f\5\34\17\2\u008f"+
		"\27\3\2\2\2\u0090\u0092\7\17\2\2\u0091\u0093\7\21\2\2\u0092\u0091\3\2"+
		"\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0097\5\34\17\2\u0097\31\3\2\2\2\u0098\u009f\7\20"+
		"\2\2\u0099\u009b\7\21\2\2\u009a\u0099\3\2\2\2\u009b\u009c\3\2\2\2\u009c"+
		"\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009e\3\2\2\2\u009e\u00a0\5\34"+
		"\17\2\u009f\u009a\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\33\3\2\2\2\u00a1\u00ab"+
		"\5\36\20\2\u00a2\u00a4\5\36\20\2\u00a3\u00a5\7\21\2\2\u00a4\u00a3\3\2"+
		"\2\2\u00a5\u00a6\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a6\u00a7\3\2\2\2\u00a7"+
		"\u00a8\3\2\2\2\u00a8\u00a9\5\34\17\2\u00a9\u00ab\3\2\2\2\u00aa\u00a1\3"+
		"\2\2\2\u00aa\u00a2\3\2\2\2\u00ab\35\3\2\2\2\u00ac\u00ae\5 \21\2\u00ad"+
		"\u00af\5\36\20\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b5\3"+
		"\2\2\2\u00b0\u00b2\5\"\22\2\u00b1\u00b3\5\36\20\2\u00b2\u00b1\3\2\2\2"+
		"\u00b2\u00b3\3\2\2\2\u00b3\u00b5\3\2\2\2\u00b4\u00ac\3\2\2\2\u00b4\u00b0"+
		"\3\2\2\2\u00b5\37\3\2\2\2\u00b6\u00b8\7\22\2\2\u00b7\u00b6\3\2\2\2\u00b8"+
		"\u00b9\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00c7\3\2"+
		"\2\2\u00bb\u00c7\7\6\2\2\u00bc\u00c7\7\7\2\2\u00bd\u00c7\7\b\2\2\u00be"+
		"\u00c7\7\t\2\2\u00bf\u00c7\7\n\2\2\u00c0\u00c7\7\13\2\2\u00c1\u00c7\7"+
		"\f\2\2\u00c2\u00c7\7\r\2\2\u00c3\u00c7\7\16\2\2\u00c4\u00c7\7\17\2\2\u00c5"+
		"\u00c7\7\20\2\2\u00c6\u00b7\3\2\2\2\u00c6\u00bb\3\2\2\2\u00c6\u00bc\3"+
		"\2\2\2\u00c6\u00bd\3\2\2\2\u00c6\u00be\3\2\2\2\u00c6\u00bf\3\2\2\2\u00c6"+
		"\u00c0\3\2\2\2\u00c6\u00c1\3\2\2\2\u00c6\u00c2\3\2\2\2\u00c6\u00c3\3\2"+
		"\2\2\u00c6\u00c4\3\2\2\2\u00c6\u00c5\3\2\2\2\u00c7!\3\2\2\2\u00c8\u00cc"+
		"\5$\23\2\u00c9\u00cc\5(\25\2\u00ca\u00cc\5,\27\2\u00cb\u00c8\3\2\2\2\u00cb"+
		"\u00c9\3\2\2\2\u00cb\u00ca\3\2\2\2\u00cc#\3\2\2\2\u00cd\u00ce\7\3\2\2"+
		"\u00ce\u00cf\5&\24\2\u00cf\u00d0\7\3\2\2\u00d0%\3\2\2\2\u00d1\u00d3\t"+
		"\2\2\2\u00d2\u00d1\3\2\2\2\u00d3\u00d6\3\2\2\2\u00d4\u00d2\3\2\2\2\u00d4"+
		"\u00d5\3\2\2\2\u00d5\'\3\2\2\2\u00d6\u00d4\3\2\2\2\u00d7\u00d8\7\4\2\2"+
		"\u00d8\u00d9\5*\26\2\u00d9\u00da\7\4\2\2\u00da)\3\2\2\2\u00db\u00e1\7"+
		"\22\2\2\u00dc\u00e1\7\23\2\2\u00dd\u00e1\7\21\2\2\u00de\u00e1\7\3\2\2"+
		"\u00df\u00e1\5,\27\2\u00e0\u00db\3\2\2\2\u00e0\u00dc\3\2\2\2\u00e0\u00dd"+
		"\3\2\2\2\u00e0\u00de\3\2\2\2\u00e0\u00df\3\2\2\2\u00e1\u00e4\3\2\2\2\u00e2"+
		"\u00e0\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3+\3\2\2\2\u00e4\u00e2\3\2\2\2"+
		"\u00e5\u00e6\7\5\2\2\u00e6\u00e7\5.\30\2\u00e7\u00e8\7\5\2\2\u00e8-\3"+
		"\2\2\2\u00e9\u00eb\t\3\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2\2\2\u00ec"+
		"\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00ed/\3\2\2\2\u00ee\u00ec\3\2\2\2"+
		" \63:HPX[adjru{~\u0084\u008c\u0094\u009c\u009f\u00a6\u00aa\u00ae\u00b2"+
		"\u00b4\u00b9\u00c6\u00cb\u00d4\u00e0\u00e2\u00ec";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}