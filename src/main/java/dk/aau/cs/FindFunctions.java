package dk.aau.cs;

import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class FindFunctions implements GMMVisitor {

    public class Func{
        public String identifier;
        public List<GMMParser.ScopedStmtContext> body;

        public Func(String identifier, List<GMMParser.ScopedStmtContext> body) {
            this.identifier = identifier;
            this.body = body;
        }
    }

    ArrayList<Func> funcs = new ArrayList<>();

    @Override
    public Object visitProg(GMMParser.ProgContext ctx) {
        return null;
    }

    @Override
    public Object visitFunctionDef(GMMParser.FunctionDefContext ctx) {
        String id = ctx.ID().getSymbol().getText();
        funcs.add(new Func(id, ctx.scopedStmt()));
        return null;
    }

    @Override
    public Object visitBlockDef(GMMParser.BlockDefContext ctx) {
        return null;
    }

    @Override
    public Object visitFormalParameters(GMMParser.FormalParametersContext ctx) {
        return null;
    }

    @Override
    public Object visitFormalParameter(GMMParser.FormalParameterContext ctx) {
        return null;
    }

    @Override
    public Object visitMachineOptions(GMMParser.MachineOptionsContext ctx) {
        return null;
    }

    @Override
    public Object visitMachineOption(GMMParser.MachineOptionContext ctx) {
        return null;
    }

    @Override
    public Object visitBlock(GMMParser.BlockContext ctx) {
        return null;
    }

    @Override
    public Object visitWhileLoop(GMMParser.WhileLoopContext ctx) {
        return null;
    }

    @Override
    public Object visitIfStatement(GMMParser.IfStatementContext ctx) {
        return null;
    }

    @Override
    public Object visitCallFunction(GMMParser.CallFunctionContext ctx) {
        return null;
    }

    @Override
    public Object visitAssignment(GMMParser.AssignmentContext ctx) {
        return null;
    }

    @Override
    public Object visitDeclaration(GMMParser.DeclarationContext ctx) {
        return null;
    }

    @Override
    public Object visitMove(GMMParser.MoveContext ctx) {
        return null;
    }

    @Override
    public Object visitRightCircle(GMMParser.RightCircleContext ctx) {
        return null;
    }

    @Override
    public Object visitLeftCircle(GMMParser.LeftCircleContext ctx) {
        return null;
    }

    @Override
    public Object visitRelativeParameter(GMMParser.RelativeParameterContext ctx) {
        return null;
    }

    @Override
    public Object visitAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx) {
        return null;
    }

    @Override
    public Object visitParameters(GMMParser.ParametersContext ctx) {
        return null;
    }

    @Override
    public Object visitExpression(GMMParser.ExpressionContext ctx) {
        return null;
    }

    @Override
    public Object visitLogic(GMMParser.LogicContext ctx) {
        return null;
    }

    @Override
    public Object visitBooleanExpr(GMMParser.BooleanExprContext ctx) {
        return null;
    }

    @Override
    public Object visitExpr(GMMParser.ExprContext ctx) {
        return null;
    }

    @Override
    public Object visitTerm(GMMParser.TermContext ctx) {
        return null;
    }

    @Override
    public Object visitFactor(GMMParser.FactorContext ctx) {
        return null;
    }

    @Override
    public Object visit(ParseTree parseTree) {
        return null;
    }

    @Override
    public Object visitChildren(RuleNode ruleNode) {
        return null;
    }

    @Override
    public Object visitTerminal(TerminalNode terminalNode) {
        return null;
    }

    @Override
    public Object visitErrorNode(ErrorNode errorNode) {
        return null;
    }
}
