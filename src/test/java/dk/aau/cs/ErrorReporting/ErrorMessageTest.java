package dk.aau.cs.ErrorReporting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ErrorMessageTest {


    @Test
    void getErrorMessage(){
        ErrorMessage em = new ErrorMessage("This is a comment", WarningLevel.Comment);
        assertEquals("This is a comment", em.getMessage());
    }

    @Test
    void getErrorLevel01(){
        ErrorMessage em = new ErrorMessage("This is a comment", WarningLevel.Comment);
        assertEquals(WarningLevel.Comment, em.getWarningLevel());
    }

    @Test
    void getErrorLevel02(){
        ErrorMessage em = new ErrorMessage("This is a warning", WarningLevel.Warning);
        assertEquals(WarningLevel.Warning, em.getWarningLevel());
    }

    @Test
    void getErrorLevel03(){
        ErrorMessage em = new ErrorMessage("This is an error", WarningLevel.Error);
        assertEquals(WarningLevel.Error, em.getWarningLevel());
    }
    
}
