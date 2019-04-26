package dk.aau.cs.ErrorReporting;

import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class LoggerTest {

    private ErrorMessage errorMessage01 = new ErrorMessage("This is a Warning", WarningLevel.Warning);
    private ErrorMessage errorMessage02 = new ErrorMessage("This is a Error", WarningLevel.Error);
    private ErrorMessage errorMessage03 = new ErrorMessage("This is a Comment", WarningLevel.Comment);


    @Test
    public void logFlush(){
        Logger.flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        assertEquals(2, Logger.flush().size());
    }

    @Test
    public void logWarningLevel01(){
        Logger.flush();
        Logger.Log(errorMessage01);
        assertEquals(WarningLevel.Warning, Logger.GetWarningLevel());
        Logger.flush();
    }

    @Test
    public void logWarningLevel02(){
        Logger.flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
        Logger.flush();
    }

    @Test
    public void logWarningLevel03(){
        Logger.flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals(WarningLevel.Error, Logger.GetWarningLevel());
        Logger.flush();
    }

    @Test
    public void logWarningLevel04(){
        Logger.flush();
        assertEquals(WarningLevel.Comment, Logger.GetWarningLevel());
        Logger.flush();
    }

    @Test
    public void logMessageCount(){
        Logger.flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals(3, Logger.flush().size());
    }

    @Test
    public void logMessageContent(){
        Logger.flush();
        Logger.Log(errorMessage01);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage03);
        assertEquals("This is a Warning", Logger.flush().get(0).getMessage());
    }

    @Test
    void checkForError01(){
        Logger.flush();
        Logger.Log(errorMessage02);
        assertTrue(Logger.checkForError());
    }

    @Test
    void checkForError02(){
        Logger.flush();
        Logger.Log(errorMessage01);
        assertFalse(Logger.checkForError());
    }

    @Test
    void checkForError03(){
        Logger.flush();
        Logger.Log(errorMessage03);
        assertFalse(Logger.checkForError());
    }

    @Test
    void checkForError04(){
        Logger.flush();
        Logger.Log(errorMessage03);
        Logger.Log(errorMessage02);
        Logger.Log(errorMessage01);
        assertTrue(Logger.checkForError());
    }

    @Test
    void printLogs(){
        Logger.flush();
        Logger.Log(errorMessage01);
        ByteArrayOutputStream outContent = new ByteArrayOutputStream();
        System.setOut(new PrintStream(outContent));
        Logger.PrintLogs(new PrintStream(outContent));

        assertEquals("This is a Warning\r\n", outContent.toString());
    }

}