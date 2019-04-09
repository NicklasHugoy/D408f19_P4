package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;

public class ExpressionEvaluatorVisitor implements ASTVisitor<IValue> {

	private IFunctionTable functionTable;
	private ISymbolTable symbolTable;
	private ASTVisitor functionEvaluater;

	public ExpressionEvaluatorVisitor(IFunctionTable functionTable, ISymbolTable symbolTable, ASTVisitor functionEvaluater) {
		this.functionTable = functionTable;
		this.symbolTable = symbolTable;
		this.functionEvaluater = functionEvaluater;
	}

	public ExpressionEvaluatorVisitor(IFunctionTable functionTable, ISymbolTable symbolTable) {
		this.functionTable = functionTable;
		this.symbolTable = symbolTable;
	}

	@Override
	public IValue visitPlus(Plus plus) {
		IValue leftTypeValuePair = plus.left.accept(this);
		IValue rightTypeValuePair = plus.right.accept(this);

		return leftTypeValuePair.add(rightTypeValuePair);
	}

	@Override
	public IValue visitMinus(Minus minus) {
		IValue leftTypeValuePair = minus.left.accept(this);
		IValue rightTypeValuePair = minus.right.accept(this);

		return leftTypeValuePair.minus(rightTypeValuePair);
	}

	@Override
	public IValue visitTimes(Times times) {
		IValue leftValue = times.left.accept(this);
		IValue rightValue = times.right.accept(this);

		return leftValue.times(rightValue);
	}

	@Override
	public IValue visitDivide(Divide divide) {
		IValue leftValue = divide.left.accept(this);
		IValue rightValue = divide.right.accept(this);

		return leftValue.divide(rightValue);
	}

	@Override
	public IValue visitAnd(And and) {
		IValue leftValue = and.left.accept(this);
		IValue rightValue = and.right.accept(this);

		return leftValue.and(rightValue);
	}

	@Override
	public IValue visitOr(Or or) {
		IValue leftValue = or.left.accept(this);
		IValue rightValue = or.right.accept(this);

		return leftValue.or(rightValue);
	}

	@Override
	public IValue visitEquality(Equality equality) {
		IValue leftValue = equality.left.accept(this);
		IValue rightValue = equality.right.accept(this);

		return leftValue.equal(rightValue);
	}

	@Override
	public IValue visitInEquality(InEquality inEquality) {
		IValue leftValue = inEquality.left.accept(this);
		IValue rightValue = inEquality.right.accept(this);

		return leftValue.inEqual(rightValue);
	}

	@Override
	public IValue visitGreaterThan(GreaterThan greaterThan) {
		IValue leftValue = greaterThan.left.accept(this);
		IValue rightValue = greaterThan.right.accept(this);

		return leftValue.greaterThan(rightValue);
	}

	@Override
	public IValue visitLessThan(LessThan lessThan) {
		IValue leftValue = lessThan.left.accept(this);
		IValue rightValue = lessThan.right.accept(this);

		return leftValue.lessThan(rightValue);
	}

	@Override
	public IValue visitLiteralVector(LiteralVector literalVector) {

		NumValue x = (NumValue) literalVector.x.accept(this);
		NumValue y = (NumValue) literalVector.y.accept(this);
		NumValue z = (NumValue) literalVector.z.accept(this);

		return new VectorValue(new Vector(x.getValue(), y.getValue(), z.getValue()));
	}

	@Override
	public IValue visitNegate(Negate negate) {
		IValue value = negate.expression.accept(this);

		return value.negate();
	}

	@Override
	public IValue visitVariable(Variable variable) {
		return symbolTable.retrieveSymbolWithValue(variable.identifier.identifier).getValue();
	}

	@Override
	public IValue visitLiteralNumber(LiteralNumber literalNumber) {
		return new NumValue(literalNumber.value);
	}

	@Override
	public IValue visitLiteralBool(LiteralBool literalBool) {
		return new BoolValue(literalBool.boolValue);
	}

	@Override
	public IValue visitFunctionCall(FunctionCall functionCall) {
		return (IValue) functionCall.accept(functionEvaluater);
	}
}
