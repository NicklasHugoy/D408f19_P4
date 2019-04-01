// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/GCode\GMM.g4 by ANTLR 4.7.2
import org.antlr.v4.runtime.tree.ParseTreeVisitor;

/**
 * This interface defines a complete generic visitor for a parse tree produced
 * by {@link GMMParser}.
 *
 * @param <T> The return type of the visit operation. Use {@link Void} for
 * operations with no return type.
 */
public interface GMMVisitor<T> extends ParseTreeVisitor<T> {
	/**
	 * Visit a parse tree produced by {@link GMMParser#prog}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitProg(GMMParser.ProgContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#functionDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionDef(GMMParser.FunctionDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#blockDef}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlockDef(GMMParser.BlockDefContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#formalParameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameters(GMMParser.FormalParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#formalParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFormalParameter(GMMParser.FormalParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#machineOptions}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMachineOptions(GMMParser.MachineOptionsContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#machineOption}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMachineOption(GMMParser.MachineOptionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Block}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBlock(GMMParser.BlockContext ctx);
	/**
	 * Visit a parse tree produced by the {@code WhileLoop}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitWhileLoop(GMMParser.WhileLoopContext ctx);
	/**
	 * Visit a parse tree produced by the {@code IfStatement}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitIfStatement(GMMParser.IfStatementContext ctx);
	/**
	 * Visit a parse tree produced by the {@code CallFunction}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitCallFunction(GMMParser.CallFunctionContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GMMParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GMMParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GCommand}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGCommand(GMMParser.GCommandContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Move}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove(GMMParser.MoveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightCircle(GMMParser.RightCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeftCircle}
	 * labeled alternative in {@link GMMParser#command}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftCircle(GMMParser.LeftCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RelativeParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRelativeParameter(GMMParser.RelativeParameterContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AbsoluteParameter}
	 * labeled alternative in {@link GMMParser#commandParameter}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#parameters}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParameters(GMMParser.ParametersContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#expression}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpression(GMMParser.ExpressionContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogic(GMMParser.LogicContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#boolean}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBoolean(GMMParser.BooleanContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpr(GMMParser.ExprContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTerm(GMMParser.TermContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFactor(GMMParser.FactorContext ctx);
}