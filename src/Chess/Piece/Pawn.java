package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

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

    /**
     * Used to store the start position of the piece, dependant on colour
     */
    private byte startRowIndex;
    /**
     * Used to store the allowed direction of movement, dependant on colour
     */
    private byte moveOffset;

    // BEHAVIOUR

    /**
     * Pawns can move:
     * <ul>
     *     <li>One square in moveOffset direction</li>
     *     <li>Two squares in moveOffset direction, if at startRowIndex</li>
     *     <li>One square in moveOffset direction and one square left/right, if move.isCapture()</li>
     * </ul>
     * @param move
     * @return True, if movement is one of the above patterns
     */
    @Override
    public boolean validMove(Movement move) {

        if (move.newP.y == (move.oldP.y + moveOffset)) {
            if (move.oldP.x == move.newP.x && !move.isCapture())
                return true;
            else if (move.isCapture() && (move.newP.x == move.oldP.x + 1 || move.newP.x == move.oldP.x - 1))
                return true;
        }

        return (!move.isCapture()
                && move.oldP.y == startRowIndex
                && move.getXDiff() == 0
                && move.newP.y == (move.oldP.y + (moveOffset * 2)));

    }

    @Override
    public String toString() {
        return super.toString() + "P";
    }
}
