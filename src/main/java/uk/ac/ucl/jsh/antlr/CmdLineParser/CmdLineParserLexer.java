// Generated from uk/ac/ucl/jsh/antlr/CmdLineParser/CmdLineParser.g4 by ANTLR 4.7.2
package uk.ac.ucl.jsh.antlr.CmdLineParser;
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class CmdLineParserLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		CALL_CONTENT=1, SEMI=2, PIPE=3, DQUOTE=4, SQUOTE=5, BQUOTE=6, GT=7, LT=8, 
		UNQUOTED=9, WHITESPACE=10;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SQUOTE_CONTENT", "BQUOTE_CONTENT", "DQUOTE_CONTENT", "NON_KEYWORD", 
			"CALL_CONTENT", "SEMI", "PIPE", "DQUOTE", "SQUOTE", "BQUOTE", "GT", "LT", 
			"UNQUOTED", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'", "'|'", "'\"'", "'''", "'`'", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CALL_CONTENT", "SEMI", "PIPE", "DQUOTE", "SQUOTE", "BQUOTE", "GT", 
			"LT", "UNQUOTED", "WHITESPACE"
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


	public CmdLineParserLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "CmdLineParser.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getChannelNames() { return channelNames; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\fV\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\3\2\6\2!\n\2\r\2\16\2\"\3\3\6"+
		"\3&\n\3\r\3\16\3\'\3\4\3\4\6\4,\n\4\r\4\16\4-\3\5\3\5\3\6\3\6\3\6\3\6"+
		"\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\3\6\6\6?\n\6\r\6\16\6@\3\7\3\7\3\b\3"+
		"\b\3\t\3\t\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\17\3\17\3\17"+
		"\3\17\2\2\20\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\27\t\31\n\33"+
		"\13\35\f\3\2\b\5\2\f\f\17\17))\5\2\f\f\17\17bb\6\2\f\f\17\17$$bb\b\2\f"+
		"\f$$))==bb~~\13\2\13\f\17\17\"\"$$))=>@@bb~~\4\2\13\13\"\"\2Y\2\13\3\2"+
		"\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2"+
		"\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\3 \3\2\2\2\5%\3\2\2"+
		"\2\7+\3\2\2\2\t/\3\2\2\2\13>\3\2\2\2\rB\3\2\2\2\17D\3\2\2\2\21F\3\2\2"+
		"\2\23H\3\2\2\2\25J\3\2\2\2\27L\3\2\2\2\31N\3\2\2\2\33P\3\2\2\2\35R\3\2"+
		"\2\2\37!\n\2\2\2 \37\3\2\2\2!\"\3\2\2\2\" \3\2\2\2\"#\3\2\2\2#\4\3\2\2"+
		"\2$&\n\3\2\2%$\3\2\2\2&\'\3\2\2\2\'%\3\2\2\2\'(\3\2\2\2(\6\3\2\2\2),\5"+
		"\5\3\2*,\n\4\2\2+)\3\2\2\2+*\3\2\2\2,-\3\2\2\2-+\3\2\2\2-.\3\2\2\2.\b"+
		"\3\2\2\2/\60\n\5\2\2\60\n\3\2\2\2\61?\5\t\5\2\62\63\5\23\n\2\63\64\5\3"+
		"\2\2\64\65\5\23\n\2\65?\3\2\2\2\66\67\5\25\13\2\678\5\5\3\289\5\25\13"+
		"\29?\3\2\2\2:;\5\21\t\2;<\5\7\4\2<=\5\21\t\2=?\3\2\2\2>\61\3\2\2\2>\62"+
		"\3\2\2\2>\66\3\2\2\2>:\3\2\2\2?@\3\2\2\2@>\3\2\2\2@A\3\2\2\2A\f\3\2\2"+
		"\2BC\7=\2\2C\16\3\2\2\2DE\7~\2\2E\20\3\2\2\2FG\7$\2\2G\22\3\2\2\2HI\7"+
		")\2\2I\24\3\2\2\2JK\7b\2\2K\26\3\2\2\2LM\7@\2\2M\30\3\2\2\2NO\7>\2\2O"+
		"\32\3\2\2\2PQ\n\6\2\2Q\34\3\2\2\2RS\t\7\2\2ST\3\2\2\2TU\b\17\2\2U\36\3"+
		"\2\2\2\t\2\"\'+->@\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}