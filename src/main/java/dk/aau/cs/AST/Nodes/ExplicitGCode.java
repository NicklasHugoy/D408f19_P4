package dk.aau.cs.AST.Nodes;

import com.ibm.icu.impl.UnicodeRegex;
import dk.aau.cs.AST.ASTVisitor;
import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.TypeChecking.ISymbolTable;
import dk.aau.cs.AST.TypeChecking.TypeValuePair;
import dk.aau.cs.ErrorReporting.ErrorMessage;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.PositionedErrorMessage;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.net.Proxy;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExplicitGCode extends PositionedNode implements Statement {

    public String gcode;

    public ExplicitGCode(int lineNumber, int charNumber, String gcode) {
        super(lineNumber, charNumber);
        this.gcode = gcode;
    }

    public String fillReferences(ISymbolTable symbolTable){
        StringBuffer sb = new StringBuffer();
        Pattern pattern = Pattern.compile("((?:[{])[a-zA-Z0-9_]+(?:[}]))");
        Matcher matcher = pattern.matcher(gcode);

        for(int i = 0; matcher.find(); i++){
            String id = matcher.group().substring(1,matcher.group().length() -1 );
            TypeValuePair typeValuePair = symbolTable.retrieveSymbolWithValue(id);

            if(typeValuePair.getType() != GMMType.Num){
                Logger.Log(new PositionedErrorMessage("GCode variable references can only be of type Num", this, WarningLevel.Error));
                continue;
            }


            NumValue number = (NumValue) typeValuePair.getValue();

            if(number == null)
                continue;

            matcher.appendReplacement(sb, String.format("%.4f", number.getValue()).replace(',', '.'));
        }
        matcher.appendTail(sb);

        return sb.toString();
    }

    @Override
    public Node[] getChildren() {
        return new Node[0];
    }

    @Override
    public <T> T accept(ASTVisitor<T> visitor) {
        return visitor.visitExplicitGCode(this);
    }
}
