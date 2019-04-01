package dk.aau.cs;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.RuleNode;
import org.antlr.v4.runtime.tree.TerminalNode;


public class Main {

    public static void main(String[] args){
        System.out.println("Hello, World!");

        CharStream cs = CharStreams.fromString("function helloworld () {move X=50}" +
                "function thisIsAwesome(){move X=0 move X=10}");
        GMMLexer lexer = new GMMLexer(cs);
        TokenStream ts = new BufferedTokenStream(lexer);
        GMMParser parser = new GMMParser(ts);

        GMMParser.ProgContext prog = parser.prog();

        GMMVisitor printer = new Printer();
        FindFunctions functionsFinder = new FindFunctions();

        VisitTree(functionsFinder, prog);

        for(FindFunctions.Func func : functionsFinder.funcs)
            System.out.println(func.identifier + "  with " + func.body.size() + " lines");
    }

    public static void VisitTree(GMMVisitor visitor, ParseTree tree){
        tree.accept(visitor);

        for(int i = 0; i < tree.getChildCount(); i++)
            VisitTree(visitor, tree.getChild(i));
    }



    private static class Printer implements GMMVisitor{

        @Override
        public Object visitProg(GMMParser.ProgContext ctx) {
            System.out.println("prog");

            return null;
        }

        @Override
        public Object visitFunctionDef(GMMParser.FunctionDefContext ctx) {
            System.out.println("Function Def");
            return null;
        }

        @Override
        public Object visitBlockDef(GMMParser.BlockDefContext ctx) {
            System.out.println("Block Def");
            return null;
        }

        @Override
        public Object visitFormalParameters(GMMParser.FormalParametersContext ctx) {
            System.out.println("FormalParameters");
            return null;
        }

        @Override
        public Object visitFormalParameter(GMMParser.FormalParameterContext ctx) {
            System.out.println("FormalParameter");
            return null;
        }

        @Override
        public Object visitMachineOptions(GMMParser.MachineOptionsContext ctx) {
            System.out.println("MachineOptions");
            return null;
        }

        @Override
        public Object visitMachineOption(GMMParser.MachineOptionContext ctx) {
            System.out.println("MachineOption");
            return null;
        }

        @Override
        public Object visitBlock(GMMParser.BlockContext ctx) {
            System.out.println("Block");
            return null;
        }

        @Override
        public Object visitWhileLoop(GMMParser.WhileLoopContext ctx) {
            System.out.println("While loop");
            return null;
        }

        @Override
        public Object visitIfStatement(GMMParser.IfStatementContext ctx) {
            System.out.println("If Statement");
            return null;
        }

        @Override
        public Object visitCallFunction(GMMParser.CallFunctionContext ctx) {
            System.out.println("Call Function");
            return null;
        }

        @Override
        public Object visitAssignment(GMMParser.AssignmentContext ctx) {
            System.out.println("Assignment");
            return null;
        }

        @Override
        public Object visitDeclaration(GMMParser.DeclarationContext ctx) {
            System.out.println("Declaration");
            return null;
        }

        @Override
        public Object visitMove(GMMParser.MoveContext ctx) {
            System.out.println("Move");
            return null;
        }

        @Override
        public Object visitRightCircle(GMMParser.RightCircleContext ctx) {
            System.out.println("RightCircle");
            return null;
        }

        @Override
        public Object visitLeftCircle(GMMParser.LeftCircleContext ctx) {
            System.out.println("LeftCircle");
            return null;
        }

        @Override
        public Object visitRelativeParameter(GMMParser.RelativeParameterContext ctx) {
            System.out.println("Relative Parameter");
            return null;
        }

        @Override
        public Object visitAbsoluteParameter(GMMParser.AbsoluteParameterContext ctx) {
            System.out.println("Absolute Parameter");
            return null;
        }

        @Override
        public Object visitParameters(GMMParser.ParametersContext ctx) {
            System.out.println("Parameters");
            return null;
        }

        @Override
        public Object visitExpression(GMMParser.ExpressionContext ctx) {
            System.out.println("Expression");
            return null;
        }

        @Override
        public Object visitLogic(GMMParser.LogicContext ctx) {
            System.out.println("Logic");
            return null;
        }

        @Override
        public Object visitBooleanExpr(GMMParser.BooleanExprContext ctx) {
            System.out.println("Boolean");
            return null;
        }

        @Override
        public Object visitExpr(GMMParser.ExprContext ctx) {
            System.out.println("Expr");
            return null;
        }

        @Override
        public Object visitTerm(GMMParser.TermContext ctx) {
            System.out.println("Term");
            return null;
        }

        @Override
        public Object visitFactor(GMMParser.FactorContext ctx) {
            System.out.println("Factor");
            return null;
        }

        @Override
        public Object visit(ParseTree parseTree) {
            System.out.println("Parse tree");
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

}
