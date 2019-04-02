package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.BaseNode;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.Statement;

import java.util.ArrayList;

public class TypeChecker implements ASTVisitor{

    ArrayList<TypeTable> tables = new ArrayList<>();
    ArrayList<IDs> workingTable = new ArrayList<>();
    int scopelvl = 0;



    public TypeChecker(){}

    @Override
    public Object visitProgram(Program program) {
        for (BaseNode child: program.children) {
            child.accept(this);
            tables.add(new TypeTable(workingTable));
            workingTable.clear();
            scopelvl++;

        }
        return null;
    }

    @Override
    public Object visitFunctionDef(FunctionDef functionDef) {
        for (FormalParameter params : functionDef.parameters) {
            IDs newID = (IDs)params.accept(this);
            for (IDs id: workingTable) {
                if(id.id.equals(newID.id))
                    throw new RuntimeException("Id " + newID.id + " is already used within this scope");
            }
            workingTable.add(newID);
        }
        for (Statement S : functionDef.statements) {
            S.accept(this);

        }
        return workingTable;
    }

    @Override
    public Object visitBlockDef(BlockDef blockDef) {
        return null;
    }

    @Override
    public Object visitFormalParameter(FormalParameter formalParameter) {
        GMMType o = (GMMType) formalParameter.type.accept(this);
        String iden = (String) formalParameter.identifier.accept(this);

        IDs pair = new IDs(iden , o);

        return pair;
    }

    @Override
    public Object visitTypeNode(TypeNode typeNode) {
        return typeNode.type;
    }

    @Override
    public Object visitID(ID id) {
        return id.identifier;
    }

    @Override
    public Object visitMachineOption(MachineOption machineOption) {
        return null;
    }

    @Override
    public Object visitRelativeParameter(RelativeParameter relativeParameter) {
        return null;
    }

    @Override
    public Object visitDeclaration(Declaration declaration) {
        return null;
    }

    @Override
    public Object visitAssign(Assign assign) {
        for (IDs pair: workingTable) {
            if (pair.id.equals(assign.identifier)){
                GMMType right = (GMMType) assign.expression.accept(this);
                if (pair.type.equals(right)){
                    return pair.type;
                }
                throw new RuntimeException("Type error. Variable " + pair.id + " is type " + pair.type + " but right side expression is type " + right);
            }
        }
        throw new RuntimeException("Variable " + assign.identifier + " must be declared before used");
    }

    @Override
    public Object visitFunctionCall(FunctionCall functionCall) {
        return null;
    }

    @Override
    public Object visitIfNode(IfNode ifNode) {
        return null;
    }

    @Override
    public Object visitLeftCircle(LeftCircle leftCircle) {
        return null;
    }

    @Override
    public Object visitAbsoluteParameter(AbsoluteParameter absoluteParameter) {
        return null;
    }

    @Override
    public Object visitEquality(Equality equality) {
        GMMType left = (GMMType) equality.left.accept(this);
        GMMType right = (GMMType) equality.right.accept(this);
        if (left.equals(right)){
            return GMMType.Bool;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitInEquality(InEquality inEquality) {
        GMMType left = (GMMType) inEquality.left.accept(this);
        GMMType right = (GMMType) inEquality.right.accept(this);
        if (left.equals(right)){
            return GMMType.Bool;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitAnd(And and) {
        GMMType left = (GMMType) and.left.accept(this);
        GMMType right = (GMMType) and.right.accept(this);
        if (left.equals(GMMType.Bool) && right.equals(GMMType.Bool)){
            return GMMType.Bool;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitOr(Or or) {
        GMMType left = (GMMType) or.left.accept(this);
        GMMType right = (GMMType) or.right.accept(this);
        if (left.equals(GMMType.Bool) && right.equals(GMMType.Bool)){
            return GMMType.Bool;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitDivide(Divide divide) {
        GMMType left = (GMMType) divide.left.accept(this);
        GMMType right = (GMMType) divide.right.accept(this);
        if (left.equals(right)){
            return left;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitTimes(Times times) {
        GMMType left = (GMMType)times.left.accept(this);
        GMMType right = (GMMType)times.right.accept(this);
        if (left.equals(right)){
            return left;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitPlus(Plus plus) {
        GMMType left = (GMMType)plus.left.accept(this);
        GMMType right = (GMMType)plus.right.accept(this);
        if (left.equals(right)){
            return left;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitMinus(Minus minus) {
        GMMType left = (GMMType)minus.left.accept(this);
        GMMType right = (GMMType)minus.right.accept(this);
        if (left.equals(right)){
            return GMMType.Bool;
        }
        throw new RuntimeException("Incorrect type comparing " + left + " and " + right);
    }

    @Override
    public Object visitVariable(Variable variable) {
        String var = (String)variable.identifier.accept(this);
        for (IDs pair: workingTable) {
            if(var.equals(pair.id)){
                return pair.type;
            }
        }
        throw new RuntimeException("Variable " + variable.identifier + " must be declared before used");
    }

    @Override
    public Object visitLiteralBool(LiteralBool literalBool) {
        return literalBool.boolValue;
    }

    @Override
    public Object visitLiteralInt(LiteralInt literalInt) {
        return literalInt.value;
    }

    @Override
    public Object visitRightCircle(RightCircle rightCircle) {
        return null;
    }

    @Override
    public Object visitMove(Move move) {
        return null;
    }

}








