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
import dk.aau.cs.BlockDefChecker.MachineOptionsGenerator;

import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class CodeGeneratorVisitor implements ASTVisitor {

    private ISymbolTable symbolTable;
    private IFunctionTable functionTable;
    private Writer writer;

    private ExpressionEvaluatorVisitor evaluator;
    private MachineOptionsGenerator blockChecker;

    public boolean annotateWithLineNumbers = false;

    public CodeGeneratorVisitor(ISymbolTable symbolTable, IFunctionTable functionTable, Writer writer) {
        this.symbolTable = symbolTable;
        this.functionTable = functionTable;
        this.writer = writer;
        evaluator = new ExpressionEvaluatorVisitor(symbolTable, this);
        blockChecker = new MachineOptionsGenerator();
    }

    @Override
    public Object visitProgram(Program program) {

        for(BaseNode node : program.children){
            if(node instanceof BlockDef){
                blockChecker.enterFirstBlock((BlockDef) node);
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
    public Object visitRelativeParameter(NumCommandParameter numCommandParameter) {
        String id = numCommandParameter.identifier.identifier;
        IValue value = numCommandParameter.expression.accept(evaluator);

        safeWrite(" "+id + value.toString(), numCommandParameter);

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
        safeWrite("G3",leftCircle);
        for(CommandParameter parameter : leftCircle.parameters){
            parameter.accept(this);
        }
        safeWrite("\n",leftCircle);

        return null;
    }

    @Override
    public Object visitRightCircle(RightCircle rightCircle) {
        safeWrite("G2",rightCircle);
        for(CommandParameter parameter : rightCircle.parameters){
            parameter.accept(this);
        }
        safeWrite("\n", rightCircle);

        return null;
    }

    @Override
    public Object visitMove(Move move) {
        safeWrite("G1", move);
        for(CommandParameter parameter : move.parameters){
            parameter.accept(this);
        }
        safeWrite("\n", move);
        return null;
    }

    @Override
    public Object visitJump(Jump jump) {
        safeWrite("G0", jump);
        for(CommandParameter parameter : jump.parameters){
            parameter.accept(this);
        }
        safeWrite("\n", jump);
        return null;
    }

    @Override
    public Object visitBlockDef(BlockDef blockDef) {
        //todo handle machine options

        symbolTable.openScope();
        List<ExplicitGCode> newBlockGCodes = blockChecker.enterBlock(blockDef);
        for(ExplicitGCode gCode : newBlockGCodes)
            gCode.accept(this);


        Object returnValue = null;
        for(Statement statement : blockDef.statements){
             returnValue = statement.accept(this);
            if(returnValue != null){
                break;
            }
        }

        List<ExplicitGCode> previousBlockGCodes = blockChecker.exitBlock();
        for(ExplicitGCode gCode : previousBlockGCodes)
            gCode.accept(this);

        symbolTable.leaveScope();
        return returnValue;
    }

    @Override
    public Object visitLoop(Loop loop) {
        double startValue = (double) loop.startExpression.accept(evaluator).getValue();
        double endValue = (double) loop.endExpression.accept(evaluator).getValue();

        symbolTable.enterSymbol(loop.identifier.identifier, GMMType.Num);

        while(startValue != endValue){
            Object returnValue = executeLoopBody(loop, startValue);
            if (returnValue != null) return returnValue;

            if(startValue < endValue)
                startValue++;
            else
                startValue--;
        }

        Object returnValue = executeLoopBody(loop, startValue);
        if (returnValue != null) return returnValue;

        return null;
    }

    private Object executeLoopBody(Loop loop, double startValue) {
        symbolTable.assignValue(loop.identifier.identifier, new NumValue(startValue));
        for (Statement statement : loop.statements) {
            Object returnValue = statement.accept(this);
            if (returnValue != null) {
                return returnValue;
            }
        }
        return null;
    }

    @Override
    public Object visitVectorComponentAssign(VectorComponentAssign vectorComponentAssign) {
        NumValue value = (NumValue) vectorComponentAssign.expression.accept(evaluator);
        String id = vectorComponentAssign.identifier.identifier;
        String component = vectorComponentAssign.component.identifier;

        TypeValuePair pair = symbolTable.retrieveSymbolWithValue(id);
        Vector vector = ((VectorValue)pair.getValue()).getValue();

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

        safeWrite(gcode+"\n", explicitGCode);

        return null;
    }

    @Override
    public Object visitVectorCommandParameter(VectorCommandParameter vectorCommandParameter) {
        Vector vec = ((VectorValue)vectorCommandParameter.vectorExpression.accept(evaluator)).getValue();
        safeWrite(String.format(" X%.4f Y%.4f Z%.4f", vec.getX(), vec.getY(), vec.getZ()).replace(',', '.'), vectorCommandParameter);
        return null;
    }

    private void safeWrite(String str, PositionedNode writingNode){
        if(annotateWithLineNumbers)
            str = str.replace("\n", "    (line "+ writingNode.lineNumber +")\n");

        try {
            writer.write(str);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
