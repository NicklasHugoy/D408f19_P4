package dk.aau.cs.Syntax;

import dk.aau.cs.AST.Nodes.TypeNode;
import org.antlr.v4.runtime.*;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

public class ParserTest {

    GMMParser getParser(CharStream cs) {
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        return new GMMParser(ts);
    }


    @Disabled
    @Test
    void getRuleNames() {

        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String[] rules = {
                "prog", "functionDef", "blockDef", "formalParameters", "formalParameter",
                "machineOptions", "machineOption", "scopedStmt", "functionCall", "vectorCommandParameter",
                "singleCommandParameter", "parameters", "expression", "logic", "booleanExpr",
                "expr", "term", "factor"
        };


        assertEquals(Arrays.toString(rules), Arrays.toString(parser.getRuleNames()));
        assertEquals(17, parser.getRuleNames().length);
    }

    @Disabled
    @Test
    void getTokenNames() {
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String[] tokenNames = {
                "<INVALID>", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'",
                "'=='", "'!='", "'>'", "'<'", "'true'", "'false'", "INT", "';'", "','",
                "'.'", "':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", "'}'",
                "'move '", "'leftCircle '", "'rightCircle '", "Type", "'$'", "CommandParameter",
                "ID", "WS"
        };
        assertEquals(Arrays.toString(tokenNames), Arrays.toString(parser.getTokenNames()));
        assertEquals(36, parser.getTokenNames().length);
    }

    @Test
    void getGrammaFileName() {
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("GMM.g4", parser.getGrammarFileName());
    }

    @Disabled
    @Test
    void getVocabulary(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals(35, parser.getVocabulary().getMaxTokenType());
    }

    @Test
    void getVocabulary01(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("Return", parser.getVocabulary().getSymbolicName(2));
    }


    @Test
    void getVocabulary02(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("'-'", parser.getVocabulary().getLiteralName(5));

    }

    @Test
    void getVocabulary03(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("'/'", parser.getVocabulary().getDisplayName(7));
    }

    @Test
    void getFactorIndex(){
        CharStream cs = CharStreams.fromString("true");
        GMMParser parser = getParser(cs);

        assertEquals(17, parser.factor().getRuleIndex());
    }


    @Test
    void ruleStateAndParrent(){
        RuleContext parrentRule = new RuleContext();
        RuleContext rule = new RuleContext(parrentRule, 12);
        ParserRuleContext ps = new ParserRuleContext();
        assertEquals(12, rule.invokingState);
        assertEquals(parrentRule, rule.parent);
        assertEquals(1, parrentRule.depth());
    }

    @Test
    void functionDefCtx(){
        CharStream cs = CharStreams.fromString("num fac(num x){return x+2}");
        GMMParser parser = getParser(cs);
        GMMParser.FunctionDefContext fc = parser.functionDef();

        assertEquals(1, fc.getRuleIndex());
        assertEquals(parser.getTokenStream().get(0), fc.Type().getSymbol());
        assertEquals(parser.getTokenStream().get(1), fc.ID().getSymbol());
        assertEquals(parser.getTokenStream().get(6), fc.LCurl().getSymbol());
        assertEquals(parser.getTokenStream().get(11), fc.RCurl().getSymbol());
        assertEquals(parser.getTokenStream().get(2), fc.LParan().getSymbol());
        assertEquals(parser.getTokenStream().get(5), fc.RParan().getSymbol());
    }

    @Test
    void blockDefCtx(){
        CharStream cs = CharStreams.fromString("block[tool:1, bound_x:200]{x = 2}");
        GMMParser parser = getParser(cs);
        GMMParser.BlockDefContext blockDef = parser.blockDef();

        assertEquals(2, blockDef.getRuleIndex());
        assertEquals(parser.getTokenStream().get(0), blockDef.ID().getSymbol());
        assertEquals(parser.getTokenStream().get(1), blockDef.LSquare().getSymbol());
        assertEquals(parser.getTokenStream().get(5), blockDef.RSquare().getSymbol());
        assertEquals(parser.getTokenStream().get(6), blockDef.LCurl().getSymbol());
        assertEquals(parser.getTokenStream().get(10), blockDef.RCurl().getSymbol());
    }

    @Test
    void formalParameterCtx01(){
        CharStream cs = CharStreams.fromString("num fac(num x){return x+2}");
        GMMParser parser = getParser(cs);
        GMMParser.FormalParameterContext fp = parser.formalParameter();

        assertEquals(4, fp.getRuleIndex());
        assertEquals(parser.getTokenStream().get(1), fp.ID().getSymbol());
        assertEquals(parser.getTokenStream().get(0), fp.Type().getSymbol());
    }

