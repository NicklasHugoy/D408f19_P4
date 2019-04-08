package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.TypeValuePair;

public class ExpressionEvaluatorVisitor implements ASTVisitor<TempValue> {

	private IFunctionTable functionTable;
	private ISymbolTable symbolTable;

	public ExpressionEvaluatorVisitor(IFunctionTable functionTable, ISymbolTable symbolTable) {
		this.functionTable = functionTable;
		this.symbolTable = symbolTable;
	}

	@Override
	public TempValue visitPlus(Plus plus) {
		TempValue leftTypeValuePair = plus.left.accept(this);
		TempValue rightTypeValuePair = plus.right.accept(this);

		return leftTypeValuePair.add(rightTypeValuePair);
	}

	@Override
	public TempValue visitMinus(Minus minus) {
		TempValue leftTypeValuePair = minus.left.accept(this);
		TempValue rightTypeValuePair = minus.right.accept(this);

		return leftTypeValuePair.minus(rightTypeValuePair);
	}

	@Override
	public TempValue visitTimes(Times times) {
		TempValue leftValue = times.left.accept(this);
		TempValue rightValue = times.right.accept(this);

		return leftValue.times(rightValue);
	}

	@Override
	public TempValue visitAnd(And and) {
		TempValue leftValue = and.left.accept(this);
		TempValue rightValue = and.right.accept(this);

		return leftValue.and(rightValue);
	}

	@Override
	public TempValue visitOr(Or or) {
		TempValue leftValue = or.left.accept(this);
		TempValue rightValue = or.right.accept(this);

		return leftValue.or(rightValue);
	}

	@Override
	public TempValue visitEquality(Equality equality) {
		TempValue leftValue = equality.left.accept(this);
		TempValue rightValue = equality.right.accept(this);

		return leftValue.equal(rightValue);
	}

	@Override
	public TempValue visitInEquality(InEquality inEquality) {
		TempValue leftValue = inEquality.left.accept(this);
		TempValue rightValue = inEquality.right.accept(this);

		return leftValue.inEqual(rightValue);
	}

	@Override
	public TempValue visitGreaterThan(GreaterThan greaterThan) {
		TempValue leftValue = greaterThan.left.accept(this);
		TempValue rightValue = greaterThan.right.accept(this);

		return leftValue.greaterThan(rightValue);
	}

	@Override
	public TempValue visitLessThan(LessThan lessThan) {
		TempValue leftValue = lessThan.left.accept(this);
		TempValue rightValue = lessThan.right.accept(this);

		return leftValue.lessThan(rightValue);
	}

	@Override
	public TempValue visitLiteralVector(LiteralVector literalVector) {

		NumValue x = (NumValue) literalVector.x.accept(this);
		NumValue y = (NumValue) literalVector.y.accept(this);
		NumValue z = (NumValue) literalVector.z.accept(this);

		return new VectorValue(new Vector(x.getValue(), y.getValue(), z.getValue()));
	}

	@Override
	public TempValue visitNegate(Negate negate) {
		TempValue value = negate.expression.accept(this);

		return value.negate();
	}

	@Override
	public TempValue visitLiteralNumber(LiteralNumber literalNumber) {
		return new NumValue(literalNumber.value);
	}

	@Override
	public TempValue visitLiteralBool(LiteralBool literalBool) {
		return new BoolValue(literalBool.boolValue);
	}
}
