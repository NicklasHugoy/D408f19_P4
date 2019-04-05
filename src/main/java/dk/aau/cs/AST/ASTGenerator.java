package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.Syntax.GMMParser;
import dk.aau.cs.Syntax.GMMVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class ASTGenerator implements GMMVisitor<Node> {

    @Override
    public Node visitProg(GMMParser.ProgContext ctx) {
        ArrayList<BaseNode> nodes = new ArrayList<>();
        for(ParseTree child : ctx.children)
            nodes.add((BaseNode) child.accept(this));

        return new Program(nodes);
    }

    @Override
    public Node visitFunctionDef(GMMParser.FunctionDefContext ctx) {
        TypeNode typeNode = GetFunctionTypeNode(ctx.Type());
        ID idNode = GetIDNode(ctx.ID());
        ArrayList<FormalParameter> parameters = new ArrayList<>();
        ArrayList<Statement> statements = new ArrayList<>();

        if(ctx.formalParameters() != null){
            List<GMMParser.FormalParameterContext> parameterContexts = ctx.formalParameters().formalParameter();

            for(GMMParser.FormalParameterContext parameterContext : parameterContexts)
                parameters.add((FormalParameter) parameterContext.accept(this));
        }

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt())
            statements.add((Statement) stmtContext.accept(this));

        return new FunctionDef(typeNode, idNode, parameters, statements);
    }

    @Override
    public Node visitBlockDef(GMMParser.BlockDefContext ctx) {
        ArrayList<MachineOption> options = new ArrayList<>();
        ArrayList<Statement> statements = new ArrayList<>();

        if(ctx.machineOptions() != null){
            for(GMMParser.MachineOptionContext optionContext : ctx.machineOptions().machineOption())
                options.add((MachineOption) optionContext.accept(this));
        }

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt()){
            statements.add((Statement) stmtContext.accept(this));
            if(stmtContext instanceof GMMParser.FunctionReturnContext){
                Logger.Log("return statement used in block definition", WarningLevel.Error);
            }
        }


        return new BlockDef(options, statements);
    }

    @Override
    public Node visitFormalParameters(GMMParser.FormalParametersContext ctx) {
        throw new IllegalArgumentException("This shouldnt be called exception"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitFormalParameter(GMMParser.FormalParameterContext ctx) {
        TypeNode typeNode = GetTypeNode(ctx.Type());
        ID idNode = GetIDNode(ctx.ID());

        return new FormalParameter(typeNode, idNode);
    }

    private ID GetIDNode(TerminalNode id) {
        return new ID(id.getText());
    }

    private TypeNode GetTypeNode(TerminalNode type) {
        switch (type.getText().trim()){
            case "num":
                return new TypeNode(GMMType.Num);
            case "bool":
                return new TypeNode(GMMType.Bool);
            case "vector":
                return new TypeNode(GMMType.Vector);
        }
        throw new IllegalArgumentException( type.getText() + " Doesnt match any of the types");
    }

    private TypeNode GetFunctionTypeNode(TerminalNode type) {
        switch (type.getText().trim()){
            case "num":
                return new TypeNode(GMMType.Num);
            case "bool":
                return new TypeNode(GMMType.Bool);
            case "vector":
                return new TypeNode(GMMType.Vector);
            case "void":
                return new TypeNode(GMMType.Void);
        }
        throw new IllegalArgumentException( type.getText() + " Doesnt match any of the types");
    }

    @Override
    public Node visitMachineOptions(GMMParser.MachineOptionsContext ctx) {
        throw new IllegalArgumentException("This shouldnt be called exception"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitMachineOption(GMMParser.MachineOptionContext ctx)
    {
        ID idNode = GetIDNode(ctx.ID());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new MachineOption(idNode, expression);
    }

    @Override
    public Node visitFunctionReturn(GMMParser.FunctionReturnContext ctx) {
        Expression expression = (Expression) ctx.expression().accept(this);

        return new ReturnNode(expression);
    }

    @Override
    public Node visitBlock(GMMParser.BlockContext ctx) {
        return ctx.blockDef().accept(this);
    }

    @Override
    public Node visitWhileLoop(GMMParser.WhileLoopContext ctx) {
        Expression expression = (Expression) ctx.expression().accept(this);
        List<Statement> statements = new ArrayList<>();

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt())
            statements.add((Statement) stmtContext.accept(this));


        return new WhileLoop(expression, statements);
    }

    @Override
    public Node visitIfStatement(GMMParser.IfStatementContext ctx) {
        Expression expression = (Expression) ctx.expression().accept(this);
        List<Statement> statements = new ArrayList<>();

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt())
            statements.add((Statement) stmtContext.accept(this));

        return new IfNode(expression, statements);
    }

    @Override
    public Node visitScopedStmtFunctionCall(GMMParser.ScopedStmtFunctionCallContext ctx) {
        return ctx.functionCall().accept(this);
    }

/*
    @Override
    public Node visitCallFunction(GMMParser.CallFunctionContext ctx)
    {
        ID idNode = GetIDNode(ctx.ID());
        List<Expression> expressions = new ArrayList<>();

        if(ctx.parameters() != null){
            for(GMMParser.ExpressionContext expressionContext : ctx.parameters().expression())
                expressions.add((Expression) expressionContext.accept(this));
        }

        return new FunctionCall(idNode, expressions);
    }
 */

    @Override
    public Node visitAssignment(GMMParser.AssignmentContext ctx)
    {
        ID idNode = GetIDNode(ctx.ID());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new Assign(idNode, expression);
    }

    @Override
    public Node visitVectorComponentAssign(GMMParser.VectorComponentAssignContext ctx) {
        ID identifier = GetIDNode(ctx.ID(0));
        ID component = GetIDNode(ctx.ID(1));

        Expression expression = (Expression) ctx.expression().accept(this);

        return new VectorComponentAssign(identifier, component, expression);
    }

    @Override
    public Node visitDeclaration(GMMParser.DeclarationContext ctx) {
        TypeNode typeNode = GetTypeNode(ctx.Type());
        ID idNode = GetIDNode(ctx.ID());
        Expression expression = (Expression) ctx.expression().accept(this);


        return new Declaration(typeNode, idNode, expression);
    }

    @Override
    public Node visitMove(GMMParser.MoveContext ctx) {
        List<CommandParameter> commandParameters = new ArrayList<>();

        for(GMMParser.CommandParameterContext commandParameterContext : ctx.commandParameter())
            commandParameters.add((CommandParameter) commandParameterContext.accept(this));

        return new Move(commandParameters);
    }

    @Override
    public Node visitRightCircle(GMMParser.RightCircleContext ctx) {
        List<CommandParameter> commandParameters = new ArrayList<>();

        for(GMMParser.CommandParameterContext commandParameterContext : ctx.commandParameter())
            commandParameters.add((CommandParameter) commandParameterContext.accept(this));

        return new RightCircle(commandParameters);
    }

    @Override
    public Node visitLeftCircle(GMMParser.LeftCircleContext ctx) {
        List<CommandParameter> commandParameters = new ArrayList<>();

        for(GMMParser.CommandParameterContext commandParameterContext : ctx.commandParameter())
            commandParameters.add((CommandParameter) commandParameterContext.accept(this));
        return new LeftCircle(commandParameters);
    }

    @Override
    public Node visitFunctionCall(GMMParser.FunctionCallContext ctx) {
        ID idNode = GetIDNode(ctx.ID());
        List<Expression> expressions = new ArrayList<>();

        if(ctx.parameters() != null){
            for(GMMParser.ExpressionContext expressionContext : ctx.parameters().expression())
                expressions.add((Expression) expressionContext.accept(this));
        }

        return new FunctionCall(idNode, expressions);
    }

    @Override
    public Node visitRelativeParameter(GMMParser.RelativeParameterContext ctx) {
        ID idNode = GetIDNode(ctx.CommandParameter());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new RelativeParameter(idNode, expression);
    }

    @Override
    public Node visitAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx) {
        ID idNode = GetIDNode(ctx.CommandParameter());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new AbsoluteParameter(idNode, expression);
    }

    @Override
    public Node visitParameters(GMMParser.ParametersContext ctx) {
        throw new IllegalArgumentException("This shouldnt be called exception"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitExpression(GMMParser.ExpressionContext ctx) {
        return ctx.logic().accept(this);
    }

    @Override
    public Node visitAndLogic(GMMParser.AndLogicContext ctx) {
        Expression left = (Expression) ctx.logic().accept(this);
        Expression right = (Expression) ctx.booleanExpr().accept(this);

        return new And(left, right);
    }

    @Override
    public Node visitLogicDerivation(GMMParser.LogicDerivationContext ctx) {
        return ctx.booleanExpr().accept(this);
    }

    @Override
    public Node visitOrLogic(GMMParser.OrLogicContext ctx) {
        Expression left = (Expression) ctx.logic().accept(this);
        Expression right = (Expression) ctx.booleanExpr().accept(this);

        return new Or(left, right);
    }

    @Override
    public Node visitEqualityExpr(GMMParser.EqualityExprContext ctx) {
        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new Equality(left, right);
    }

    @Override
    public Node visitInEqualityExpr(GMMParser.InEqualityExprContext ctx) {
        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new InEquality(left, right);
    }

    @Override
    public Node visitGreaterThanExpr(GMMParser.GreaterThanExprContext ctx) {
        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new GreaterThan(left, right);
    }

    @Override
    public Node visitLessThanExpr(GMMParser.LessThanExprContext ctx) {
		Expression left = (Expression) ctx.expr(0).accept(this);
		Expression right = (Expression) ctx.expr(1).accept(this);

		return new LessThan(left, right);
    }

    @Override
    public Node visitBooleanExprDerivation(GMMParser.BooleanExprDerivationContext ctx) {
        return ctx.expr().accept(this);
    }

    @Override
    public Node visitPlusExpr(GMMParser.PlusExprContext ctx) {
        Expression left = (Expression) ctx.expr().accept(this);
        Expression right = (Expression) ctx.term().accept(this);

        return new Plus(left, right);
    }

    @Override
    public Node visitExprDerivation(GMMParser.ExprDerivationContext ctx) {
        return ctx.term().accept(this);
    }

    @Override
    public Node visitMinusExpr(GMMParser.MinusExprContext ctx) {
        Expression left = (Expression) ctx.expr().accept(this);
        Expression right = (Expression) ctx.term().accept(this);

        return new Minus(left, right);
    }

    @Override
    public Node visitTermDerivation(GMMParser.TermDerivationContext ctx) {
        return ctx.factor().accept(this);
    }

    @Override
    public Node visitDivideTerm(GMMParser.DivideTermContext ctx) {
        Expression left = (Expression) ctx.term().accept(this);
        Expression right = (Expression) ctx.factor().accept(this);

        return new Divide(left, right);
    }

    @Override
    public Node visitTimesTerm(GMMParser.TimesTermContext ctx) {
        Expression left = (Expression) ctx.term().accept(this);
        Expression right = (Expression) ctx.factor().accept(this);

        return new Times(left, right);
    }

    @Override
    public Node visitParanExpr(GMMParser.ParanExprContext ctx) {
        return ctx.expr().accept(this);
    }

    @Override
    public Node visitLiteralInt(GMMParser.LiteralIntContext ctx) {

        float value = Float.parseFloat(ctx.INT().getText());

        return new LiteralNumber(value);
    }

    @Override
    public Node visitLiteralTrue(GMMParser.LiteralTrueContext ctx) {
        return new LiteralBool(true);
    }

    @Override
    public Node visitLiteralFalse(GMMParser.LiteralFalseContext ctx) {
        return new LiteralBool(false);
    }

    @Override
    public Node visitVariable(GMMParser.VariableContext ctx) {
        ID idNode = GetIDNode(ctx.ID());

        return new Variable(idNode);
    }

    @Override
    public Node visitAccessVector(GMMParser.AccessVectorContext ctx) {
        ID identifier = GetIDNode(ctx.ID(0));
        ID component = GetComponentIDNode(ctx.ID(1));
        return new VectorComponent(identifier, component);
    }

    private ID GetComponentIDNode(TerminalNode id) {
        String text = id.getText();
        if(!(text.equals("x") || text.equals("y") || text.equals("z")))
            throw new RuntimeException("Component ids have to be x y or z");
        return new ID(text);
    }

    @Override
    public Node visitExpressionFunctionCall(GMMParser.ExpressionFunctionCallContext ctx) {
        return ctx.functionCall().accept(this);
    }

    @Override
    public Node visitLiteralVector(GMMParser.LiteralVectorContext ctx) {
        Expression x = (Expression) ctx.expression(0).accept(this);
        Expression y = (Expression) ctx.expression(1).accept(this);
        Expression z = (Expression) ctx.expression(2).accept(this);
        return new LiteralVector(x,y,z);
    }

    @Override
    public Node visitNegatedFactor(GMMParser.NegatedFactorContext ctx) {
        return new Negate((Expression) ctx.factor().accept(this));
    }

    @Override
    public Node visit(ParseTree tree) {
        return null;
    }

    @Override
    public Node visitChildren(RuleNode node) {
        return null;
    }

    @Override
    public Node visitTerminal(TerminalNode node) {
        return null;
    }

    @Override
    public Node visitErrorNode(ErrorNode node) {
        return null;
    }
}
