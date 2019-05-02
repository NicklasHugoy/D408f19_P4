package dk.aau.cs.BlockDefChecker;

import dk.aau.cs.AST.ASTGenerator;
import dk.aau.cs.AST.Nodes.*;
import dk.aau.cs.AST.TypeChecking.IFunctionTable;
import dk.aau.cs.ErrorReporting.ErrorMessage;
import dk.aau.cs.ErrorReporting.InvalidBlockParameter;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.Syntax.GMMLexer;
import dk.aau.cs.Syntax.GMMParser;
import org.antlr.v4.runtime.BufferedTokenStream;
import org.antlr.v4.runtime.CharStream;
import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.TokenStream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

class MachineOptionsGeneratorTest {

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

	@BeforeEach
	void beforeEach(){
		Logger.flush();
	}

	@Test
	void tool() {
		CharStream cs = CharStreams.fromString("block[tool:2]{ num x = 2 + 3 }");
		runCode(cs);
		BlockDef blockDef = (BlockDef) ast.getChildren()[0];

		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();
		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef).get(0);

		assertEquals("T2", explicitGCode.gcode);
	}

	@Test
	void positionMode_relative() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("G91", explicitGCode.gcode);
	}

	@Test
	void positionMode_absolute() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("positionMode"), "absolute"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("G90", explicitGCode.gcode);
	}

	@Test
	void unit_mm() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "mm"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("G21", explicitGCode.gcode);
	}

	@Test
	void unit_inch() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("G20", explicitGCode.gcode);
	}

	@Test
	void feedRate_number() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("speed"), "22"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("F22", explicitGCode.gcode);
	}

	@Test
	void feedRate_NaN() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("speed"), "abc"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.get(0) instanceof InvalidBlockParameter);
	}

	@Test
	void feedRate_mixed() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("speed"), "22d"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.get(0) instanceof InvalidBlockParameter);
	}

	@Test
	void spinrate_number(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("spinrate"), "123"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
		assertEquals("S123", explicitGCode.gcode);
	}

	@Test
	void spinrate_mixed(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("spinrate"), "2d"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.get(0) instanceof InvalidBlockParameter);
	}

	@Test
	void spinrate_NaN(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("spinrate"), "dsad"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.get(0) instanceof InvalidBlockParameter);
	}

	@Test
	void exitBlock_multipleOptionsFirst() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(0);

		assertEquals("G20", explicitGCode.gcode);
	}

	@Test
	void exitBlock_multipleOptionsSecond() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		ExplicitGCode explicitGCode = machineOptionsGenerator.enterBlock(blockDef1).get(1);

		assertEquals("G91", explicitGCode.gcode);
	}

	@Test
	void exitBlock_test01() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "mm"));
		}};
		List<MachineOption> options2 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDef blockDef2 = new BlockDef(options2, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef2);
		List<ExplicitGCode> gCodeArrayList = machineOptionsGenerator.exitBlock();

		assertEquals("G21", gCodeArrayList.get(0).gcode);
	}

	@Test
	void exitBlock_test02() {
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		List<MachineOption> options2 = new ArrayList<>(){{
			add(new MachineOption(new ID("unit"), "inch"));
		}};
		List<MachineOption> options3 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "2"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDef blockDef2 = new BlockDef(options2, new ArrayList<>());
		BlockDef blockDef3 = new BlockDef(options3, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef2);
		machineOptionsGenerator.enterBlock(blockDef3);
		List<ExplicitGCode> gCode = machineOptionsGenerator.exitBlock();

		assertEquals("T1" , gCode.get(0).gcode);
	}

	@Test
	void enterFirstBlockNoErrorTest(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionMode"), "relative"));
			add(new MachineOption(new ID("speed"), "200"));
			add(new MachineOption(new ID("spinrate"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
	}

	@Test
	void enterFirstBlockMissingParamTest(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionMode"), "relative"));
			add(new MachineOption(new ID("spinrate"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.get(0) instanceof InvalidBlockParameter);
	}

	@Test
	void onlyReturnsImportantBlockParameters(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionMode"), "absolute"));
			add(new MachineOption(new ID("speed"), "200"));
			add(new MachineOption(new ID("spinrate"), "30"));
		}};
		List<MachineOption> options2 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "2"));
			add(new MachineOption(new ID("unit"), "mm"));
		}};
		List<MachineOption> options3 = new ArrayList<>(){{
			add(new MachineOption(new ID("positionMode"), "relative"));
		}};
		List<MachineOption> options4 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "2"));
			add(new MachineOption(new ID("speed"), "500"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		BlockDef blockDef2 = new BlockDef(options2, new ArrayList<>());
		BlockDef blockDef3 = new BlockDef(options3, new ArrayList<>());
		BlockDef blockDef4 = new BlockDef(options4, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		List<ExplicitGCode> block1 = machineOptionsGenerator.enterBlock(blockDef1);
		assertEquals(5, block1.size());
		assertEquals("T1", block1.get(0).gcode);
		assertEquals("G21", block1.get(1).gcode);
		assertEquals("G90", block1.get(2).gcode);
		assertEquals("F200", block1.get(3).gcode);
		assertEquals("S30", block1.get(4).gcode);

		List<ExplicitGCode> block2 = machineOptionsGenerator.enterBlock(blockDef2);
		assertEquals(1, block2.size());
		assertEquals("T2", block2.get(0).gcode);

		List<ExplicitGCode> block3 = machineOptionsGenerator.enterBlock(blockDef3);
		assertEquals(1, block3.size());
		assertEquals("G91", block3.get(0).gcode);

		List<ExplicitGCode> exitBlock3 = machineOptionsGenerator.exitBlock();
		assertEquals(1, exitBlock3.size());
		assertEquals("G90", exitBlock3.get(0).gcode);

		List<ExplicitGCode> exitBlock2 = machineOptionsGenerator.exitBlock();
		assertEquals(1, exitBlock2.size());
		assertEquals("T1", exitBlock2.get(0).gcode);

		List<ExplicitGCode> block4 = machineOptionsGenerator.enterBlock(blockDef4);
		assertEquals(2, block4.size());
		assertEquals("T2", block4.get(0).gcode);
		assertEquals("F500", block4.get(1).gcode);

		List<ExplicitGCode> exitBlock4 = machineOptionsGenerator.exitBlock();
		assertEquals(2, exitBlock4.size());
		assertEquals("T1", exitBlock4.get(0).gcode);
		assertEquals("F200", exitBlock4.get(1).gcode);
	}

	@Test
	void testCaseSensitivityForMachineOptionName_DownCase(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionmode"), "relative"));
			add(new MachineOption(new ID("speed"), "200"));
			add(new MachineOption(new ID("spinrate"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
	}

	@Test
	void testCaseSensitivityForMachineOptionName_UpCase(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("TOOL"), "1"));
			add(new MachineOption(new ID("UNIT"), "mm"));
			add(new MachineOption(new ID("POSITIONMODE"), "relative"));
			add(new MachineOption(new ID("SPEED"), "200"));
			add(new MachineOption(new ID("SPINRATE"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
	}

	@Test
	void testCaseSensitivityForMachineOptionParameters_DownCase(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "mm"));
			add(new MachineOption(new ID("positionMode"), "relative"));
			add(new MachineOption(new ID("speed"), "200"));
			add(new MachineOption(new ID("spinrate"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
	}

	@Test
	void testCaseSensitivityForMachineOptionParameters_UpCase(){
		List<MachineOption> options1 = new ArrayList<>(){{
			add(new MachineOption(new ID("tool"), "1"));
			add(new MachineOption(new ID("unit"), "MM"));
			add(new MachineOption(new ID("positionMode"), "RELATIVE"));
			add(new MachineOption(new ID("speed"), "200"));
			add(new MachineOption(new ID("spinrate"), "300"));
		}};
		BlockDef blockDef1 = new BlockDef(options1, new ArrayList<>());
		MachineOptionsGenerator machineOptionsGenerator = new MachineOptionsGenerator();

		machineOptionsGenerator.enterFirstBlock(blockDef1);
		machineOptionsGenerator.enterBlock(blockDef1);
		List<ErrorMessage> errorMessages = Logger.flush();

		assertTrue(errorMessages.isEmpty());
	}
}