    @Test
    void formalParameterCtx02(){
        CharStream cs = CharStreams.fromString("num fac(num x, num y){return x+2}");
        GMMParser parser = getParser(cs);
        GMMParser.FunctionDefContext fc = parser.functionDef();

        assertEquals(parser.getTokenStream().get(5), fc.formalParameters().CommaSeperator().get(0).getSymbol());
        assertEquals(parser.getTokenStream().get(3), fc.formalParameters().formalParameter().get(0).start);
        assertEquals(3, fc.formalParameters().getRuleIndex());

    }

    @Test
    void machineOptionCtx01(){
        CharStream cs = CharStreams.fromString("block[tool:1, bound_x:200]{x = 2}");
        GMMParser parser = getParser(cs);
        GMMParser.MachineOptionContext mc = parser.machineOption();

        assertEquals(6, mc.getRuleIndex());

        assertEquals(parser.getTokenStream().get(2), mc.BlockParam().getSymbol());
    }

    @Test
    void machineOptionCtx02(){
        CharStream cs = CharStreams.fromString("block[tool:1, bound_x:200]{x = 2}");
        GMMParser parser = getParser(cs);
        GMMParser.BlockDefContext blockDef = parser.blockDef();

        assertEquals(parser.getTokenStream().get(3), blockDef.machineOptions().CommaSeperator().get(0).getSymbol());
        assertEquals(parser.getTokenStream().get(2), blockDef.machineOptions().machineOption().get(0).start);
        assertEquals(5, blockDef.machineOptions().getRuleIndex());
    }

    @Test
    void scopedStmtCtx(){
        CharStream cs = CharStreams.fromString("num fac(num x, num y){return x+2}");
        GMMParser parser = getParser(cs);
        GMMParser.ScopedStmtContext sctx = parser.scopedStmt();

        assertEquals(7, sctx.getRuleIndex());
    }

    @Test
    void Ctx(){
        CharStream cs = CharStreams.fromString("block[tool:1, bound_x:200]{num x = 2}");
        GMMParser parser = getParser(cs);
        
    }


