package dk.aau.cs.CodeGeneration;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.ExpressionEvaluator.*;
import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTableEntry;
import dk.aau.cs.AST.TypeChecking.TypeValuePair;
import dk.aau.cs.Syntax.GMMVisitor;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CodeGeneratorVisitor implements ASTVisitor {

    private ISymbolTable symbolTable;
    private IFunctionTable functionTable;
    private Writer writer;

    private ExpressionEvaluatorVisitor evaluator;

    public CodeGeneratorVisitor(ISymbolTable symbolTable, IFunctionTable functionTable, Writer writer) {
        this.symbolTable = symbolTable;
        this.functionTable = functionTable;
        this.writer = writer;
        evaluator = new ExpressionEvaluatorVisitor(functionTable, symbolTable, this);
    }

    @Override
    public Object visitProgram(Program program) {

        for(BaseNode node : program.children){
            if(node instanceof BlockDef){
                node.accept(this);
            }

        }

        return null;
    }

    @Override
    public Object visitMachineOption(MachineOption machineOption) {
        return null;
    }

    @Override
    public Object visitRelativeParameter(RelativeParameter relativeParameter) {
        String id = relativeParameter.identifier.identifier;
        IValue value = relativeParameter.expression.accept(evaluator);

        safeWrite(" "+id + value.toString());

        return null;
    }

    @Override
    public Object visitDeclaration(Declaration declaration) {
        GMMType type = declaration.type.type;
        String id = declaration.identifier.identifier;
        IValue value = declaration.expression.accept(evaluator);

        symbolTable.enterSymbol(id, type, value);
        return null;
    }

    @Override
    public Object visitAssign(Assign assign) {
        String id = assign.identifier.identifier;
        IValue value = assign.expression.accept(evaluator);

        symbolTable.assignValue(id, value);

        return null;
    }

    @Override
    public Object visitFunctionCall(FunctionCall functionCall) {
        FunctionEntry function = functionTable.retrieveFunction(functionCall.identifier.identifier);

        List<SymbolTableEntry> parameters = new ArrayList<>();
        for(int i = 0; i < function.getParameterNames().size(); i++){
            String id = function.getParameterNames().get(i);
            GMMType type = function.getParameterTypes().get(i);
            IValue value = functionCall.parameters.get(i).accept(evaluator);
            parameters.add(new SymbolTableEntry(id, type, value));
        }

        symbolTable.openScope();
        symbolTable.isolateScope();

        for(SymbolTableEntry parameter : parameters)
            symbolTable.enterSymbol(parameter.getId(), parameter.getType(), parameter.getValue());

        for(Statement statement : function.getStatements()){

            Object returnValue = statement.accept(this);
            if(returnValue != null){
                symbolTable.leaveScope();
                return returnValue;
            }
        }

        symbolTable.leaveScope();
        return null;
    }

    @Override
    public Object visitReturnNode(ReturnNode returnNode) {
        return returnNode.expression.accept(evaluator);
    }

    @Override
    public Object visitIfNode(IfNode ifNode) {
        BoolValue value = (BoolValue) ifNode.predicate.accept(evaluator);

        if(value.getValue()){
            for(Statement statement : ifNode.statements){
                Object returnValue = statement.accept(this);
                if(returnValue != null){
                    return returnValue;
                }
            }
        }

        return null;
    }

    @Override
    public Object visitLeftCircle(LeftCircle leftCircle) {
        safeWrite("G3");
        for(CommandParameter parameter : leftCircle.parameters){
            parameter.accept(this);
        }
        safeWrite("\n");

        return null;
    }

    @Override
    public Object visitAbsoluteParameter(AbsoluteParameter absoluteParameter) {
        String id = absoluteParameter.identifier.identifier;
        IValue value = absoluteParameter.expression.accept(evaluator);

        safeWrite(" "+id + value.toString());
        return null;
    }

    @Override
    public Object visitRightCircle(RightCircle rightCircle) {
        safeWrite("G2");
        for(CommandParameter parameter : rightCircle.parameters){
            parameter.accept(this);
        }
        safeWrite("\n");

        return null;
    }

    @Override
    public Object visitMove(Move move) {
        safeWrite("G1");
        for(CommandParameter parameter : move.parameters){
            parameter.accept(this);
        }
        safeWrite("\n");
        return null;
    }

    @Override
    public Object visitBlockDef(BlockDef blockDef) {
        //todo handle machine options

        symbolTable.openScope();

        Object returnValue = null;
        for(Statement statement : blockDef.statements){
             returnValue = statement.accept(this);
            if(returnValue != null){
                break;
            }
        }


        symbolTable.leaveScope();
        return returnValue;
    }

    @Override
    public Object visitWhileLoop(WhileLoop whileLoop) {
        BoolValue value = (BoolValue) whileLoop.expression.accept(evaluator);
        while(value.getValue()){
            for(Statement statement : whileLoop.statements){
                Object returnValue = statement.accept(this);
                if(returnValue != null){
                    return returnValue;
                }
            }

            value = (BoolValue) whileLoop.expression.accept(evaluator);
        }

        return null;
    }

    @Override
    public Object visitVectorComponentAssign(VectorComponentAssign vectorComponentAssign) {
        NumValue value = (NumValue) vectorComponentAssign.expression.accept(evaluator);
        String id = vectorComponentAssign.identifier.identifier;
        String component = vectorComponentAssign.component.identifier;

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue(id);
        Vector vector = (Vector)pair.getValue();

        switch (component){
            case "x":
                vector.setX(value.getValue());
                break;
            case "y":
                vector.setY(value.getValue());
                break;
            case "z":
                vector.setZ(value.getValue());
                break;
        }

        symbolTable.assignValue(id, new VectorValue(vector));

        return null;
    }

    @Override
    public Object visitExplicitGCode(ExplicitGCode explicitGCode) {
        String gcode = explicitGCode.fillReferences(symbolTable).replace('@', ' ').trim();

        safeWrite(gcode+"\n");

        return null;
    }

    private void safeWrite(String str){
        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
