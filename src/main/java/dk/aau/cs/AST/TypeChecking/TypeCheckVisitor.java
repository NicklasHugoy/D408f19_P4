package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.*;
import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.ErrorReporting.*;
import dk.aau.cs.Syntax.GMMParser;

import java.util.ArrayList;
import java.util.List;

public class TypeCheckVisitor implements ASTVisitor<GMMType> {

    private ISymbolTable symbolTable;
    private IFunctionTable functionTable;

    public TypeCheckVisitor(ISymbolTable symbolTable, IFunctionTable functionTable) {
        this.symbolTable = symbolTable;
        this.functionTable = functionTable;
    }

    @Override
    public GMMType visitProgram(Program program) {
        for(BaseNode node : program.children)
            node.accept(this);

        return null;
    }

    @Override
    public GMMType visitFunctionDef(FunctionDef functionDef) {
        GMMType returnType = functionDef.returnType.accept(this);

        symbolTable.openScope();
        for(FormalParameter parameter : functionDef.parameters){
            parameter.accept(this);
        }

        List<GMMType> actualReturnTypes = new ArrayList<>();
        for(Statement statement : functionDef.statements){
            if(statement instanceof ReturnNode){
                actualReturnTypes.add(statement.accept(this));
            }else{
                statement.accept(this);
            }
        }

        if(returnType != GMMType.Void && actualReturnTypes.size() == 0){
            Logger.Log(new InvalidReturnTypeError("Function " + functionDef.idNode.identifier + " does not return anything", functionDef));
        }

        for(GMMType actualReturnType : actualReturnTypes){
            if(returnType != actualReturnType){
                Logger.Log(new InvalidReturnTypeError( functionDef.idNode.identifier + " has a mismatched return type expected " + returnType + " but got " + actualReturnType, functionDef));
            }
        }

        symbolTable.leaveScope();

        return null;
    }

    @Override
    public GMMType visitFormalParameter(FormalParameter formalParameter) {
        symbolTable.enterSymbol(formalParameter.identifier.identifier, formalParameter.type.accept(this));
        return null;
    }

    @Override
    public GMMType visitTypeNode(TypeNode typeNode) {
        return typeNode.type;
    }

    @Override
    public GMMType visitID(ID id) {
        throw new RuntimeException("This code is not supposed to be run");
    }

    @Override
    public GMMType visitMachineOption(MachineOption machineOption) {
        //TODO make type checking for different options
        return null;
    }

    @Override
    public GMMType visitRelativeParameter(RelativeParameter relativeParameter) {
        GMMType exprType = relativeParameter.expression.accept(this);

        if(exprType != GMMType.Num){
            Logger.Log(new InvalidExpressionType("Relative parameters only accepts type Num but got " + exprType, relativeParameter));
        }
        return null;
    }

    @Override
    public GMMType visitDeclaration(Declaration declaration) {
        GMMType declaredType = declaration.type.accept(this);
        GMMType expressedType = declaration.expression.accept(this);

        if(symbolTable.retrieveSymbolInScope(declaration.identifier.identifier) != null){
            Logger.Log(new OccupiedSymbolError(declaration.identifier.identifier + " has already been declared in this scope", declaration));
        }

        symbolTable.enterSymbol(declaration.identifier.identifier, declaredType);

        if(declaredType != expressedType){
            Logger.Log(new AssignmentTypeError("Mismatched type during " + declaration.identifier.identifier + " declaration expected "+ declaredType + " but got " + expressedType, declaration));
        }

        return null;
    }

    @Override
    public GMMType visitAssign(Assign assign) {
        GMMType variableType = symbolTable.retrieveSymbol(assign.identifier.identifier);
        GMMType expressedType = assign.expression.accept(this);

        if(variableType != expressedType){
            Logger.Log(new AssignmentTypeError("Mismatched types around var = expr statement expected " + variableType + " but got " + expressedType, assign));
        }

        return null;
    }

    @Override
    public GMMType visitFunctionCall(FunctionCall functionCall) {
        FunctionEntry functionSig = functionTable.retrieveFunction(functionCall.identifier.identifier);

        if(functionSig == null){
            return GMMType.Void; //Error logging handled elsewhere
        }

        for(int i = 0; i < functionCall.parameters.size(); i++){
            if(functionSig.getParameterTypes().get(i) != functionCall.parameters.get(i).accept(this)){
                Logger.Log(new InvalidParameterTypeError("Function call to " + functionSig.getId() + " has mismatched arguments", functionCall));
            }
        }

        return functionSig.getReturnType();
    }

