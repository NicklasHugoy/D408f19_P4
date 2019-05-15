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
        assertEquals(18, parser.getRuleNames().length);
    }

    @Test
    void getTokenNames() {
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String[] tokenNames = {
                "<INVALID>", "'..'", "'sqrt'", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'",
                "'||'", "'=='", "'!='", "'>'", "'<'", "'true'", "'false'", "INT", "';'", "','", "'.'", "':'", "'loop'",
                "'if'", "'(', ')'", "'[', ']'", "'{', '}'", "'jump '", "'move '", "'leftCircle '", "'rightCircle '"
                , "Type", "CommandParameter", "GCode", "GCodeVarRef", "ID", "BlockParam", "WS"
        };
        assertEquals(Arrays.toString(tokenNames), Arrays.toString(parser.getTokenNames()));
        assertEquals(41, parser.getTokenNames().length);
    }

    @Test
    void getGrammaFileName() {
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("GMM.g4", parser.getGrammarFileName());
    }

    @Test
    void getVocabulary(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals(40, parser.getVocabulary().getMaxTokenType());
    }

    @Test
    void getVocabulary01(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("Return", parser.getVocabulary().getSymbolicName(3));
    }

    @Test
    void getVocabulary02(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("'-'", parser.getVocabulary().getLiteralName(6));

    }

    @Test
    void getVocabulary03(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        assertEquals("'/'", parser.getVocabulary().getDisplayName(8));
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


    @Test
    void getSerializedATN(){
        CharStream cs = CharStreams.fromString("");
        GMMParser parser = getParser(cs);

        String ATN = 		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0137\4\2\t\2\4"+
                "\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
                "\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
                "\4\23\t\23\3\2\7\2(\n\2\f\2\16\2+\13\2\3\2\3\2\3\3\3\3\3\3\3\3\5\3\63"+
                "\n\3\3\3\3\3\3\3\7\38\n\3\f\3\16\3;\13\3\3\3\3\3\3\4\3\4\3\4\5\4B\n\4"+
                "\3\4\3\4\3\4\7\4G\n\4\f\4\16\4J\13\4\3\4\3\4\3\5\3\5\3\5\7\5Q\n\5\f\5"+
                "\16\5T\13\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7\\\n\7\f\7\16\7_\13\7\3\b\3\b\3"+
                "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\tn\n\t\f\t\16\tq\13\t\3\t"+
                "\3\t\3\t\3\t\3\t\3\t\3\t\3\t\7\t{\n\t\f\t\16\t~\13\t\3\t\3\t\3\t\3\t\3"+
                "\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u0091\n\t\3\t\7"+
                "\t\u0094\n\t\f\t\16\t\u0097\13\t\3\t\3\t\5\t\u009b\n\t\3\t\7\t\u009e\n"+
                "\t\f\t\16\t\u00a1\13\t\3\t\3\t\5\t\u00a5\n\t\3\t\7\t\u00a8\n\t\f\t\16"+
                "\t\u00ab\13\t\3\t\3\t\5\t\u00af\n\t\3\t\7\t\u00b2\n\t\f\t\16\t\u00b5\13"+
                "\t\3\t\3\t\3\t\5\t\u00ba\n\t\3\n\3\n\3\n\5\n\u00bf\n\n\3\n\3\n\3\13\3"+
                "\13\3\f\3\f\3\f\3\f\3\r\3\r\3\r\7\r\u00cc\n\r\f\r\16\r\u00cf\13\r\3\16"+
                "\3\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\7\17\u00dc\n\17\f\17"+
                "\16\17\u00df\13\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3"+
                "\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f6\n\20"+
                "\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u0101\n\21\f\21\16"+
                "\21\u0104\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u010f"+
                "\n\22\f\22\16\22\u0112\13\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
                "\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
                "\23\3\23\3\23\5\23\u012d\n\23\3\23\3\23\3\23\7\23\u0132\n\23\f\23\16\23"+
                "\u0135\13\23\3\23\2\6\34 \"$\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36"+
                " \"$\2\2\2\u0157\2)\3\2\2\2\4.\3\2\2\2\6>\3\2\2\2\bM\3\2\2\2\nU\3\2\2"+
                "\2\fX\3\2\2\2\16`\3\2\2\2\20\u00b9\3\2\2\2\22\u00bb\3\2\2\2\24\u00c2\3"+
                "\2\2\2\26\u00c4\3\2\2\2\30\u00c8\3\2\2\2\32\u00d0\3\2\2\2\34\u00d2\3\2"+
                "\2\2\36\u00f5\3\2\2\2 \u00f7\3\2\2\2\"\u0105\3\2\2\2$\u012c\3\2\2\2&("+
                "\5\4\3\2\'&\3\2\2\2(+\3\2\2\2)\'\3\2\2\2)*\3\2\2\2*,\3\2\2\2+)\3\2\2\2"+
                ",-\5\6\4\2-\3\3\2\2\2./\7$\2\2/\60\7(\2\2\60\62\7\32\2\2\61\63\5\b\5\2"+
                "\62\61\3\2\2\2\62\63\3\2\2\2\63\64\3\2\2\2\64\65\7\33\2\2\659\7\36\2\2"+
                "\668\5\20\t\2\67\66\3\2\2\28;\3\2\2\29\67\3\2\2\29:\3\2\2\2:<\3\2\2\2"+
                ";9\3\2\2\2<=\7\37\2\2=\5\3\2\2\2>?\7(\2\2?A\7\34\2\2@B\5\f\7\2A@\3\2\2"+
                "\2AB\3\2\2\2BC\3\2\2\2CD\7\35\2\2DH\7\36\2\2EG\5\20\t\2FE\3\2\2\2GJ\3"+
                "\2\2\2HF\3\2\2\2HI\3\2\2\2IK\3\2\2\2JH\3\2\2\2KL\7\37\2\2L\7\3\2\2\2M"+
                "R\5\n\6\2NO\7\25\2\2OQ\5\n\6\2PN\3\2\2\2QT\3\2\2\2RP\3\2\2\2RS\3\2\2\2"+
                "S\t\3\2\2\2TR\3\2\2\2UV\7$\2\2VW\7(\2\2W\13\3\2\2\2X]\5\16\b\2YZ\7\25"+
                "\2\2Z\\\5\16\b\2[Y\3\2\2\2\\_\3\2\2\2][\3\2\2\2]^\3\2\2\2^\r\3\2\2\2_"+
                "]\3\2\2\2`a\7)\2\2a\17\3\2\2\2b\u00ba\5\6\4\2cd\7\30\2\2de\7\32\2\2ef"+
                "\7(\2\2fg\7\6\2\2gh\5\32\16\2hi\7\3\2\2ij\5\32\16\2jk\7\33\2\2ko\7\36"+
                "\2\2ln\5\20\t\2ml\3\2\2\2nq\3\2\2\2om\3\2\2\2op\3\2\2\2pr\3\2\2\2qo\3"+
                "\2\2\2rs\7\37\2\2s\u00ba\3\2\2\2tu\7\31\2\2uv\7\32\2\2vw\5\32\16\2wx\7"+
                "\33\2\2x|\7\36\2\2y{\5\20\t\2zy\3\2\2\2{~\3\2\2\2|z\3\2\2\2|}\3\2\2\2"+
                "}\177\3\2\2\2~|\3\2\2\2\177\u0080\7\37\2\2\u0080\u00ba\3\2\2\2\u0081\u00ba"+
                "\5\22\n\2\u0082\u0083\7(\2\2\u0083\u0084\7\6\2\2\u0084\u00ba\5\32\16\2"+
                "\u0085\u0086\7(\2\2\u0086\u0087\7\26\2\2\u0087\u0088\7(\2\2\u0088\u0089"+
                "\7\6\2\2\u0089\u00ba\5\32\16\2\u008a\u008b\7$\2\2\u008b\u008c\7(\2\2\u008c"+
                "\u008d\7\6\2\2\u008d\u00ba\5\32\16\2\u008e\u0090\7!\2\2\u008f\u0091\5"+
                "\24\13\2\u0090\u008f\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u0095\3\2\2\2\u0092"+
                "\u0094\5\26\f\2\u0093\u0092\3\2\2\2\u0094\u0097\3\2\2\2\u0095\u0093\3"+
                "\2\2\2\u0095\u0096\3\2\2\2\u0096\u00ba\3\2\2\2\u0097\u0095\3\2\2\2\u0098"+
                "\u009a\7#\2\2\u0099\u009b\5\24\13\2\u009a\u0099\3\2\2\2\u009a\u009b\3"+
                "\2\2\2\u009b\u009f\3\2\2\2\u009c\u009e\5\26\f\2\u009d\u009c\3\2\2\2\u009e"+
                "\u00a1\3\2\2\2\u009f\u009d\3\2\2\2\u009f\u00a0\3\2\2\2\u00a0\u00ba\3\2"+
                "\2\2\u00a1\u009f\3\2\2\2\u00a2\u00a4\7\"\2\2\u00a3\u00a5\5\24\13\2\u00a4"+
                "\u00a3\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5\u00a9\3\2\2\2\u00a6\u00a8\5\26"+
                "\f\2\u00a7\u00a6\3\2\2\2\u00a8\u00ab\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9"+
                "\u00aa\3\2\2\2\u00aa\u00ba\3\2\2\2\u00ab\u00a9\3\2\2\2\u00ac\u00ae\7 "+
                "\2\2\u00ad\u00af\5\24\13\2\u00ae\u00ad\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
                "\u00b3\3\2\2\2\u00b0\u00b2\5\26\f\2\u00b1\u00b0\3\2\2\2\u00b2\u00b5\3"+
                "\2\2\2\u00b3\u00b1\3\2\2\2\u00b3\u00b4\3\2\2\2\u00b4\u00ba\3\2\2\2\u00b5"+
                "\u00b3\3\2\2\2\u00b6\u00b7\7\5\2\2\u00b7\u00ba\5\32\16\2\u00b8\u00ba\7"+
                "&\2\2\u00b9b\3\2\2\2\u00b9c\3\2\2\2\u00b9t\3\2\2\2\u00b9\u0081\3\2\2\2"+
                "\u00b9\u0082\3\2\2\2\u00b9\u0085\3\2\2\2\u00b9\u008a\3\2\2\2\u00b9\u008e"+
                "\3\2\2\2\u00b9\u0098\3\2\2\2\u00b9\u00a2\3\2\2\2\u00b9\u00ac\3\2\2\2\u00b9"+
                "\u00b6\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\21\3\2\2\2\u00bb\u00bc\7(\2\2"+
                "\u00bc\u00be\7\32\2\2\u00bd\u00bf\5\30\r\2\u00be\u00bd\3\2\2\2\u00be\u00bf"+
                "\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\u00c1\7\33\2\2\u00c1\23\3\2\2\2\u00c2"+
                "\u00c3\5\32\16\2\u00c3\25\3\2\2\2\u00c4\u00c5\7%\2\2\u00c5\u00c6\7\6\2"+
                "\2\u00c6\u00c7\5\32\16\2\u00c7\27\3\2\2\2\u00c8\u00cd\5\32\16\2\u00c9"+
                "\u00ca\7\25\2\2\u00ca\u00cc\5\32\16\2\u00cb\u00c9\3\2\2\2\u00cc\u00cf"+
                "\3\2\2\2\u00cd\u00cb\3\2\2\2\u00cd\u00ce\3\2\2\2\u00ce\31\3\2\2\2\u00cf"+
                "\u00cd\3\2\2\2\u00d0\u00d1\5\34\17\2\u00d1\33\3\2\2\2\u00d2\u00d3\b\17"+
                "\1\2\u00d3\u00d4\5\36\20\2\u00d4\u00dd\3\2\2\2\u00d5\u00d6\f\5\2\2\u00d6"+
                "\u00d7\7\13\2\2\u00d7\u00dc\5\36\20\2\u00d8\u00d9\f\4\2\2\u00d9\u00da"+
                "\7\f\2\2\u00da\u00dc\5\36\20\2\u00db\u00d5\3\2\2\2\u00db\u00d8\3\2\2\2"+
                "\u00dc\u00df\3\2\2\2\u00dd\u00db\3\2\2\2\u00dd\u00de\3\2\2\2\u00de\35"+
                "\3\2\2\2\u00df\u00dd\3\2\2\2\u00e0\u00e1\5 \21\2\u00e1\u00e2\7\r\2\2\u00e2"+
                "\u00e3\5 \21\2\u00e3\u00f6\3\2\2\2\u00e4\u00e5\5 \21\2\u00e5\u00e6\7\16"+
                "\2\2\u00e6\u00e7\5 \21\2\u00e7\u00f6\3\2\2\2\u00e8\u00e9\5 \21\2\u00e9"+
                "\u00ea\7\17\2\2\u00ea\u00eb\5 \21\2\u00eb\u00f6\3\2\2\2\u00ec\u00ed\5"+
                " \21\2\u00ed\u00ee\7\20\2\2\u00ee\u00ef\5 \21\2\u00ef\u00f6\3\2\2\2\u00f0"+
                "\u00f1\7\32\2\2\u00f1\u00f2\5\34\17\2\u00f2\u00f3\7\33\2\2\u00f3\u00f6"+
                "\3\2\2\2\u00f4\u00f6\5 \21\2\u00f5\u00e0\3\2\2\2\u00f5\u00e4\3\2\2\2\u00f5"+
                "\u00e8\3\2\2\2\u00f5\u00ec\3\2\2\2\u00f5\u00f0\3\2\2\2\u00f5\u00f4\3\2"+
                "\2\2\u00f6\37\3\2\2\2\u00f7\u00f8\b\21\1\2\u00f8\u00f9\5\"\22\2\u00f9"+
                "\u0102\3\2\2\2\u00fa\u00fb\f\5\2\2\u00fb\u00fc\7\7\2\2\u00fc\u0101\5\""+
                "\22\2\u00fd\u00fe\f\4\2\2\u00fe\u00ff\7\b\2\2\u00ff\u0101\5\"\22\2\u0100"+
                "\u00fa\3\2\2\2\u0100\u00fd\3\2\2\2\u0101\u0104\3\2\2\2\u0102\u0100\3\2"+
                "\2\2\u0102\u0103\3\2\2\2\u0103!\3\2\2\2\u0104\u0102\3\2\2\2\u0105\u0106"+
                "\b\22\1\2\u0106\u0107\5$\23\2\u0107\u0110\3\2\2\2\u0108\u0109\f\5\2\2"+
                "\u0109\u010a\7\t\2\2\u010a\u010f\5$\23\2\u010b\u010c\f\4\2\2\u010c\u010d"+
                "\7\n\2\2\u010d\u010f\5$\23\2\u010e\u0108\3\2\2\2\u010e\u010b\3\2\2\2\u010f"+
                "\u0112\3\2\2\2\u0110\u010e\3\2\2\2\u0110\u0111\3\2\2\2\u0111#\3\2\2\2"+
                "\u0112\u0110\3\2\2\2\u0113\u0114\b\23\1\2\u0114\u0115\7\32\2\2\u0115\u0116"+
                "\5 \21\2\u0116\u0117\7\33\2\2\u0117\u012d\3\2\2\2\u0118\u012d\7\23\2\2"+
                "\u0119\u012d\7\21\2\2\u011a\u012d\7\22\2\2\u011b\u012d\7(\2\2\u011c\u011d"+
                "\7\4\2\2\u011d\u011e\7\32\2\2\u011e\u011f\5 \21\2\u011f\u0120\7\33\2\2"+
                "\u0120\u012d\3\2\2\2\u0121\u012d\5\22\n\2\u0122\u0123\7\32\2\2\u0123\u0124"+
                "\5\32\16\2\u0124\u0125\7\25\2\2\u0125\u0126\5\32\16\2\u0126\u0127\7\25"+
                "\2\2\u0127\u0128\5\32\16\2\u0128\u0129\7\33\2\2\u0129\u012d\3\2\2\2\u012a"+
                "\u012b\7\b\2\2\u012b\u012d\5$\23\3\u012c\u0113\3\2\2\2\u012c\u0118\3\2"+
                "\2\2\u012c\u0119\3\2\2\2\u012c\u011a\3\2\2\2\u012c\u011b\3\2\2\2\u012c"+
                "\u011c\3\2\2\2\u012c\u0121\3\2\2\2\u012c\u0122\3\2\2\2\u012c\u012a\3\2"+
                "\2\2\u012d\u0133\3\2\2\2\u012e\u012f\f\7\2\2\u012f\u0130\7\26\2\2\u0130"+
                "\u0132\7(\2\2\u0131\u012e\3\2\2\2\u0132\u0135\3\2\2\2\u0133\u0131\3\2"+
                "\2\2\u0133\u0134\3\2\2\2\u0134%\3\2\2\2\u0135\u0133\3\2\2\2\37)\629AH"+
                "R]o|\u0090\u0095\u009a\u009f\u00a4\u00a9\u00ae\u00b3\u00b9\u00be\u00cd"+
                "\u00db\u00dd\u00f5\u0100\u0102\u010e\u0110\u012c\u0133";
        assertEquals(ATN, parser.getSerializedATN());

    }







}

