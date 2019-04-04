package dk.aau.cs.Syntax;// Generated from C:/Users/thoru/OneDrive/Dokumenter/Git/D408f19_P4\GMM.g4 by ANTLR 4.7.2
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
	 * Visit a parse tree produced by the {@code ScopedStmtFunctionCall}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitScopedStmtFunctionCall(GMMParser.ScopedStmtFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Assignment}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAssignment(GMMParser.AssignmentContext ctx);
	/**
	 * Visit a parse tree produced by the {@code VectorComponentAssign}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVectorComponentAssign(GMMParser.VectorComponentAssignContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Declaration}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDeclaration(GMMParser.DeclarationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Move}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMove(GMMParser.MoveContext ctx);
	/**
	 * Visit a parse tree produced by the {@code RightCircle}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitRightCircle(GMMParser.RightCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LeftCircle}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLeftCircle(GMMParser.LeftCircleContext ctx);
	/**
	 * Visit a parse tree produced by the {@code FunctionReturn}
	 * labeled alternative in {@link GMMParser#scopedStmt}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionReturn(GMMParser.FunctionReturnContext ctx);
	/**
	 * Visit a parse tree produced by {@link GMMParser#functionCall}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitFunctionCall(GMMParser.FunctionCallContext ctx);
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
	 * Visit a parse tree produced by the {@code AndLogic}
	 * labeled alternative in {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAndLogic(GMMParser.AndLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LogicDerivation}
	 * labeled alternative in {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLogicDerivation(GMMParser.LogicDerivationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code OrLogic}
	 * labeled alternative in {@link GMMParser#logic}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitOrLogic(GMMParser.OrLogicContext ctx);
	/**
	 * Visit a parse tree produced by the {@code EqualityExpr}
	 * labeled alternative in {@link GMMParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitEqualityExpr(GMMParser.EqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code InEqualityExpr}
	 * labeled alternative in {@link GMMParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitInEqualityExpr(GMMParser.InEqualityExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code GreaterThanExpr}
	 * labeled alternative in {@link GMMParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitGreaterThanExpr(GMMParser.GreaterThanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LessThanExpr}
	 * labeled alternative in {@link GMMParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLessThanExpr(GMMParser.LessThanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code BooleanExprDerivation}
	 * labeled alternative in {@link GMMParser#booleanExpr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitBooleanExprDerivation(GMMParser.BooleanExprDerivationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code PlusExpr}
	 * labeled alternative in {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitPlusExpr(GMMParser.PlusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExprDerivation}
	 * labeled alternative in {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExprDerivation(GMMParser.ExprDerivationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code MinusExpr}
	 * labeled alternative in {@link GMMParser#expr}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitMinusExpr(GMMParser.MinusExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TermDerivation}
	 * labeled alternative in {@link GMMParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTermDerivation(GMMParser.TermDerivationContext ctx);
	/**
	 * Visit a parse tree produced by the {@code DivideTerm}
	 * labeled alternative in {@link GMMParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitDivideTerm(GMMParser.DivideTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code TimesTerm}
	 * labeled alternative in {@link GMMParser#term}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitTimesTerm(GMMParser.TimesTermContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ParanExpr}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitParanExpr(GMMParser.ParanExprContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralInt}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralInt(GMMParser.LiteralIntContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralTrue}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralTrue(GMMParser.LiteralTrueContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralFalse}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralFalse(GMMParser.LiteralFalseContext ctx);
	/**
	 * Visit a parse tree produced by the {@code Variable}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitVariable(GMMParser.VariableContext ctx);
	/**
	 * Visit a parse tree produced by the {@code AccessVector}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitAccessVector(GMMParser.AccessVectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code ExpressionFunctionCall}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitExpressionFunctionCall(GMMParser.ExpressionFunctionCallContext ctx);
	/**
	 * Visit a parse tree produced by the {@code LiteralVector}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitLiteralVector(GMMParser.LiteralVectorContext ctx);
	/**
	 * Visit a parse tree produced by the {@code NegatedFactor}
	 * labeled alternative in {@link GMMParser#factor}.
	 * @param ctx the parse tree
	 * @return the visitor result
	 */
	T visitNegatedFactor(GMMParser.NegatedFactorContext ctx);
}