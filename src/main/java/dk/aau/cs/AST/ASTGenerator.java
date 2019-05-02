package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.ErrorReporting.*;
import dk.aau.cs.Syntax.GMMParser;
import dk.aau.cs.Syntax.GMMVisitor;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ASTGenerator implements GMMVisitor<Node> {

    private boolean functionScope = false;

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

        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        if(ctx.formalParameters() != null){
            List<GMMParser.FormalParameterContext> parameterContexts = ctx.formalParameters().formalParameter();

            for(GMMParser.FormalParameterContext parameterContext : parameterContexts)
                parameters.add((FormalParameter) parameterContext.accept(this));
        }

        functionScope = true;

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt())
            statements.add((Statement) stmtContext.accept(this));

        functionScope = false;

        return new FunctionDef(line, charNr ,typeNode, idNode, parameters, statements);
    }

    @Override
    public Node visitBlockDef(GMMParser.BlockDefContext ctx) {
        ArrayList<MachineOption> options = new ArrayList<>();
        ArrayList<Statement> statements = new ArrayList<>();

        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        if(ctx.machineOptions() != null){
            for(GMMParser.MachineOptionContext optionContext : ctx.machineOptions().machineOption())
                options.add((MachineOption) optionContext.accept(this));
        }

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt()){
            statements.add((Statement) stmtContext.accept(this));
            if(stmtContext instanceof GMMParser.FunctionReturnContext && !functionScope){
                Logger.Log(new SyntaxError("return statement used in block definition", WarningLevel.Error));
            }
        }


        return new BlockDef(line, charNr,options, statements);
    }

    @Override
    public Node visitFormalParameters(GMMParser.FormalParametersContext ctx) {
        throw new IllegalArgumentException("This should not be called exception"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitFormalParameter(GMMParser.FormalParameterContext ctx) {
        TypeNode typeNode = GetTypeNode(ctx.Type());
        ID idNode = GetIDNode(ctx.ID());

        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        return new FormalParameter(line, charNr, typeNode, idNode);
    }

    private ID GetIDNode(TerminalNode id) {
        int line = id.getSymbol().getLine();
        int charNr = id.getSymbol().getCharPositionInLine();

        return new ID(line, charNr,id.getText());
    }

    private TypeNode GetTypeNode(TerminalNode type) {
        int line = type.getSymbol().getLine();
        int charNr = type.getSymbol().getCharPositionInLine();

        switch (type.getText().trim()){
            case "num":
                return new TypeNode(line, charNr, GMMType.Num);
            case "bool":
                return new TypeNode(line, charNr, GMMType.Bool);
            case "vector":
                return new TypeNode(line, charNr, GMMType.Vector);
        }
        throw new IllegalArgumentException( type.getText() + " Does not match any of the types");
    }

    private TypeNode GetFunctionTypeNode(TerminalNode type) {
        int line = type.getSymbol().getLine();
        int charNr = type.getSymbol().getCharPositionInLine();

        switch (type.getText().trim()){
            case "num":
                return new TypeNode(line, charNr, GMMType.Num);
            case "bool":
                return new TypeNode(line, charNr, GMMType.Bool);
            case "vector":
                return new TypeNode(line, charNr, GMMType.Vector);
            case "void":
                return new TypeNode(line, charNr, GMMType.Void);
        }
        throw new IllegalArgumentException( type.getText() + " Does not match any of the types");
    }

    @Override
    public Node visitMachineOptions(GMMParser.MachineOptionsContext ctx) {
        throw new IllegalArgumentException("This should not be called"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitMachineOption(GMMParser.MachineOptionContext ctx)
    {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        String[] blockParam = ctx.BlockParam().getText().split(":");

        ID idNode = new ID(ctx.start.getLine(), ctx.start.getCharPositionInLine(), blockParam[0].trim());

        return new MachineOption(line, charNr, idNode, blockParam[1]);
    }

    @Override
    public Node visitFunctionReturn(GMMParser.FunctionReturnContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression expression = (Expression) ctx.expression().accept(this);

        return new ReturnNode(line, charNr, expression);
    }

    @Override
    public Node visitExplicitGCode(GMMParser.ExplicitGCodeContext ctx) {
        return new ExplicitGCode(ctx.start.getLine(), ctx.start.getCharPositionInLine(), ctx.getText());
    }

    @Override
    public Node visitBlock(GMMParser.BlockContext ctx) {
        return ctx.blockDef().accept(this);
    }

    @Override
    public Node visitLoop(GMMParser.LoopContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID identifier = GetIDNode(ctx.ID());
        Expression startExpression = (Expression) ctx.expression(0).accept(this);
        Expression endExpression = (Expression) ctx.expression(1).accept(this);
        List<Statement> statements = ctx.scopedStmt().stream()
                        .map(scopedStmtContext -> (Statement) scopedStmtContext.accept(this))
                        .collect(Collectors.toList());

        return new Loop(line, charNr, identifier, startExpression, endExpression, statements);
    }

    @Override
    public Node visitIfStatement(GMMParser.IfStatementContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression expression = (Expression) ctx.expression().accept(this);
        List<Statement> statements = new ArrayList<>();

        for(GMMParser.ScopedStmtContext stmtContext : ctx.scopedStmt())
            statements.add((Statement) stmtContext.accept(this));

        return new IfNode(line, charNr, expression, statements);
    }

    @Override
    public Node visitScopedStmtFunctionCall(GMMParser.ScopedStmtFunctionCallContext ctx) {
        return ctx.functionCall().accept(this);
    }

    @Override
    public Node visitAssignment(GMMParser.AssignmentContext ctx)
    {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID idNode = GetIDNode(ctx.ID());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new Assign(line , charNr, idNode, expression);
    }

    @Override
    public Node visitVectorComponentAssign(GMMParser.VectorComponentAssignContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID identifier = GetIDNode(ctx.ID(0));
        ID component = GetIDNode(ctx.ID(1));

        Expression expression = (Expression) ctx.expression().accept(this);

        return new VectorComponentAssign(line , charNr, identifier, component, expression);
    }

    @Override
    public Node visitDeclaration(GMMParser.DeclarationContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        TypeNode typeNode = GetTypeNode(ctx.Type());
        ID idNode = GetIDNode(ctx.ID());
        Expression expression = (Expression) ctx.expression().accept(this);


        return new Declaration(line, charNr, typeNode, idNode, expression);
    }

    @Override
    public Node visitMove(GMMParser.MoveContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        List<CommandParameter> commandParameters = new ArrayList<>();

        if(ctx.vectorCommandParameter() != null)
            commandParameters.add((CommandParameter) ctx.vectorCommandParameter().accept(this));

        for(GMMParser.SingleCommandParameterContext singleCommandParameterContext : ctx.singleCommandParameter())
            commandParameters.add((CommandParameter) singleCommandParameterContext.accept(this));

        return new Move(line, charNr, commandParameters);
    }

    @Override
    public Node visitJump(GMMParser.JumpContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        List<CommandParameter> commandParameters = new ArrayList<>();

        if(ctx.vectorCommandParameter() != null)
            commandParameters.add((CommandParameter) ctx.vectorCommandParameter().accept(this));

        for(GMMParser.SingleCommandParameterContext singleCommandParameterContext : ctx.singleCommandParameter())
            commandParameters.add((CommandParameter) singleCommandParameterContext.accept(this));

        return new Jump(line, charNr, commandParameters);
    }

    @Override
    public Node visitRightCircle(GMMParser.RightCircleContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        List<CommandParameter> commandParameters = new ArrayList<>();

        if(ctx.vectorCommandParameter() != null)
            commandParameters.add((CommandParameter) ctx.vectorCommandParameter().accept(this));

        for(GMMParser.SingleCommandParameterContext singleCommandParameterContext : ctx.singleCommandParameter())
            commandParameters.add((CommandParameter) singleCommandParameterContext.accept(this));

        return new RightCircle(line, charNr, commandParameters);
    }

    @Override
    public Node visitLeftCircle(GMMParser.LeftCircleContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        List<CommandParameter> commandParameters = new ArrayList<>();

        if(ctx.vectorCommandParameter() != null)
            commandParameters.add((CommandParameter) ctx.vectorCommandParameter().accept(this));

        for(GMMParser.SingleCommandParameterContext singleCommandParameterContext : ctx.singleCommandParameter())
            commandParameters.add((CommandParameter) singleCommandParameterContext.accept(this));

        return new LeftCircle(line, charNr,commandParameters);
    }

    @Override
    public Node visitFunctionCall(GMMParser.FunctionCallContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID idNode = GetIDNode(ctx.ID());
        List<Expression> expressions = new ArrayList<>();

        if(ctx.parameters() != null){
            for(GMMParser.ExpressionContext expressionContext : ctx.parameters().expression())
                expressions.add((Expression) expressionContext.accept(this));
        }

        return new FunctionCall(line, charNr, idNode, expressions);
    }

    @Override
    public Node visitSingleCommandParameter(GMMParser.SingleCommandParameterContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID idNode = GetIDNode(ctx.CommandParameter());
        Expression expression = (Expression) ctx.expression().accept(this);

        return new RelativeParameter(line, charNr, idNode, expression);
    }

    @Override
    public Node visitVectorCommandParameter(GMMParser.VectorCommandParameterContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        return new VectorCommandParameter(line, charNr, (Expression) ctx.expression().accept(this));
    }

    @Override
    public Node visitParameters(GMMParser.ParametersContext ctx) {
        throw new IllegalArgumentException("This should not be called"); // This node should be ignored because it simply acts as a structural node
    }

    @Override
    public Node visitExpression(GMMParser.ExpressionContext ctx) {
        return ctx.logic().accept(this);
    }

    @Override
    public Node visitAndLogic(GMMParser.AndLogicContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.logic().accept(this);
        Expression right = (Expression) ctx.booleanExpr().accept(this);

        return new And(line, charNr, left, right);
    }

    @Override
    public Node visitLogicDerivation(GMMParser.LogicDerivationContext ctx) {
        return ctx.booleanExpr().accept(this);
    }

    @Override
    public Node visitOrLogic(GMMParser.OrLogicContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.logic().accept(this);
        Expression right = (Expression) ctx.booleanExpr().accept(this);

        return new Or(line, charNr, left, right);
    }

    @Override
    public Node visitEqualityExpr(GMMParser.EqualityExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new Equality(line, charNr, left, right);
    }

    @Override
    public Node visitInEqualityExpr(GMMParser.InEqualityExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new InEquality(line, charNr, left, right);
    }

    @Override
    public Node visitGreaterThanExpr(GMMParser.GreaterThanExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.expr(0).accept(this);
        Expression right = (Expression) ctx.expr(1).accept(this);

        return new GreaterThan(line, charNr,left, right);
    }

    @Override
    public Node visitLessThanExpr(GMMParser.LessThanExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

		Expression left = (Expression) ctx.expr(0).accept(this);
		Expression right = (Expression) ctx.expr(1).accept(this);

		return new LessThan(line, charNr, left, right);
    }

    @Override
    public Node visitParanLogic(GMMParser.ParanLogicContext ctx) {
        return ctx.logic().accept(this);
    }

    @Override
    public Node visitBooleanExprDerivation(GMMParser.BooleanExprDerivationContext ctx) {
        return ctx.expr().accept(this);
    }

    @Override
    public Node visitPlusExpr(GMMParser.PlusExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.expr().accept(this);
        Expression right = (Expression) ctx.term().accept(this);

        return new Plus(line, charNr, left, right);
    }

    @Override
    public Node visitExprDerivation(GMMParser.ExprDerivationContext ctx) {
        return ctx.term().accept(this);
    }

    @Override
    public Node visitMinusExpr(GMMParser.MinusExprContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.expr().accept(this);
        Expression right = (Expression) ctx.term().accept(this);

        return new Minus(line, charNr, left, right);
    }

    @Override
    public Node visitTermDerivation(GMMParser.TermDerivationContext ctx) {
        return ctx.factor().accept(this);
    }

    @Override
    public Node visitDivideTerm(GMMParser.DivideTermContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.term().accept(this);
        Expression right = (Expression) ctx.factor().accept(this);

        return new Divide(line, charNr, left, right);
    }

    @Override
    public Node visitTimesTerm(GMMParser.TimesTermContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression left = (Expression) ctx.term().accept(this);
        Expression right = (Expression) ctx.factor().accept(this);

        return new Times(line, charNr, left, right);
    }

    @Override
    public Node visitParanExpr(GMMParser.ParanExprContext ctx) {
        return ctx.expr().accept(this);
    }

    @Override
    public Node visitLiteralInt(GMMParser.LiteralIntContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        float value = Float.parseFloat(ctx.INT().getText());

        return new LiteralNumber(line, charNr, value);
    }

    @Override
    public Node visitLiteralTrue(GMMParser.LiteralTrueContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();
        return new LiteralBool(line, charNr, true);
    }

    @Override
    public Node visitLiteralFalse(GMMParser.LiteralFalseContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();
        return new LiteralBool(line, charNr, false);
    }

    @Override
    public Node visitVariable(GMMParser.VariableContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        ID idNode = GetIDNode(ctx.ID());

        return new Variable(line, charNr, idNode);
    }

    @Override
    public Node visitAccessVector(GMMParser.AccessVectorContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression expression = (Expression) ctx.factor().accept(this);
        ID component = GetComponentIDNode(ctx.ID());
        return new VectorComponent(line, charNr, expression, component);
    }

    @Override
    public Node visitSquareRoot(GMMParser.SquareRootContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        return new SquareRoot(line, charNr, (Expression) ctx.expr().accept(this));
    }

    private ID GetComponentIDNode(TerminalNode id) {
        int line = id.getSymbol().getLine();
        int charNr = id.getSymbol().getCharPositionInLine();
        String text = id.getText();
        if(!(text.equals("x") || text.equals("y") || text.equals("z")))
            Logger.Log(new ErrorMessage("Vector components can only be x y or z not "+text, WarningLevel.Error));
        return new ID(line, charNr, text);
    }

    @Override
    public Node visitExpressionFunctionCall(GMMParser.ExpressionFunctionCallContext ctx) {
        return ctx.functionCall().accept(this);
    }

    @Override
    public Node visitLiteralVector(GMMParser.LiteralVectorContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        Expression x = (Expression) ctx.expression(0).accept(this);
        Expression y = (Expression) ctx.expression(1).accept(this);
        Expression z = (Expression) ctx.expression(2).accept(this);
        return new LiteralVector(line, charNr, x, y, z);
    }

    @Override
    public Node visitNegatedFactor(GMMParser.NegatedFactorContext ctx) {
        int line = ctx.start.getLine();
        int charNr = ctx.start.getCharPositionInLine();

        return new Negate(line, charNr, (Expression) ctx.factor().accept(this));
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
