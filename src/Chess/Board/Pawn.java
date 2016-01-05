package Chess.Board;

import Chess.Colour;
import Chess.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class Pawn extends Piece {

    // CONSTRUCTOR
    public Pawn(Colour colour) {

        super(colour);

        if (colour == Colour.WHITE) {
            startRowIndex = 1;
            moveOffset = 1;
        }
        else {
            startRowIndex = 6;
            moveOffset = -1;
        }
    }

    // DATA

    private byte startRowIndex;
    private byte moveOffset;

    // BEHAVIOUR

    @Override
    public boolean validMove(Movement move) {

        if (move.newY == (move.oldY + moveOffset)) {
            if (move.oldX == move.newX && !move.isCapture)
                return true;
            else if (move.isCapture && (move.newX == move.oldX + 1 || move.newX == move.oldX - 1))
                return true;
        }

        return (!move.isCapture
                && move.oldY == startRowIndex
                && move.newY == (move.oldY + (moveOffset * 2)));

    }
}
