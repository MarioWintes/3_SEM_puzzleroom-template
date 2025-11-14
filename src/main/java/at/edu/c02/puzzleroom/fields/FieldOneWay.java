package at.edu.c02.puzzleroom.fields;

import at.edu.c02.puzzleroom.Direction;
import at.edu.c02.puzzleroom.GameBoard;

/**
 * A path field. The player can freely walk onto this field, without any special effects.
 */
public class FieldOneWay extends BaseField {
    public FieldOneWay(GameBoard gameBoard, char name, int row, int col) {
        super(gameBoard, name, row, col);
    }

    public void initialize() {
    }



    public boolean enterField(Direction direction) {
        gameBoard.getPlayer().walkStep();
        setPlayerPositionToField();
        return true;
    }

    public boolean leaveField(Direction direction) {
        if (name == '<' && direction.equals(Direction.Left)) {
            return true;
        } else if (name == '>' && direction.equals(Direction.Right))  {
         return true;
        } else if (name == 'v' && direction.equals(Direction.Down))  {
         return true;
        } else if (name == '^' && direction.equals(Direction.Up))  {
            return true;
        }

        return false;

    }
}
