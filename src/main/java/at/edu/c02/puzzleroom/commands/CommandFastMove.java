package at.edu.c02.puzzleroom.commands;

import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.Player;
import at.edu.c02.puzzleroom.exceptions.*;

/**
 * This command allows the player to move up/down/left/right one step
 * Example usage: `move left`
 */
public class CommandFastMove implements Command {
    private final String[] directions;

    public CommandFastMove(String[] arguments) throws PuzzleRoomException {
        directions = arguments;
    }

    public void execute(GameBoard gameBoard) throws PuzzleRoomException {
        // The player handles all movement logic, we just parse the input and
        // call the correct function
        Player player = gameBoard.getPlayer();
        if(player == null) {
            throw new PuzzleRoomInvalidMoveException();
        }

        for (int i = 0; i < directions.length; i++) {

            String direction = directions[i];

            boolean success = switch(direction) {
                case "l" -> player.moveLeft();
                case "r" -> player.moveRight();
                case "u" -> player.moveUp();
                case "d" -> player.moveDown();
                default -> throw new PuzzleRoomInvalidArgumentsException();
            };

            if(!success) {
                throw new PuzzleRoomInvalidMoveException();
            }
        }
        CommandShow showCommand = new CommandShow();
        showCommand.execute(gameBoard);
    }
}
