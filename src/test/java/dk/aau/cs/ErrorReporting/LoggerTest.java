package dk.aau.cs.ErrorReporting;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    @Test
    public void logFlush(){
        Logger.Flush();
        Logger.Log("This is a Warning", WarningLevel.Warning);
        Logger.Log("This is a Error", WarningLevel.Error);
        assertEquals(2, Logger.Flush().size());
    }

    @Test
    public void logWarningLevel01(){
        Logger.Flush();
        Logger.Log("This is a Warning", WarningLevel.Warning);
        assertEquals(WarningLevel.Warning, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logWarningLevel02(){
        Logger.Flush();
        Logger.Log("This is a Warning", WarningLevel.Warning);
        Logger.Log("This is a Error", WarningLevel.Error);
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
        Logger.Flush();
    }

    @Test
    public void logWarningLevel03(){
        Logger.Flush();
        Logger.Log("This is a Warning", WarningLevel.Warning);
        Logger.Log("This is a Error", WarningLevel.Error);
        Logger.Log("This is a Comment", WarningLevel.Comment);
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
        Logger.Log("This is a Warning", WarningLevel.Warning);
        Logger.Log("This is a Error", WarningLevel.Error);
        Logger.Log("This is a Comment", WarningLevel.Comment);
        assertEquals(3, Logger.Flush().size());
    }

    @Test
    public void logMessageContent(){
        Logger.Flush();
        Logger.Log("This is a Warning", WarningLevel.Warning);
        Logger.Log("This is a Error", WarningLevel.Error);
        Logger.Log("This is a Comment", WarningLevel.Comment);
        assertEquals("This is a Warning", Logger.Flush().get(0).getMessage());
    }

}