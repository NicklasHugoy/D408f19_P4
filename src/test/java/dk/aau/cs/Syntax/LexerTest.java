package dk.aau.cs.Syntax;

import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class LexerTest {
    GMMLexer getLexer(CharStream cs) {
        return new GMMLexer(cs);
    }
    //TODO: fix disabled test when impl is finalized

    @Test
    void getRuleName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String[] rules = {
                "Range", "Sqrt", "Return", "Equals", "Plus", "Minus", "Times", "Divide",
                "And", "Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True",
                "False", "INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon",
                "Loop", "If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl",
                "RapidMoveCommand", "MoveCommand", "LeftCircleCommand", "RightCircleCommand",
                "Type", "CommandParameter", "GCode", "GCodeVarRef", "ID", "BlockParam",
                "Letter", "Digit", "WS"
        };

        assertEquals(Arrays.toString(rules), Arrays.toString(lexer.getRuleNames()));
    }

    @Test
    void getChannelName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("[DEFAULT_TOKEN_CHANNEL, HIDDEN]", Arrays.toString(lexer.getChannelNames()));
    }

    @Test
    void getMode(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("[DEFAULT_MODE]", Arrays.toString(lexer.getModeNames()));
    }

    @Test
    void getFileName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("GMM.g4", lexer.getGrammarFileName());
    }

    @Test
    void getATN(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals(40, lexer.getATN().maxTokenType);
    }

    @Test
    void getVocabulary01(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'>'", lexer.getVocabulary().getDisplayName(13));
    }

    @Test
    void getVocabulary02(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'-'", lexer.getVocabulary().getDisplayName(6));
    }

    @Test
    void getVocabulary03(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'jump '", lexer.getVocabulary().getDisplayName(30));
    }

    @Test
    void getVocabulary04(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("';'", lexer.getVocabulary().getDisplayName(18));
    }

    @Test
    void getVocabulary05(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'||'", lexer.getVocabulary().getDisplayName(10));
    }

    @Test
    void getTokenNames(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String[] tokens = {
                "<INVALID>", "'..'", "'sqrt'", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", "'=='", "'!='",
                "'>'", "'<'", "'true'", "'false'", "INT", "';'", "','", "'.'", "':'", "'loop'", "'if'",
                "'(', ')'", "'[', ']'", "'{', '}'", "'jump '", "'move '", "'leftCircle '", "'rightCircle '",
                "Type", "CommandParameter", "GCode", "GCodeVarRef", "ID", "BlockParam", "WS"
        };

        assertEquals(Arrays.toString(tokens), Arrays.toString(lexer.getTokenNames()));
    }

    @Test
    void getSerializedATN(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String ATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2*\u0133\b\1\4\2\t"+
                "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
                "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
                "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
                "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
                "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\3"+
                "\2\3\2\3\2\3\3\3\3\3\3\3\3\3\3\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\4\3\5\3\5"+
                "\3\6\3\6\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13\3\f\3\f\3"+
                "\f\3\r\3\r\3\r\3\16\3\16\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
                "\3\21\3\21\3\21\3\21\3\22\6\22\u008e\n\22\r\22\16\22\u008f\3\22\6\22\u0093"+
                "\n\22\r\22\16\22\u0094\3\22\3\22\3\22\5\22\u009a\n\22\3\22\5\22\u009d"+
                "\n\22\3\22\5\22\u00a0\n\22\5\22\u00a2\n\22\3\23\3\23\3\24\3\24\3\25\3"+
                "\25\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3"+
                "\32\3\33\3\33\3\34\3\34\3\35\3\35\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3"+
                "\37\3 \3 \3 \3 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3!\3\"\3\"\3\""+
                "\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3\"\3#\3#\3#\3#\3#\3#\3#\3#\3#\3"+
                "#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\3#\5#\u00fa\n#\3$\3$\3%\3%\3%\3%\3%\7"+
                "%\u0103\n%\f%\16%\u0106\13%\3%\3%\3&\3&\3&\3&\3\'\3\'\3\'\3\'\7\'\u0112"+
                "\n\'\f\'\16\'\u0115\13\'\3(\3(\7(\u0119\n(\f(\16(\u011c\13(\3(\3(\7(\u0120"+
                "\n(\f(\16(\u0123\13(\3(\3(\6(\u0127\n(\r(\16(\u0128\3)\5)\u012c\n)\3*"+
                "\3*\3+\3+\3+\3+\2\2,\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27"+
                "\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33"+
                "\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q\2S\2U*\3\2\6\5\2KLTTZ\\\4"+
                "\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2\u0144\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
                "\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
                "\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
                "\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
                "\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
                "\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2"+
                "\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M"+
                "\3\2\2\2\2O\3\2\2\2\2U\3\2\2\2\3W\3\2\2\2\5Z\3\2\2\2\7_\3\2\2\2\tg\3\2"+
                "\2\2\13i\3\2\2\2\rk\3\2\2\2\17m\3\2\2\2\21o\3\2\2\2\23q\3\2\2\2\25t\3"+
                "\2\2\2\27w\3\2\2\2\31z\3\2\2\2\33}\3\2\2\2\35\177\3\2\2\2\37\u0081\3\2"+
                "\2\2!\u0086\3\2\2\2#\u00a1\3\2\2\2%\u00a3\3\2\2\2\'\u00a5\3\2\2\2)\u00a7"+
                "\3\2\2\2+\u00a9\3\2\2\2-\u00ab\3\2\2\2/\u00b0\3\2\2\2\61\u00b3\3\2\2\2"+
                "\63\u00b5\3\2\2\2\65\u00b7\3\2\2\2\67\u00b9\3\2\2\29\u00bb\3\2\2\2;\u00bd"+
                "\3\2\2\2=\u00bf\3\2\2\2?\u00c5\3\2\2\2A\u00cb\3\2\2\2C\u00d7\3\2\2\2E"+
                "\u00f9\3\2\2\2G\u00fb\3\2\2\2I\u00fd\3\2\2\2K\u0109\3\2\2\2M\u010d\3\2"+
                "\2\2O\u0116\3\2\2\2Q\u012b\3\2\2\2S\u012d\3\2\2\2U\u012f\3\2\2\2WX\7\60"+
                "\2\2XY\7\60\2\2Y\4\3\2\2\2Z[\7u\2\2[\\\7s\2\2\\]\7t\2\2]^\7v\2\2^\6\3"+
                "\2\2\2_`\7t\2\2`a\7g\2\2ab\7v\2\2bc\7w\2\2cd\7t\2\2de\7p\2\2ef\7\"\2\2"+
                "f\b\3\2\2\2gh\7?\2\2h\n\3\2\2\2ij\7-\2\2j\f\3\2\2\2kl\7/\2\2l\16\3\2\2"+
                "\2mn\7,\2\2n\20\3\2\2\2op\7\61\2\2p\22\3\2\2\2qr\7(\2\2rs\7(\2\2s\24\3"+
                "\2\2\2tu\7~\2\2uv\7~\2\2v\26\3\2\2\2wx\7?\2\2xy\7?\2\2y\30\3\2\2\2z{\7"+
                "#\2\2{|\7?\2\2|\32\3\2\2\2}~\7@\2\2~\34\3\2\2\2\177\u0080\7>\2\2\u0080"+
                "\36\3\2\2\2\u0081\u0082\7v\2\2\u0082\u0083\7t\2\2\u0083\u0084\7w\2\2\u0084"+
                "\u0085\7g\2\2\u0085 \3\2\2\2\u0086\u0087\7h\2\2\u0087\u0088\7c\2\2\u0088"+
                "\u0089\7n\2\2\u0089\u008a\7u\2\2\u008a\u008b\7g\2\2\u008b\"\3\2\2\2\u008c"+
                "\u008e\5S*\2\u008d\u008c\3\2\2\2\u008e\u008f\3\2\2\2\u008f\u008d\3\2\2"+
                "\2\u008f\u0090\3\2\2\2\u0090\u00a2\3\2\2\2\u0091\u0093\5S*\2\u0092\u0091"+
                "\3\2\2\2\u0093\u0094\3\2\2\2\u0094\u0092\3\2\2\2\u0094\u0095\3\2\2\2\u0095"+
                "\u0096\3\2\2\2\u0096\u0097\5)\25\2\u0097\u0099\5S*\2\u0098\u009a\5S*\2"+
                "\u0099\u0098\3\2\2\2\u0099\u009a\3\2\2\2\u009a\u009c\3\2\2\2\u009b\u009d"+
                "\5S*\2\u009c\u009b\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2\2\2\u009e"+
                "\u00a0\5S*\2\u009f\u009e\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00a2\3\2\2"+
                "\2\u00a1\u008d\3\2\2\2\u00a1\u0092\3\2\2\2\u00a2$\3\2\2\2\u00a3\u00a4"+
                "\7=\2\2\u00a4&\3\2\2\2\u00a5\u00a6\7.\2\2\u00a6(\3\2\2\2\u00a7\u00a8\7"+
                "\60\2\2\u00a8*\3\2\2\2\u00a9\u00aa\7<\2\2\u00aa,\3\2\2\2\u00ab\u00ac\7"+
                "n\2\2\u00ac\u00ad\7q\2\2\u00ad\u00ae\7q\2\2\u00ae\u00af\7r\2\2\u00af."+
                "\3\2\2\2\u00b0\u00b1\7k\2\2\u00b1\u00b2\7h\2\2\u00b2\60\3\2\2\2\u00b3"+
                "\u00b4\7*\2\2\u00b4\62\3\2\2\2\u00b5\u00b6\7+\2\2\u00b6\64\3\2\2\2\u00b7"+
                "\u00b8\7]\2\2\u00b8\66\3\2\2\2\u00b9\u00ba\7_\2\2\u00ba8\3\2\2\2\u00bb"+
                "\u00bc\7}\2\2\u00bc:\3\2\2\2\u00bd\u00be\7\177\2\2\u00be<\3\2\2\2\u00bf"+
                "\u00c0\7l\2\2\u00c0\u00c1\7w\2\2\u00c1\u00c2\7o\2\2\u00c2\u00c3\7r\2\2"+
                "\u00c3\u00c4\7\"\2\2\u00c4>\3\2\2\2\u00c5\u00c6\7o\2\2\u00c6\u00c7\7q"+
                "\2\2\u00c7\u00c8\7x\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7\"\2\2\u00ca@"+
                "\3\2\2\2\u00cb\u00cc\7n\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7h\2\2\u00ce"+
                "\u00cf\7v\2\2\u00cf\u00d0\7E\2\2\u00d0\u00d1\7k\2\2\u00d1\u00d2\7t\2\2"+
                "\u00d2\u00d3\7e\2\2\u00d3\u00d4\7n\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6"+
                "\7\"\2\2\u00d6B\3\2\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da"+
                "\7i\2\2\u00da\u00db\7j\2\2\u00db\u00dc\7v\2\2\u00dc\u00dd\7E\2\2\u00dd"+
                "\u00de\7k\2\2\u00de\u00df\7t\2\2\u00df\u00e0\7e\2\2\u00e0\u00e1\7n\2\2"+
                "\u00e1\u00e2\7g\2\2\u00e2\u00e3\7\"\2\2\u00e3D\3\2\2\2\u00e4\u00e5\7p"+
                "\2\2\u00e5\u00e6\7w\2\2\u00e6\u00e7\7o\2\2\u00e7\u00fa\7\"\2\2\u00e8\u00e9"+
                "\7x\2\2\u00e9\u00ea\7g\2\2\u00ea\u00eb\7e\2\2\u00eb\u00ec\7v\2\2\u00ec"+
                "\u00ed\7q\2\2\u00ed\u00ee\7t\2\2\u00ee\u00fa\7\"\2\2\u00ef\u00f0\7d\2"+
                "\2\u00f0\u00f1\7q\2\2\u00f1\u00f2\7q\2\2\u00f2\u00f3\7n\2\2\u00f3\u00fa"+
                "\7\"\2\2\u00f4\u00f5\7x\2\2\u00f5\u00f6\7q\2\2\u00f6\u00f7\7k\2\2\u00f7"+
                "\u00f8\7f\2\2\u00f8\u00fa\7\"\2\2\u00f9\u00e4\3\2\2\2\u00f9\u00e8\3\2"+
                "\2\2\u00f9\u00ef\3\2\2\2\u00f9\u00f4\3\2\2\2\u00faF\3\2\2\2\u00fb\u00fc"+
                "\t\2\2\2\u00fcH\3\2\2\2\u00fd\u0104\7B\2\2\u00fe\u0103\5Q)\2\u00ff\u0103"+
                "\5S*\2\u0100\u0103\5U+\2\u0101\u0103\5K&\2\u0102\u00fe\3\2\2\2\u0102\u00ff"+
                "\3\2\2\2\u0102\u0100\3\2\2\2\u0102\u0101\3\2\2\2\u0103\u0106\3\2\2\2\u0104"+
                "\u0102\3\2\2\2\u0104\u0105\3\2\2\2\u0105\u0107\3\2\2\2\u0106\u0104\3\2"+
                "\2\2\u0107\u0108\7B\2\2\u0108J\3\2\2\2\u0109\u010a\7}\2\2\u010a\u010b"+
                "\5M\'\2\u010b\u010c\7\177\2\2\u010cL\3\2\2\2\u010d\u0113\5Q)\2\u010e\u0112"+
                "\5Q)\2\u010f\u0112\5S*\2\u0110\u0112\7a\2\2\u0111\u010e\3\2\2\2\u0111"+
                "\u010f\3\2\2\2\u0111\u0110\3\2\2\2\u0112\u0115\3\2\2\2\u0113\u0111\3\2"+
                "\2\2\u0113\u0114\3\2\2\2\u0114N\3\2\2\2\u0115\u0113\3\2\2\2\u0116\u011a"+
                "\5M\'\2\u0117\u0119\5U+\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a"+
                "\u0118\3\2\2\2\u011a\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2"+
                "\2\2\u011d\u0121\5+\26\2\u011e\u0120\5U+\2\u011f\u011e\3\2\2\2\u0120\u0123"+
                "\3\2\2\2\u0121\u011f\3\2\2\2\u0121\u0122\3\2\2\2\u0122\u0126\3\2\2\2\u0123"+
                "\u0121\3\2\2\2\u0124\u0127\5Q)\2\u0125\u0127\5S*\2\u0126\u0124\3\2\2\2"+
                "\u0126\u0125\3\2\2\2\u0127\u0128\3\2\2\2\u0128\u0126\3\2\2\2\u0128\u0129"+
                "\3\2\2\2\u0129P\3\2\2\2\u012a\u012c\t\3\2\2\u012b\u012a\3\2\2\2\u012c"+
                "R\3\2\2\2\u012d\u012e\t\4\2\2\u012eT\3\2\2\2\u012f\u0130\t\5\2\2\u0130"+
                "\u0131\3\2\2\2\u0131\u0132\b+\2\2\u0132V\3\2\2\2\23\2\u008f\u0094\u0099"+
                "\u009c\u009f\u00a1\u00f9\u0102\u0104\u0111\u0113\u011a\u0121\u0126\u0128"+
                "\u012b\3\b\2\2";

        assertEquals(ATN, lexer.getSerializedATN());
    }
}
