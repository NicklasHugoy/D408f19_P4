package dk.aau.cs.AST;

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

import static org.junit.jupiter.api.Assertions.*;

class ASTGeneratorTest {

	@BeforeEach
	void setUp() {
	}

	@AfterEach
	void tearDown() {
	}

	GMMParser getParser(CharStream cs){
		GMMLexer lexer = new GMMLexer(cs);
		TokenStream ts = new BufferedTokenStream(lexer);
		return new GMMParser(ts);
	}

	@Test
	void visitProg(){
		CharStream cs = CharStreams.fromString(
				"num fac(num n) { return fac(n - 1) * n}" +
				"block[]{" +
				"fac(5)" +
				"num f = fac(5)" +
				"}");
		GMMParser parser = getParser(cs);

		ASTGenerator astGenerator = new ASTGenerator();
		Node node = astGenerator.visitProg(parser.prog());

		ArrayList<Node> children = new ArrayList<>(Arrays.asList(node.getChildren()));

		
	}

	@Test
	void visitPlusExpr() {

	}
}