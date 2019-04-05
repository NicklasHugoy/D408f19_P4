package dk.aau.cs.AST.TypeChecking;

import com.ibm.icu.impl.Pair;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.AST.Value;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.UndeclaredReferenceError;
import dk.aau.cs.ErrorReporting.WarningLevel;

import java.util.LinkedList;

public class SymbolTable implements ISymbolTable {
	private LinkedList<ScopeTable> scopes;

	public SymbolTable() {
		scopes = new LinkedList<>();
	}

	@Override
	public GMMType retrieveSymbolInScope(String symbol) {
		TypeValuePair typeValuePair = scopes.getLast().Find(symbol);
		if(typeValuePair != null){
			return scopes.getLast().Find(symbol).getType();
		}
		return null;
	}

	@Override
	public GMMType retrieveSymbol(String symbol) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			TypeValuePair typeValuePair =  scopes.get(i).Find(symbol);
			if (typeValuePair != null) return typeValuePair.getType();
		}

        Logger.Log(new UndeclaredReferenceError("Variable '" + symbol + "' has not been declared"));
        return GMMType.Void;
    }

	@Override
	public TypeValuePair retrieveSymbolWithValue(String symbol) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			TypeValuePair typeValuePair =  scopes.get(i).Find(symbol);
			if (typeValuePair != null) return typeValuePair;
		}

		Logger.Log("Variable '" + symbol + "' has not been declared", WarningLevel.Error);
		return new TypeValuePair(GMMType.Void, null);
	}

	@Override
	public void enterSymbol(String symbol, GMMType type) {
		scopes.getLast().Add(symbol, type);
	}

	@Override
	public void enterSymbol(String symbol, GMMType type, Value value) {
		scopes.getLast().Add(symbol, type, value);
	}

	@Override
	public void openScope() {
		scopes.add(new ScopeTable());
	}

	@Override
	public void leaveScope() {
		scopes.removeLast();
	}
}