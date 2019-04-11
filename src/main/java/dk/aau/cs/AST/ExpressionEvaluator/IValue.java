package dk.aau.cs.AST.ExpressionEvaluator;

public interface IValue<T> {
	IValue add(IValue<T> other);
	IValue minus(IValue<T> other);
	IValue divide(IValue<T> other);
	IValue times(IValue<T> other);
	IValue and(IValue<T> rightValue);
	IValue or(IValue<T> rightValue);
	IValue equal(IValue<T> rightValue);
	IValue inEqual(IValue<T> rightValue);
	IValue greaterThan(IValue<T> rightValue);
	IValue lessThan(IValue<T> rightValue);
	IValue sqrt();
	IValue negate();

	T getValue();
}

