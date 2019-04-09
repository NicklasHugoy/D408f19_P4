package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.ExpressionEvaluator.ExpressionEvaluatorVisitor;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.BlockDef;
import dk.aau.cs.AST.Nodes.ExplicitGCode;
import dk.aau.cs.AST.Nodes.Node;
import dk.aau.cs.AST.Nodes.Plus;
import dk.aau.cs.AST.TypeChecking.FunctionTable;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.SymbolTable;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class BlockDefCheckerTest {

	IFunctionTable functionTable;
	Node ast;

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
	void visitBlockDef() {
		CharStream cs = CharStreams.fromString("block[tool:2]{ num x = 2 + 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];
		SymbolTable symbolTable = new SymbolTable();

		symbolTable.openScope();
		BlockDefChecker blockDefChecker = new BlockDefChecker(symbolTable);
		blockDefChecker.enterBlock(blockDef);

		Logger.PrintLogs(System.out);
		ExplicitGCode explicitGCode = (ExplicitGCode) blockDef.statements.get(0);
		assertEquals("T2", explicitGCode.gcode);
	}
}