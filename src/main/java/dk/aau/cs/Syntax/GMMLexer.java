package dk.aau.cs.Syntax;// Generated from C:/Dev/D408f19_P4\GMM.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.Lexer;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.Token;
import org.antlr.v4.runtime.TokenStream;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.misc.*;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GMMLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Return=1, Equals=2, Plus=3, Minus=4, Times=5, Divide=6, And=7, Or=8, Equality=9, 
		InEquality=10, GreaterThan=11, LessThan=12, True=13, False=14, INT=15, 
		SemiColon=16, CommaSeperator=17, Colon=18, While=19, If=20, LParan=21, 
		RParan=22, LSquare=23, RSquare=24, LCurl=25, RCurl=26, MoveCommand=27, 
		LeftCircleCommand=28, RightCircleCommand=29, FunctionType=30, Type=31, 
		AbsoluteParameter=32, CommandParameter=33, ID=34, WS=35;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", "Or", 
			"Equality", "InEquality", "GreaterThan", "LessThan", "True", "False", 
			"INT", "SemiColon", "CommaSeperator", "Colon", "While", "If", "LParan", 
			"RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand", "LeftCircleCommand", 
			"RightCircleCommand", "FunctionType", "Type", "AbsoluteParameter", "CommandParameter", 
			"ID", "Letter", "Digit", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
			"'=='", "'!='", "'>'", "'<'", "'true'", "'false'", null, "';'", "','", 
			"':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'move '", 
			"'leftCircle '", "'rightCircle '", null, null, "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", 
			"Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True", "False", 
			"INT", "SemiColon", "CommaSeperator", "Colon", "While", "If", "LParan", 
			"RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand", "LeftCircleCommand", 
			"RightCircleCommand", "FunctionType", "Type", "AbsoluteParameter", "CommandParameter", 
			"ID", "WS"
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


	public GMMLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "GMM.g4"; }

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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00e9\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
		"\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
		"\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\20\6\20|\n\20\r\20\16\20}\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\34\3\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3"+
		"\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3"+
		"\37\3\37\3\37\3\37\5\37\u00c0\n\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
		" \3 \3 \3 \3 \5 \u00d2\n \3!\3!\3\"\3\"\3#\3#\3#\3#\7#\u00dc\n#\f#\16"+
		"#\u00df\13#\3$\5$\u00e2\n$\3%\3%\3&\3&\3&\3&\2\2\'\3\3\5\4\7\5\t\6\13"+
		"\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'"+
		"\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G\2I\2K"+
		"%\3\2\6\5\2KLTTZ\\\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u00ed\2\3\3\2"+
		"\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17"+
		"\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2"+
		"\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3"+
		"\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3"+
		"\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2"+
		"=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2K\3\2\2\2\3M\3"+
		"\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3\2\2\2\17_\3\2"+
		"\2\2\21b\3\2\2\2\23e\3\2\2\2\25h\3\2\2\2\27k\3\2\2\2\31m\3\2\2\2\33o\3"+
		"\2\2\2\35t\3\2\2\2\37{\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083\3\2"+
		"\2\2\'\u0085\3\2\2\2)\u008b\3\2\2\2+\u008e\3\2\2\2-\u0090\3\2\2\2/\u0092"+
		"\3\2\2\2\61\u0094\3\2\2\2\63\u0096\3\2\2\2\65\u0098\3\2\2\2\67\u009a\3"+
		"\2\2\29\u00a0\3\2\2\2;\u00ac\3\2\2\2=\u00bf\3\2\2\2?\u00d1\3\2\2\2A\u00d3"+
		"\3\2\2\2C\u00d5\3\2\2\2E\u00d7\3\2\2\2G\u00e1\3\2\2\2I\u00e3\3\2\2\2K"+
		"\u00e5\3\2\2\2MN\7t\2\2NO\7g\2\2OP\7v\2\2PQ\7w\2\2QR\7t\2\2RS\7p\2\2S"+
		"T\7\"\2\2T\4\3\2\2\2UV\7?\2\2V\6\3\2\2\2WX\7-\2\2X\b\3\2\2\2YZ\7/\2\2"+
		"Z\n\3\2\2\2[\\\7,\2\2\\\f\3\2\2\2]^\7\61\2\2^\16\3\2\2\2_`\7(\2\2`a\7"+
		"(\2\2a\20\3\2\2\2bc\7~\2\2cd\7~\2\2d\22\3\2\2\2ef\7?\2\2fg\7?\2\2g\24"+
		"\3\2\2\2hi\7#\2\2ij\7?\2\2j\26\3\2\2\2kl\7@\2\2l\30\3\2\2\2mn\7>\2\2n"+
		"\32\3\2\2\2op\7v\2\2pq\7t\2\2qr\7w\2\2rs\7g\2\2s\34\3\2\2\2tu\7h\2\2u"+
		"v\7c\2\2vw\7n\2\2wx\7u\2\2xy\7g\2\2y\36\3\2\2\2z|\5I%\2{z\3\2\2\2|}\3"+
		"\2\2\2}{\3\2\2\2}~\3\2\2\2~ \3\2\2\2\177\u0080\7=\2\2\u0080\"\3\2\2\2"+
		"\u0081\u0082\7.\2\2\u0082$\3\2\2\2\u0083\u0084\7<\2\2\u0084&\3\2\2\2\u0085"+
		"\u0086\7y\2\2\u0086\u0087\7j\2\2\u0087\u0088\7k\2\2\u0088\u0089\7n\2\2"+
		"\u0089\u008a\7g\2\2\u008a(\3\2\2\2\u008b\u008c\7k\2\2\u008c\u008d\7h\2"+
		"\2\u008d*\3\2\2\2\u008e\u008f\7*\2\2\u008f,\3\2\2\2\u0090\u0091\7+\2\2"+
		"\u0091.\3\2\2\2\u0092\u0093\7]\2\2\u0093\60\3\2\2\2\u0094\u0095\7_\2\2"+
		"\u0095\62\3\2\2\2\u0096\u0097\7}\2\2\u0097\64\3\2\2\2\u0098\u0099\7\177"+
		"\2\2\u0099\66\3\2\2\2\u009a\u009b\7o\2\2\u009b\u009c\7q\2\2\u009c\u009d"+
		"\7x\2\2\u009d\u009e\7g\2\2\u009e\u009f\7\"\2\2\u009f8\3\2\2\2\u00a0\u00a1"+
		"\7n\2\2\u00a1\u00a2\7g\2\2\u00a2\u00a3\7h\2\2\u00a3\u00a4\7v\2\2\u00a4"+
		"\u00a5\7E\2\2\u00a5\u00a6\7k\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8\7e\2\2"+
		"\u00a8\u00a9\7n\2\2\u00a9\u00aa\7g\2\2\u00aa\u00ab\7\"\2\2\u00ab:\3\2"+
		"\2\2\u00ac\u00ad\7t\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7i\2\2\u00af\u00b0"+
		"\7j\2\2\u00b0\u00b1\7v\2\2\u00b1\u00b2\7E\2\2\u00b2\u00b3\7k\2\2\u00b3"+
		"\u00b4\7t\2\2\u00b4\u00b5\7e\2\2\u00b5\u00b6\7n\2\2\u00b6\u00b7\7g\2\2"+
		"\u00b7\u00b8\7\"\2\2\u00b8<\3\2\2\2\u00b9\u00ba\7x\2\2\u00ba\u00bb\7q"+
		"\2\2\u00bb\u00bc\7k\2\2\u00bc\u00bd\7f\2\2\u00bd\u00c0\7\"\2\2\u00be\u00c0"+
		"\5? \2\u00bf\u00b9\3\2\2\2\u00bf\u00be\3\2\2\2\u00c0>\3\2\2\2\u00c1\u00c2"+
		"\7p\2\2\u00c2\u00c3\7w\2\2\u00c3\u00c4\7o\2\2\u00c4\u00d2\7\"\2\2\u00c5"+
		"\u00c6\7x\2\2\u00c6\u00c7\7g\2\2\u00c7\u00c8\7e\2\2\u00c8\u00c9\7v\2\2"+
		"\u00c9\u00ca\7q\2\2\u00ca\u00cb\7t\2\2\u00cb\u00d2\7\"\2\2\u00cc\u00cd"+
		"\7d\2\2\u00cd\u00ce\7q\2\2\u00ce\u00cf\7q\2\2\u00cf\u00d0\7n\2\2\u00d0"+
		"\u00d2\7\"\2\2\u00d1\u00c1\3\2\2\2\u00d1\u00c5\3\2\2\2\u00d1\u00cc\3\2"+
		"\2\2\u00d2@\3\2\2\2\u00d3\u00d4\7&\2\2\u00d4B\3\2\2\2\u00d5\u00d6\t\2"+
		"\2\2\u00d6D\3\2\2\2\u00d7\u00dd\5G$\2\u00d8\u00dc\5G$\2\u00d9\u00dc\5"+
		"I%\2\u00da\u00dc\7a\2\2\u00db\u00d8\3\2\2\2\u00db\u00d9\3\2\2\2\u00db"+
		"\u00da\3\2\2\2\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2"+
		"\2\2\u00deF\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e2\t\3\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2H\3\2\2\2\u00e3\u00e4\t\4\2\2\u00e4J\3\2\2\2\u00e5\u00e6"+
		"\t\5\2\2\u00e6\u00e7\3\2\2\2\u00e7\u00e8\b&\2\2\u00e8L\3\2\2\2\t\2}\u00bf"+
		"\u00d1\u00db\u00dd\u00e1\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}