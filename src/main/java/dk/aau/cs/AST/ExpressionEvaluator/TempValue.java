package dk.aau.cs.AST.ExpressionEvaluator;

public interface TempValue<T> {
	TempValue add(TempValue<T> other);
	TempValue minus(TempValue<T> other);
	TempValue divide(TempValue<T> other);
	TempValue times(TempValue<T> other);
	TempValue and(TempValue<T> rightValue);
	TempValue or(TempValue<T> rightValue);
	TempValue equal(TempValue<T> rightValue);
	TempValue inEqual(TempValue<T> rightValue);
	TempValue greaterThan(TempValue<T> rightValue);
	TempValue lessThan(TempValue<T> rightValue);
	TempValue negate();

	T getValue();
}

