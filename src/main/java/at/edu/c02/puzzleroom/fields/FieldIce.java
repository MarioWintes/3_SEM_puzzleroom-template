package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;
import at.edu.c02.puzzleroom.exceptions.PuzzleRoomException;

public class FieldIce extends BaseField{
    protected FieldIce(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    @Override
    public void initialize() throws PuzzleRoomException {
    }

    @Override
    public boolean enterField(Direction direction) {
        Field nextField = null;
        switch (direction) {
            case Up:
                nextField = gameBoard.getField(row - 1, col);
            case Down:
                nextField = gameBoard.getField(row + 1, col);
            case Left:
                nextField = gameBoard.getField(row, col - 1);
            case Right:
                nextField = gameBoard.getField(row, col + 1);
        }
        setPlayerPositionToField();
        if(nextField.enterField(direction)){
            return true;
        }
        gameBoard.getPlayer().walkStep();
        return false;
    }

    @Override
    public boolean leaveField(Direction direction) {
        return false;
    }
}
