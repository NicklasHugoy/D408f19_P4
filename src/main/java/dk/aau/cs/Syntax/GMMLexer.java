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
		SemiColon=16, CommaSeperator=17, DotOperator=18, Colon=19, While=20, If=21, 
		LParan=22, RParan=23, LSquare=24, RSquare=25, LCurl=26, RCurl=27, MoveCommand=28, 
		LeftCircleCommand=29, RightCircleCommand=30, Type=31, AbsoluteParameter=32, 
		CommandParameter=33, GCode=34, GCodeVarRef=35, ID=36, BlockParam=37, WS=38;
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
			"INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", "While", 
			"If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand", 
			"LeftCircleCommand", "RightCircleCommand", "Type", "AbsoluteParameter", 
			"CommandParameter", "GCode", "GCodeVarRef", "ID", "BlockParam", "Letter", 
			"Digit", "WS"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
			"'=='", "'!='", "'>'", "'<'", "'true'", "'false'", null, "';'", "','", 
			"'.'", "':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", "'}'", 
			"'move '", "'leftCircle '", "'rightCircle '", null, "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", 
			"Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True", "False", 
			"INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", "While", 
			"If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand", 
			"LeftCircleCommand", "RightCircleCommand", "Type", "AbsoluteParameter", 
			"CommandParameter", "GCode", "GCodeVarRef", "ID", "BlockParam", "WS"
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2(\u0122\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\3\2\3\2\3\2\3"+
		"\2\3\2\3\2\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b"+
		"\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16"+
		"\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\20\6\20\u0082\n\20\r\20\16"+
		"\20\u0083\3\20\3\20\3\20\5\20\u0089\n\20\3\20\5\20\u008c\n\20\3\20\5\20"+
		"\u008f\n\20\3\20\5\20\u0092\n\20\5\20\u0094\n\20\3\21\3\21\3\22\3\22\3"+
		"\23\3\23\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3"+
		"\27\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3"+
		"\35\3\35\3\35\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3"+
		"\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00e7"+
		"\n \3!\3!\3\"\3\"\3#\3#\3#\3#\3#\7#\u00f2\n#\f#\16#\u00f5\13#\3#\3#\3"+
		"$\3$\3$\3$\3%\3%\3%\3%\7%\u0101\n%\f%\16%\u0104\13%\3&\3&\7&\u0108\n&"+
		"\f&\16&\u010b\13&\3&\3&\7&\u010f\n&\f&\16&\u0112\13&\3&\3&\6&\u0116\n"+
		"&\r&\16&\u0117\3\'\5\'\u011b\n\'\3(\3(\3)\3)\3)\3)\2\2*\3\3\5\4\7\5\t"+
		"\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23"+
		"%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G"+
		"%I&K\'M\2O\2Q(\3\2\6\5\2KLTTZ\\\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2"+
		"\u0133\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
		"\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
		"\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
		"\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
		"/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
		"\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
		"G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2Q\3\2\2\2\3S\3\2\2\2\5[\3\2\2\2\7]\3"+
		"\2\2\2\t_\3\2\2\2\13a\3\2\2\2\rc\3\2\2\2\17e\3\2\2\2\21h\3\2\2\2\23k\3"+
		"\2\2\2\25n\3\2\2\2\27q\3\2\2\2\31s\3\2\2\2\33u\3\2\2\2\35z\3\2\2\2\37"+
		"\u0093\3\2\2\2!\u0095\3\2\2\2#\u0097\3\2\2\2%\u0099\3\2\2\2\'\u009b\3"+
		"\2\2\2)\u009d\3\2\2\2+\u00a3\3\2\2\2-\u00a6\3\2\2\2/\u00a8\3\2\2\2\61"+
		"\u00aa\3\2\2\2\63\u00ac\3\2\2\2\65\u00ae\3\2\2\2\67\u00b0\3\2\2\29\u00b2"+
		"\3\2\2\2;\u00b8\3\2\2\2=\u00c4\3\2\2\2?\u00e6\3\2\2\2A\u00e8\3\2\2\2C"+
		"\u00ea\3\2\2\2E\u00ec\3\2\2\2G\u00f8\3\2\2\2I\u00fc\3\2\2\2K\u0105\3\2"+
		"\2\2M\u011a\3\2\2\2O\u011c\3\2\2\2Q\u011e\3\2\2\2ST\7t\2\2TU\7g\2\2UV"+
		"\7v\2\2VW\7w\2\2WX\7t\2\2XY\7p\2\2YZ\7\"\2\2Z\4\3\2\2\2[\\\7?\2\2\\\6"+
		"\3\2\2\2]^\7-\2\2^\b\3\2\2\2_`\7/\2\2`\n\3\2\2\2ab\7,\2\2b\f\3\2\2\2c"+
		"d\7\61\2\2d\16\3\2\2\2ef\7(\2\2fg\7(\2\2g\20\3\2\2\2hi\7~\2\2ij\7~\2\2"+
		"j\22\3\2\2\2kl\7?\2\2lm\7?\2\2m\24\3\2\2\2no\7#\2\2op\7?\2\2p\26\3\2\2"+
		"\2qr\7@\2\2r\30\3\2\2\2st\7>\2\2t\32\3\2\2\2uv\7v\2\2vw\7t\2\2wx\7w\2"+
		"\2xy\7g\2\2y\34\3\2\2\2z{\7h\2\2{|\7c\2\2|}\7n\2\2}~\7u\2\2~\177\7g\2"+
		"\2\177\36\3\2\2\2\u0080\u0082\5O(\2\u0081\u0080\3\2\2\2\u0082\u0083\3"+
		"\2\2\2\u0083\u0081\3\2\2\2\u0083\u0084\3\2\2\2\u0084\u0094\3\2\2\2\u0085"+
		"\u0086\5O(\2\u0086\u0088\5%\23\2\u0087\u0089\5O(\2\u0088\u0087\3\2\2\2"+
		"\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5O(\2\u008b\u008a"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d\u008f\5O(\2\u008e"+
		"\u008d\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u0091\3\2\2\2\u0090\u0092\5O"+
		"(\2\u0091\u0090\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u0094\3\2\2\2\u0093"+
		"\u0081\3\2\2\2\u0093\u0085\3\2\2\2\u0094 \3\2\2\2\u0095\u0096\7=\2\2\u0096"+
		"\"\3\2\2\2\u0097\u0098\7.\2\2\u0098$\3\2\2\2\u0099\u009a\7\60\2\2\u009a"+
		"&\3\2\2\2\u009b\u009c\7<\2\2\u009c(\3\2\2\2\u009d\u009e\7y\2\2\u009e\u009f"+
		"\7j\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7n\2\2\u00a1\u00a2\7g\2\2\u00a2"+
		"*\3\2\2\2\u00a3\u00a4\7k\2\2\u00a4\u00a5\7h\2\2\u00a5,\3\2\2\2\u00a6\u00a7"+
		"\7*\2\2\u00a7.\3\2\2\2\u00a8\u00a9\7+\2\2\u00a9\60\3\2\2\2\u00aa\u00ab"+
		"\7]\2\2\u00ab\62\3\2\2\2\u00ac\u00ad\7_\2\2\u00ad\64\3\2\2\2\u00ae\u00af"+
		"\7}\2\2\u00af\66\3\2\2\2\u00b0\u00b1\7\177\2\2\u00b18\3\2\2\2\u00b2\u00b3"+
		"\7o\2\2\u00b3\u00b4\7q\2\2\u00b4\u00b5\7x\2\2\u00b5\u00b6\7g\2\2\u00b6"+
		"\u00b7\7\"\2\2\u00b7:\3\2\2\2\u00b8\u00b9\7n\2\2\u00b9\u00ba\7g\2\2\u00ba"+
		"\u00bb\7h\2\2\u00bb\u00bc\7v\2\2\u00bc\u00bd\7E\2\2\u00bd\u00be\7k\2\2"+
		"\u00be\u00bf\7t\2\2\u00bf\u00c0\7e\2\2\u00c0\u00c1\7n\2\2\u00c1\u00c2"+
		"\7g\2\2\u00c2\u00c3\7\"\2\2\u00c3<\3\2\2\2\u00c4\u00c5\7t\2\2\u00c5\u00c6"+
		"\7k\2\2\u00c6\u00c7\7i\2\2\u00c7\u00c8\7j\2\2\u00c8\u00c9\7v\2\2\u00c9"+
		"\u00ca\7E\2\2\u00ca\u00cb\7k\2\2\u00cb\u00cc\7t\2\2\u00cc\u00cd\7e\2\2"+
		"\u00cd\u00ce\7n\2\2\u00ce\u00cf\7g\2\2\u00cf\u00d0\7\"\2\2\u00d0>\3\2"+
		"\2\2\u00d1\u00d2\7p\2\2\u00d2\u00d3\7w\2\2\u00d3\u00d4\7o\2\2\u00d4\u00e7"+
		"\7\"\2\2\u00d5\u00d6\7x\2\2\u00d6\u00d7\7g\2\2\u00d7\u00d8\7e\2\2\u00d8"+
		"\u00d9\7v\2\2\u00d9\u00da\7q\2\2\u00da\u00db\7t\2\2\u00db\u00e7\7\"\2"+
		"\2\u00dc\u00dd\7d\2\2\u00dd\u00de\7q\2\2\u00de\u00df\7q\2\2\u00df\u00e0"+
		"\7n\2\2\u00e0\u00e7\7\"\2\2\u00e1\u00e2\7x\2\2\u00e2\u00e3\7q\2\2\u00e3"+
		"\u00e4\7k\2\2\u00e4\u00e5\7f\2\2\u00e5\u00e7\7\"\2\2\u00e6\u00d1\3\2\2"+
		"\2\u00e6\u00d5\3\2\2\2\u00e6\u00dc\3\2\2\2\u00e6\u00e1\3\2\2\2\u00e7@"+
		"\3\2\2\2\u00e8\u00e9\7&\2\2\u00e9B\3\2\2\2\u00ea\u00eb\t\2\2\2\u00ebD"+
		"\3\2\2\2\u00ec\u00f3\7B\2\2\u00ed\u00f2\5M\'\2\u00ee\u00f2\5O(\2\u00ef"+
		"\u00f2\5Q)\2\u00f0\u00f2\5G$\2\u00f1\u00ed\3\2\2\2\u00f1\u00ee\3\2\2\2"+
		"\u00f1\u00ef\3\2\2\2\u00f1\u00f0\3\2\2\2\u00f2\u00f5\3\2\2\2\u00f3\u00f1"+
		"\3\2\2\2\u00f3\u00f4\3\2\2\2\u00f4\u00f6\3\2\2\2\u00f5\u00f3\3\2\2\2\u00f6"+
		"\u00f7\7B\2\2\u00f7F\3\2\2\2\u00f8\u00f9\7}\2\2\u00f9\u00fa\5I%\2\u00fa"+
		"\u00fb\7\177\2\2\u00fbH\3\2\2\2\u00fc\u0102\5M\'\2\u00fd\u0101\5M\'\2"+
		"\u00fe\u0101\5O(\2\u00ff\u0101\7a\2\2\u0100\u00fd\3\2\2\2\u0100\u00fe"+
		"\3\2\2\2\u0100\u00ff\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2\2\2\u0102"+
		"\u0103\3\2\2\2\u0103J\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0109\5I%\2\u0106"+
		"\u0108\5Q)\2\u0107\u0106\3\2\2\2\u0108\u010b\3\2\2\2\u0109\u0107\3\2\2"+
		"\2\u0109\u010a\3\2\2\2\u010a\u010c\3\2\2\2\u010b\u0109\3\2\2\2\u010c\u0110"+
		"\5\'\24\2\u010d\u010f\5Q)\2\u010e\u010d\3\2\2\2\u010f\u0112\3\2\2\2\u0110"+
		"\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111\u0115\3\2\2\2\u0112\u0110\3\2"+
		"\2\2\u0113\u0116\5M\'\2\u0114\u0116\5O(\2\u0115\u0113\3\2\2\2\u0115\u0114"+
		"\3\2\2\2\u0116\u0117\3\2\2\2\u0117\u0115\3\2\2\2\u0117\u0118\3\2\2\2\u0118"+
		"L\3\2\2\2\u0119\u011b\t\3\2\2\u011a\u0119\3\2\2\2\u011bN\3\2\2\2\u011c"+
		"\u011d\t\4\2\2\u011dP\3\2\2\2\u011e\u011f\t\5\2\2\u011f\u0120\3\2\2\2"+
		"\u0120\u0121\b)\2\2\u0121R\3\2\2\2\23\2\u0083\u0088\u008b\u008e\u0091"+
		"\u0093\u00e6\u00f1\u00f3\u0100\u0102\u0109\u0110\u0115\u0117\u011a\3\b"+
		"\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}