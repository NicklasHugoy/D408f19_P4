package dk.aau.cs.Syntax;// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/D408f19_P4\GMM.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.atn.*;
import org.antlr.v4.runtime.dfa.DFA;
import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import java.util.List;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class GMMParser extends Parser {
	static { RuntimeMetaData.checkVersion("4.7.2", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		Sqrt=1, Return=2, Equals=3, Plus=4, Minus=5, Times=6, Divide=7, And=8, 
		Or=9, Equality=10, InEquality=11, GreaterThan=12, LessThan=13, True=14, 
		False=15, INT=16, SemiColon=17, CommaSeperator=18, DotOperator=19, Colon=20, 
		While=21, If=22, LParan=23, RParan=24, LSquare=25, RSquare=26, LCurl=27, 
		RCurl=28, RapidMoveCommand=29, MoveCommand=30, LeftCircleCommand=31, RightCircleCommand=32, 
		Type=33, AbsoluteParameter=34, CommandParameter=35, GCode=36, GCodeVarRef=37, 
		ID=38, BlockParam=39, WS=40;
	public static final int
		RULE_prog = 0, RULE_functionDef = 1, RULE_blockDef = 2, RULE_formalParameters = 3, 
		RULE_formalParameter = 4, RULE_machineOptions = 5, RULE_machineOption = 6, 
		RULE_scopedStmt = 7, RULE_functionCall = 8, RULE_vectorCommandParameter = 9, 
		RULE_singleCommandParameter = 10, RULE_parameters = 11, RULE_expression = 12, 
		RULE_logic = 13, RULE_booleanExpr = 14, RULE_expr = 15, RULE_term = 16, 
		RULE_factor = 17;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "functionDef", "blockDef", "formalParameters", "formalParameter", 
			"machineOptions", "machineOption", "scopedStmt", "functionCall", "vectorCommandParameter", 
			"singleCommandParameter", "parameters", "expression", "logic", "booleanExpr", 
			"expr", "term", "factor"
		};
	}
	public static final String[] ruleNames = makeRuleNames();

	private static String[] makeLiteralNames() {
		return new String[] {
			null, "'sqrt'", "'return '", "'='", "'+'", "'-'", "'*'", "'/'", "'&&'", 
			"'||'", "'=='", "'!='", "'>'", "'<'", "'true'", "'false'", null, "';'", 
			"','", "'.'", "':'", "'while'", "'if'", "'('", "')'", "'['", "']'", "'{'", 
			"'}'", "'jump '", "'move '", "'leftCircle '", "'rightCircle '", null, 
			"'$'"
		};
	}
	private static final String[] _LITERAL_NAMES = makeLiteralNames();
	private static String[] makeSymbolicNames() {
		return new String[] {
			null, "Sqrt", "Return", "Equals", "Plus", "Minus", "Times", "Divide", 
			"And", "Or", "Equality", "InEquality", "GreaterThan", "LessThan", "True", 
			"False", "INT", "SemiColon", "CommaSeperator", "DotOperator", "Colon", 
			"While", "If", "LParan", "RParan", "LSquare", "RSquare", "LCurl", "RCurl", 
			"RapidMoveCommand", "MoveCommand", "LeftCircleCommand", "RightCircleCommand", 
			"Type", "AbsoluteParameter", "CommandParameter", "GCode", "GCodeVarRef", 
			"ID", "BlockParam", "WS"
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
			setState(40);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Type || _la==ID) {
				{
				setState(38);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
					{
					setState(36);
					functionDef();
					}
					break;
				case ID:
					{
					setState(37);
					blockDef();
					}
					break;
				default:
					throw new NoViableAltException(this);
				}
				}
				setState(42);
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
		public TerminalNode Type() { return getToken(GMMParser.Type, 0); }
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
			setState(43);
			match(Type);
			setState(44);
			match(ID);
			setState(45);
			match(LParan);
			setState(47);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==Type) {
				{
				setState(46);
				formalParameters();
				}
			}

			setState(49);
			match(RParan);
			setState(50);
			match(LCurl);
			setState(54);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << RapidMoveCommand) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
				{
				{
				setState(51);
				scopedStmt();
				}
				}
				setState(56);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(57);
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
			setState(59);
			match(ID);
			setState(60);
			match(LSquare);
			setState(62);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if (_la==BlockParam) {
				{
				setState(61);
				machineOptions();
				}
			}

			setState(64);
			match(RSquare);
			setState(65);
			match(LCurl);
			setState(69);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << RapidMoveCommand) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
				{
				{
				setState(66);
				scopedStmt();
				}
				}
				setState(71);
				_errHandler.sync(this);
				_la = _input.LA(1);
			}
			setState(72);
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
			setState(74);
			formalParameter();
			setState(79);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(75);
				match(CommaSeperator);
				setState(76);
				formalParameter();
				}
				}
				setState(81);
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
			setState(82);
			match(Type);
			setState(83);
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
			setState(85);
			machineOption();
			setState(90);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(86);
				match(CommaSeperator);
				setState(87);
				machineOption();
				}
				}
				setState(92);
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
		public TerminalNode BlockParam() { return getToken(GMMParser.BlockParam, 0); }
		public MachineOptionContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_machineOption; }
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
			setState(93);
			match(BlockParam);
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
	public static class FunctionReturnContext extends ScopedStmtContext {
		public TerminalNode Return() { return getToken(GMMParser.Return, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public FunctionReturnContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFunctionReturn(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class RightCircleContext extends ScopedStmtContext {
		public TerminalNode RightCircleCommand() { return getToken(GMMParser.RightCircleCommand, 0); }
		public VectorCommandParameterContext vectorCommandParameter() {
			return getRuleContext(VectorCommandParameterContext.class,0);
		}
		public List<SingleCommandParameterContext> singleCommandParameter() {
			return getRuleContexts(SingleCommandParameterContext.class);
		}
		public SingleCommandParameterContext singleCommandParameter(int i) {
			return getRuleContext(SingleCommandParameterContext.class,i);
		}
		public RightCircleContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitRightCircle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class JumpContext extends ScopedStmtContext {
		public TerminalNode RapidMoveCommand() { return getToken(GMMParser.RapidMoveCommand, 0); }
		public VectorCommandParameterContext vectorCommandParameter() {
			return getRuleContext(VectorCommandParameterContext.class,0);
		}
		public List<SingleCommandParameterContext> singleCommandParameter() {
			return getRuleContexts(SingleCommandParameterContext.class);
		}
		public SingleCommandParameterContext singleCommandParameter(int i) {
			return getRuleContext(SingleCommandParameterContext.class,i);
		}
		public JumpContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitJump(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExplicitGCodeContext extends ScopedStmtContext {
		public TerminalNode GCode() { return getToken(GMMParser.GCode, 0); }
		public ExplicitGCodeContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExplicitGCode(this);
			else return visitor.visitChildren(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitIfStatement(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoveContext extends ScopedStmtContext {
		public TerminalNode MoveCommand() { return getToken(GMMParser.MoveCommand, 0); }
		public VectorCommandParameterContext vectorCommandParameter() {
			return getRuleContext(VectorCommandParameterContext.class,0);
		}
		public List<SingleCommandParameterContext> singleCommandParameter() {
			return getRuleContexts(SingleCommandParameterContext.class);
		}
		public SingleCommandParameterContext singleCommandParameter(int i) {
			return getRuleContext(SingleCommandParameterContext.class,i);
		}
		public MoveContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitMove(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VectorComponentAssignContext extends ScopedStmtContext {
		public List<TerminalNode> ID() { return getTokens(GMMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GMMParser.ID, i);
		}
		public TerminalNode DotOperator() { return getToken(GMMParser.DotOperator, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VectorComponentAssignContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitVectorComponentAssign(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BlockContext extends ScopedStmtContext {
		public BlockDefContext blockDef() {
			return getRuleContext(BlockDefContext.class,0);
		}
		public BlockContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitBlock(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ScopedStmtFunctionCallContext extends ScopedStmtContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ScopedStmtFunctionCallContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitScopedStmtFunctionCall(this);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitWhileLoop(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LeftCircleContext extends ScopedStmtContext {
		public TerminalNode LeftCircleCommand() { return getToken(GMMParser.LeftCircleCommand, 0); }
		public VectorCommandParameterContext vectorCommandParameter() {
			return getRuleContext(VectorCommandParameterContext.class,0);
		}
		public List<SingleCommandParameterContext> singleCommandParameter() {
			return getRuleContexts(SingleCommandParameterContext.class);
		}
		public SingleCommandParameterContext singleCommandParameter(int i) {
			return getRuleContext(SingleCommandParameterContext.class,i);
		}
		public LeftCircleContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLeftCircle(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ScopedStmtContext scopedStmt() throws RecognitionException {
		ScopedStmtContext _localctx = new ScopedStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scopedStmt);
		int _la;
		try {
			setState(178);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,18,_ctx) ) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << RapidMoveCommand) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
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
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << RapidMoveCommand) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
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
				_localctx = new ScopedStmtFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(122);
				functionCall();
				}
				break;
			case 5:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(123);
				match(ID);
				setState(124);
				match(Equals);
				setState(125);
				expression();
				}
				break;
			case 6:
				_localctx = new VectorComponentAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(126);
				match(ID);
				setState(127);
				match(DotOperator);
				setState(128);
				match(ID);
				setState(129);
				match(Equals);
				setState(130);
				expression();
				}
				break;
			case 7:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 7);
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
			case 8:
				_localctx = new MoveContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(135);
				match(MoveCommand);
				setState(137);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,10,_ctx) ) {
				case 1:
					{
					setState(136);
					vectorCommandParameter();
					}
					break;
				}
				setState(142);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CommandParameter) {
					{
					{
					setState(139);
					singleCommandParameter();
					}
					}
					setState(144);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 9:
				_localctx = new RightCircleContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(145);
				match(RightCircleCommand);
				setState(147);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,12,_ctx) ) {
				case 1:
					{
					setState(146);
					vectorCommandParameter();
					}
					break;
				}
				setState(152);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CommandParameter) {
					{
					{
					setState(149);
					singleCommandParameter();
					}
					}
					setState(154);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 10:
				_localctx = new LeftCircleContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(155);
				match(LeftCircleCommand);
				setState(157);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,14,_ctx) ) {
				case 1:
					{
					setState(156);
					vectorCommandParameter();
					}
					break;
				}
				setState(162);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CommandParameter) {
					{
					{
					setState(159);
					singleCommandParameter();
					}
					}
					setState(164);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 11:
				_localctx = new JumpContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(165);
				match(RapidMoveCommand);
				setState(167);
				_errHandler.sync(this);
				switch ( getInterpreter().adaptivePredict(_input,16,_ctx) ) {
				case 1:
					{
					setState(166);
					vectorCommandParameter();
					}
					break;
				}
				setState(172);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while (_la==CommandParameter) {
					{
					{
					setState(169);
					singleCommandParameter();
					}
					}
					setState(174);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				}
				break;
			case 12:
				_localctx = new FunctionReturnContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(175);
				match(Return);
				setState(176);
				expression();
				}
				break;
			case 13:
				_localctx = new ExplicitGCodeContext(_localctx);
				enterOuterAlt(_localctx, 13);
				{
				setState(177);
				match(GCode);
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

	public static class FunctionCallContext extends ParserRuleContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public ParametersContext parameters() {
			return getRuleContext(ParametersContext.class,0);
		}
		public FunctionCallContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_functionCall; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FunctionCallContext functionCall() throws RecognitionException {
		FunctionCallContext _localctx = new FunctionCallContext(_ctx, getState());
		enterRule(_localctx, 16, RULE_functionCall);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
			match(ID);
			setState(181);
			match(LParan);
			setState(183);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Sqrt) | (1L << Minus) | (1L << True) | (1L << False) | (1L << INT) | (1L << LParan) | (1L << ID))) != 0)) {
				{
				setState(182);
				parameters();
				}
			}

			setState(185);
			match(RParan);
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

	public static class VectorCommandParameterContext extends ParserRuleContext {
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public VectorCommandParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_vectorCommandParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitVectorCommandParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final VectorCommandParameterContext vectorCommandParameter() throws RecognitionException {
		VectorCommandParameterContext _localctx = new VectorCommandParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_vectorCommandParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(187);
			expression();
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

	public static class SingleCommandParameterContext extends ParserRuleContext {
		public TerminalNode CommandParameter() { return getToken(GMMParser.CommandParameter, 0); }
		public TerminalNode Equals() { return getToken(GMMParser.Equals, 0); }
		public ExpressionContext expression() {
			return getRuleContext(ExpressionContext.class,0);
		}
		public SingleCommandParameterContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_singleCommandParameter; }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitSingleCommandParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final SingleCommandParameterContext singleCommandParameter() throws RecognitionException {
		SingleCommandParameterContext _localctx = new SingleCommandParameterContext(_ctx, getState());
		enterRule(_localctx, 20, RULE_singleCommandParameter);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(189);
			match(CommandParameter);
			setState(190);
			match(Equals);
			setState(191);
			expression();
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitParameters(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ParametersContext parameters() throws RecognitionException {
		ParametersContext _localctx = new ParametersContext(_ctx, getState());
		enterRule(_localctx, 22, RULE_parameters);
		int _la;
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(193);
			expression();
			setState(198);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(194);
				match(CommaSeperator);
				setState(195);
				expression();
				}
				}
				setState(200);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExpression(this);
			else return visitor.visitChildren(this);
		}
	}

	public final ExpressionContext expression() throws RecognitionException {
		ExpressionContext _localctx = new ExpressionContext(_ctx, getState());
		enterRule(_localctx, 24, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(201);
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
		public LogicContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_logic; }
	 
		public LogicContext() { }
		public void copyFrom(LogicContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AndLogicContext extends LogicContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public TerminalNode And() { return getToken(GMMParser.And, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public AndLogicContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitAndLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LogicDerivationContext extends LogicContext {
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public LogicDerivationContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLogicDerivation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class OrLogicContext extends LogicContext {
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public TerminalNode Or() { return getToken(GMMParser.Or, 0); }
		public BooleanExprContext booleanExpr() {
			return getRuleContext(BooleanExprContext.class,0);
		}
		public OrLogicContext(LogicContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitOrLogic(this);
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
		int _startState = 26;
		enterRecursionRule(_localctx, 26, RULE_logic, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LogicDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(204);
			booleanExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(214);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,22,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(212);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,21,_ctx) ) {
					case 1:
						{
						_localctx = new AndLogicContext(new LogicContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(206);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(207);
						match(And);
						setState(208);
						booleanExpr();
						}
						break;
					case 2:
						{
						_localctx = new OrLogicContext(new LogicContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(209);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(210);
						match(Or);
						setState(211);
						booleanExpr();
						}
						break;
					}
					} 
				}
				setState(216);
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

	public static class BooleanExprContext extends ParserRuleContext {
		public BooleanExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_booleanExpr; }
	 
		public BooleanExprContext() { }
		public void copyFrom(BooleanExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class EqualityExprContext extends BooleanExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode Equality() { return getToken(GMMParser.Equality, 0); }
		public EqualityExprContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class GreaterThanExprContext extends BooleanExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode GreaterThan() { return getToken(GMMParser.GreaterThan, 0); }
		public GreaterThanExprContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitGreaterThanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanLogicContext extends BooleanExprContext {
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public LogicContext logic() {
			return getRuleContext(LogicContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public ParanLogicContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitParanLogic(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class InEqualityExprContext extends BooleanExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode InEquality() { return getToken(GMMParser.InEquality, 0); }
		public InEqualityExprContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitInEqualityExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LessThanExprContext extends BooleanExprContext {
		public List<ExprContext> expr() {
			return getRuleContexts(ExprContext.class);
		}
		public ExprContext expr(int i) {
			return getRuleContext(ExprContext.class,i);
		}
		public TerminalNode LessThan() { return getToken(GMMParser.LessThan, 0); }
		public LessThanExprContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLessThanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class BooleanExprDerivationContext extends BooleanExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public BooleanExprDerivationContext(BooleanExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitBooleanExprDerivation(this);
			else return visitor.visitChildren(this);
		}
	}

	public final BooleanExprContext booleanExpr() throws RecognitionException {
		BooleanExprContext _localctx = new BooleanExprContext(_ctx, getState());
		enterRule(_localctx, 28, RULE_booleanExpr);
		try {
			setState(238);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,23,_ctx) ) {
			case 1:
				_localctx = new EqualityExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(217);
				expr(0);
				setState(218);
				match(Equality);
				setState(219);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InEqualityExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(221);
				expr(0);
				setState(222);
				match(InEquality);
				setState(223);
				expr(0);
				}
				break;
			case 3:
				_localctx = new GreaterThanExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(225);
				expr(0);
				setState(226);
				match(GreaterThan);
				setState(227);
				expr(0);
				}
				break;
			case 4:
				_localctx = new LessThanExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(229);
				expr(0);
				setState(230);
				match(LessThan);
				setState(231);
				expr(0);
				}
				break;
			case 5:
				_localctx = new ParanLogicContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(233);
				match(LParan);
				setState(234);
				logic(0);
				setState(235);
				match(RParan);
				}
				break;
			case 6:
				_localctx = new BooleanExprDerivationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(237);
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
		public ExprContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_expr; }
	 
		public ExprContext() { }
		public void copyFrom(ExprContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class PlusExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Plus() { return getToken(GMMParser.Plus, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public PlusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitPlusExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExprDerivationContext extends ExprContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public ExprDerivationContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExprDerivation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MinusExprContext extends ExprContext {
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode Minus() { return getToken(GMMParser.Minus, 0); }
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public MinusExprContext(ExprContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitMinusExpr(this);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(241);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(251);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,25,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(249);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
					case 1:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(243);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(244);
						match(Plus);
						setState(245);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(246);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(247);
						match(Minus);
						setState(248);
						term(0);
						}
						break;
					}
					} 
				}
				setState(253);
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

	public static class TermContext extends ParserRuleContext {
		public TermContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_term; }
	 
		public TermContext() { }
		public void copyFrom(TermContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class TermDerivationContext extends TermContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TermDerivationContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitTermDerivation(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class DivideTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode Divide() { return getToken(GMMParser.Divide, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public DivideTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitDivideTerm(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class TimesTermContext extends TermContext {
		public TermContext term() {
			return getRuleContext(TermContext.class,0);
		}
		public TerminalNode Times() { return getToken(GMMParser.Times, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TimesTermContext(TermContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitTimesTerm(this);
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
		int _startState = 32;
		enterRecursionRule(_localctx, 32, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(255);
			factor(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(265);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(263);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,26,_ctx) ) {
					case 1:
						{
						_localctx = new TimesTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(257);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(258);
						match(Times);
						setState(259);
						factor(0);
						}
						break;
					case 2:
						{
						_localctx = new DivideTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(260);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(261);
						match(Divide);
						setState(262);
						factor(0);
						}
						break;
					}
					} 
				}
				setState(267);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,27,_ctx);
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
		public FactorContext(ParserRuleContext parent, int invokingState) {
			super(parent, invokingState);
		}
		@Override public int getRuleIndex() { return RULE_factor; }
	 
		public FactorContext() { }
		public void copyFrom(FactorContext ctx) {
			super.copyFrom(ctx);
		}
	}
	public static class AccessVectorContext extends FactorContext {
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public TerminalNode DotOperator() { return getToken(GMMParser.DotOperator, 0); }
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public AccessVectorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitAccessVector(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ParanExprContext extends FactorContext {
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public ParanExprContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitParanExpr(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralFalseContext extends FactorContext {
		public TerminalNode False() { return getToken(GMMParser.False, 0); }
		public LiteralFalseContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLiteralFalse(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class VariableContext extends FactorContext {
		public TerminalNode ID() { return getToken(GMMParser.ID, 0); }
		public VariableContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitVariable(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class SquareRootContext extends FactorContext {
		public TerminalNode Sqrt() { return getToken(GMMParser.Sqrt, 0); }
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
		public ExprContext expr() {
			return getRuleContext(ExprContext.class,0);
		}
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public SquareRootContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitSquareRoot(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralVectorContext extends FactorContext {
		public TerminalNode LParan() { return getToken(GMMParser.LParan, 0); }
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
		public TerminalNode RParan() { return getToken(GMMParser.RParan, 0); }
		public LiteralVectorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLiteralVector(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class NegatedFactorContext extends FactorContext {
		public TerminalNode Minus() { return getToken(GMMParser.Minus, 0); }
		public FactorContext factor() {
			return getRuleContext(FactorContext.class,0);
		}
		public NegatedFactorContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitNegatedFactor(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class ExpressionFunctionCallContext extends FactorContext {
		public FunctionCallContext functionCall() {
			return getRuleContext(FunctionCallContext.class,0);
		}
		public ExpressionFunctionCallContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitExpressionFunctionCall(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralIntContext extends FactorContext {
		public TerminalNode INT() { return getToken(GMMParser.INT, 0); }
		public LiteralIntContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLiteralInt(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class LiteralTrueContext extends FactorContext {
		public TerminalNode True() { return getToken(GMMParser.True, 0); }
		public LiteralTrueContext(FactorContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLiteralTrue(this);
			else return visitor.visitChildren(this);
		}
	}

	public final FactorContext factor() throws RecognitionException {
		return factor(0);
	}

	private FactorContext factor(int _p) throws RecognitionException {
		ParserRuleContext _parentctx = _ctx;
		int _parentState = getState();
		FactorContext _localctx = new FactorContext(_ctx, _parentState);
		FactorContext _prevctx = _localctx;
		int _startState = 34;
		enterRecursionRule(_localctx, 34, RULE_factor, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			setState(293);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,28,_ctx) ) {
			case 1:
				{
				_localctx = new ParanExprContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;

				setState(269);
				match(LParan);
				setState(270);
				expr(0);
				setState(271);
				match(RParan);
				}
				break;
			case 2:
				{
				_localctx = new LiteralIntContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(273);
				match(INT);
				}
				break;
			case 3:
				{
				_localctx = new LiteralTrueContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(274);
				match(True);
				}
				break;
			case 4:
				{
				_localctx = new LiteralFalseContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(275);
				match(False);
				}
				break;
			case 5:
				{
				_localctx = new VariableContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(276);
				match(ID);
				}
				break;
			case 6:
				{
				_localctx = new SquareRootContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(277);
				match(Sqrt);
				setState(278);
				match(LParan);
				setState(279);
				expr(0);
				setState(280);
				match(RParan);
				}
				break;
			case 7:
				{
				_localctx = new ExpressionFunctionCallContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(282);
				functionCall();
				}
				break;
			case 8:
				{
				_localctx = new LiteralVectorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(283);
				match(LParan);
				setState(284);
				expression();
				setState(285);
				match(CommaSeperator);
				setState(286);
				expression();
				setState(287);
				match(CommaSeperator);
				setState(288);
				expression();
				setState(289);
				match(RParan);
				}
				break;
			case 9:
				{
				_localctx = new NegatedFactorContext(_localctx);
				_ctx = _localctx;
				_prevctx = _localctx;
				setState(291);
				match(Minus);
				setState(292);
				factor(1);
				}
				break;
			}
			_ctx.stop = _input.LT(-1);
			setState(300);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					{
					_localctx = new AccessVectorContext(new FactorContext(_parentctx, _parentState));
					pushNewRecursionContext(_localctx, _startState, RULE_factor);
					setState(295);
					if (!(precpred(_ctx, 5))) throw new FailedPredicateException(this, "precpred(_ctx, 5)");
					setState(296);
					match(DotOperator);
					setState(297);
					match(ID);
					}
					} 
				}
				setState(302);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,29,_ctx);
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

	public boolean sempred(RuleContext _localctx, int ruleIndex, int predIndex) {
		switch (ruleIndex) {
		case 13:
			return logic_sempred((LogicContext)_localctx, predIndex);
		case 15:
			return expr_sempred((ExprContext)_localctx, predIndex);
		case 16:
			return term_sempred((TermContext)_localctx, predIndex);
		case 17:
			return factor_sempred((FactorContext)_localctx, predIndex);
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
	private boolean factor_sempred(FactorContext _localctx, int predIndex) {
		switch (predIndex) {
		case 6:
			return precpred(_ctx, 5);
		}
		return true;
	}

	public static final String _serializedATN =
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3*\u0132\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\3\2\3\2\7\2)\n\2\f\2\16\2,\13\2\3\3\3\3\3\3\3\3\5\3\62\n\3"+
		"\3\3\3\3\3\3\7\3\67\n\3\f\3\16\3:\13\3\3\3\3\3\3\4\3\4\3\4\5\4A\n\4\3"+
		"\4\3\4\3\4\7\4F\n\4\f\4\16\4I\13\4\3\4\3\4\3\5\3\5\3\5\7\5P\n\5\f\5\16"+
		"\5S\13\5\3\6\3\6\3\6\3\7\3\7\3\7\7\7[\n\7\f\7\16\7^\13\7\3\b\3\b\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\7\ti\n\t\f\t\16\tl\13\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\3\t\3\t\7\tv\n\t\f\t\16\ty\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\5\t\u008c\n\t\3\t\7\t\u008f\n\t\f\t\16"+
		"\t\u0092\13\t\3\t\3\t\5\t\u0096\n\t\3\t\7\t\u0099\n\t\f\t\16\t\u009c\13"+
		"\t\3\t\3\t\5\t\u00a0\n\t\3\t\7\t\u00a3\n\t\f\t\16\t\u00a6\13\t\3\t\3\t"+
		"\5\t\u00aa\n\t\3\t\7\t\u00ad\n\t\f\t\16\t\u00b0\13\t\3\t\3\t\3\t\5\t\u00b5"+
		"\n\t\3\n\3\n\3\n\5\n\u00ba\n\n\3\n\3\n\3\13\3\13\3\f\3\f\3\f\3\f\3\r\3"+
		"\r\3\r\7\r\u00c7\n\r\f\r\16\r\u00ca\13\r\3\16\3\16\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\7\17\u00d7\n\17\f\17\16\17\u00da\13\17\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u00f1\n\20\3\21\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\3\21\3\21\7\21\u00fc\n\21\f\21\16\21\u00ff\13\21\3\22\3\22"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\7\22\u010a\n\22\f\22\16\22\u010d\13"+
		"\22\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3"+
		"\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\3\23\5\23\u0128"+
		"\n\23\3\23\3\23\3\23\7\23\u012d\n\23\f\23\16\23\u0130\13\23\3\23\2\6\34"+
		" \"$\24\2\4\6\b\n\f\16\20\22\24\26\30\32\34\36 \"$\2\2\2\u0153\2*\3\2"+
		"\2\2\4-\3\2\2\2\6=\3\2\2\2\bL\3\2\2\2\nT\3\2\2\2\fW\3\2\2\2\16_\3\2\2"+
		"\2\20\u00b4\3\2\2\2\22\u00b6\3\2\2\2\24\u00bd\3\2\2\2\26\u00bf\3\2\2\2"+
		"\30\u00c3\3\2\2\2\32\u00cb\3\2\2\2\34\u00cd\3\2\2\2\36\u00f0\3\2\2\2 "+
		"\u00f2\3\2\2\2\"\u0100\3\2\2\2$\u0127\3\2\2\2&)\5\4\3\2\')\5\6\4\2(&\3"+
		"\2\2\2(\'\3\2\2\2),\3\2\2\2*(\3\2\2\2*+\3\2\2\2+\3\3\2\2\2,*\3\2\2\2-"+
		".\7#\2\2./\7(\2\2/\61\7\31\2\2\60\62\5\b\5\2\61\60\3\2\2\2\61\62\3\2\2"+
		"\2\62\63\3\2\2\2\63\64\7\32\2\2\648\7\35\2\2\65\67\5\20\t\2\66\65\3\2"+
		"\2\2\67:\3\2\2\28\66\3\2\2\289\3\2\2\29;\3\2\2\2:8\3\2\2\2;<\7\36\2\2"+
		"<\5\3\2\2\2=>\7(\2\2>@\7\33\2\2?A\5\f\7\2@?\3\2\2\2@A\3\2\2\2AB\3\2\2"+
		"\2BC\7\34\2\2CG\7\35\2\2DF\5\20\t\2ED\3\2\2\2FI\3\2\2\2GE\3\2\2\2GH\3"+
		"\2\2\2HJ\3\2\2\2IG\3\2\2\2JK\7\36\2\2K\7\3\2\2\2LQ\5\n\6\2MN\7\24\2\2"+
		"NP\5\n\6\2OM\3\2\2\2PS\3\2\2\2QO\3\2\2\2QR\3\2\2\2R\t\3\2\2\2SQ\3\2\2"+
		"\2TU\7#\2\2UV\7(\2\2V\13\3\2\2\2W\\\5\16\b\2XY\7\24\2\2Y[\5\16\b\2ZX\3"+
		"\2\2\2[^\3\2\2\2\\Z\3\2\2\2\\]\3\2\2\2]\r\3\2\2\2^\\\3\2\2\2_`\7)\2\2"+
		"`\17\3\2\2\2a\u00b5\5\6\4\2bc\7\27\2\2cd\7\31\2\2de\5\32\16\2ef\7\32\2"+
		"\2fj\7\35\2\2gi\5\20\t\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2"+
		"\2\2lj\3\2\2\2mn\7\36\2\2n\u00b5\3\2\2\2op\7\30\2\2pq\7\31\2\2qr\5\32"+
		"\16\2rs\7\32\2\2sw\7\35\2\2tv\5\20\t\2ut\3\2\2\2vy\3\2\2\2wu\3\2\2\2w"+
		"x\3\2\2\2xz\3\2\2\2yw\3\2\2\2z{\7\36\2\2{\u00b5\3\2\2\2|\u00b5\5\22\n"+
		"\2}~\7(\2\2~\177\7\5\2\2\177\u00b5\5\32\16\2\u0080\u0081\7(\2\2\u0081"+
		"\u0082\7\25\2\2\u0082\u0083\7(\2\2\u0083\u0084\7\5\2\2\u0084\u00b5\5\32"+
		"\16\2\u0085\u0086\7#\2\2\u0086\u0087\7(\2\2\u0087\u0088\7\5\2\2\u0088"+
		"\u00b5\5\32\16\2\u0089\u008b\7 \2\2\u008a\u008c\5\24\13\2\u008b\u008a"+
		"\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u0090\3\2\2\2\u008d\u008f\5\26\f\2"+
		"\u008e\u008d\3\2\2\2\u008f\u0092\3\2\2\2\u0090\u008e\3\2\2\2\u0090\u0091"+
		"\3\2\2\2\u0091\u00b5\3\2\2\2\u0092\u0090\3\2\2\2\u0093\u0095\7\"\2\2\u0094"+
		"\u0096\5\24\13\2\u0095\u0094\3\2\2\2\u0095\u0096\3\2\2\2\u0096\u009a\3"+
		"\2\2\2\u0097\u0099\5\26\f\2\u0098\u0097\3\2\2\2\u0099\u009c\3\2\2\2\u009a"+
		"\u0098\3\2\2\2\u009a\u009b\3\2\2\2\u009b\u00b5\3\2\2\2\u009c\u009a\3\2"+
		"\2\2\u009d\u009f\7!\2\2\u009e\u00a0\5\24\13\2\u009f\u009e\3\2\2\2\u009f"+
		"\u00a0\3\2\2\2\u00a0\u00a4\3\2\2\2\u00a1\u00a3\5\26\f\2\u00a2\u00a1\3"+
		"\2\2\2\u00a3\u00a6\3\2\2\2\u00a4\u00a2\3\2\2\2\u00a4\u00a5\3\2\2\2\u00a5"+
		"\u00b5\3\2\2\2\u00a6\u00a4\3\2\2\2\u00a7\u00a9\7\37\2\2\u00a8\u00aa\5"+
		"\24\13\2\u00a9\u00a8\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa\u00ae\3\2\2\2\u00ab"+
		"\u00ad\5\26\f\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac\3"+
		"\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b5\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b2\7\4\2\2\u00b2\u00b5\5\32\16\2\u00b3\u00b5\7&\2\2\u00b4a\3\2\2\2"+
		"\u00b4b\3\2\2\2\u00b4o\3\2\2\2\u00b4|\3\2\2\2\u00b4}\3\2\2\2\u00b4\u0080"+
		"\3\2\2\2\u00b4\u0085\3\2\2\2\u00b4\u0089\3\2\2\2\u00b4\u0093\3\2\2\2\u00b4"+
		"\u009d\3\2\2\2\u00b4\u00a7\3\2\2\2\u00b4\u00b1\3\2\2\2\u00b4\u00b3\3\2"+
		"\2\2\u00b5\21\3\2\2\2\u00b6\u00b7\7(\2\2\u00b7\u00b9\7\31\2\2\u00b8\u00ba"+
		"\5\30\r\2\u00b9\u00b8\3\2\2\2\u00b9\u00ba\3\2\2\2\u00ba\u00bb\3\2\2\2"+
		"\u00bb\u00bc\7\32\2\2\u00bc\23\3\2\2\2\u00bd\u00be\5\32\16\2\u00be\25"+
		"\3\2\2\2\u00bf\u00c0\7%\2\2\u00c0\u00c1\7\5\2\2\u00c1\u00c2\5\32\16\2"+
		"\u00c2\27\3\2\2\2\u00c3\u00c8\5\32\16\2\u00c4\u00c5\7\24\2\2\u00c5\u00c7"+
		"\5\32\16\2\u00c6\u00c4\3\2\2\2\u00c7\u00ca\3\2\2\2\u00c8\u00c6\3\2\2\2"+
		"\u00c8\u00c9\3\2\2\2\u00c9\31\3\2\2\2\u00ca\u00c8\3\2\2\2\u00cb\u00cc"+
		"\5\34\17\2\u00cc\33\3\2\2\2\u00cd\u00ce\b\17\1\2\u00ce\u00cf\5\36\20\2"+
		"\u00cf\u00d8\3\2\2\2\u00d0\u00d1\f\5\2\2\u00d1\u00d2\7\n\2\2\u00d2\u00d7"+
		"\5\36\20\2\u00d3\u00d4\f\4\2\2\u00d4\u00d5\7\13\2\2\u00d5\u00d7\5\36\20"+
		"\2\u00d6\u00d0\3\2\2\2\u00d6\u00d3\3\2\2\2\u00d7\u00da\3\2\2\2\u00d8\u00d6"+
		"\3\2\2\2\u00d8\u00d9\3\2\2\2\u00d9\35\3\2\2\2\u00da\u00d8\3\2\2\2\u00db"+
		"\u00dc\5 \21\2\u00dc\u00dd\7\f\2\2\u00dd\u00de\5 \21\2\u00de\u00f1\3\2"+
		"\2\2\u00df\u00e0\5 \21\2\u00e0\u00e1\7\r\2\2\u00e1\u00e2\5 \21\2\u00e2"+
		"\u00f1\3\2\2\2\u00e3\u00e4\5 \21\2\u00e4\u00e5\7\16\2\2\u00e5\u00e6\5"+
		" \21\2\u00e6\u00f1\3\2\2\2\u00e7\u00e8\5 \21\2\u00e8\u00e9\7\17\2\2\u00e9"+
		"\u00ea\5 \21\2\u00ea\u00f1\3\2\2\2\u00eb\u00ec\7\31\2\2\u00ec\u00ed\5"+
		"\34\17\2\u00ed\u00ee\7\32\2\2\u00ee\u00f1\3\2\2\2\u00ef\u00f1\5 \21\2"+
		"\u00f0\u00db\3\2\2\2\u00f0\u00df\3\2\2\2\u00f0\u00e3\3\2\2\2\u00f0\u00e7"+
		"\3\2\2\2\u00f0\u00eb\3\2\2\2\u00f0\u00ef\3\2\2\2\u00f1\37\3\2\2\2\u00f2"+
		"\u00f3\b\21\1\2\u00f3\u00f4\5\"\22\2\u00f4\u00fd\3\2\2\2\u00f5\u00f6\f"+
		"\5\2\2\u00f6\u00f7\7\6\2\2\u00f7\u00fc\5\"\22\2\u00f8\u00f9\f\4\2\2\u00f9"+
		"\u00fa\7\7\2\2\u00fa\u00fc\5\"\22\2\u00fb\u00f5\3\2\2\2\u00fb\u00f8\3"+
		"\2\2\2\u00fc\u00ff\3\2\2\2\u00fd\u00fb\3\2\2\2\u00fd\u00fe\3\2\2\2\u00fe"+
		"!\3\2\2\2\u00ff\u00fd\3\2\2\2\u0100\u0101\b\22\1\2\u0101\u0102\5$\23\2"+
		"\u0102\u010b\3\2\2\2\u0103\u0104\f\5\2\2\u0104\u0105\7\b\2\2\u0105\u010a"+
		"\5$\23\2\u0106\u0107\f\4\2\2\u0107\u0108\7\t\2\2\u0108\u010a\5$\23\2\u0109"+
		"\u0103\3\2\2\2\u0109\u0106\3\2\2\2\u010a\u010d\3\2\2\2\u010b\u0109\3\2"+
		"\2\2\u010b\u010c\3\2\2\2\u010c#\3\2\2\2\u010d\u010b\3\2\2\2\u010e\u010f"+
		"\b\23\1\2\u010f\u0110\7\31\2\2\u0110\u0111\5 \21\2\u0111\u0112\7\32\2"+
		"\2\u0112\u0128\3\2\2\2\u0113\u0128\7\22\2\2\u0114\u0128\7\20\2\2\u0115"+
		"\u0128\7\21\2\2\u0116\u0128\7(\2\2\u0117\u0118\7\3\2\2\u0118\u0119\7\31"+
		"\2\2\u0119\u011a\5 \21\2\u011a\u011b\7\32\2\2\u011b\u0128\3\2\2\2\u011c"+
		"\u0128\5\22\n\2\u011d\u011e\7\31\2\2\u011e\u011f\5\32\16\2\u011f\u0120"+
		"\7\24\2\2\u0120\u0121\5\32\16\2\u0121\u0122\7\24\2\2\u0122\u0123\5\32"+
		"\16\2\u0123\u0124\7\32\2\2\u0124\u0128\3\2\2\2\u0125\u0126\7\7\2\2\u0126"+
		"\u0128\5$\23\3\u0127\u010e\3\2\2\2\u0127\u0113\3\2\2\2\u0127\u0114\3\2"+
		"\2\2\u0127\u0115\3\2\2\2\u0127\u0116\3\2\2\2\u0127\u0117\3\2\2\2\u0127"+
		"\u011c\3\2\2\2\u0127\u011d\3\2\2\2\u0127\u0125\3\2\2\2\u0128\u012e\3\2"+
		"\2\2\u0129\u012a\f\7\2\2\u012a\u012b\7\25\2\2\u012b\u012d\7(\2\2\u012c"+
		"\u0129\3\2\2\2\u012d\u0130\3\2\2\2\u012e\u012c\3\2\2\2\u012e\u012f\3\2"+
		"\2\2\u012f%\3\2\2\2\u0130\u012e\3\2\2\2 (*\618@GQ\\jw\u008b\u0090\u0095"+
		"\u009a\u009f\u00a4\u00a9\u00ae\u00b4\u00b9\u00c8\u00d6\u00d8\u00f0\u00fb"+
		"\u00fd\u0109\u010b\u0127\u012e";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}