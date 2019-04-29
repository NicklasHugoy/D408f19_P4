package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.IValue;
import dk.aau.cs.AST.GMMType;
import dk.aau.cs.ErrorReporting.Logger;
import dk.aau.cs.ErrorReporting.UndeclaredReferenceError;
import dk.aau.cs.Exceptions.WriteProtectedVariableException;

import java.util.LinkedList;

public class SymbolTable implements ISymbolTable {
	private LinkedList<ScopeTable> scopes;

	public SymbolTable() {
		scopes = new LinkedList<>();
	}

	@Override
	public GMMType retrieveSymbolInScope(String symbol) {
		SymbolTableEntry entry = scopes.getLast().find(symbol);
		if(entry != null){
			return scopes.getLast().find(symbol).getType();
		}
		return GMMType.Void;
	}

	@Override
	public GMMType retrieveSymbol(String symbol) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			SymbolTableEntry entry =  scopes.get(i).find(symbol);
			if (entry != null) return entry.getType();
			if (scopes.get(i).isIsolatedScope()) break;
		}

        Logger.Log(new UndeclaredReferenceError("Variable '" + symbol + "' has not been declared"));
        return GMMType.Void;
    }

	@Override
	public TypeValuePair retrieveSymbolWithValue(String symbol) {
		for (int i = scopes.size() - 1; i >= 0; i--) {
			SymbolTableEntry entry =  scopes.get(i).find(symbol);
			if (entry != null) {
				return new TypeValuePair(entry.getType(), entry.getValue());
			}
			if(scopes.get(i).isIsolatedScope()) break;
		}

		Logger.Log(new UndeclaredReferenceError("Variable '" + symbol + "' has not been declared"));
		return new TypeValuePair(GMMType.Void, null);
	}

	@Override
	public void enterSymbol(String symbol, GMMType type) {
		scopes.getLast().add(symbol, type, null, false);
	}

	@Override
	public void enterSymbol(String symbol, GMMType type, IValue value) {
		scopes.getLast().add(symbol, type, value, false);
	}

	@Override
	public void assignValue(String symbol, IValue value) {
		for(int i = scopes.size() - 1; i >= 0; i--){
			SymbolTableEntry entry = scopes.get(i).find(symbol);

			if(entry != null){
				if(entry.isWriteProtected()){
					throw new WriteProtectedVariableException("Can't assign to write protected variable " + symbol);
				}

				scopes.get(i).add(symbol, entry.getType(), value, false);
				return;
			}
			if(scopes.get(i).isIsolatedScope())
				return;
		}
	}

	@Override
	public void openScope() {
		scopes.add(new ScopeTable());
	}

	@Override
	public void isolateScope() {
		scopes.getLast().isolate();
	}

	@Override
	public void leaveScope() {
		scopes.removeLast();
	}

	@Override
	public void assignWriteProtectedValue(String symbol, IValue value) {
		for(int i = scopes.size() - 1; i >= 0; i--){
			SymbolTableEntry entry = scopes.get(i).find(symbol);
			if(entry != null){
				scopes.get(i).add(symbol, entry.getType(), value, true);
				return;
			}
			if(scopes.get(i).isIsolatedScope())
				return;
		}
	}

	@Override
	public void enterWriteProtectedSymbol(String symbol, GMMType type) {
		scopes.getLast().add(symbol, type, null, true);
	}
}