package dk.aau.cs.AST.ExpressionEvaluator;

public interface TempValue<T> {
	TempValue add(TempValue<T> other);
	TempValue minus(TempValue<T> other);
	TempValue divide(TempValue<T> other);
	TempValue multiply(TempValue<T> other);
	T getValue();
}
