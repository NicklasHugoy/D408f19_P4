package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.ExpressionEvaluator.ExpressionEvaluatorVisitor;
import dk.aau.cs.AST.FunctionVisitor.FunctionVisitor;
import dk.aau.cs.AST.Nodes.*;
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

import java.util.ArrayList;
import java.util.List;

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
	}

	@Test
	void tool() {
		CharStream cs = CharStreams.fromString("block[tool:2]{ num x = 2 + 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];

		BlockDefChecker blockDefChecker = new BlockDefChecker();
		blockDefChecker.enterBlock(blockDef);

		ExplicitGCode explicitGCode = (ExplicitGCode) blockDef.statements.get(0);
		assertEquals("T2", explicitGCode.gcode);
	}

	@Test
	void positionMode_relative() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G91", ((ExplicitGCode)blockDef1.statements.get(0)).gcode);
	}

	@Test
	void positionMode_absolute() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("positionMode"), "absolute"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G90", ((ExplicitGCode)blockDef1.statements.get(0)).gcode);
	}

	@Test
	void unit_mm() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "mm"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G21", ((ExplicitGCode)blockDef1.statements.get(0)).gcode);
	}

	@Test
	void unit_inch() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G20", ((ExplicitGCode)blockDef1.statements.get(0)).gcode);
	}

	@Test
	void exitBlock_multipleOptionsFirst() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G91", ((ExplicitGCode)blockDef1.statements.get(0)).gcode);
	}

	@Test
	void exitBlock_multipleOptionsSecond() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);

		assertEquals("G20", ((ExplicitGCode)blockDef1.statements.get(1)).gcode);
	}

	@Test
	void test() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "mm"));
		}};
		List<MachineOption> options2 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDef blockDef2 = new BlockDef(options2, new ArrayList<>());
		BlockDefChecker blockDefChecker = new BlockDefChecker();

		blockDefChecker.enterBlock(blockDef1);
		blockDefChecker.enterBlock(blockDef2);
		List<ExplicitGCode> gCodeArrayList = blockDefChecker.exitBlock();

		assertEquals("G21", gCodeArrayList.get(0).gcode);
	}
}