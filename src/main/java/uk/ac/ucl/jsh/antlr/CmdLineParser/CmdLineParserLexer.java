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
		CALL_CONTENT=1, SEMI=2, PIPE=3, GT=4, LT=5, WHITESPACE=6;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"SQUOTED", "BQUOTED", "DQUOTED", "NON_KEYWORD", "CALL_CONTENT", "SEMI", 
			"PIPE", "GT", "LT", "WHITESPACE"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, null, "';'", "'|'", "'>'", "'<'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "CALL_CONTENT", "SEMI", "PIPE", "GT", "LT", "WHITESPACE"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2\bF\b\1\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\3\2\3\2\6\2\32\n\2\r\2\16\2\33\3\2\3\2\3\3\3\3\6\3\"\n\3\r\3\16\3"+
		"#\3\3\3\3\3\4\3\4\3\4\6\4+\n\4\r\4\16\4,\3\4\3\4\3\5\3\5\3\6\3\6\3\6\3"+
		"\6\6\6\67\n\6\r\6\16\68\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\2\2\f\3\2\5\2\7\2\t\2\13\3\r\4\17\5\21\6\23\7\25\b\3\2\7\5\2\f\f"+
		"\17\17))\5\2\f\f\17\17bb\6\2\f\f\17\17$$bb\b\2\f\f$$))==bb~~\4\2\13\13"+
		"\"\"\2I\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2"+
		"\2\2\25\3\2\2\2\3\27\3\2\2\2\5\37\3\2\2\2\7\'\3\2\2\2\t\60\3\2\2\2\13"+
		"\66\3\2\2\2\r:\3\2\2\2\17<\3\2\2\2\21>\3\2\2\2\23@\3\2\2\2\25B\3\2\2\2"+
		"\27\31\7)\2\2\30\32\n\2\2\2\31\30\3\2\2\2\32\33\3\2\2\2\33\31\3\2\2\2"+
		"\33\34\3\2\2\2\34\35\3\2\2\2\35\36\7)\2\2\36\4\3\2\2\2\37!\7b\2\2 \"\n"+
		"\3\2\2! \3\2\2\2\"#\3\2\2\2#!\3\2\2\2#$\3\2\2\2$%\3\2\2\2%&\7b\2\2&\6"+
		"\3\2\2\2\'*\7$\2\2(+\5\5\3\2)+\n\4\2\2*(\3\2\2\2*)\3\2\2\2+,\3\2\2\2,"+
		"*\3\2\2\2,-\3\2\2\2-.\3\2\2\2./\7$\2\2/\b\3\2\2\2\60\61\n\5\2\2\61\n\3"+
		"\2\2\2\62\67\5\t\5\2\63\67\5\3\2\2\64\67\5\5\3\2\65\67\5\7\4\2\66\62\3"+
		"\2\2\2\66\63\3\2\2\2\66\64\3\2\2\2\66\65\3\2\2\2\678\3\2\2\28\66\3\2\2"+
		"\289\3\2\2\29\f\3\2\2\2:;\7=\2\2;\16\3\2\2\2<=\7~\2\2=\20\3\2\2\2>?\7"+
		"@\2\2?\22\3\2\2\2@A\7>\2\2A\24\3\2\2\2BC\t\6\2\2CD\3\2\2\2DE\b\13\2\2"+
		"E\26\3\2\2\2\t\2\33#*,\668\3\2\3\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}