    @Override
    public GMMType visitIfNode(IfNode ifNode) {
        GMMType predicateType = ifNode.predicate.accept(this);

        for(Statement statement : ifNode.statements){
            statement.accept(this);
        }

        if(predicateType != GMMType.Bool){
            Logger.Log(new InvalidPredicateType("If statement got " + predicateType + " type but expected a bool", ifNode));
        }

        return null;
    }

    @Override
    public GMMType visitExplicitGCode(ExplicitGCode explicitGCode) {
        return null;
    }

    @Override
    public GMMType visitLeftCircle(LeftCircle leftCircle) {
        for(CommandParameter parameter : leftCircle.parameters){
            parameter.accept(this);
        }

        checkForMultiple(leftCircle.parameters, leftCircle);

        return null;
    }

    @Override
    public GMMType visitAbsoluteParameter(AbsoluteParameter absoluteParameter) {
        GMMType exprType = absoluteParameter.expression.accept(this);

        if(exprType != GMMType.Num){
            Logger.Log(new InvalidExpressionType("Absolute parameters only accepts type Num but got " + exprType, absoluteParameter));
        }
        return null;
    }

    @Override
    public GMMType visitEquality(Equality equality) {
        GMMType left = equality.left.accept(this);
        GMMType right = equality.right.accept(this);

        if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("== expected similar types but got " + left + " == " + right, equality));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitInEquality(InEquality inEquality) {
        GMMType left = inEquality.left.accept(this);
        GMMType right = inEquality.right.accept(this);

        if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("!= expected similar types but got " + left + " != " + right, inEquality));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitAnd(And and) {
        GMMType left = and.left.accept(this);
        GMMType right = and.right.accept(this);

        if(left != GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The && can only operate on type Bool but got " + left, and));
        }
        if(right != GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The && can only operate on type Bool but got " + right, and));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitOr(Or or) {
        GMMType left = or.left.accept(this);
        GMMType right = or.right.accept(this);

        if(left != GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The || can only operate on type Bool but got " + left, or));
        }
        if(right != GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The || can only operate on type Bool but got " + right, or));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitDivide(Divide divide) {
        GMMType left = divide.left.accept(this);
        GMMType right = divide.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The / operator cannot operate on type Bool", divide));
        }

        if(left == GMMType.Vector || right == GMMType.Vector){
            Logger.Log(new InvalidExpressionType("/ expression does not accept Vector type", divide));
            return null;
        }
        if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("/ only accepts operands of the same type got "+left + " and " + right, divide));
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitTimes(Times times) {
        GMMType left = times.left.accept(this);
        GMMType right = times.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The * operator cannot operate on type Bool", times));
            return null;
        }else if(left == GMMType.Vector && right == GMMType.Vector){
            Logger.Log(new InvalidExpressionType("The * operator cannot operate on two Vectors", times));
            return null;
        } else if(left == GMMType.Num && right == GMMType.Vector || left == GMMType.Vector && right == GMMType.Num){
            return GMMType.Vector;
        }
        else if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("* only accepts operands of the same type got "+left + " and " + right, times));
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitPlus(Plus plus) {
        GMMType left = plus.left.accept(this);
        GMMType right = plus.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The + operator cannot operate on type Bool", plus));
        }

