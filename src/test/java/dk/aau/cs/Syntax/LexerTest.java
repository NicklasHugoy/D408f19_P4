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


    @Disabled
    @Test
    void getRuleName(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String[] rules = {
                "Return", "Equals", "Plus", "Minus", "Times", "Divide", "And", "Or",
                "Equality", "InEquality", "GreaterThan", "LessThan", "True", "False",
                "INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", "While",
                "If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", "MoveCommand",
                "LeftCircleCommand", "RightCircleCommand", "Type", "AbsoluteParameter",
                "CommandParameter", "ID", "Letter", "Digit", "WS"
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

    @Disabled
    @Test
    void getATN(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals(35, lexer.getATN().maxTokenType);
    }

    @Test
    void getVocabulary01(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'<'", lexer.getVocabulary().getDisplayName(12));
    }

    @Test
    void getVocabulary02(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'*'", lexer.getVocabulary().getDisplayName(5));
    }

    @Test
    void getVocabulary03(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'move '", lexer.getVocabulary().getDisplayName(28));
    }

    @Test
    void getVocabulary04(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("','", lexer.getVocabulary().getDisplayName(17));
    }

    @Test
    void getVocabulary05(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        assertEquals("'=='", lexer.getVocabulary().getDisplayName(9));
    }

    @Disabled
    @Test
    void getTokenNames(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String[] tokens = {
                "<INVALID>", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'",
                "'=='", "'!='", "'>'", "'<'", "'true'", "'false'", "INT", "';'", "','",
                "'.'", "':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", "'}'",
                "'move '", "'leftCircle '", "'rightCircle '", "Type", "'$'", "CommandParameter",
                "ID", "WS"
        };

        assertEquals(Arrays.toString(tokens), Arrays.toString(lexer.getTokenNames()));
    }

    @Disabled
    @Test
    void getSerializedATN(){
        CharStream cs = CharStreams.fromString("");
        GMMLexer lexer = getLexer(cs);

        String ATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\2%\u00f8\b\1\4\2\t"+
                "\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
                "\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
                "\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
                "\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
                "\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3\2\3"+
                "\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\t\3\n\3\n"+
                "\3\n\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\17\3\17"+
                "\3\17\3\17\3\17\3\17\3\20\6\20|\n\20\r\20\16\20}\3\20\3\20\3\20\5\20\u0083"+
                "\n\20\3\20\5\20\u0086\n\20\3\20\5\20\u0089\n\20\3\20\5\20\u008c\n\20\5"+
                "\20\u008e\n\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3\25\3\25"+
                "\3\25\3\25\3\25\3\26\3\26\3\26\3\27\3\27\3\30\3\30\3\31\3\31\3\32\3\32"+
                "\3\33\3\33\3\34\3\34\3\35\3\35\3\35\3\35\3\35\3\35\3\36\3\36\3\36\3\36"+
                "\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\36\3\37\3\37\3\37\3\37\3\37\3\37"+
                "\3\37\3\37\3\37\3\37\3\37\3\37\3\37\3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3 \3"+
                " \3 \3 \3 \3 \3 \3 \3 \3 \3 \5 \u00e1\n \3!\3!\3\"\3\"\3#\3#\3#\3#\7#"+
                "\u00eb\n#\f#\16#\u00ee\13#\3$\5$\u00f1\n$\3%\3%\3&\3&\3&\3&\2\2\'\3\3"+
                "\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
                "!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
                "A\"C#E$G\2I\2K%\3\2\6\5\2KLTTZ\\\4\2C\\c|\3\2\62;\5\2\13\f\17\17\"\"\2"+
                "\u0101\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2"+
                "\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3"+
                "\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2"+
                "\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2"+
                "/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2"+
                "\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2\2"+
                "K\3\2\2\2\3M\3\2\2\2\5U\3\2\2\2\7W\3\2\2\2\tY\3\2\2\2\13[\3\2\2\2\r]\3"+
                "\2\2\2\17_\3\2\2\2\21b\3\2\2\2\23e\3\2\2\2\25h\3\2\2\2\27k\3\2\2\2\31"+
                "m\3\2\2\2\33o\3\2\2\2\35t\3\2\2\2\37\u008d\3\2\2\2!\u008f\3\2\2\2#\u0091"+
                "\3\2\2\2%\u0093\3\2\2\2\'\u0095\3\2\2\2)\u0097\3\2\2\2+\u009d\3\2\2\2"+
                "-\u00a0\3\2\2\2/\u00a2\3\2\2\2\61\u00a4\3\2\2\2\63\u00a6\3\2\2\2\65\u00a8"+
                "\3\2\2\2\67\u00aa\3\2\2\29\u00ac\3\2\2\2;\u00b2\3\2\2\2=\u00be\3\2\2\2"+
                "?\u00e0\3\2\2\2A\u00e2\3\2\2\2C\u00e4\3\2\2\2E\u00e6\3\2\2\2G\u00f0\3"+
                "\2\2\2I\u00f2\3\2\2\2K\u00f4\3\2\2\2MN\7t\2\2NO\7g\2\2OP\7v\2\2PQ\7w\2"+
                "\2QR\7t\2\2RS\7p\2\2ST\7\"\2\2T\4\3\2\2\2UV\7?\2\2V\6\3\2\2\2WX\7-\2\2"+
                "X\b\3\2\2\2YZ\7/\2\2Z\n\3\2\2\2[\\\7,\2\2\\\f\3\2\2\2]^\7\61\2\2^\16\3"+
                "\2\2\2_`\7(\2\2`a\7(\2\2a\20\3\2\2\2bc\7~\2\2cd\7~\2\2d\22\3\2\2\2ef\7"+
                "?\2\2fg\7?\2\2g\24\3\2\2\2hi\7#\2\2ij\7?\2\2j\26\3\2\2\2kl\7@\2\2l\30"+
                "\3\2\2\2mn\7>\2\2n\32\3\2\2\2op\7v\2\2pq\7t\2\2qr\7w\2\2rs\7g\2\2s\34"+
                "\3\2\2\2tu\7h\2\2uv\7c\2\2vw\7n\2\2wx\7u\2\2xy\7g\2\2y\36\3\2\2\2z|\5"+
                "I%\2{z\3\2\2\2|}\3\2\2\2}{\3\2\2\2}~\3\2\2\2~\u008e\3\2\2\2\177\u0080"+
                "\5I%\2\u0080\u0082\5%\23\2\u0081\u0083\5I%\2\u0082\u0081\3\2\2\2\u0082"+
                "\u0083\3\2\2\2\u0083\u0085\3\2\2\2\u0084\u0086\5I%\2\u0085\u0084\3\2\2"+
                "\2\u0085\u0086\3\2\2\2\u0086\u0088\3\2\2\2\u0087\u0089\5I%\2\u0088\u0087"+
                "\3\2\2\2\u0088\u0089\3\2\2\2\u0089\u008b\3\2\2\2\u008a\u008c\5I%\2\u008b"+
                "\u008a\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u008e\3\2\2\2\u008d{\3\2\2\2"+
                "\u008d\177\3\2\2\2\u008e \3\2\2\2\u008f\u0090\7=\2\2\u0090\"\3\2\2\2\u0091"+
                "\u0092\7.\2\2\u0092$\3\2\2\2\u0093\u0094\7\60\2\2\u0094&\3\2\2\2\u0095"+
                "\u0096\7<\2\2\u0096(\3\2\2\2\u0097\u0098\7y\2\2\u0098\u0099\7j\2\2\u0099"+
                "\u009a\7k\2\2\u009a\u009b\7n\2\2\u009b\u009c\7g\2\2\u009c*\3\2\2\2\u009d"+
                "\u009e\7k\2\2\u009e\u009f\7h\2\2\u009f,\3\2\2\2\u00a0\u00a1\7*\2\2\u00a1"+
                ".\3\2\2\2\u00a2\u00a3\7+\2\2\u00a3\60\3\2\2\2\u00a4\u00a5\7]\2\2\u00a5"+
                "\62\3\2\2\2\u00a6\u00a7\7_\2\2\u00a7\64\3\2\2\2\u00a8\u00a9\7}\2\2\u00a9"+
                "\66\3\2\2\2\u00aa\u00ab\7\177\2\2\u00ab8\3\2\2\2\u00ac\u00ad\7o\2\2\u00ad"+
                "\u00ae\7q\2\2\u00ae\u00af\7x\2\2\u00af\u00b0\7g\2\2\u00b0\u00b1\7\"\2"+
                "\2\u00b1:\3\2\2\2\u00b2\u00b3\7n\2\2\u00b3\u00b4\7g\2\2\u00b4\u00b5\7"+
                "h\2\2\u00b5\u00b6\7v\2\2\u00b6\u00b7\7E\2\2\u00b7\u00b8\7k\2\2\u00b8\u00b9"+
                "\7t\2\2\u00b9\u00ba\7e\2\2\u00ba\u00bb\7n\2\2\u00bb\u00bc\7g\2\2\u00bc"+
                "\u00bd\7\"\2\2\u00bd<\3\2\2\2\u00be\u00bf\7t\2\2\u00bf\u00c0\7k\2\2\u00c0"+
                "\u00c1\7i\2\2\u00c1\u00c2\7j\2\2\u00c2\u00c3\7v\2\2\u00c3\u00c4\7E\2\2"+
                "\u00c4\u00c5\7k\2\2\u00c5\u00c6\7t\2\2\u00c6\u00c7\7e\2\2\u00c7\u00c8"+
                "\7n\2\2\u00c8\u00c9\7g\2\2\u00c9\u00ca\7\"\2\2\u00ca>\3\2\2\2\u00cb\u00cc"+
                "\7p\2\2\u00cc\u00cd\7w\2\2\u00cd\u00ce\7o\2\2\u00ce\u00e1\7\"\2\2\u00cf"+
                "\u00d0\7x\2\2\u00d0\u00d1\7g\2\2\u00d1\u00d2\7e\2\2\u00d2\u00d3\7v\2\2"+
                "\u00d3\u00d4\7q\2\2\u00d4\u00d5\7t\2\2\u00d5\u00e1\7\"\2\2\u00d6\u00d7"+
                "\7d\2\2\u00d7\u00d8\7q\2\2\u00d8\u00d9\7q\2\2\u00d9\u00da\7n\2\2\u00da"+
                "\u00e1\7\"\2\2\u00db\u00dc\7x\2\2\u00dc\u00dd\7q\2\2\u00dd\u00de\7k\2"+
                "\2\u00de\u00df\7f\2\2\u00df\u00e1\7\"\2\2\u00e0\u00cb\3\2\2\2\u00e0\u00cf"+
                "\3\2\2\2\u00e0\u00d6\3\2\2\2\u00e0\u00db\3\2\2\2\u00e1@\3\2\2\2\u00e2"+
                "\u00e3\7&\2\2\u00e3B\3\2\2\2\u00e4\u00e5\t\2\2\2\u00e5D\3\2\2\2\u00e6"+
                "\u00ec\5G$\2\u00e7\u00eb\5G$\2\u00e8\u00eb\5I%\2\u00e9\u00eb\7a\2\2\u00ea"+
                "\u00e7\3\2\2\2\u00ea\u00e8\3\2\2\2\u00ea\u00e9\3\2\2\2\u00eb\u00ee\3\2"+
                "\2\2\u00ec\u00ea\3\2\2\2\u00ec\u00ed\3\2\2\2\u00edF\3\2\2\2\u00ee\u00ec"+
                "\3\2\2\2\u00ef\u00f1\t\3\2\2\u00f0\u00ef\3\2\2\2\u00f1H\3\2\2\2\u00f2"+
                "\u00f3\t\4\2\2\u00f3J\3\2\2\2\u00f4\u00f5\t\5\2\2\u00f5\u00f6\3\2\2\2"+
                "\u00f6\u00f7\b&\2\2\u00f7L\3\2\2\2\r\2}\u0082\u0085\u0088\u008b\u008d"+
                "\u00e0\u00ea\u00ec\u00f0\3\b\2\2";

        assertEquals(ATN, lexer.getSerializedATN());
    }
}