package com.kreitek.editor.commands;

import com.kreitek.editor.*;

import java.util.Stack;

public class CommandFactory {
    private static final CommandParser commandParser = new CommandParser();
    private Stack<Command> undoStack = new Stack<>();

    public Command getCommand(String commandLine) throws BadCommandException, ExitException {
        String[] args = commandParser.parse(commandLine);
        return switch (args[0]) {
            case "a" -> createAppendCommand(args[1]);
            case "u" -> createUpdateCommand(args[1], args[2]);
            case "d" -> createDeleteCommand(args[1]);
            case "undo" -> createUndoCommand();
            default -> throw new ExitException();
        };
    }

    private Command createUndoCommand() {
        if (undoStack.empty()) {
            System.out.println("No hay cambios para deshacer.");
            return null;
        }
        return undoStack.pop();
    }

    private Command createDeleteCommand(String lineNumber) {
        int number = Integer.parseInt(lineNumber);
        return new DeleteCommand(number);
    }

    private Command createUpdateCommand(String lineNumber, String text) {
        int number = Integer.parseInt(lineNumber);
        return new UpdateCommand(text, number);
    }

    private Command createAppendCommand(String text) {
        return new AppendCommand(text);
    }

}