        if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("+ only accepts operands of the same type got "+left + " and " + right, plus));
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitMinus(Minus minus) {
        GMMType left = minus.left.accept(this);
        GMMType right = minus.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log(new InvalidExpressionType("The - operator cannot operate on type Bool", minus));
        }

        if(left != right){
            Logger.Log(new MismatchedExpressionTypeError("- only accepts operands of the same type got "+left + " and " + right, minus));
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitVariable(Variable variable) {
        return symbolTable.retrieveSymbol(variable.identifier.identifier);
    }

    @Override
    public GMMType visitLiteralBool(LiteralBool literalBool) {
        return GMMType.Bool;
    }

    @Override
    public GMMType visitLiteralNumber(LiteralNumber literalNumber) {
        return GMMType.Num;
    }

    @Override
    public GMMType visitRightCircle(RightCircle rightCircle) {
        for(CommandParameter parameter : rightCircle.parameters)
            parameter.accept(this);

        checkForMultiple(rightCircle.parameters, rightCircle);

        return null;
    }

    @Override
    public GMMType visitMove(Move move) {
        for(CommandParameter parameter : move.parameters)
            parameter.accept(this);

        checkForMultiple(move.parameters, move);

        return null;
    }

    @Override
    public GMMType visitJump(Jump jump) {
        for(CommandParameter parameter : jump.parameters)
            parameter.accept(this);

        checkForMultiple(jump.parameters, jump);

        return null;
    }

    private void checkForMultiple(List<CommandParameter> parameters, PositionedNode node) {
        List<String> activeSymbols = new ArrayList<>();
        for(CommandParameter parameter : parameters){
            if(parameter instanceof VectorCommandParameter){
                if(activeSymbols.contains("X") || activeSymbols.contains("Y") || activeSymbols.contains("Z"))
                    Logger.Log(new MultipleCommandParameterError("multiple affecting X Y or Z", node));
                activeSymbols.add("X");
                activeSymbols.add("Y");
                activeSymbols.add("Z");
            }else{
                RelativeParameter param = (RelativeParameter) parameter;
                String symbol = param.identifier.identifier;
                if(activeSymbols.contains(symbol))
                    Logger.Log(new MultipleCommandParameterError("multiple affecting "+symbol, node));

                activeSymbols.add(symbol);
            }
        }
    }

    @Override
    public GMMType visitBlockDef(BlockDef blockDef) {
        for(MachineOption option : blockDef.options)
            option.accept(this);

        symbolTable.openScope();

        for(Statement statements : blockDef.statements)
            statements.accept(this);

        symbolTable.leaveScope();
        return null;
    }

    @Override
    public GMMType visitWhileLoop(WhileLoop whileLoop) {
        GMMType predicateType = whileLoop.expression.accept(this);

        symbolTable.openScope();

        if(predicateType != GMMType.Bool){
            Logger.Log(new InvalidPredicateType("While loop expected type Bool but got " + predicateType, whileLoop));
        }

        for (Statement statement : whileLoop.statements)
            statement.accept(this);

        symbolTable.leaveScope();


        return null;
    }

    @Override
    public GMMType visitReturnNode(ReturnNode returnNode) {
        return returnNode.expression.accept(this);
    }

    @Override
    public GMMType visitGreaterThan(GreaterThan greaterThan) {
        GMMType left = greaterThan.left.accept(this);
        GMMType right = greaterThan.right.accept(this);

        if(left != GMMType.Num){
            Logger.Log(new InvalidExpressionType("> can only operate on Num but got "+left, greaterThan));
        }
        if(right != GMMType.Num){
            Logger.Log(new InvalidExpressionType("> can only operate on Num but got "+right, greaterThan));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitLessThan(LessThan lessThan) {
        GMMType left = lessThan.left.accept(this);
        GMMType right = lessThan.right.accept(this);

        if(left != GMMType.Num){
            Logger.Log(new InvalidExpressionType("< can only operate on Num but got "+left, lessThan));
        }
        if(right != GMMType.Num){
            Logger.Log(new InvalidExpressionType("< can only operate on Num but got "+right, lessThan));
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitVectorComponentAssign(VectorComponentAssign vectorComponentAssign) {
        GMMType expressedType = vectorComponentAssign.expression.accept(this);

        if(expressedType != GMMType.Num){
            Logger.Log(new AssignmentTypeError("Vector component assignment expected a Num but got " + expressedType, vectorComponentAssign));
        }

        return null;
    }

    @Override
    public GMMType visitVectorComponent(VectorComponent vectorComponent) {
        return GMMType.Num;
    }

    @Override
    public GMMType visitLiteralVector(LiteralVector literalVector) {
        GMMType x = literalVector.x.accept(this);
        GMMType y = literalVector.y.accept(this);
        GMMType z = literalVector.z.accept(this);

        if(x != GMMType.Num)
            Logger.Log(new InvalidExpressionType("First component of Literal Vector expected type Num but got " + x, literalVector));
        if(y != GMMType.Num)
            Logger.Log(new InvalidExpressionType("Second component of Literal Vector expected type Num but got " + y, literalVector));
        if(z != GMMType.Num)
            Logger.Log(new InvalidExpressionType("Third component of Literal Vector expected type Num but got " + z, literalVector));

        return GMMType.Vector;
    }

    @Override
    public GMMType visitNegate(Negate negate) {
        GMMType type = negate.expression.accept(this);

        if(type == GMMType.Void){
            Logger.Log(new InvalidExpressionType("Cannot negate type Void", negate));
        }

        return type;
    }

    @Override
    public GMMType visitSquareRoot(SquareRoot squareRoot) {
        if(squareRoot.expression.accept(this) != GMMType.Num){
            Logger.Log(new InvalidExpressionType("Square root can only operate on type Num", squareRoot));
        }

        return GMMType.Num;
    }

    @Override
    public GMMType visitVectorCommandParameter(VectorCommandParameter vectorCommandParameter) {
        GMMType type = vectorCommandParameter.vectorExpression.accept(this);
        if(type != GMMType.Vector){
            Logger.Log(new InvalidExpressionType("Command parameter expected type Vector but got "+ type, vectorCommandParameter));
        }
        return null;
    }


}
