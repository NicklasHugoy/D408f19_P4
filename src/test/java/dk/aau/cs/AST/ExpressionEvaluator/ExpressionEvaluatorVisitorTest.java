package dk.aau.cs.AST.ExpressionEvaluator;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Node;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.FunctionTable;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.Exceptions.OperationNotSupportedException;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ExpressionEvaluatorVisitorTest {

	IFunctionTable functionTable;
	Node ast;

	@BeforeEach
	void setUp() {

	}

	void runCode(CharStream cs){
		//Scan and parse code
		GMMLexer lexer = new GMMLexer(cs);
		TokenStream ts = new BufferedTokenStream(lexer);
		GMMParser parser = new GMMParser(ts);

		//Convert parse tree to AST
		ASTGenerator astGenerator = new ASTGenerator();
		ast = parser.prog().accept(astGenerator);

		//Initialize function and symbol table
		functionTable = new FunctionTable();
		ISymbolTable symbolTable = new SymbolTable();

		//Cultivate the function table
		FunctionVisitor functionVisitor = new FunctionVisitor(functionTable);
		ast.accept(functionVisitor);
	}

	@Test
	void visitPlus_num(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 2 + 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Plus plus = (Plus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(5f, plus.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitPlus_bool(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = true + false }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Plus plus = (Plus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			plus.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitPlus_vector(){
		CharStream cs = CharStreams.fromString("block[]{ vector x = (1,2,3) + (3,4,5) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Plus plus = (Plus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		Vector actualVector = (Vector) plus.accept(expressionEvaluatorVisitor).getValue();
		Vector expectedVector = new Vector(4, 6, 8);
		assertEquals(expectedVector, actualVector);
	}

	@Test
	void visitMinus_num(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 4 - 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Minus minus = (Minus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(1f, minus.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitMinus_bool(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = true - false }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Minus minus = (Minus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			minus.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitTimes_num(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 4 * 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Times times = (Times) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(12f, times.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitTimes_bool(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = true * false }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Times times = (Times) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			times.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitTimes_vectors(){
		CharStream cs = CharStreams.fromString("block[]{ num x = (1,2,3) * (4,5,6) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Times times = (Times) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			times.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitAnd_num(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 2 && 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		And and = (And) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			and.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitAnd_bool(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = false && true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		And and = (And) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, and.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitAnd_vector(){
		CharStream cs = CharStreams.fromString("block[]{ vector x = (1,2,3) && (2,4,5) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		And and = (And) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			and.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitOr_num(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 3 || 0 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Or or = (Or) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			or.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitOr_bool(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = false || true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Or or = (Or) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, or.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitOr_vector(){
		CharStream cs = CharStreams.fromString("block[]{ vector x = (1,2,3) || (2,4,5) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Or or = (Or) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertThrows(OperationNotSupportedException.class, () -> {
			or.accept(expressionEvaluatorVisitor).getValue();
		});
	}

	@Test
	void visitEquality_numTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 3 == 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitEquality_numFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 2 == 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitEquality_boolTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = true == true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitEquality_boolFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = true == false }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitEquality_vectorTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = (1,2,3) == (1,2,3) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitEquality_vectorFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = (1,2,3) == (1,2,4) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Equality equality = (Equality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, equality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_numFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 3 != 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_numTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 3 != 4 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_boolFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = false != false }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_boolTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = false != true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_vectorFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = (1,2,3) != (1,2,3) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitInEquality_vectorTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = (3,2,3) != (1,2,3) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		InEquality inEquality = (InEquality) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, inEquality.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitGreaterThan_numTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 3 > 2 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		GreaterThan greaterThan = (GreaterThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, greaterThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitGreaterThan_numFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 2 > 5 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		GreaterThan greaterThan = (GreaterThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, greaterThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitGreaterThan_numFalseNegativeNum(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = -6 > -5 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		GreaterThan greaterThan = (GreaterThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, greaterThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitGreaterThan_numTrueNegativeNum(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = -4 > -7 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		GreaterThan greaterThan = (GreaterThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, greaterThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitGreaterThan_numTrueMixedNum(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 2 > -7 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		GreaterThan greaterThan = (GreaterThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, greaterThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitLessThan_numTrue(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 2 < 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		LessThan lessThan = (LessThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, lessThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitLessThan_numFalse(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = 5 < 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		LessThan lessThan = (LessThan) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, lessThan.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_numPositiveToNegative(){
		CharStream cs = CharStreams.fromString("block[]{ num x = -3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(-3f, negate.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_numDoubleNegate(){
		CharStream cs = CharStreams.fromString("block[]{ num x = --3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(3f, negate.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_boolNegate(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = -true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(false, negate.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_boolDoubleNegate(){
		CharStream cs = CharStreams.fromString("block[]{ bool x = --true }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(true, negate.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_vectorNegate(){
		CharStream cs = CharStreams.fromString("block[]{ vector x = -(1,2,3) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(new Vector(-1,-2,-3), negate.accept(expressionEvaluatorVisitor).getValue());
	}

	@Test
	void visitNegate_vectorDoubleNegate(){
		CharStream cs = CharStreams.fromString("block[]{ vector x = --(1,2,3) }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Negate negate = (Negate) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(new Vector(1,2,3), negate.accept(expressionEvaluatorVisitor).getValue());
	}


	@Test
	void visitVariable(){
		CharStream cs = CharStreams.fromString("block[]{ num x = 2 + y }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		Plus plus = (Plus) blockDef.statements.get(0).getChildren()[2];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		symbolTable.enterSymbol("y", GMMType.Num, new NumValue(5));
		ExpressionEvaluatorVisitor expressionEvaluatorVisitor = new ExpressionEvaluatorVisitor(functionTable, symbolTable);

		assertEquals(7f, plus.accept(expressionEvaluatorVisitor).getValue());
	}
}