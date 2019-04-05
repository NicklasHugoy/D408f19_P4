package dk.aau.cs.ErrorReporting;

import dk.aau.cs.AST.Nodes.PositionedNode;

public class PositionedErrorMessage extends ErrorMessage {
    private int lineNumber;
    private int charNumber;


    public PositionedErrorMessage(String message, PositionedNode node , WarningLevel level) {
        super(message, level);
        lineNumber = node.lineNumber;
        charNumber = node.charNumber;
    }

    @Override
    public String getMessage(){
       return lineNumber + ","+ charNumber + "  " + super.getMessage();
    }


}
