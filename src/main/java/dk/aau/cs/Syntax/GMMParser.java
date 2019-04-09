package dk.aau.cs.Syntax;// Generated from C:/Dev/D408f19_P4\GMM.g4 by ANTLR 4.7.2
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
		Return=1, Equals=2, Plus=3, Minus=4, Times=5, Divide=6, And=7, Or=8, Equality=9, 
		InEquality=10, GreaterThan=11, LessThan=12, True=13, False=14, INT=15, 
		SemiColon=16, CommaSeperator=17, DotOperator=18, Colon=19, While=20, If=21, 
		LParan=22, RParan=23, LSquare=24, RSquare=25, LCurl=26, RCurl=27, MoveCommand=28, 
		LeftCircleCommand=29, RightCircleCommand=30, Type=31, AbsoluteParameter=32, 
		CommandParameter=33, GCode=34, GCodeVarRef=35, ID=36, BlockParam=37, WS=38;
	public static final int
		RULE_prog = 0, RULE_functionDef = 1, RULE_blockDef = 2, RULE_formalParameters = 3, 
		RULE_formalParameter = 4, RULE_machineOptions = 5, RULE_machineOption = 6, 
		RULE_scopedStmt = 7, RULE_functionCall = 8, RULE_commandParameter = 9, 
		RULE_parameters = 10, RULE_expression = 11, RULE_logic = 12, RULE_booleanExpr = 13, 
		RULE_expr = 14, RULE_term = 15, RULE_factor = 16;
	private static String[] makeRuleNames() {
		return new String[] {
			"prog", "functionDef", "blockDef", "formalParameters", "formalParameter", 
			"machineOptions", "machineOption", "scopedStmt", "functionCall", "commandParameter", 
			"parameters", "expression", "logic", "booleanExpr", "expr", "term", "factor"
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
			setState(38);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==Type || _la==ID) {
				{
				setState(36);
				_errHandler.sync(this);
				switch (_input.LA(1)) {
				case Type:
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
			setState(41);
			match(Type);
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
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
			if (_la==BlockParam) {
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
			while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
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
			setState(91);
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
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
		}
		public RightCircleContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitRightCircle(this);
			else return visitor.visitChildren(this);
		}
	}
	public static class MoveContext extends ScopedStmtContext {
		public TerminalNode MoveCommand() { return getToken(GMMParser.MoveCommand, 0); }
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
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
		public List<CommandParameterContext> commandParameter() {
			return getRuleContexts(CommandParameterContext.class);
		}
		public CommandParameterContext commandParameter(int i) {
			return getRuleContext(CommandParameterContext.class,i);
		}
		public LeftCircleContext(ScopedStmtContext ctx) { copyFrom(ctx); }
		@Override
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitLeftCircle(this);
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

	public final ScopedStmtContext scopedStmt() throws RecognitionException {
		ScopedStmtContext _localctx = new ScopedStmtContext(_ctx, getState());
		enterRule(_localctx, 14, RULE_scopedStmt);
		int _la;
		try {
			setState(154);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,13,_ctx) ) {
			case 1:
				_localctx = new BlockContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(93);
				blockDef();
				}
				break;
			case 2:
				_localctx = new WhileLoopContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(94);
				match(While);
				setState(95);
				match(LParan);
				setState(96);
				expression();
				setState(97);
				match(RParan);
				setState(98);
				match(LCurl);
				setState(102);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
					{
					{
					setState(99);
					scopedStmt();
					}
					}
					setState(104);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(105);
				match(RCurl);
				}
				break;
			case 3:
				_localctx = new IfStatementContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(107);
				match(If);
				setState(108);
				match(LParan);
				setState(109);
				expression();
				setState(110);
				match(RParan);
				setState(111);
				match(LCurl);
				setState(115);
				_errHandler.sync(this);
				_la = _input.LA(1);
				while ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Return) | (1L << While) | (1L << If) | (1L << MoveCommand) | (1L << LeftCircleCommand) | (1L << RightCircleCommand) | (1L << Type) | (1L << GCode) | (1L << ID))) != 0)) {
					{
					{
					setState(112);
					scopedStmt();
					}
					}
					setState(117);
					_errHandler.sync(this);
					_la = _input.LA(1);
				}
				setState(118);
				match(RCurl);
				}
				break;
			case 4:
				_localctx = new ScopedStmtFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(120);
				functionCall();
				}
				break;
			case 5:
				_localctx = new AssignmentContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(121);
				match(ID);
				setState(122);
				match(Equals);
				setState(123);
				expression();
				}
				break;
			case 6:
				_localctx = new VectorComponentAssignContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(124);
				match(ID);
				setState(125);
				match(DotOperator);
				setState(126);
				match(ID);
				setState(127);
				match(Equals);
				setState(128);
				expression();
				}
				break;
			case 7:
				_localctx = new DeclarationContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(129);
				match(Type);
				setState(130);
				match(ID);
				setState(131);
				match(Equals);
				setState(132);
				expression();
				}
				break;
			case 8:
				_localctx = new MoveContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(133);
				match(MoveCommand);
				setState(135); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(134);
					commandParameter();
					}
					}
					setState(137); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
				}
				break;
			case 9:
				_localctx = new RightCircleContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(139);
				match(RightCircleCommand);
				setState(141); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(140);
					commandParameter();
					}
					}
					setState(143); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
				}
				break;
			case 10:
				_localctx = new LeftCircleContext(_localctx);
				enterOuterAlt(_localctx, 10);
				{
				setState(145);
				match(LeftCircleCommand);
				setState(147); 
				_errHandler.sync(this);
				_la = _input.LA(1);
				do {
					{
					{
					setState(146);
					commandParameter();
					}
					}
					setState(149); 
					_errHandler.sync(this);
					_la = _input.LA(1);
				} while ( _la==CommandParameter );
				}
				break;
			case 11:
				_localctx = new FunctionReturnContext(_localctx);
				enterOuterAlt(_localctx, 11);
				{
				setState(151);
				match(Return);
				setState(152);
				expression();
				}
				break;
			case 12:
				_localctx = new ExplicitGCodeContext(_localctx);
				enterOuterAlt(_localctx, 12);
				{
				setState(153);
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
			setState(156);
			match(ID);
			setState(157);
			match(LParan);
			setState(159);
			_errHandler.sync(this);
			_la = _input.LA(1);
			if ((((_la) & ~0x3f) == 0 && ((1L << _la) & ((1L << Minus) | (1L << True) | (1L << False) | (1L << INT) | (1L << LParan) | (1L << ID))) != 0)) {
				{
				setState(158);
				parameters();
				}
			}

			setState(161);
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
		public <T> T accept(ParseTreeVisitor<? extends T> visitor) {
			if ( visitor instanceof GMMVisitor ) return ((GMMVisitor<? extends T>)visitor).visitRelativeParameter(this);
			else return visitor.visitChildren(this);
		}
	}

	public final CommandParameterContext commandParameter() throws RecognitionException {
		CommandParameterContext _localctx = new CommandParameterContext(_ctx, getState());
		enterRule(_localctx, 18, RULE_commandParameter);
		try {
			setState(170);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,15,_ctx) ) {
			case 1:
				_localctx = new RelativeParameterContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(163);
				match(CommandParameter);
				setState(164);
				match(Equals);
				setState(165);
				expression();
				}
				break;
			case 2:
				_localctx = new AbsoluteParameterContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(166);
				match(CommandParameter);
				setState(167);
				match(Equals);
				setState(168);
				match(AbsoluteParameter);
				setState(169);
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
			setState(172);
			expression();
			setState(177);
			_errHandler.sync(this);
			_la = _input.LA(1);
			while (_la==CommaSeperator) {
				{
				{
				setState(173);
				match(CommaSeperator);
				setState(174);
				expression();
				}
				}
				setState(179);
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
		enterRule(_localctx, 22, RULE_expression);
		try {
			enterOuterAlt(_localctx, 1);
			{
			setState(180);
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
		int _startState = 24;
		enterRecursionRule(_localctx, 24, RULE_logic, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new LogicDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(183);
			booleanExpr();
			}
			_ctx.stop = _input.LT(-1);
			setState(193);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(191);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,17,_ctx) ) {
					case 1:
						{
						_localctx = new AndLogicContext(new LogicContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(185);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(186);
						match(And);
						setState(187);
						booleanExpr();
						}
						break;
					case 2:
						{
						_localctx = new OrLogicContext(new LogicContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_logic);
						setState(188);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(189);
						match(Or);
						setState(190);
						booleanExpr();
						}
						break;
					}
					} 
				}
				setState(195);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,18,_ctx);
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
		enterRule(_localctx, 26, RULE_booleanExpr);
		try {
			setState(217);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,19,_ctx) ) {
			case 1:
				_localctx = new EqualityExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(196);
				expr(0);
				setState(197);
				match(Equality);
				setState(198);
				expr(0);
				}
				break;
			case 2:
				_localctx = new InEqualityExprContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(200);
				expr(0);
				setState(201);
				match(InEquality);
				setState(202);
				expr(0);
				}
				break;
			case 3:
				_localctx = new GreaterThanExprContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(204);
				expr(0);
				setState(205);
				match(GreaterThan);
				setState(206);
				expr(0);
				}
				break;
			case 4:
				_localctx = new LessThanExprContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(208);
				expr(0);
				setState(209);
				match(LessThan);
				setState(210);
				expr(0);
				}
				break;
			case 5:
				_localctx = new ParanLogicContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(212);
				match(LParan);
				setState(213);
				logic(0);
				setState(214);
				match(RParan);
				}
				break;
			case 6:
				_localctx = new BooleanExprDerivationContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(216);
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
		int _startState = 28;
		enterRecursionRule(_localctx, 28, RULE_expr, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new ExprDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(220);
			term(0);
			}
			_ctx.stop = _input.LT(-1);
			setState(230);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(228);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,20,_ctx) ) {
					case 1:
						{
						_localctx = new PlusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(222);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(223);
						match(Plus);
						setState(224);
						term(0);
						}
						break;
					case 2:
						{
						_localctx = new MinusExprContext(new ExprContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_expr);
						setState(225);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(226);
						match(Minus);
						setState(227);
						term(0);
						}
						break;
					}
					} 
				}
				setState(232);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,21,_ctx);
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
		int _startState = 30;
		enterRecursionRule(_localctx, 30, RULE_term, _p);
		try {
			int _alt;
			enterOuterAlt(_localctx, 1);
			{
			{
			_localctx = new TermDerivationContext(_localctx);
			_ctx = _localctx;
			_prevctx = _localctx;

			setState(234);
			factor();
			}
			_ctx.stop = _input.LT(-1);
			setState(244);
			_errHandler.sync(this);
			_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
			while ( _alt!=2 && _alt!=org.antlr.v4.runtime.atn.ATN.INVALID_ALT_NUMBER ) {
				if ( _alt==1 ) {
					if ( _parseListeners!=null ) triggerExitRuleEvent();
					_prevctx = _localctx;
					{
					setState(242);
					_errHandler.sync(this);
					switch ( getInterpreter().adaptivePredict(_input,22,_ctx) ) {
					case 1:
						{
						_localctx = new TimesTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(236);
						if (!(precpred(_ctx, 3))) throw new FailedPredicateException(this, "precpred(_ctx, 3)");
						setState(237);
						match(Times);
						setState(238);
						factor();
						}
						break;
					case 2:
						{
						_localctx = new DivideTermContext(new TermContext(_parentctx, _parentState));
						pushNewRecursionContext(_localctx, _startState, RULE_term);
						setState(239);
						if (!(precpred(_ctx, 2))) throw new FailedPredicateException(this, "precpred(_ctx, 2)");
						setState(240);
						match(Divide);
						setState(241);
						factor();
						}
						break;
					}
					} 
				}
				setState(246);
				_errHandler.sync(this);
				_alt = getInterpreter().adaptivePredict(_input,23,_ctx);
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
		public List<TerminalNode> ID() { return getTokens(GMMParser.ID); }
		public TerminalNode ID(int i) {
			return getToken(GMMParser.ID, i);
		}
		public TerminalNode DotOperator() { return getToken(GMMParser.DotOperator, 0); }
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
		FactorContext _localctx = new FactorContext(_ctx, getState());
		enterRule(_localctx, 32, RULE_factor);
		try {
			setState(269);
			_errHandler.sync(this);
			switch ( getInterpreter().adaptivePredict(_input,24,_ctx) ) {
			case 1:
				_localctx = new ParanExprContext(_localctx);
				enterOuterAlt(_localctx, 1);
				{
				setState(247);
				match(LParan);
				setState(248);
				expr(0);
				setState(249);
				match(RParan);
				}
				break;
			case 2:
				_localctx = new LiteralIntContext(_localctx);
				enterOuterAlt(_localctx, 2);
				{
				setState(251);
				match(INT);
				}
				break;
			case 3:
				_localctx = new LiteralTrueContext(_localctx);
				enterOuterAlt(_localctx, 3);
				{
				setState(252);
				match(True);
				}
				break;
			case 4:
				_localctx = new LiteralFalseContext(_localctx);
				enterOuterAlt(_localctx, 4);
				{
				setState(253);
				match(False);
				}
				break;
			case 5:
				_localctx = new VariableContext(_localctx);
				enterOuterAlt(_localctx, 5);
				{
				setState(254);
				match(ID);
				}
				break;
			case 6:
				_localctx = new AccessVectorContext(_localctx);
				enterOuterAlt(_localctx, 6);
				{
				setState(255);
				match(ID);
				setState(256);
				match(DotOperator);
				setState(257);
				match(ID);
				}
				break;
			case 7:
				_localctx = new ExpressionFunctionCallContext(_localctx);
				enterOuterAlt(_localctx, 7);
				{
				setState(258);
				functionCall();
				}
				break;
			case 8:
				_localctx = new LiteralVectorContext(_localctx);
				enterOuterAlt(_localctx, 8);
				{
				setState(259);
				match(LParan);
				setState(260);
				expression();
				setState(261);
				match(CommaSeperator);
				setState(262);
				expression();
				setState(263);
				match(CommaSeperator);
				setState(264);
				expression();
				setState(265);
				match(RParan);
				}
				break;
			case 9:
				_localctx = new NegatedFactorContext(_localctx);
				enterOuterAlt(_localctx, 9);
				{
				setState(267);
				match(Minus);
				setState(268);
				factor();
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
		"\3\u608b\ua72a\u8133\ub9ed\u417c\u3be7\u7786\u5964\3(\u0112\4\2\t\2\4"+
		"\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13\t"+
		"\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\3\2\3\2\7\2\'\n\2\f\2\16\2*\13\2\3\3\3\3\3\3\3\3\5\3\60\n\3\3\3\3\3\3"+
		"\3\7\3\65\n\3\f\3\16\38\13\3\3\3\3\3\3\4\3\4\3\4\5\4?\n\4\3\4\3\4\3\4"+
		"\7\4D\n\4\f\4\16\4G\13\4\3\4\3\4\3\5\3\5\3\5\7\5N\n\5\f\5\16\5Q\13\5\3"+
		"\6\3\6\3\6\3\7\3\7\3\7\7\7Y\n\7\f\7\16\7\\\13\7\3\b\3\b\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\7\tg\n\t\f\t\16\tj\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t"+
		"\7\tt\n\t\f\t\16\tw\13\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3\t\3"+
		"\t\3\t\3\t\3\t\3\t\3\t\6\t\u008a\n\t\r\t\16\t\u008b\3\t\3\t\6\t\u0090"+
		"\n\t\r\t\16\t\u0091\3\t\3\t\6\t\u0096\n\t\r\t\16\t\u0097\3\t\3\t\3\t\5"+
		"\t\u009d\n\t\3\n\3\n\3\n\5\n\u00a2\n\n\3\n\3\n\3\13\3\13\3\13\3\13\3\13"+
		"\3\13\3\13\5\13\u00ad\n\13\3\f\3\f\3\f\7\f\u00b2\n\f\f\f\16\f\u00b5\13"+
		"\f\3\r\3\r\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\7\16\u00c2\n\16"+
		"\f\16\16\16\u00c5\13\16\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3"+
		"\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\3\17\5\17\u00dc"+
		"\n\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\20\7\20\u00e7\n\20\f\20"+
		"\16\20\u00ea\13\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\7\21\u00f5"+
		"\n\21\f\21\16\21\u00f8\13\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3"+
		"\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\22\5"+
		"\22\u0110\n\22\3\22\2\5\32\36 \23\2\4\6\b\n\f\16\20\22\24\26\30\32\34"+
		"\36 \"\2\2\2\u012e\2(\3\2\2\2\4+\3\2\2\2\6;\3\2\2\2\bJ\3\2\2\2\nR\3\2"+
		"\2\2\fU\3\2\2\2\16]\3\2\2\2\20\u009c\3\2\2\2\22\u009e\3\2\2\2\24\u00ac"+
		"\3\2\2\2\26\u00ae\3\2\2\2\30\u00b6\3\2\2\2\32\u00b8\3\2\2\2\34\u00db\3"+
		"\2\2\2\36\u00dd\3\2\2\2 \u00eb\3\2\2\2\"\u010f\3\2\2\2$\'\5\4\3\2%\'\5"+
		"\6\4\2&$\3\2\2\2&%\3\2\2\2\'*\3\2\2\2(&\3\2\2\2()\3\2\2\2)\3\3\2\2\2*"+
		"(\3\2\2\2+,\7!\2\2,-\7&\2\2-/\7\30\2\2.\60\5\b\5\2/.\3\2\2\2/\60\3\2\2"+
		"\2\60\61\3\2\2\2\61\62\7\31\2\2\62\66\7\34\2\2\63\65\5\20\t\2\64\63\3"+
		"\2\2\2\658\3\2\2\2\66\64\3\2\2\2\66\67\3\2\2\2\679\3\2\2\28\66\3\2\2\2"+
		"9:\7\35\2\2:\5\3\2\2\2;<\7&\2\2<>\7\32\2\2=?\5\f\7\2>=\3\2\2\2>?\3\2\2"+
		"\2?@\3\2\2\2@A\7\33\2\2AE\7\34\2\2BD\5\20\t\2CB\3\2\2\2DG\3\2\2\2EC\3"+
		"\2\2\2EF\3\2\2\2FH\3\2\2\2GE\3\2\2\2HI\7\35\2\2I\7\3\2\2\2JO\5\n\6\2K"+
		"L\7\23\2\2LN\5\n\6\2MK\3\2\2\2NQ\3\2\2\2OM\3\2\2\2OP\3\2\2\2P\t\3\2\2"+
		"\2QO\3\2\2\2RS\7!\2\2ST\7&\2\2T\13\3\2\2\2UZ\5\16\b\2VW\7\23\2\2WY\5\16"+
		"\b\2XV\3\2\2\2Y\\\3\2\2\2ZX\3\2\2\2Z[\3\2\2\2[\r\3\2\2\2\\Z\3\2\2\2]^"+
		"\7\'\2\2^\17\3\2\2\2_\u009d\5\6\4\2`a\7\26\2\2ab\7\30\2\2bc\5\30\r\2c"+
		"d\7\31\2\2dh\7\34\2\2eg\5\20\t\2fe\3\2\2\2gj\3\2\2\2hf\3\2\2\2hi\3\2\2"+
		"\2ik\3\2\2\2jh\3\2\2\2kl\7\35\2\2l\u009d\3\2\2\2mn\7\27\2\2no\7\30\2\2"+
		"op\5\30\r\2pq\7\31\2\2qu\7\34\2\2rt\5\20\t\2sr\3\2\2\2tw\3\2\2\2us\3\2"+
		"\2\2uv\3\2\2\2vx\3\2\2\2wu\3\2\2\2xy\7\35\2\2y\u009d\3\2\2\2z\u009d\5"+
		"\22\n\2{|\7&\2\2|}\7\4\2\2}\u009d\5\30\r\2~\177\7&\2\2\177\u0080\7\24"+
		"\2\2\u0080\u0081\7&\2\2\u0081\u0082\7\4\2\2\u0082\u009d\5\30\r\2\u0083"+
		"\u0084\7!\2\2\u0084\u0085\7&\2\2\u0085\u0086\7\4\2\2\u0086\u009d\5\30"+
		"\r\2\u0087\u0089\7\36\2\2\u0088\u008a\5\24\13\2\u0089\u0088\3\2\2\2\u008a"+
		"\u008b\3\2\2\2\u008b\u0089\3\2\2\2\u008b\u008c\3\2\2\2\u008c\u009d\3\2"+
		"\2\2\u008d\u008f\7 \2\2\u008e\u0090\5\24\13\2\u008f\u008e\3\2\2\2\u0090"+
		"\u0091\3\2\2\2\u0091\u008f\3\2\2\2\u0091\u0092\3\2\2\2\u0092\u009d\3\2"+
		"\2\2\u0093\u0095\7\37\2\2\u0094\u0096\5\24\13\2\u0095\u0094\3\2\2\2\u0096"+
		"\u0097\3\2\2\2\u0097\u0095\3\2\2\2\u0097\u0098\3\2\2\2\u0098\u009d\3\2"+
		"\2\2\u0099\u009a\7\3\2\2\u009a\u009d\5\30\r\2\u009b\u009d\7$\2\2\u009c"+
		"_\3\2\2\2\u009c`\3\2\2\2\u009cm\3\2\2\2\u009cz\3\2\2\2\u009c{\3\2\2\2"+
		"\u009c~\3\2\2\2\u009c\u0083\3\2\2\2\u009c\u0087\3\2\2\2\u009c\u008d\3"+
		"\2\2\2\u009c\u0093\3\2\2\2\u009c\u0099\3\2\2\2\u009c\u009b\3\2\2\2\u009d"+
		"\21\3\2\2\2\u009e\u009f\7&\2\2\u009f\u00a1\7\30\2\2\u00a0\u00a2\5\26\f"+
		"\2\u00a1\u00a0\3\2\2\2\u00a1\u00a2\3\2\2\2\u00a2\u00a3\3\2\2\2\u00a3\u00a4"+
		"\7\31\2\2\u00a4\23\3\2\2\2\u00a5\u00a6\7#\2\2\u00a6\u00a7\7\4\2\2\u00a7"+
		"\u00ad\5\30\r\2\u00a8\u00a9\7#\2\2\u00a9\u00aa\7\4\2\2\u00aa\u00ab\7\""+
		"\2\2\u00ab\u00ad\5\30\r\2\u00ac\u00a5\3\2\2\2\u00ac\u00a8\3\2\2\2\u00ad"+
		"\25\3\2\2\2\u00ae\u00b3\5\30\r\2\u00af\u00b0\7\23\2\2\u00b0\u00b2\5\30"+
		"\r\2\u00b1\u00af\3\2\2\2\u00b2\u00b5\3\2\2\2\u00b3\u00b1\3\2\2\2\u00b3"+
		"\u00b4\3\2\2\2\u00b4\27\3\2\2\2\u00b5\u00b3\3\2\2\2\u00b6\u00b7\5\32\16"+
		"\2\u00b7\31\3\2\2\2\u00b8\u00b9\b\16\1\2\u00b9\u00ba\5\34\17\2\u00ba\u00c3"+
		"\3\2\2\2\u00bb\u00bc\f\5\2\2\u00bc\u00bd\7\t\2\2\u00bd\u00c2\5\34\17\2"+
		"\u00be\u00bf\f\4\2\2\u00bf\u00c0\7\n\2\2\u00c0\u00c2\5\34\17\2\u00c1\u00bb"+
		"\3\2\2\2\u00c1\u00be\3\2\2\2\u00c2\u00c5\3\2\2\2\u00c3\u00c1\3\2\2\2\u00c3"+
		"\u00c4\3\2\2\2\u00c4\33\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c6\u00c7\5\36\20"+
		"\2\u00c7\u00c8\7\13\2\2\u00c8\u00c9\5\36\20\2\u00c9\u00dc\3\2\2\2\u00ca"+
		"\u00cb\5\36\20\2\u00cb\u00cc\7\f\2\2\u00cc\u00cd\5\36\20\2\u00cd\u00dc"+
		"\3\2\2\2\u00ce\u00cf\5\36\20\2\u00cf\u00d0\7\r\2\2\u00d0\u00d1\5\36\20"+
		"\2\u00d1\u00dc\3\2\2\2\u00d2\u00d3\5\36\20\2\u00d3\u00d4\7\16\2\2\u00d4"+
		"\u00d5\5\36\20\2\u00d5\u00dc\3\2\2\2\u00d6\u00d7\7\30\2\2\u00d7\u00d8"+
		"\5\32\16\2\u00d8\u00d9\7\31\2\2\u00d9\u00dc\3\2\2\2\u00da\u00dc\5\36\20"+
		"\2\u00db\u00c6\3\2\2\2\u00db\u00ca\3\2\2\2\u00db\u00ce\3\2\2\2\u00db\u00d2"+
		"\3\2\2\2\u00db\u00d6\3\2\2\2\u00db\u00da\3\2\2\2\u00dc\35\3\2\2\2\u00dd"+
		"\u00de\b\20\1\2\u00de\u00df\5 \21\2\u00df\u00e8\3\2\2\2\u00e0\u00e1\f"+
		"\5\2\2\u00e1\u00e2\7\5\2\2\u00e2\u00e7\5 \21\2\u00e3\u00e4\f\4\2\2\u00e4"+
		"\u00e5\7\6\2\2\u00e5\u00e7\5 \21\2\u00e6\u00e0\3\2\2\2\u00e6\u00e3\3\2"+
		"\2\2\u00e7\u00ea\3\2\2\2\u00e8\u00e6\3\2\2\2\u00e8\u00e9\3\2\2\2\u00e9"+
		"\37\3\2\2\2\u00ea\u00e8\3\2\2\2\u00eb\u00ec\b\21\1\2\u00ec\u00ed\5\"\22"+
		"\2\u00ed\u00f6\3\2\2\2\u00ee\u00ef\f\5\2\2\u00ef\u00f0\7\7\2\2\u00f0\u00f5"+
		"\5\"\22\2\u00f1\u00f2\f\4\2\2\u00f2\u00f3\7\b\2\2\u00f3\u00f5\5\"\22\2"+
		"\u00f4\u00ee\3\2\2\2\u00f4\u00f1\3\2\2\2\u00f5\u00f8\3\2\2\2\u00f6\u00f4"+
		"\3\2\2\2\u00f6\u00f7\3\2\2\2\u00f7!\3\2\2\2\u00f8\u00f6\3\2\2\2\u00f9"+
		"\u00fa\7\30\2\2\u00fa\u00fb\5\36\20\2\u00fb\u00fc\7\31\2\2\u00fc\u0110"+
		"\3\2\2\2\u00fd\u0110\7\21\2\2\u00fe\u0110\7\17\2\2\u00ff\u0110\7\20\2"+
		"\2\u0100\u0110\7&\2\2\u0101\u0102\7&\2\2\u0102\u0103\7\24\2\2\u0103\u0110"+
		"\7&\2\2\u0104\u0110\5\22\n\2\u0105\u0106\7\30\2\2\u0106\u0107\5\30\r\2"+
		"\u0107\u0108\7\23\2\2\u0108\u0109\5\30\r\2\u0109\u010a\7\23\2\2\u010a"+
		"\u010b\5\30\r\2\u010b\u010c\7\31\2\2\u010c\u0110\3\2\2\2\u010d\u010e\7"+
		"\6\2\2\u010e\u0110\5\"\22\2\u010f\u00f9\3\2\2\2\u010f\u00fd\3\2\2\2\u010f"+
		"\u00fe\3\2\2\2\u010f\u00ff\3\2\2\2\u010f\u0100\3\2\2\2\u010f\u0101\3\2"+
		"\2\2\u010f\u0104\3\2\2\2\u010f\u0105\3\2\2\2\u010f\u010d\3\2\2\2\u0110"+
		"#\3\2\2\2\33&(/\66>EOZhu\u008b\u0091\u0097\u009c\u00a1\u00ac\u00b3\u00c1"+
		"\u00c3\u00db\u00e6\u00e8\u00f4\u00f6\u010f";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}