// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/GCode\GMM.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeListener;

/**
 * This interface defines a complete listener for a parse tree produced by
 * {@link GMMParser}.
 */
public interface GMMListener extends ParseTreeListener {
	/**
	 * Enter a parse tree produced by {@link GMMParser#prog}.
	 * @param ctx the parse tree
	 */
	void enterProg(GMMParser.ProgContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#prog}.
	 * @param ctx the parse tree
	 */
	void exitProg(GMMParser.ProgContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void enterFunctionDef(GMMParser.FunctionDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#functionDef}.
	 * @param ctx the parse tree
	 */
	void exitFunctionDef(GMMParser.FunctionDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#blockDef}.
	 * @param ctx the parse tree
	 */
	void enterBlockDef(GMMParser.BlockDefContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#blockDef}.
	 * @param ctx the parse tree
	 */
	void exitBlockDef(GMMParser.BlockDefContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameters(GMMParser.FormalParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#formalParameters}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameters(GMMParser.FormalParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void enterFormalParameter(GMMParser.FormalParameterContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#formalParameter}.
	 * @param ctx the parse tree
	 */
	void exitFormalParameter(GMMParser.FormalParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#machineOptions}.
	 * @param ctx the parse tree
	 */
	void enterMachineOptions(GMMParser.MachineOptionsContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#machineOptions}.
	 * @param ctx the parse tree
	 */
	void exitMachineOptions(GMMParser.MachineOptionsContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#machineOption}.
	 * @param ctx the parse tree
	 */
	void enterMachineOption(GMMParser.MachineOptionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#machineOption}.
	 * @param ctx the parse tree
	 */
	void exitMachineOption(GMMParser.MachineOptionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Block}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterBlock(GMMParser.BlockContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitBlock(GMMParser.BlockContext ctx);
	/**
	 * Enter a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterWhileLoop(GMMParser.WhileLoopContext ctx);
	/**
	 * Exit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitWhileLoop(GMMParser.WhileLoopContext ctx);
	/**
	 * Enter a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterIfStatement(GMMParser.IfStatementContext ctx);
	/**
	 * Exit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitIfStatement(GMMParser.IfStatementContext ctx);
	/**
	 * Enter a parse tree produced by the {@code CallFunction}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterCallFunction(GMMParser.CallFunctionContext ctx);
	/**
	 * Exit a parse tree produced by the {@code CallFunction}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitCallFunction(GMMParser.CallFunctionContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterAssignment(GMMParser.AssignmentContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitAssignment(GMMParser.AssignmentContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterDeclaration(GMMParser.DeclarationContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitDeclaration(GMMParser.DeclarationContext ctx);
	/**
	 * Enter a parse tree produced by the {@code GCommand}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void enterGCommand(GMMParser.GCommandContext ctx);
	/**
	 * Exit a parse tree produced by the {@code GCommand}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 */
	void exitGCommand(GMMParser.GCommandContext ctx);
	/**
	 * Enter a parse tree produced by the {@code Move}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void enterMove(GMMParser.MoveContext ctx);
	/**
	 * Exit a parse tree produced by the {@code Move}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void exitMove(GMMParser.MoveContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RightCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void enterRightCircle(GMMParser.RightCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RightCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void exitRightCircle(GMMParser.RightCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code LeftCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void enterLeftCircle(GMMParser.LeftCircleContext ctx);
	/**
	 * Exit a parse tree produced by the {@code LeftCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 */
	void exitLeftCircle(GMMParser.LeftCircleContext ctx);
	/**
	 * Enter a parse tree produced by the {@code RelativeParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 */
	void enterRelativeParameter(GMMParser.RelativeParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code RelativeParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 */
	void exitRelativeParameter(GMMParser.RelativeParameterContext ctx);
	/**
	 * Enter a parse tree produced by the {@code AbsoluteParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 */
	void enterAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx);
	/**
	 * Exit a parse tree produced by the {@code AbsoluteParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 */
	void exitAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#parameters}.
	 * @param ctx the parse tree
	 */
	void enterParameters(GMMParser.ParametersContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#parameters}.
	 * @param ctx the parse tree
	 */
	void exitParameters(GMMParser.ParametersContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#expression}.
	 * @param ctx the parse tree
	 */
	void enterExpression(GMMParser.ExpressionContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#expression}.
	 * @param ctx the parse tree
	 */
	void exitExpression(GMMParser.ExpressionContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 */
	void enterLogic(GMMParser.LogicContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 */
	void exitLogic(GMMParser.LogicContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#boolean}.
	 * @param ctx the parse tree
	 */
	void enterBoolean(GMMParser.BooleanContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#boolean}.
	 * @param ctx the parse tree
	 */
	void exitBoolean(GMMParser.BooleanContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void enterExpr(GMMParser.ExprContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 */
	void exitExpr(GMMParser.ExprContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#term}.
	 * @param ctx the parse tree
	 */
	void enterTerm(GMMParser.TermContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#term}.
	 * @param ctx the parse tree
	 */
	void exitTerm(GMMParser.TermContext ctx);
	/**
	 * Enter a parse tree produced by {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 */
	void enterFactor(GMMParser.FactorContext ctx);
	/**
	 * Exit a parse tree produced by {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 */
	void exitFactor(GMMParser.FactorContext ctx);
}