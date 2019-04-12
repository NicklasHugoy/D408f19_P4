package dk.aau.cs.AST.TypeChecking;

import dk.aau.cs.AST.ExpressionEvaluator.NumValue;
import dk.aau.cs.AST.GMMType;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TypeValuePairTest {

    private TypeValuePair type;

    @BeforeEach
    void setUp(){
        NumValue value = new NumValue(0);
        type = new TypeValuePair(GMMType.Num, value);
    }

    @Test
    void getType(){
        assertEquals(GMMType.Num, type.getType());
    }

    @Test
    void setType01(){
        type.setType(GMMType.Bool);
        assertEquals(GMMType.Bool, type.getType());
    }

    @Test
    void setType02(){
        type.setType(GMMType.Vector);
        assertEquals(GMMType.Vector, type.getType());
    }

    @Test
    void setType03(){
        type.setType(GMMType.Void);
        assertEquals(GMMType.Void, type.getType());
    }

    @Test
    void getValue(){
        // Num in GMM is a float value with 4 decimals
        assertEquals(0.0000, type.getValue().getValue());
    }

    @Test
    void setValue01(){
        type.setValue(new NumValue(5));
        assertEquals(5.0000, type.getValue().getValue());
    }

    @Test
    void setValue02(){
        type.setValue(new NumValue(-5));
        assertEquals(-5.0000, type.getValue().getValue());
    }

    @Test
    void setValue03(){
        type.setValue(new NumValue(500000000));
        assertEquals(5.0E8, type.getValue().getValue());
    }
}
