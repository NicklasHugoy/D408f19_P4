package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.FunctionVisitor.FunctionEntry;
import dk.aau.cs.ErrorReporting.ErrorMessage;
import dk.aau.cs.ErrorReporting.WarningLevel;
import dk.aau.cs.ErrorReporting.Logger;
import java.util.ArrayList;
import java.util.List;

public class FunctionTable implements IFunctionTable {

    private List<FunctionEntry> functions;

    public FunctionTable() {
        functions = new ArrayList<>();
    }

    @Override
    public FunctionEntry retrieveFunction(String identifier) {
        for(FunctionEntry entry : functions){
            if(entry.getId().equals(identifier))
                return entry;
        }

        Logger.Log(new ErrorMessage("No function signature could be found matching "+identifier, WarningLevel.Error));
        return null;
    }

    @Override
    public void enterFunction(FunctionEntry entry) {
        functions.add(entry);
    }

    @Override
    public List<FunctionEntry> retrieveFunctions() {
        return new ArrayList<>(functions);
    }

    @Override
    public boolean functionExists(String identifier) {
        for(FunctionEntry entry : functions){
            if(entry.getId().equals(identifier))
                return true;
        }

        return false;
    }
}