    @Disabled
    @Test
    void getSerializedATN(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String ATN = "\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3%\u0113\4\2\t\2\4"+
                "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
                "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
                "\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3"+
                "\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4"+
                "\7\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3"+
                "\6\3\6\3\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\3\t\3"+
                "\t\3\t\3\t\3\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\t\3\t\3\t\3\t\3\t\3\t"+
                "\3\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
                "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\6\t\u008c\n\t\r\t\16\t\u008d\3\t\3\t\6"+
                "\t\u0092\n\t\r\t\16\t\u0093\3\t\3\t\6\t\u0098\n\t\r\t\16\t\u0099\3\t\3"+
                "\t\5\t\u009e\n\t\3\n\3\n\3\n\5\n\u00a3\n\n\3\n\3\n\3\13\3\13\3\13\3\13"+
                "\3\13\3\13\3\13\5\13\u00ae\n\13\3\f\3\f\3\f\7\f\u00b3\n\f\f\f\16\f\u00b6"+
                "\13\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c3"+
                "\n\16\f\16\16\16\u00c6\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
                "\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dd"+
                "\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e8\n\20\f\20"+
                "\16\20\u00eb\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00f6"+
                "\n\21\f\21\16\21\u00f9\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
                "\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5"+
                "\22\u0111\n\22\3\22\2\5\32\36 \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
                "\36 \"\2\2\2\u012e\2(\3\2\2\2\4+\3\2\2\2\6;\3\2\2\2\bJ\3\2\2\2\nR\3\2"+
                "\2\2\fU\3\2\2\2\16]\3\2\2\2\20\u009d\3\2\2\2\22\u009f\3\2\2\2\24\u00ad"+
                "\3\2\2\2\26\u00af\3\2\2\2\30\u00b7\3\2\2\2\32\u00b9\3\2\2\2\34\u00dc\3"+
                "\2\2\2\36\u00de\3\2\2\2 \u00ec\3\2\2\2\"\u0110\3\2\2\2$\'\5\4\3\2%\'\5"+
                "\6\4\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\3\3\2\2\2*"+
                "(\3\2\2\2+,\7!\2\2,-\7$\2\2-/\7\30\2\2.\60\5\b\5\2/.\3\2\2\2/\60\3\2\2"+
                "\2\60\61\3\2\2\2\61\62\7\31\2\2\62\66\7\34\2\2\63\65\5\20\t\2\64\63\3"+
                "\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\2"+
                "9:\7\35\2\2:\5\3\2\2\2;<\7$\2\2<>\7\32\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2\2"+
                "\2?@\3\2\2\2@A\7\33\2\2AE\7\34\2\2BD\5\20\t\2CB\3\2\2\2DG\3\2\2\2EC\3"+
                "\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\35\2\2I\7\3\2\2\2JO\5\n\6\2K"+
                "L\7\23\2\2LN\5\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2"+
                "\2QO\3\2\2\2RS\7!\2\2ST\7$\2\2T\13\3\2\2\2UZ\5\16\b\2VW\7\23\2\2WY\5\16"+
                "\b\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]^"+
                "\7$\2\2^_\7\25\2\2_`\5\30\r\2`\17\3\2\2\2a\u009e\5\6\4\2bc\7\26\2\2cd"+
                "\7\30\2\2de\5\30\r\2ef\7\31\2\2fj\7\34\2\2gi\5\20\t\2hg\3\2\2\2il\3\2"+
                "\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\35\2\2n\u009e\3\2\2\2"+
                "op\7\27\2\2pq\7\30\2\2qr\5\30\r\2rs\7\31\2\2sw\7\34\2\2tv\5\20\t\2ut\3"+
                "\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\35\2\2{\u009e"+
                "\3\2\2\2|\u009e\5\22\n\2}~\7$\2\2~\177\7\4\2\2\177\u009e\5\30\r\2\u0080"+
                "\u0081\7$\2\2\u0081\u0082\7\24\2\2\u0082\u0083\7$\2\2\u0083\u0084\7\4"+
                "\2\2\u0084\u009e\5\30\r\2\u0085\u0086\7!\2\2\u0086\u0087\7$\2\2\u0087"+
                "\u0088\7\4\2\2\u0088\u009e\5\30\r\2\u0089\u008b\7\36\2\2\u008a\u008c\5"+
                "\24\13\2\u008b\u008a\3\2\2\2\u008c\u008d\3\2\2\2\u008d\u008b\3\2\2\2\u008d"+
                "\u008e\3\2\2\2\u008e\u009e\3\2\2\2\u008f\u0091\7 \2\2\u0090\u0092\5\24"+
                "\13\2\u0091\u0090\3\2\2\2\u0092\u0093\3\2\2\2\u0093\u0091\3\2\2\2\u0093"+
                "\u0094\3\2\2\2\u0094\u009e\3\2\2\2\u0095\u0097\7\37\2\2\u0096\u0098\5"+
                "\24\13\2\u0097\u0096\3\2\2\2\u0098\u0099\3\2\2\2\u0099\u0097\3\2\2\2\u0099"+
                "\u009a\3\2\2\2\u009a\u009e\3\2\2\2\u009b\u009c\7\3\2\2\u009c\u009e\5\30"+
                "\r\2\u009da\3\2\2\2\u009db\3\2\2\2\u009do\3\2\2\2\u009d|\3\2\2\2\u009d"+
                "}\3\2\2\2\u009d\u0080\3\2\2\2\u009d\u0085\3\2\2\2\u009d\u0089\3\2\2\2"+
                "\u009d\u008f\3\2\2\2\u009d\u0095\3\2\2\2\u009d\u009b\3\2\2\2\u009e\21"+
                "\3\2\2\2\u009f\u00a0\7$\2\2\u00a0\u00a2\7\30\2\2\u00a1\u00a3\5\26\f\2"+
                "\u00a2\u00a1\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4\3\2\2\2\u00a4\u00a5"+
                "\7\31\2\2\u00a5\23\3\2\2\2\u00a6\u00a7\7#\2\2\u00a7\u00a8\7\4\2\2\u00a8"+
                "\u00ae\5\30\r\2\u00a9\u00aa\7#\2\2\u00aa\u00ab\7\4\2\2\u00ab\u00ac\7\""+
                "\2\2\u00ac\u00ae\5\30\r\2\u00ad\u00a6\3\2\2\2\u00ad\u00a9\3\2\2\2\u00ae"+
                "\25\3\2\2\2\u00af\u00b4\5\30\r\2\u00b0\u00b1\7\23\2\2\u00b1\u00b3\5\30"+
                "\r\2\u00b2\u00b0\3\2\2\2\u00b3\u00b6\3\2\2\2\u00b4\u00b2\3\2\2\2\u00b4"+
                "\u00b5\3\2\2\2\u00b5\27\3\2\2\2\u00b6\u00b4\3\2\2\2\u00b7\u00b8\5\32\16"+
                "\2\u00b8\31\3\2\2\2\u00b9\u00ba\b\16\1\2\u00ba\u00bb\5\34\17\2\u00bb\u00c4"+
                "\3\2\2\2\u00bc\u00bd\f\5\2\2\u00bd\u00be\7\t\2\2\u00be\u00c3\5\34\17\2"+
                "\u00bf\u00c0\f\4\2\2\u00c0\u00c1\7\n\2\2\u00c1\u00c3\5\34\17\2\u00c2\u00bc"+
                "\3\2\2\2\u00c2\u00bf\3\2\2\2\u00c3\u00c6\3\2\2\2\u00c4\u00c2\3\2\2\2\u00c4"+
                "\u00c5\3\2\2\2\u00c5\33\3\2\2\2\u00c6\u00c4\3\2\2\2\u00c7\u00c8\5\36\20"+
                "\2\u00c8\u00c9\7\13\2\2\u00c9\u00ca\5\36\20\2\u00ca\u00dd\3\2\2\2\u00cb"+
                "\u00cc\5\36\20\2\u00cc\u00cd\7\f\2\2\u00cd\u00ce\5\36\20\2\u00ce\u00dd"+
                "\3\2\2\2\u00cf\u00d0\5\36\20\2\u00d0\u00d1\7\r\2\2\u00d1\u00d2\5\36\20"+
                "\2\u00d2\u00dd\3\2\2\2\u00d3\u00d4\5\36\20\2\u00d4\u00d5\7\16\2\2\u00d5"+
                "\u00d6\5\36\20\2\u00d6\u00dd\3\2\2\2\u00d7\u00d8\7\30\2\2\u00d8\u00d9"+
                "\5\32\16\2\u00d9\u00da\7\31\2\2\u00da\u00dd\3\2\2\2\u00db\u00dd\5\36\20"+
                "\2\u00dc\u00c7\3\2\2\2\u00dc\u00cb\3\2\2\2\u00dc\u00cf\3\2\2\2\u00dc\u00d3"+
                "\3\2\2\2\u00dc\u00d7\3\2\2\2\u00dc\u00db\3\2\2\2\u00dd\35\3\2\2\2\u00de"+
                "\u00df\b\20\1\2\u00df\u00e0\5 \21\2\u00e0\u00e9\3\2\2\2\u00e1\u00e2\f"+
                "\5\2\2\u00e2\u00e3\7\5\2\2\u00e3\u00e8\5 \21\2\u00e4\u00e5\f\4\2\2\u00e5"+
                "\u00e6\7\6\2\2\u00e6\u00e8\5 \21\2\u00e7\u00e1\3\2\2\2\u00e7\u00e4\3\2"+
                "\2\2\u00e8\u00eb\3\2\2\2\u00e9\u00e7\3\2\2\2\u00e9\u00ea\3\2\2\2\u00ea"+
                "\37\3\2\2\2\u00eb\u00e9\3\2\2\2\u00ec\u00ed\b\21\1\2\u00ed\u00ee\5\"\22"+
                "\2\u00ee\u00f7\3\2\2\2\u00ef\u00f0\f\5\2\2\u00f0\u00f1\7\7\2\2\u00f1\u00f6"+
                "\5\"\22\2\u00f2\u00f3\f\4\2\2\u00f3\u00f4\7\b\2\2\u00f4\u00f6\5\"\22\2"+
                "\u00f5\u00ef\3\2\2\2\u00f5\u00f2\3\2\2\2\u00f6\u00f9\3\2\2\2\u00f7\u00f5"+
                "\3\2\2\2\u00f7\u00f8\3\2\2\2\u00f8!\3\2\2\2\u00f9\u00f7\3\2\2\2\u00fa"+
                "\u00fb\7\30\2\2\u00fb\u00fc\5\36\20\2\u00fc\u00fd\7\31\2\2\u00fd\u0111"+
                "\3\2\2\2\u00fe\u0111\7\21\2\2\u00ff\u0111\7\17\2\2\u0100\u0111\7\20\2"+
                "\2\u0101\u0111\7$\2\2\u0102\u0103\7$\2\2\u0103\u0104\7\24\2\2\u0104\u0111"+
                "\7$\2\2\u0105\u0111\5\22\n\2\u0106\u0107\7\30\2\2\u0107\u0108\5\30\r\2"+
                "\u0108\u0109\7\23\2\2\u0109\u010a\5\30\r\2\u010a\u010b\7\23\2\2\u010b"+
                "\u010c\5\30\r\2\u010c\u010d\7\31\2\2\u010d\u0111\3\2\2\2\u010e\u010f\7"+
                "\6\2\2\u010f\u0111\5\"\22\2\u0110\u00fa\3\2\2\2\u0110\u00fe\3\2\2\2\u0110"+
                "\u00ff\3\2\2\2\u0110\u0100\3\2\2\2\u0110\u0101\3\2\2\2\u0110\u0102\3\2"+
                "\2\2\u0110\u0105\3\2\2\2\u0110\u0106\3\2\2\2\u0110\u010e\3\2\2\2\u0111"+
                "#\3\2\2\2\33&(/\66>EOZjw\u008d\u0093\u0099\u009d\u00a2\u00ad\u00b4\u00c2"+
                "\u00c4\u00dc\u00e7\u00e9\u00f5\u00f7\u0110";;
        assertEquals(ATN, parser.getSerializedATN());

    }







}

