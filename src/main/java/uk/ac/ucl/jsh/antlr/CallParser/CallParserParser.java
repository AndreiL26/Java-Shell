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
		T__0=1, T__1=2, T__2=3, WS=4, NON_KEYWORD=5, QUOTE_CONTENT=6;
	public static final int
		RULE_compileUnit = 0, RULE_arguments = 1, RULE_argument = 2, RULE_non_quoted = 3, 
		RULE_quoted = 4, RULE_single_quoted = 5, RULE_squote_content = 6, RULE_double_quoted = 7, 
		RULE_dquote_content = 8, RULE_backquoted = 9, RULE_bquote_content = 10;
	private static String[] makeRuleNames() {
		return new String[] {
			"compileUnit", "arguments", "argument", "non_quoted", "quoted", "single_quoted", 
			"squote_content", "double_quoted", "dquote_content", "backquoted", "bquote_content"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'''", "'\"'", "'`'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, null, null, null, "WS", "NON_KEYWORD", "QUOTE_CONTENT"
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
		public ArgumentsContext arguments() {
			return getRuleContext(ArgumentsContext.class,0);
		}
		public TerminalNode EOF() { return getToken(CallParserParser.EOF, 0); }
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
			setState(25);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(22);
				match(WS);
				}
				}
				setState(27);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(28);
			arguments();
			setState(32);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==WS) {
				{
				{
				setState(29);
				match(WS);
				}
				}
				setState(34);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(35);
			match(EOF);
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
		enterRule(_localctx, 2, RULE_arguments);
		int _la;
		try {
			setState(46);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,3,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(37);
				argument();
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(38);
				argument();
				setState(40); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(39);
					match(WS);
					}
					}
					setState(42); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==WS );
				setState(44);
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
		enterRule(_localctx, 4, RULE_argument);
		int _la;
		try {
			setState(56);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case NON_KEYWORD:
				enterOuterAlt(_localctx, 1);
				{
				setState(48);
				((ArgumentContext)_localctx).non_quote = non_quoted();
				setState(50);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(49);
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
				setState(52);
				quoted();
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
				if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << T__2) | (1L << NON_KEYWORD))) != 0)) {
					{
					setState(53);
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
		enterRule(_localctx, 6, RULE_non_quoted);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(59); 
			_errHandler.sync(this);
			_alt = 1;
			do {
				switch (_alt) {
				case 1:
					{
					{
					setState(58);
					match(NON_KEYWORD);
					}
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				setState(61); 
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,7,_ctx);
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
		enterRule(_localctx, 8, RULE_quoted);
		try {
			setState(66);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
				enterOuterAlt(_localctx, 1);
				{
				setState(63);
				single_quoted();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 2);
				{
				setState(64);
				double_quoted();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 3);
				{
				setState(65);
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
		enterRule(_localctx, 10, RULE_single_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(68);
			match(T__0);
			setState(69);
			((Single_quotedContext)_localctx).content = squote_content();
			setState(70);
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
		enterRule(_localctx, 12, RULE_squote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(75);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__1) | (1L << T__2) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(72);
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
				setState(77);
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
		enterRule(_localctx, 14, RULE_double_quoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(78);
			match(T__1);
			setState(79);
			((Double_quotedContext)_localctx).content = dquote_content();
			setState(80);
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
		public Token content;
		public Dquote_contentContext dquote_content() {
			return getRuleContext(Dquote_contentContext.class,0);
		}
		public TerminalNode NON_KEYWORD() { return getToken(CallParserParser.NON_KEYWORD, 0); }
		public TerminalNode QUOTE_CONTENT() { return getToken(CallParserParser.QUOTE_CONTENT, 0); }
		public TerminalNode WS() { return getToken(CallParserParser.WS, 0); }
		public BackquotedContext backquoted() {
			return getRuleContext(BackquotedContext.class,0);
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
		enterRule(_localctx, 16, RULE_dquote_content);
		int _la;
		try {
			setState(88);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case T__0:
			case WS:
			case NON_KEYWORD:
			case QUOTE_CONTENT:
				enterOuterAlt(_localctx, 1);
				{
				setState(82);
				((Dquote_contentContext)_localctx).content = _input.LT(1);
				_la = _input.LA(1);
				if ( !((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) ) {
					((Dquote_contentContext)_localctx).content = (Token)_errHandler.recoverInline(this);
				}
				else {
					if ( _input.LA(1)==Token.EOF ) matchedEOF = true;
					_errHandler.reportMatch(this);
					consume();
				}
				setState(83);
				dquote_content();
				}
				break;
			case T__2:
				enterOuterAlt(_localctx, 2);
				{
				setState(84);
				backquoted();
				setState(85);
				dquote_content();
				}
				break;
			case T__1:
				enterOuterAlt(_localctx, 3);
				{
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
		enterRule(_localctx, 18, RULE_backquoted);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(90);
			match(T__2);
			setState(91);
			((BackquotedContext)_localctx).content = bquote_content();
			setState(92);
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
		enterRule(_localctx, 20, RULE_bquote_content);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(97);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << T__0) | (1L << T__1) | (1L << WS) | (1L << NON_KEYWORD) | (1L << QUOTE_CONTENT))) != 0)) {
				{
				{
				setState(94);
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
				setState(99);
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\bg\4\2\t\2\4\3\t"+
		"\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t\13\4"+
		"\f\t\f\3\2\7\2\32\n\2\f\2\16\2\35\13\2\3\2\3\2\7\2!\n\2\f\2\16\2$\13\2"+
		"\3\2\3\2\3\3\3\3\3\3\6\3+\n\3\r\3\16\3,\3\3\3\3\5\3\61\n\3\3\4\3\4\5\4"+
		"\65\n\4\3\4\3\4\5\49\n\4\5\4;\n\4\3\5\6\5>\n\5\r\5\16\5?\3\6\3\6\3\6\5"+
		"\6E\n\6\3\7\3\7\3\7\3\7\3\b\7\bL\n\b\f\b\16\bO\13\b\3\t\3\t\3\t\3\t\3"+
		"\n\3\n\3\n\3\n\3\n\3\n\5\n[\n\n\3\13\3\13\3\13\3\13\3\f\7\fb\n\f\f\f\16"+
		"\fe\13\f\3\f\2\2\r\2\4\6\b\n\f\16\20\22\24\26\2\5\3\2\4\b\4\2\3\3\6\b"+
		"\4\2\3\4\6\b\2i\2\33\3\2\2\2\4\60\3\2\2\2\6:\3\2\2\2\b=\3\2\2\2\nD\3\2"+
		"\2\2\fF\3\2\2\2\16M\3\2\2\2\20P\3\2\2\2\22Z\3\2\2\2\24\\\3\2\2\2\26c\3"+
		"\2\2\2\30\32\7\6\2\2\31\30\3\2\2\2\32\35\3\2\2\2\33\31\3\2\2\2\33\34\3"+
		"\2\2\2\34\36\3\2\2\2\35\33\3\2\2\2\36\"\5\4\3\2\37!\7\6\2\2 \37\3\2\2"+
		"\2!$\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#%\3\2\2\2$\"\3\2\2\2%&\7\2\2\3&\3\3"+
		"\2\2\2\'\61\5\6\4\2(*\5\6\4\2)+\7\6\2\2*)\3\2\2\2+,\3\2\2\2,*\3\2\2\2"+
		",-\3\2\2\2-.\3\2\2\2./\5\4\3\2/\61\3\2\2\2\60\'\3\2\2\2\60(\3\2\2\2\61"+
		"\5\3\2\2\2\62\64\5\b\5\2\63\65\5\6\4\2\64\63\3\2\2\2\64\65\3\2\2\2\65"+
		";\3\2\2\2\668\5\n\6\2\679\5\6\4\28\67\3\2\2\289\3\2\2\29;\3\2\2\2:\62"+
		"\3\2\2\2:\66\3\2\2\2;\7\3\2\2\2<>\7\7\2\2=<\3\2\2\2>?\3\2\2\2?=\3\2\2"+
		"\2?@\3\2\2\2@\t\3\2\2\2AE\5\f\7\2BE\5\20\t\2CE\5\24\13\2DA\3\2\2\2DB\3"+
		"\2\2\2DC\3\2\2\2E\13\3\2\2\2FG\7\3\2\2GH\5\16\b\2HI\7\3\2\2I\r\3\2\2\2"+
		"JL\t\2\2\2KJ\3\2\2\2LO\3\2\2\2MK\3\2\2\2MN\3\2\2\2N\17\3\2\2\2OM\3\2\2"+
		"\2PQ\7\4\2\2QR\5\22\n\2RS\7\4\2\2S\21\3\2\2\2TU\t\3\2\2U[\5\22\n\2VW\5"+
		"\24\13\2WX\5\22\n\2X[\3\2\2\2Y[\3\2\2\2ZT\3\2\2\2ZV\3\2\2\2ZY\3\2\2\2"+
		"[\23\3\2\2\2\\]\7\5\2\2]^\5\26\f\2^_\7\5\2\2_\25\3\2\2\2`b\t\4\2\2a`\3"+
		"\2\2\2be\3\2\2\2ca\3\2\2\2cd\3\2\2\2d\27\3\2\2\2ec\3\2\2\2\16\33\",\60"+
		"\648:?DMZc";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}