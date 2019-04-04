package dk.aau.cs.AST.TypeChecking;

import com.ibm.icu.impl.Pair;
import dk.aau.cs.AST.GMMType;

import java.util.ArrayList;
import java.util.List;

public class ScopeTable{
    List<Pair<String, GMMType>> symbols;

    public ScopeTable() {
        symbols = new ArrayList<>();
    }

    public GMMType Find(String id){
        for(Pair<String, GMMType> symbol : symbols){
            if(symbol.first.equals(id))
                return symbol.second;
        }
        return null;
    }

    public void Add(String id, GMMType type){
        symbols.add(Pair.of(id, type));
    }
}
