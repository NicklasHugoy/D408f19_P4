// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/GCode\GMM.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.misc.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;
import java.util.Iterator;
import java.util.ArrayList;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GMMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		FunctionPrefix=1, Equals=2, Plus=3, Minus=4, Times=5, Divide=6, And=7, 
		Or=8, Equality=9, InEquality=10, True=11, False=12, INT=13, SemiColon=14, 
		CommaSeperator=15, Colon=16, While=17, If=18, LParan=19, RParan=20, LSquare=21, 
		RSquare=22, LCurl=23, RCurl=24, MoveCommand=25, LeftCircleCommand=26, 
		RightCircleCommand=27, Type=28, AbsoluteParameter=29, CommandParameter=30, 
		ID=31, WS=32;
	public static final int
		RULE_prog = 0, RULE_functionDef = 1, RULE_blockDef = 2, RULE_formalParameters = 3, 
		RULE_formalParameter = 4, RULE_machineOptions = 5, RULE_machineOption = 6, 
		RULE_scopedStmt = 7, RULE_command = 8, RULE_commandParameter = 9, RULE_parameters = 10, 
		RULE_expression = 11, RULE_logic = 12, RULE_boolean = 13, RULE_expr = 14, 
		RULE_term = 15, RULE_factor = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "functionDef", "blockDef", "formalParameters", "formalParameter", 
			"machineOptions", "machineOption", "scopedStmt", "command", "commandParameter", 
			"parameters", "expression", "logic", "boolean", "expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'function '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", "'||'", 
			"'=='", "'!='", "'true'", "'false'", null, "';'", "','", "':'", "'while'", 
			"'if'", "'('", "')'", "'['", "']'", "'{'", "'}'", "'move '", "'leftCircle '", 
			"'rightCircle '", null, "'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "FunctionPrefix", "Equals", "Plus", "Minus", "Times", "Divide", 
			"And", "Or", "Equality", "InEquality", "True", "False", "INT", "SemiColon", 
			"CommaSeperator", "Colon", "While", "If", "LParan", "RParan", "LSquare", 
			"RSquare", "LCurl", "RCurl", "MoveCommand", "LeftCircleCommand", "RightCircleCommand", 
			"Type", "AbsoluteParameter", "CommandParameter", "ID", "WS"
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
	public String getGrammarFileName() { return "GMM.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public ATN getATN() { return _ATN; }

	public GMMParser(TokenStream input) {
		super(input);
		_interp = new ParserATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	public static class ProgContext extends ParserRuleContext {
		public List<FunctionDefContext> functionDef() {
			return getRuleContexts(FunctionDefContext.class);
		}
		public FunctionDefContext functionDef(int i) {
			return getRuleContext(FunctionDefContext.class,i);
		}
		public List<BlockDefContext> blockDef() {
			return getRuleContexts(BlockDefContext.class);
		}
		public BlockDefContext blockDef(int i) {
			return getRuleContext(BlockDefContext.class,i);
		}
		public ProgContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_prog; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterProg(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitProg(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitProg(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ProgContext prog() throws RecognitionException {
		ProgContext _localctx = new ProgContext(_ctx, getState());
		enterRule(_localctx, 0, RULE_prog);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==FunctionPrefix || _la==ID) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case FunctionPrefix:
					{
					setState(34);
					functionDef();
					}
					break;
				case ID:
					{
					setState(35);
					blockDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(40);
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

	public static class FunctionDefContext extends ParserRuleContext {
		public TerminalNode FunctionPrefix() { return getToken(GMMParser.FunctionPrefix, 0); }
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public TerminalNode LCurl() { return getToken(GMMParser.LCurl, 0); }
		public TerminalNode RCurl() { return getToken(GMMParser.RCurl, 0); }
		public FormalParametersContext formalParameters() {
			return getRuleContext(FormalParametersContext.class,0);
		}
		public List<ScopedStmtContext> scopedStmt() {
			return getRuleContexts(ScopedStmtContext.class);
		}
		public ScopedStmtContext scopedStmt(int i) {
			return getRuleContext(ScopedStmtContext.class,i);
		}
		public FunctionDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterFunctionDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitFunctionDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFunctionDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionDefContext functionDef() throws RecognitionException {
		FunctionDefContext _localctx = new FunctionDefContext(_ctx, getState());
		enterRule(_localctx, 2, RULE_functionDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(41);
			match(FunctionPrefix);
			setState(42);
			match(ID);
			setState(43);
			match(LParan);
			setState(45);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(44);
				formalParameters();
				}
			}

			setState(47);
			match(RParan);
			setState(48);
			match(LCurl);
			setState(52);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << ID))) != 0)) {
				{
				{
				setState(49);
				scopedStmt();
				}
				}
				setState(54);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(55);
			match(RCurl);
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

	public static class BlockDefContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode LSquare() { return getToken(GMMParser.LSquare, 0); }
		public TerminalNode RSquare() { return getToken(GMMParser.RSquare, 0); }
		public TerminalNode LCurl() { return getToken(GMMParser.LCurl, 0); }
		public TerminalNode RCurl() { return getToken(GMMParser.RCurl, 0); }
		public MachineOptionsContext machineOptions() {
			return getRuleContext(MachineOptionsContext.class,0);
		}
		public List<ScopedStmtContext> scopedStmt() {
			return getRuleContexts(ScopedStmtContext.class);
		}
		public ScopedStmtContext scopedStmt(int i) {
			return getRuleContext(ScopedStmtContext.class,i);
		}
		public BlockDefContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_blockDef; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterBlockDef(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitBlockDef(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitBlockDef(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BlockDefContext blockDef() throws RecognitionException {
		BlockDefContext _localctx = new BlockDefContext(_ctx, getState());
		enterRule(_localctx, 4, RULE_blockDef);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(57);
			match(ID);
			setState(58);
			match(LSquare);
			setState(60);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==ID) {
				{
				setState(59);
				machineOptions();
				}
			}

			setState(62);
			match(RSquare);
			setState(63);
			match(LCurl);
			setState(67);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << ID))) != 0)) {
				{
				{
				setState(64);
				scopedStmt();
				}
				}
				setState(69);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(70);
			match(RCurl);
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

	public static class FormalParametersContext extends ParserRuleContext {
		public List<FormalParameterContext> formalParameter() {
			return getRuleContexts(FormalParameterContext.class);
		}
		public FormalParameterContext formalParameter(int i) {
			return getRuleContext(FormalParameterContext.class,i);
		}
		public List<TerminalNode> CommaSeperator() { return getTokens(GMMParser.CommaSeperator); }
		public TerminalNode CommaSeperator(int i) {
			return getToken(GMMParser.CommaSeperator, i);
		}
		public FormalParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterFormalParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitFormalParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFormalParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParametersContext formalParameters() throws RecognitionException {
		FormalParametersContext _localctx = new FormalParametersContext(_ctx, getState());
		enterRule(_localctx, 6, RULE_formalParameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(72);
			formalParameter();
			setState(77);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(73);
				match(CommaSeperator);
				setState(74);
				formalParameter();
				}
				}
				setState(79);
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

	public static class FormalParameterContext extends ParserRuleContext {
		public TerminalNode Type() { return getToken(GMMParser.Type, 0); }
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public FormalParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_formalParameter; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterFormalParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitFormalParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFormalParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FormalParameterContext formalParameter() throws RecognitionException {
		FormalParameterContext _localctx = new FormalParameterContext(_ctx, getState());
		enterRule(_localctx, 8, RULE_formalParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(80);
			match(Type);
			setState(81);
			match(ID);
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

	public static class MachineOptionsContext extends ParserRuleContext {
		public List<MachineOptionContext> machineOption() {
			return getRuleContexts(MachineOptionContext.class);
		}
		public MachineOptionContext machineOption(int i) {
			return getRuleContext(MachineOptionContext.class,i);
		}
		public List<TerminalNode> CommaSeperator() { return getTokens(GMMParser.CommaSeperator); }
		public TerminalNode CommaSeperator(int i) {
			return getToken(GMMParser.CommaSeperator, i);
		}
		public MachineOptionsContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_machineOptions; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterMachineOptions(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitMachineOptions(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitMachineOptions(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MachineOptionsContext machineOptions() throws RecognitionException {
		MachineOptionsContext _localctx = new MachineOptionsContext(_ctx, getState());
		enterRule(_localctx, 10, RULE_machineOptions);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(83);
			machineOption();
			setState(88);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(84);
				match(CommaSeperator);
				setState(85);
				machineOption();
				}
				}
				setState(90);
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

	public static class MachineOptionContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode Colon() { return getToken(GMMParser.Colon, 0); }
		public TerminalNode INT() { return getToken(GMMParser.INT, 0); }
		public MachineOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_machineOption; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterMachineOption(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitMachineOption(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitMachineOption(this);
			else return visitor.visitChildren(this);
		}
	}

	public final MachineOptionContext machineOption() throws RecognitionException {
		MachineOptionContext _localctx = new MachineOptionContext(_ctx, getState());
		enterRule(_localctx, 12, RULE_machineOption);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(91);
			match(ID);
			setState(92);
			match(Colon);
			setState(93);
			match(INT);
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

	public static class ScopedStmtContext extends ParserRuleContext {
		public ScopedStmtContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_scopedStmt; }
	 
		public ScopedStmtContext() { }
		public void copyFrom(ScopedStmtContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AssignmentContext extends ScopedStmtContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AssignmentContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterAssignment(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitAssignment(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitAssignment(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class IfStatementContext extends ScopedStmtContext {
		public TerminalNode If() { return getToken(GMMParser.If, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public TerminalNode LCurl() { return getToken(GMMParser.LCurl, 0); }
		public TerminalNode RCurl() { return getToken(GMMParser.RCurl, 0); }
		public List<ScopedStmtContext> scopedStmt() {
			return getRuleContexts(ScopedStmtContext.class);
		}
		public ScopedStmtContext scopedStmt(int i) {
			return getRuleContext(ScopedStmtContext.class,i);
		}
		public IfStatementContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterIfStatement(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitIfStatement(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GCommandContext extends ScopedStmtContext {
		public CommandContext command() {
			return getRuleContext(CommandContext.class,0);
		}
		public GCommandContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterGCommand(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitGCommand(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitGCommand(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends ScopedStmtContext {
		public BlockDefContext blockDef() {
			return getRuleContext(BlockDefContext.class,0);
		}
		public BlockContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterBlock(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitBlock(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DeclarationContext extends ScopedStmtContext {
		public TerminalNode Type() { return getToken(GMMParser.Type, 0); }
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public DeclarationContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterDeclaration(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitDeclaration(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitDeclaration(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class WhileLoopContext extends ScopedStmtContext {
		public TerminalNode While() { return getToken(GMMParser.While, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public TerminalNode LCurl() { return getToken(GMMParser.LCurl, 0); }
		public TerminalNode RCurl() { return getToken(GMMParser.RCurl, 0); }
		public List<ScopedStmtContext> scopedStmt() {
			return getRuleContexts(ScopedStmtContext.class);
		}
		public ScopedStmtContext scopedStmt(int i) {
			return getRuleContext(ScopedStmtContext.class,i);
		}
		public WhileLoopContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterWhileLoop(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitWhileLoop(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class CallFunctionContext extends ScopedStmtContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public CallFunctionContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterCallFunction(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitCallFunction(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitCallFunction(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopedStmtContext scopedStmt() throws RecognitionException {
		ScopedStmtContext _localctx = new ScopedStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scopedStmt);
		int _la;
		try {
			setState(136);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,11,_ctx) ) {
			case 1:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(95);
				blockDef();
				}
				break;
			case 2:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(96);
				match(While);
				setState(97);
				match(LParan);
				setState(98);
				expression();
				setState(99);
				match(RParan);
				setState(100);
				match(LCurl);
				setState(104);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << ID))) != 0)) {
					{
					{
					setState(101);
					scopedStmt();
					}
					}
					setState(106);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(107);
				match(RCurl);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(109);
				match(If);
				setState(110);
				match(LParan);
				setState(111);
				expression();
				setState(112);
				match(RParan);
				setState(113);
				match(LCurl);
				setState(117);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << ID))) != 0)) {
					{
					{
					setState(114);
					scopedStmt();
					}
					}
					setState(119);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(120);
				match(RCurl);
				}
				break;
			case 4:
				_localctx = new CallFunctionContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				match(ID);
				setState(123);
				match(LParan);
				setState(125);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(124);
					parameters();
					}
					break;
				}
				setState(127);
				match(RParan);
				}
				break;
			case 5:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(128);
				match(ID);
				setState(129);
				match(Equals);
				setState(130);
				expression();
				}
				break;
			case 6:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(131);
				match(Type);
				setState(132);
				match(ID);
				setState(133);
				match(Equals);
				setState(134);
				expression();
				}
				break;
			case 7:
				_localctx = new GCommandContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(135);
				command();
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

	public static class CommandContext extends ParserRuleContext {
		public CommandContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_command; }
	 
		public CommandContext() { }
		public void copyFrom(CommandContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class RightCircleContext extends CommandContext {
		public TerminalNode RightCircleCommand() { return getToken(GMMParser.RightCircleCommand, 0); }
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
		}
		public RightCircleContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterRightCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitRightCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitRightCircle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoveContext extends CommandContext {
		public TerminalNode MoveCommand() { return getToken(GMMParser.MoveCommand, 0); }
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
		}
		public MoveContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterMove(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitMove(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftCircleContext extends CommandContext {
		public TerminalNode LeftCircleCommand() { return getToken(GMMParser.LeftCircleCommand, 0); }
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
		}
		public LeftCircleContext(CommandContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterLeftCircle(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitLeftCircle(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLeftCircle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandContext command() throws RecognitionException {
		CommandContext _localctx = new CommandContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_command);
		int _la;
		try {
			setState(156);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case MoveCommand:
				_localctx = new MoveContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(138);
				match(MoveCommand);
				setState(140); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(139);
					commandParameter();
					}
					}
					setState(142); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
				}
				break;
			case RightCircleCommand:
				_localctx = new RightCircleContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(144);
				match(RightCircleCommand);
				setState(146); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(145);
					commandParameter();
					}
					}
					setState(148); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
				}
				break;
			case LeftCircleCommand:
				_localctx = new LeftCircleContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(150);
				match(LeftCircleCommand);
				setState(152); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(151);
					commandParameter();
					}
					}
					setState(154); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
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

	public static class CommandParameterContext extends ParserRuleContext {
		public CommandParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_commandParameter; }
	 
		public CommandParameterContext() { }
		public void copyFrom(CommandParameterContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AbsoluteParameterContext extends CommandParameterContext {
		public TerminalNode CommandParameter() { return getToken(GMMParser.CommandParameter, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public TerminalNode AbsoluteParameter() { return getToken(GMMParser.AbsoluteParameter, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public AbsoluteParameterContext(CommandParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterAbsoluteParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitAbsoluteParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitAbsoluteParameter(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RelativeParameterContext extends CommandParameterContext {
		public TerminalNode CommandParameter() { return getToken(GMMParser.CommandParameter, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public RelativeParameterContext(CommandParameterContext ctx) { copyFrom(ctx); }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterRelativeParameter(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitRelativeParameter(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitRelativeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandParameterContext commandParameter() throws RecognitionException {
		CommandParameterContext _localctx = new CommandParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_commandParameter);
		try {
			setState(165);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
			case 1:
				_localctx = new RelativeParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(158);
				match(CommandParameter);
				setState(159);
				match(Equals);
				setState(160);
				expression();
				}
				break;
			case 2:
				_localctx = new AbsoluteParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(161);
				match(CommandParameter);
				setState(162);
				match(Equals);
				setState(163);
				match(AbsoluteParameter);
				setState(164);
				expression();
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

	public static class ParametersContext extends ParserRuleContext {
		public List<ExpressionContext> expression() {
			return getRuleContexts(ExpressionContext.class);
		}
		public ExpressionContext expression(int i) {
			return getRuleContext(ExpressionContext.class,i);
		}
		public List<TerminalNode> CommaSeperator() { return getTokens(GMMParser.CommaSeperator); }
		public TerminalNode CommaSeperator(int i) {
			return getToken(GMMParser.CommaSeperator, i);
		}
		public ParametersContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_parameters; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterParameters(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitParameters(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(167);
			expression();
			setState(172);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(168);
				match(CommaSeperator);
				setState(169);
				expression();
				}
				}
				setState(174);
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

	public static class ExpressionContext extends ParserRuleContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public ExpressionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expression; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterExpression(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitExpression(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(175);
			logic(0);
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

	public static class LogicContext extends ParserRuleContext {
		public BooleanContext boolean() {
			return getRuleContext(BooleanContext.class,0);
		}
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public TerminalNode And() { return getToken(GMMParser.And, 0); }
		public TerminalNode Or() { return getToken(GMMParser.Or, 0); }
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterLogic(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitLogic(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLogic(this);
			else return visitor.visitChildren(this);
		}
	}

	public final LogicContext logic() throws RecognitionException {
		return logic(0);
	}

	private LogicContext logic(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		LogicContext _localctx = new LogicContext(_ctx, _parentState);
		LogicContext _prevctx = _localctx;
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_logic, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(178);
			boolean();
			}
			_ctx.stop = _input.LT(-1);
			setState(188);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(186);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
					case 1:
						{
						_localctx = new LogicContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(180);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(181);
						match(And);
						setState(182);
						boolean();
						}
						break;
					case 2:
						{
						_localctx = new LogicContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(183);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(184);
						match(Or);
						setState(185);
						boolean();
						}
						break;
					}
					} 
				}
				setState(190);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,19,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class BooleanContext extends ParserRuleContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Equality() { return getToken(GMMParser.Equality, 0); }
		public TerminalNode InEquality() { return getToken(GMMParser.InEquality, 0); }
		public BooleanContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_boolean; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterBoolean(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitBoolean(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitBoolean(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanContext boolean() throws RecognitionException {
		BooleanContext _localctx = new BooleanContext(_ctx, getState());
		enterRule(_localctx, 26, RULE_boolean);
		try {
			setState(200);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
			case 1:
				enterOuterAlt(_localctx, 1);
				{
				setState(191);
				expr(0);
				setState(192);
				match(Equality);
				setState(193);
				expr(0);
				}
				break;
			case 2:
				enterOuterAlt(_localctx, 2);
				{
				setState(195);
				expr(0);
				setState(196);
				match(InEquality);
				setState(197);
				expr(0);
				}
				break;
			case 3:
				enterOuterAlt(_localctx, 3);
				{
				setState(199);
				expr(0);
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

	public static class ExprContext extends ParserRuleContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Plus() { return getToken(GMMParser.Plus, 0); }
		public TerminalNode Minus() { return getToken(GMMParser.Minus, 0); }
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterExpr(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitExpr(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExpr(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExprContext expr() throws RecognitionException {
		return expr(0);
	}

	private ExprContext expr(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		ExprContext _localctx = new ExprContext(_ctx, _parentState);
		ExprContext _prevctx = _localctx;
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			setState(203);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(213);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(211);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(205);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(206);
						match(Plus);
						setState(207);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new ExprContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(208);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(209);
						match(Minus);
						setState(210);
						term(0);
						}
						break;
					}
					} 
				}
				setState(215);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class TermContext extends ParserRuleContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode Times() { return getToken(GMMParser.Times, 0); }
		public TerminalNode Divide() { return getToken(GMMParser.Divide, 0); }
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterTerm(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitTerm(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitTerm(this);
			else return visitor.visitChildren(this);
		}
	}

	public final TermContext term() throws RecognitionException {
		return term(0);
	}

	private TermContext term(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		TermContext _localctx = new TermContext(_ctx, _parentState);
		TermContext _prevctx = _localctx;
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(218);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				{
				}
				break;
			case 2:
				{
				setState(217);
				factor();
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(228);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(226);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(220);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(221);
						match(Times);
						setState(222);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new TermContext(_parentctx, _parentState);
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(223);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(224);
						match(Divide);
						setState(225);
						factor();
						}
						break;
					}
					} 
				}
				setState(230);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			}
			}
		}
		catch (RecognitionException re) {
			_localctx.exception = re;
			_errHandler.reportError(this, re);
			_errHandler.recover(this, re);
		}
		finally {
			unrollRecursionContexts(_parentctx);
		}
		return _localctx;
	}

	public static class FactorContext extends ParserRuleContext {
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public TerminalNode INT() { return getToken(GMMParser.INT, 0); }
		public TerminalNode True() { return getToken(GMMParser.True, 0); }
		public TerminalNode False() { return getToken(GMMParser.False, 0); }
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
		@Override
		public void enterRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).enterFactor(this);
		}
		@Override
		public void exitRule(ParseTreeListener listener) {
			if ( listener instanceof GMMListener ) ((GMMListener)listener).exitFactor(this);
		}
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFactor(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(238);
			_errHandler.sync(this);
			switch (_input.LA(1)) {
			case LParan:
				enterOuterAlt(_localctx, 1);
				{
				setState(231);
				match(LParan);
				setState(232);
				expr(0);
				setState(233);
				match(RParan);
				}
				break;
			case INT:
				enterOuterAlt(_localctx, 2);
				{
				setState(235);
				match(INT);
				}
				break;
			case True:
				enterOuterAlt(_localctx, 3);
				{
				setState(236);
				match(True);
				}
				break;
			case False:
				enterOuterAlt(_localctx, 4);
				{
				setState(237);
				match(False);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 12:
			return logic_sempred((LogicContext)_localctx, predIndex);
		case 14:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 15:
			return term_sempred((TermContext)_localctx, predIndex);
		}
		return true;
	}
	private boolean logic_sempred(LogicContext _localctx, int predIndex) {
		switch (predIndex) {
		case 0:
			return precpred(_ctx, 3);
		case 1:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean expr_sempred(ExprContext _localctx, int predIndex) {
		switch (predIndex) {
		case 2:
			return precpred(_ctx, 3);
		case 3:
			return precpred(_ctx, 2);
		}
		return true;
	}
	private boolean term_sempred(TermContext _localctx, int predIndex) {
		switch (predIndex) {
		case 4:
			return precpred(_ctx, 3);
		case 5:
			return precpred(_ctx, 2);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3\"\u00f3\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4"+
		"\7\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\t\3\t\3\t\5\t\u0080\n\t\3\t"+
		"\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008b\n\t\3\n\3\n\6\n\u008f\n\n\r"+
		"\n\16\n\u0090\3\n\3\n\6\n\u0095\n\n\r\n\16\n\u0096\3\n\3\n\6\n\u009b\n"+
		"\n\r\n\16\n\u009c\5\n\u009f\n\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\5\13"+
		"\u00a8\n\13\3\f\3\f\3\f\7\f\u00ad\n\f\f\f\16\f\u00b0\13\f\3\r\3\r\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00bd\n\16\f\16\16\16\u00c0"+
		"\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00cb\n\17\3"+
		"\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00d6\n\20\f\20\16\20"+
		"\u00d9\13\20\3\21\3\21\5\21\u00dd\n\21\3\21\3\21\3\21\3\21\3\21\3\21\7"+
		"\21\u00e5\n\21\f\21\16\21\u00e8\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\5\22\u00f1\n\22\3\22\2\5\32\36 \23\2\4\6\b\n\f\16\20\22\24\26\30\32"+
		"\34\36 \"\2\2\2\u0105\2(\3\2\2\2\4+\3\2\2\2\6;\3\2\2\2\bJ\3\2\2\2\nR\3"+
		"\2\2\2\fU\3\2\2\2\16]\3\2\2\2\20\u008a\3\2\2\2\22\u009e\3\2\2\2\24\u00a7"+
		"\3\2\2\2\26\u00a9\3\2\2\2\30\u00b1\3\2\2\2\32\u00b3\3\2\2\2\34\u00ca\3"+
		"\2\2\2\36\u00cc\3\2\2\2 \u00dc\3\2\2\2\"\u00f0\3\2\2\2$\'\5\4\3\2%\'\5"+
		"\6\4\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\3\3\2\2\2*"+
		"(\3\2\2\2+,\7\3\2\2,-\7!\2\2-/\7\25\2\2.\60\5\b\5\2/.\3\2\2\2/\60\3\2"+
		"\2\2\60\61\3\2\2\2\61\62\7\26\2\2\62\66\7\31\2\2\63\65\5\20\t\2\64\63"+
		"\3\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2"+
		"\29:\7\32\2\2:\5\3\2\2\2;<\7!\2\2<>\7\27\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2"+
		"\2\2?@\3\2\2\2@A\7\30\2\2AE\7\31\2\2BD\5\20\t\2CB\3\2\2\2DG\3\2\2\2EC"+
		"\3\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\32\2\2I\7\3\2\2\2JO\5\n\6\2"+
		"KL\7\21\2\2LN\5\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2"+
		"\2QO\3\2\2\2RS\7\36\2\2ST\7!\2\2T\13\3\2\2\2UZ\5\16\b\2VW\7\21\2\2WY\5"+
		"\16\b\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2"+
		"]^\7!\2\2^_\7\22\2\2_`\7\17\2\2`\17\3\2\2\2a\u008b\5\6\4\2bc\7\23\2\2"+
		"cd\7\25\2\2de\5\30\r\2ef\7\26\2\2fj\7\31\2\2gi\5\20\t\2hg\3\2\2\2il\3"+
		"\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2mn\7\32\2\2n\u008b\3\2\2"+
		"\2op\7\24\2\2pq\7\25\2\2qr\5\30\r\2rs\7\26\2\2sw\7\31\2\2tv\5\20\t\2u"+
		"t\3\2\2\2vy\3\2\2\2wu\3\2\2\2wx\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\32\2\2"+
		"{\u008b\3\2\2\2|}\7!\2\2}\177\7\25\2\2~\u0080\5\26\f\2\177~\3\2\2\2\177"+
		"\u0080\3\2\2\2\u0080\u0081\3\2\2\2\u0081\u008b\7\26\2\2\u0082\u0083\7"+
		"!\2\2\u0083\u0084\7\4\2\2\u0084\u008b\5\30\r\2\u0085\u0086\7\36\2\2\u0086"+
		"\u0087\7!\2\2\u0087\u0088\7\4\2\2\u0088\u008b\5\30\r\2\u0089\u008b\5\22"+
		"\n\2\u008aa\3\2\2\2\u008ab\3\2\2\2\u008ao\3\2\2\2\u008a|\3\2\2\2\u008a"+
		"\u0082\3\2\2\2\u008a\u0085\3\2\2\2\u008a\u0089\3\2\2\2\u008b\21\3\2\2"+
		"\2\u008c\u008e\7\33\2\2\u008d\u008f\5\24\13\2\u008e\u008d\3\2\2\2\u008f"+
		"\u0090\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091\3\2\2\2\u0091\u009f\3\2"+
		"\2\2\u0092\u0094\7\35\2\2\u0093\u0095\5\24\13\2\u0094\u0093\3\2\2\2\u0095"+
		"\u0096\3\2\2\2\u0096\u0094\3\2\2\2\u0096\u0097\3\2\2\2\u0097\u009f\3\2"+
		"\2\2\u0098\u009a\7\34\2\2\u0099\u009b\5\24\13\2\u009a\u0099\3\2\2\2\u009b"+
		"\u009c\3\2\2\2\u009c\u009a\3\2\2\2\u009c\u009d\3\2\2\2\u009d\u009f\3\2"+
		"\2\2\u009e\u008c\3\2\2\2\u009e\u0092\3\2\2\2\u009e\u0098\3\2\2\2\u009f"+
		"\23\3\2\2\2\u00a0\u00a1\7 \2\2\u00a1\u00a2\7\4\2\2\u00a2\u00a8\5\30\r"+
		"\2\u00a3\u00a4\7 \2\2\u00a4\u00a5\7\4\2\2\u00a5\u00a6\7\37\2\2\u00a6\u00a8"+
		"\5\30\r\2\u00a7\u00a0\3\2\2\2\u00a7\u00a3\3\2\2\2\u00a8\25\3\2\2\2\u00a9"+
		"\u00ae\5\30\r\2\u00aa\u00ab\7\21\2\2\u00ab\u00ad\5\30\r\2\u00ac\u00aa"+
		"\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3\2\2\2\u00ae\u00af\3\2\2\2\u00af"+
		"\27\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1\u00b2\5\32\16\2\u00b2\31\3\2\2\2"+
		"\u00b3\u00b4\b\16\1\2\u00b4\u00b5\5\34\17\2\u00b5\u00be\3\2\2\2\u00b6"+
		"\u00b7\f\5\2\2\u00b7\u00b8\7\t\2\2\u00b8\u00bd\5\34\17\2\u00b9\u00ba\f"+
		"\4\2\2\u00ba\u00bb\7\n\2\2\u00bb\u00bd\5\34\17\2\u00bc\u00b6\3\2\2\2\u00bc"+
		"\u00b9\3\2\2\2\u00bd\u00c0\3\2\2\2\u00be\u00bc\3\2\2\2\u00be\u00bf\3\2"+
		"\2\2\u00bf\33\3\2\2\2\u00c0\u00be\3\2\2\2\u00c1\u00c2\5\36\20\2\u00c2"+
		"\u00c3\7\13\2\2\u00c3\u00c4\5\36\20\2\u00c4\u00cb\3\2\2\2\u00c5\u00c6"+
		"\5\36\20\2\u00c6\u00c7\7\f\2\2\u00c7\u00c8\5\36\20\2\u00c8\u00cb\3\2\2"+
		"\2\u00c9\u00cb\5\36\20\2\u00ca\u00c1\3\2\2\2\u00ca\u00c5\3\2\2\2\u00ca"+
		"\u00c9\3\2\2\2\u00cb\35\3\2\2\2\u00cc\u00cd\b\20\1\2\u00cd\u00ce\5 \21"+
		"\2\u00ce\u00d7\3\2\2\2\u00cf\u00d0\f\5\2\2\u00d0\u00d1\7\5\2\2\u00d1\u00d6"+
		"\5 \21\2\u00d2\u00d3\f\4\2\2\u00d3\u00d4\7\6\2\2\u00d4\u00d6\5 \21\2\u00d5"+
		"\u00cf\3\2\2\2\u00d5\u00d2\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2"+
		"\2\2\u00d7\u00d8\3\2\2\2\u00d8\37\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00dd"+
		"\b\21\1\2\u00db\u00dd\5\"\22\2\u00dc\u00da\3\2\2\2\u00dc\u00db\3\2\2\2"+
		"\u00dd\u00e6\3\2\2\2\u00de\u00df\f\5\2\2\u00df\u00e0\7\7\2\2\u00e0\u00e5"+
		"\5\"\22\2\u00e1\u00e2\f\4\2\2\u00e2\u00e3\7\b\2\2\u00e3\u00e5\5\"\22\2"+
		"\u00e4\u00de\3\2\2\2\u00e4\u00e1\3\2\2\2\u00e5\u00e8\3\2\2\2\u00e6\u00e4"+
		"\3\2\2\2\u00e6\u00e7\3\2\2\2\u00e7!\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e9"+
		"\u00ea\7\25\2\2\u00ea\u00eb\5\36\20\2\u00eb\u00ec\7\26\2\2\u00ec\u00f1"+
		"\3\2\2\2\u00ed\u00f1\7\17\2\2\u00ee\u00f1\7\r\2\2\u00ef\u00f1\7\16\2\2"+
		"\u00f0\u00e9\3\2\2\2\u00f0\u00ed\3\2\2\2\u00f0\u00ee\3\2\2\2\u00f0\u00ef"+
		"\3\2\2\2\u00f1#\3\2\2\2\35&(/\66>EOZjw\177\u008a\u0090\u0096\u009c\u009e"+
		"\u00a7\u00ae\u00bc\u00be\u00ca\u00d5\u00d7\u00dc\u00e4\u00e6\u00f0";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}