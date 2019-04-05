package dk.aau.cs.ErrorReporting;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class Logger {
    private static List<ErrorMessage> messages = new ArrayList<>();
    private static WarningLevel currentLevel = WarningLevel.Comment;

    public static void Log(ErrorMessage errorMessage){
        if(errorMessage.getWarningLevel().ordinal() > currentLevel.ordinal())
            currentLevel = errorMessage.getWarningLevel();

        messages.add(errorMessage);
    }

    public static WarningLevel GetWarningLevel(){
        return currentLevel;
    }

    public static void PrintLogs(PrintStream stream, WarningLevel minimumWarningLevel){
        for(ErrorMessage message : messages){
            if(minimumWarningLevel.ordinal() <= message.getWarningLevel().ordinal())
                stream.println(message.getMessage());
        }
    }

    public static void PrintLogs(PrintStream stream){
        PrintLogs(stream, WarningLevel.Comment);
    }

    public static List<ErrorMessage> Flush(){
        currentLevel = WarningLevel.Comment;
        List<ErrorMessage> oldMessages = messages;
        messages = new ArrayList<>();
        return oldMessages;
    }

    public static boolean checkForError(){
        for(ErrorMessage message : messages)
        {
            if(message.getWarningLevel() == WarningLevel.Error)
                return true;
        }
        return false;
    }
}
