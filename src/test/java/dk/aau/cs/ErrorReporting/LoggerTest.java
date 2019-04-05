package dk.aau.cs.ErrorReporting;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    private ErrorMessage errorMessage01 = new ErrorMessage("This is a Warning", WarningLevel.Warning);
    private ErrorMessage errorMessage02 = new ErrorMessage("This is a Error", WarningLevel.Error);
    private ErrorMessage errorMessage03 = new ErrorMessage("This is a Comment", WarningLevel.Comment);


    @Test
    public void logFlush(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        assertEquals(2, Logger.Flush().size());
    }

    @Test
    public void logWarningLevel01(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        assertEquals(WarningLevel.Warning, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logWarningLevel02(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logWarningLevel03(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logWarningLevel04(){
        Logger.Flush();
        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logMessageCount(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals(3, Logger.Flush().size());
    }

    @Test
    public void logMessageContent(){
        Logger.Flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals("This is a Warning", Logger.Flush().get(0).getMessage());
    }

}