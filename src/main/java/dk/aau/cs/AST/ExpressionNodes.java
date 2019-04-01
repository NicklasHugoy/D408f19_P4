package dk.aau.cs.AST;

public class Equality implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitEquality(this);
	}
}

public class InEquality implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitInEquality(this);
	}
}

public class And implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitAnd(this);
	}
}

public class Or implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitOr(this);
	}
}

public class Divide implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitDivide(this);
	}
}

public class Times implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitTimes(this);
	}
}

public class Plus implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitPlus(this);
	}
}

public class Minus implements Expression {

	public Expression left;
	public Expression right;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitMinus(this);
	}
}

public class Variable implements Expression{

	public ID identifier;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitVariable(this);
	}
}

public class LiteralBool implements Expression{

	public boolean boolValue;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitLeteralBool(this);
	}
}

public class LiteralInt implements Expression{

	public int value;

	@Override
	public <T> T accept(ASTVisitor<T> visitor) {
		return visitor.visitLiteralInt(this);
	}
}