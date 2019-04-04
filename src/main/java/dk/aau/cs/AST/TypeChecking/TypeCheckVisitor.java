package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.*;
import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.WarningLevel;

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

        for(GMMType actualReturnType : actualReturnTypes){
            if(returnType != actualReturnType){
                Logger.Log(functionDef.idNode.identifier + " has a mismatched return type", WarningLevel.Error);
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
            Logger.Log("Relative parameters only accepts type Num not " + exprType, WarningLevel.Error);
        }
        return null;
    }

    @Override
    public GMMType visitDeclaration(Declaration declaration) {
        GMMType declaredType = declaration.type.accept(this);
        GMMType expressedType = declaration.expression.accept(this);

        if(symbolTable.retrieveSymbolInScope(declaration.identifier.identifier) != null){
            Logger.Log("Variable " + declaration.identifier.identifier + " has already been declared in this scope", WarningLevel.Error);
        }

        symbolTable.enterSymbol(declaration.identifier.identifier, declaredType);

        if(declaredType != expressedType){
            Logger.Log("Mismatched type during " + declaration.identifier.identifier + " declaration expected "+ declaredType + " but got " + expressedType, WarningLevel.Error);
        }

        return null;
    }

    @Override
    public GMMType visitAssign(Assign assign) {
        GMMType variableType = symbolTable.retrieveSymbol(assign.identifier.identifier);
        GMMType expressedType = assign.expression.accept(this);

        if(variableType != expressedType){
            Logger.Log("Mismatched types around var = expr statement", WarningLevel.Error);
        }

        return null;
    }

    @Override
    public GMMType visitFunctionCall(FunctionCall functionCall) {
        FunctionEntry functionSig = functionTable.retrieveFunction(functionCall.identifier.identifier);

        for(int i = 0; i < functionCall.parameters.size(); i++){
            if(functionSig.getParameterTypes().get(i) != functionCall.parameters.get(i).accept(this)){
                Logger.Log("Function call to " + functionSig.getId() + " has mismatched arguments", WarningLevel.Error);
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
            Logger.Log("If statement got " + predicateType + " type but expected a bool", WarningLevel.Error);
        }

        return null;
    }

    @Override
    public GMMType visitLeftCircle(LeftCircle leftCircle) {
        for(CommandParameter parameter : leftCircle.parameters){
            parameter.accept(this);
        }

        return null;
    }

    @Override
    public GMMType visitAbsoluteParameter(AbsoluteParameter absoluteParameter) {
        GMMType exprType = absoluteParameter.expression.accept(this);

        if(exprType != GMMType.Num){
            Logger.Log("Absolute parameters only accepts type Num not " + exprType, WarningLevel.Error);
        }
        return null;
    }

    @Override
    public GMMType visitEquality(Equality equality) {
        GMMType left = equality.left.accept(this);
        GMMType right = equality.right.accept(this);

        if(left != right){
            Logger.Log("Got mismatched types from == expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitInEquality(InEquality inEquality) {
        GMMType left = inEquality.left.accept(this);
        GMMType right = inEquality.right.accept(this);

        if(left != right){
            Logger.Log("Got mismatched types from != expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitAnd(And and) {
        GMMType left = and.left.accept(this);
        GMMType right = and.right.accept(this);

        if(left != GMMType.Bool || right != GMMType.Bool){
            Logger.Log("Got non Bool types from && expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitOr(Or or) {
        GMMType left = or.left.accept(this);
        GMMType right = or.right.accept(this);

        if(left != GMMType.Bool || right != GMMType.Bool){
            Logger.Log("Got non Bool types from || expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitDivide(Divide divide) {
        GMMType left = divide.left.accept(this);
        GMMType right = divide.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log("The / operator cannot operate on type Bool", WarningLevel.Error);
        }

        if(left == GMMType.Vector || right == GMMType.Vector){
            Logger.Log("Divide expression does not accept Vector type", WarningLevel.Error);
            return null;
        }
        if(left != right){
            Logger.Log("Got mismatched types from divide expression", WarningLevel.Error);
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitTimes(Times times) {
        GMMType left = times.left.accept(this);
        GMMType right = times.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log("The * operator cannot operate on type Bool", WarningLevel.Error);
            return null;
        }else if(left == GMMType.Vector && right == GMMType.Vector){
            Logger.Log("The * operator cannot operate on two Vectors", WarningLevel.Error);
            return null;
        } else if(left == GMMType.Num && right == GMMType.Vector || left == GMMType.Vector && right == GMMType.Num){
            return GMMType.Vector;
        }
        else if(left != right){
            Logger.Log("Got mismatched types from times expression", WarningLevel.Error);
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitPlus(Plus plus) {
        GMMType left = plus.left.accept(this);
        GMMType right = plus.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log("The + operator cannot operate on type Bool", WarningLevel.Error);
        }

        if(left != right){
            Logger.Log("Got mismatched types from plus expression", WarningLevel.Error);
            return null;
        }

        return left;
    }

    @Override
    public GMMType visitMinus(Minus minus) {
        GMMType left = minus.left.accept(this);
        GMMType right = minus.right.accept(this);

        if(left == GMMType.Bool || right == GMMType.Bool){
            Logger.Log("The - operator cannot operate on type Bool", WarningLevel.Error);
        }

        if(left != right){
            Logger.Log("Got mismatched types from minus expression", WarningLevel.Error);
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
    public GMMType visitLiteralInt(LiteralInt literalInt) {
        return GMMType.Num;
    }

    @Override
    public GMMType visitRightCircle(RightCircle rightCircle) {
        for(CommandParameter parameter : rightCircle.parameters)
            parameter.accept(this);

        return null;
    }

    @Override
    public GMMType visitMove(Move move) {
        for(CommandParameter parameter : move.parameters)
            parameter.accept(this);
        return null;
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
            Logger.Log("Mismatched type While loop expected type Bool but got " + predicateType, WarningLevel.Error);
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

        if(left != GMMType.Num || right != GMMType.Num){
            Logger.Log("Got non Num types from > expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitLessThan(LessThan lessThan) {
        GMMType left = lessThan.left.accept(this);
        GMMType right = lessThan.right.accept(this);

        if(left != GMMType.Num || right != GMMType.Num){
            Logger.Log("Got non Bool types from < expression", WarningLevel.Error);
            return null;
        }

        return GMMType.Bool;
    }

    @Override
    public GMMType visitVectorComponentAssign(VectorComponentAssign vectorComponentAssign) {
        GMMType expressedType = vectorComponentAssign.expression.accept(this);

        if(expressedType != GMMType.Num){
            Logger.Log("Vector component assignment expected a Num but got " + expressedType, WarningLevel.Error);
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
            Logger.Log("First component of Literal Vector expected type Num but got " + x, WarningLevel.Error);
        if(y != GMMType.Num)
            Logger.Log("Second component of Literal Vector expected type Num but got " + y, WarningLevel.Error);
        if(z != GMMType.Num)
            Logger.Log("Third component of Literal Vector expected type Num but got " + z, WarningLevel.Error);

        return GMMType.Vector;
    }

    @Override
    public GMMType visitNegate(Negate negate) {
        GMMType type = negate.expression.accept(this);

        if(type == GMMType.Void){
            Logger.Log("Cannot negate Type Void", WarningLevel.Error);
        }

        return type;
    }
}
