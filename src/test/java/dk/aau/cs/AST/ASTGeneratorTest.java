package dk.aau.cs.AST;

import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ASTGeneratorTest {

	ASTGenerator astGenerator;

	@BeforeEach
	void setUp() {
		astGenerator = new ASTGenerator();
	}

	@AfterEach
	void tearDown() {
	}

	GMMParser getParser(CharStream cs) {
		GMMLexer lexer = new GMMLexer(cs);
		TokenStream ts = new BufferedTokenStream(lexer);
		return new GMMParser(ts);
	}

	@Test
	void visitProg_ContainsCorrectAmountOfNodes() {
		CharStream cs = CharStreams
				.fromString("num fac(num n) { return fac(n - 1) * n}" + "block[]{" + "fac(5)" + "num f = fac(5)" + "}");
		GMMParser parser = getParser(cs);

		Node progNode = astGenerator.visitProg(parser.prog());

		ArrayList<Node> children = new ArrayList<>(Arrays.asList(progNode.getChildren()));

		assertEquals(2, children.size());
	}

	@Test
	void visitProg_ContainsCorrectTypes() {
		CharStream cs = CharStreams
				.fromString("num fac(num n) { return fac(n - 1) * n}" + "block[]{" + "fac(5)" + "num f = fac(5)" + "}");
		GMMParser parser = getParser(cs);

		Node progNode = astGenerator.visitProg(parser.prog());

		ArrayList<Node> children = new ArrayList<>(Arrays.asList(progNode.getChildren()));

		assertTrue(children.get(0) instanceof FunctionDef &&
				children.get(1) instanceof BlockDef, "Expected children to be of type FunctionDef and BlockDef");
	}

	@Test
	void visitFunctionDef_CorrectAmountOfChildren() {
		CharStream cs = CharStreams.fromString("num fac(num n) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());

		assertEquals(4, functionDefNode.getChildren().length, "Expected function definition node to have 4 children");
	}

	@Test
	void visitFunctionDef_CorrectIdentifier() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());

		assertEquals("fac", functionDefNode.idNode.identifier, "Expected identifier to be 'fac'");
	}

	@Test
	void visitFunctionDef_AmountOfParameters() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());

		assertEquals(2, functionDefNode.parameters.size(),
				"Expected 2 parameters in function, but got " + functionDefNode.parameters.size());
	}

	@Test
	void visitFunctionDef_ReturnType() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());

		assertEquals(GMMType.Num, functionDefNode.returnType.type, "Expected return type to be Num");
	}

	@Test
	void visitFunctionDef_AmountOfStatements() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());

		assertEquals(1, functionDefNode.statements.size(), "Expected 1 statement in function");
	}

	@Test
	void visitBlockDef_AmountOfMachineOptions() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());

		assertEquals(2, blockDef.options.size(), "Expected 2 machine options in block definition");
	}

	@Test
	void visitBlockDef_BlockParameterIdentifier() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());

		assertEquals("bound_x", blockDef.options
				.get(1).identifier.identifier, "Expected 2 machine options in block definition");
	}

	@Test
	void visitBlockDef_AmountOfStatements() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());

		assertEquals(2, blockDef.statements.size(), "Expected 2 statements in block definition");
	}

	@Test
	void visitLoop_correctIdentifier(){
		CharStream cs = CharStreams.fromString("block[]{loop(x=2..3){}}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		Loop loop = (Loop) blockDef.statements.get(0);

		assertEquals("x", loop.identifier.identifier);
	}

	@Test
	void visitLoop_correctStartExpression(){
		CharStream cs = CharStreams.fromString("block[]{loop(x=2..3){}}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		Loop loop = (Loop) blockDef.statements.get(0);

		assertEquals("Num = 2.0", loop.startExpression.toString());
	}

	@Test
	void visitLoop_correctEndExpression(){
		CharStream cs = CharStreams.fromString("block[]{loop(x=2..3){}}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		Loop loop = (Loop) blockDef.statements.get(0);

		assertEquals("Num = 3.0", loop.endExpression.toString());
	}

	@Test
	void visitFormalParameter_identifier01() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());
		FormalParameter formalParameter = functionDefNode.parameters.get(0);

		assertEquals("n", formalParameter.identifier.identifier,
				"Expected first formal parameter to have identifier " + "'n'");
	}

	@Test
	void visitFormalParameter_identifier02() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());
		FormalParameter formalParameter = functionDefNode.parameters.get(1);

		assertEquals("v", formalParameter.identifier.identifier,
				"Expected second formal parameter to have identifier" + " 'v'");
	}

	@Test
	void visitFormalParameter_type01() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());
		FormalParameter formalParameter = functionDefNode.parameters.get(0);

		assertEquals(GMMType.Num, formalParameter.type.type, "Expected first formal parameter to be of type num");
	}

	@Test
	void visitFormalParameter_type02() {
		CharStream cs = CharStreams.fromString("num fac(num n, vector v) { return fac(n - 1) * n}");

		GMMParser parser = getParser(cs);
		FunctionDef functionDefNode = (FunctionDef) astGenerator.visitFunctionDef(parser.functionDef());
		FormalParameter formalParameter = functionDefNode.parameters.get(1);

		assertEquals(GMMType.Vector, formalParameter.type.type, "Expected second formal parameter to be of type vector");
	}

	@Test
	void visitMachineOption_identifier01() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		MachineOption machineOption = blockDef.options.get(0);

		assertEquals("tool", machineOption.identifier.identifier,
				"Expected first machine options to have identifier 'tool'");
	}

	@Test
	void visitMachineOption_identifier02() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		MachineOption machineOption = blockDef.options.get(1);

		assertEquals("bound_x", machineOption.identifier.identifier,
				"Expected second machine options to have identifier 'bound_x'");
	}

	@Test
	void visitMachineOption_valueOfExpression01() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		MachineOption machineOption = blockDef.options.get(0);
		String option = machineOption.option;

		assertEquals("0", option,
				"Expected value of first option to be 0");
	}

	@Test
	void visitMachineOption_valueOfExpression02() {
		CharStream cs = CharStreams.fromString("block[tool:0, bound_x:200]{ move X=2 Y=5 leftCircle X=5 R=2}");

		GMMParser parser = getParser(cs);
		BlockDef blockDef = (BlockDef) astGenerator.visitBlockDef(parser.blockDef());
		MachineOption machineOption = blockDef.options.get(1);
		String option = machineOption.option;

		assertEquals("200", option,
				"Expected value of second option to be 200");
	}


}