package dk.aau.cs.Syntax;// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/D408f19_P4\GMM.g4 by ANTLR 4.7.2
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
		Sqrt=1, Return=2, Equals=3, Plus=4, Minus=5, Times=6, Divide=7, And=8, 
		Or=9, Equality=10, InEquality=11, GreaterThan=12, LessThan=13, True=14, 
		False=15, INT=16, SemiColon=17, CommaSeperator=18, DotOperator=19, Colon=20, 
		While=21, If=22, LParan=23, RParan=24, LSquare=25, RSquare=26, LCurl=27, 
		RCurl=28, MoveCommand=29, LeftCircleCommand=30, RightCircleCommand=31, 
		Type=32, AbsoluteParameter=33, CommandParameter=34, GCode=35, GCodeVarRef=36, 
		ID=37, BlockParam=38, WS=39;
	public static String[] channelNames = {
		"DEFAULT_TOKEN_CHANNEL", "HIDDEN"
	};

	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	private static String[] makeRuleNames() {
		return new String[] {
			"Sqrt", "Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", 
			"Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True", "False", 
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
			null, "'sqrt'", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", 
			"'||'", "'=='", "'!='", "'>'", "'<'", "'true'", "'false'", null, "';'", 
			"','", "'.'", "':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'move '", "'leftCircle '", "'rightCircle '", null, "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Sqrt", "Return", "Equals", "Plus", "Minus", "Times", "Divide", 
			"And", "Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True", 
			"False", "INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", 
			"While", "If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", 
			"MoveCommand", "LeftCircleCommand", "RightCircleCommand", "Type", "AbsoluteParameter", 
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2)\u012d\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\3\2\3\2"+
		"\3\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3"+
		"\7\3\7\3\b\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3\f\3\r"+
		"\3\r\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\21\6\21\u0089\n\21\r\21\16\21\u008a\3\21\6\21\u008e\n\21\r\21\16\21"+
		"\u008f\3\21\3\21\5\21\u0094\n\21\3\21\5\21\u0097\n\21\3\21\5\21\u009a"+
		"\n\21\3\21\5\21\u009d\n\21\5\21\u009f\n\21\3\22\3\22\3\23\3\23\3\24\3"+
		"\24\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\30\3\30\3"+
		"\31\3\31\3\32\3\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\36\3\36\3"+
		"\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3"+
		" \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\5!\u00f2\n!\3\"\3\"\3#\3#\3$\3$\3$\3$"+
		"\3$\7$\u00fd\n$\f$\16$\u0100\13$\3$\3$\3%\3%\3%\3%\3&\3&\3&\3&\7&\u010c"+
		"\n&\f&\16&\u010f\13&\3\'\3\'\7\'\u0113\n\'\f\'\16\'\u0116\13\'\3\'\3\'"+
		"\7\'\u011a\n\'\f\'\16\'\u011d\13\'\3\'\3\'\6\'\u0121\n\'\r\'\16\'\u0122"+
		"\3(\5(\u0126\n(\3)\3)\3*\3*\3*\3*\2\2+\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21"+
		"\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30"+
		"/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O\2Q\2S)\3\2\6"+
		"\5\2KLTTZ\\\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u013f\2\3\3\2\2\2\2"+
		"\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2"+
		"\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2"+
		"\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2"+
		"\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2"+
		"\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2"+
		"\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2"+
		"K\3\2\2\2\2M\3\2\2\2\2S\3\2\2\2\3U\3\2\2\2\5Z\3\2\2\2\7b\3\2\2\2\td\3"+
		"\2\2\2\13f\3\2\2\2\rh\3\2\2\2\17j\3\2\2\2\21l\3\2\2\2\23o\3\2\2\2\25r"+
		"\3\2\2\2\27u\3\2\2\2\31x\3\2\2\2\33z\3\2\2\2\35|\3\2\2\2\37\u0081\3\2"+
		"\2\2!\u009e\3\2\2\2#\u00a0\3\2\2\2%\u00a2\3\2\2\2\'\u00a4\3\2\2\2)\u00a6"+
		"\3\2\2\2+\u00a8\3\2\2\2-\u00ae\3\2\2\2/\u00b1\3\2\2\2\61\u00b3\3\2\2\2"+
		"\63\u00b5\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb\3\2\2\2;\u00bd"+
		"\3\2\2\2=\u00c3\3\2\2\2?\u00cf\3\2\2\2A\u00f1\3\2\2\2C\u00f3\3\2\2\2E"+
		"\u00f5\3\2\2\2G\u00f7\3\2\2\2I\u0103\3\2\2\2K\u0107\3\2\2\2M\u0110\3\2"+
		"\2\2O\u0125\3\2\2\2Q\u0127\3\2\2\2S\u0129\3\2\2\2UV\7u\2\2VW\7s\2\2WX"+
		"\7t\2\2XY\7v\2\2Y\4\3\2\2\2Z[\7t\2\2[\\\7g\2\2\\]\7v\2\2]^\7w\2\2^_\7"+
		"t\2\2_`\7p\2\2`a\7\"\2\2a\6\3\2\2\2bc\7?\2\2c\b\3\2\2\2de\7-\2\2e\n\3"+
		"\2\2\2fg\7/\2\2g\f\3\2\2\2hi\7,\2\2i\16\3\2\2\2jk\7\61\2\2k\20\3\2\2\2"+
		"lm\7(\2\2mn\7(\2\2n\22\3\2\2\2op\7~\2\2pq\7~\2\2q\24\3\2\2\2rs\7?\2\2"+
		"st\7?\2\2t\26\3\2\2\2uv\7#\2\2vw\7?\2\2w\30\3\2\2\2xy\7@\2\2y\32\3\2\2"+
		"\2z{\7>\2\2{\34\3\2\2\2|}\7v\2\2}~\7t\2\2~\177\7w\2\2\177\u0080\7g\2\2"+
		"\u0080\36\3\2\2\2\u0081\u0082\7h\2\2\u0082\u0083\7c\2\2\u0083\u0084\7"+
		"n\2\2\u0084\u0085\7u\2\2\u0085\u0086\7g\2\2\u0086 \3\2\2\2\u0087\u0089"+
		"\5Q)\2\u0088\u0087\3\2\2\2\u0089\u008a\3\2\2\2\u008a\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u009f\3\2\2\2\u008c\u008e\5Q)\2\u008d\u008c\3\2\2"+
		"\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2\2\u008f\u0090\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u0093\5\'\24\2\u0092\u0094\5Q)\2\u0093\u0092\3\2\2\2\u0093"+
		"\u0094\3\2\2\2\u0094\u0096\3\2\2\2\u0095\u0097\5Q)\2\u0096\u0095\3\2\2"+
		"\2\u0096\u0097\3\2\2\2\u0097\u0099\3\2\2\2\u0098\u009a\5Q)\2\u0099\u0098"+
		"\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d\5Q)\2\u009c"+
		"\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e\u0088\3\2"+
		"\2\2\u009e\u008d\3\2\2\2\u009f\"\3\2\2\2\u00a0\u00a1\7=\2\2\u00a1$\3\2"+
		"\2\2\u00a2\u00a3\7.\2\2\u00a3&\3\2\2\2\u00a4\u00a5\7\60\2\2\u00a5(\3\2"+
		"\2\2\u00a6\u00a7\7<\2\2\u00a7*\3\2\2\2\u00a8\u00a9\7y\2\2\u00a9\u00aa"+
		"\7j\2\2\u00aa\u00ab\7k\2\2\u00ab\u00ac\7n\2\2\u00ac\u00ad\7g\2\2\u00ad"+
		",\3\2\2\2\u00ae\u00af\7k\2\2\u00af\u00b0\7h\2\2\u00b0.\3\2\2\2\u00b1\u00b2"+
		"\7*\2\2\u00b2\60\3\2\2\2\u00b3\u00b4\7+\2\2\u00b4\62\3\2\2\2\u00b5\u00b6"+
		"\7]\2\2\u00b6\64\3\2\2\2\u00b7\u00b8\7_\2\2\u00b8\66\3\2\2\2\u00b9\u00ba"+
		"\7}\2\2\u00ba8\3\2\2\2\u00bb\u00bc\7\177\2\2\u00bc:\3\2\2\2\u00bd\u00be"+
		"\7o\2\2\u00be\u00bf\7q\2\2\u00bf\u00c0\7x\2\2\u00c0\u00c1\7g\2\2\u00c1"+
		"\u00c2\7\"\2\2\u00c2<\3\2\2\2\u00c3\u00c4\7n\2\2\u00c4\u00c5\7g\2\2\u00c5"+
		"\u00c6\7h\2\2\u00c6\u00c7\7v\2\2\u00c7\u00c8\7E\2\2\u00c8\u00c9\7k\2\2"+
		"\u00c9\u00ca\7t\2\2\u00ca\u00cb\7e\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd"+
		"\7g\2\2\u00cd\u00ce\7\"\2\2\u00ce>\3\2\2\2\u00cf\u00d0\7t\2\2\u00d0\u00d1"+
		"\7k\2\2\u00d1\u00d2\7i\2\2\u00d2\u00d3\7j\2\2\u00d3\u00d4\7v\2\2\u00d4"+
		"\u00d5\7E\2\2\u00d5\u00d6\7k\2\2\u00d6\u00d7\7t\2\2\u00d7\u00d8\7e\2\2"+
		"\u00d8\u00d9\7n\2\2\u00d9\u00da\7g\2\2\u00da\u00db\7\"\2\2\u00db@\3\2"+
		"\2\2\u00dc\u00dd\7p\2\2\u00dd\u00de\7w\2\2\u00de\u00df\7o\2\2\u00df\u00f2"+
		"\7\"\2\2\u00e0\u00e1\7x\2\2\u00e1\u00e2\7g\2\2\u00e2\u00e3\7e\2\2\u00e3"+
		"\u00e4\7v\2\2\u00e4\u00e5\7q\2\2\u00e5\u00e6\7t\2\2\u00e6\u00f2\7\"\2"+
		"\2\u00e7\u00e8\7d\2\2\u00e8\u00e9\7q\2\2\u00e9\u00ea\7q\2\2\u00ea\u00eb"+
		"\7n\2\2\u00eb\u00f2\7\"\2\2\u00ec\u00ed\7x\2\2\u00ed\u00ee\7q\2\2\u00ee"+
		"\u00ef\7k\2\2\u00ef\u00f0\7f\2\2\u00f0\u00f2\7\"\2\2\u00f1\u00dc\3\2\2"+
		"\2\u00f1\u00e0\3\2\2\2\u00f1\u00e7\3\2\2\2\u00f1\u00ec\3\2\2\2\u00f2B"+
		"\3\2\2\2\u00f3\u00f4\7&\2\2\u00f4D\3\2\2\2\u00f5\u00f6\t\2\2\2\u00f6F"+
		"\3\2\2\2\u00f7\u00fe\7B\2\2\u00f8\u00fd\5O(\2\u00f9\u00fd\5Q)\2\u00fa"+
		"\u00fd\5S*\2\u00fb\u00fd\5I%\2\u00fc\u00f8\3\2\2\2\u00fc\u00f9\3\2\2\2"+
		"\u00fc\u00fa\3\2\2\2\u00fc\u00fb\3\2\2\2\u00fd\u0100\3\2\2\2\u00fe\u00fc"+
		"\3\2\2\2\u00fe\u00ff\3\2\2\2\u00ff\u0101\3\2\2\2\u0100\u00fe\3\2\2\2\u0101"+
		"\u0102\7B\2\2\u0102H\3\2\2\2\u0103\u0104\7}\2\2\u0104\u0105\5K&\2\u0105"+
		"\u0106\7\177\2\2\u0106J\3\2\2\2\u0107\u010d\5O(\2\u0108\u010c\5O(\2\u0109"+
		"\u010c\5Q)\2\u010a\u010c\7a\2\2\u010b\u0108\3\2\2\2\u010b\u0109\3\2\2"+
		"\2\u010b\u010a\3\2\2\2\u010c\u010f\3\2\2\2\u010d\u010b\3\2\2\2\u010d\u010e"+
		"\3\2\2\2\u010eL\3\2\2\2\u010f\u010d\3\2\2\2\u0110\u0114\5K&\2\u0111\u0113"+
		"\5S*\2\u0112\u0111\3\2\2\2\u0113\u0116\3\2\2\2\u0114\u0112\3\2\2\2\u0114"+
		"\u0115\3\2\2\2\u0115\u0117\3\2\2\2\u0116\u0114\3\2\2\2\u0117\u011b\5)"+
		"\25\2\u0118\u011a\5S*\2\u0119\u0118\3\2\2\2\u011a\u011d\3\2\2\2\u011b"+
		"\u0119\3\2\2\2\u011b\u011c\3\2\2\2\u011c\u0120\3\2\2\2\u011d\u011b\3\2"+
		"\2\2\u011e\u0121\5O(\2\u011f\u0121\5Q)\2\u0120\u011e\3\2\2\2\u0120\u011f"+
		"\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123"+
		"N\3\2\2\2\u0124\u0126\t\3\2\2\u0125\u0124\3\2\2\2\u0126P\3\2\2\2\u0127"+
		"\u0128\t\4\2\2\u0128R\3\2\2\2\u0129\u012a\t\5\2\2\u012a\u012b\3\2\2\2"+
		"\u012b\u012c\b*\2\2\u012cT\3\2\2\2\24\2\u008a\u008f\u0093\u0096\u0099"+
		"\u009c\u009e\u00f1\u00fc\u00fe\u010b\u010d\u0114\u011b\u0120\u0122\u0125"+
		"\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}