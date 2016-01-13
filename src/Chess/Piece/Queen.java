package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class Queen extends Piece {

    public Queen(Colour colour) {
        super(colour);
    }

    /**
     * @param move
     * @return True, if move is diagonal or straight
     */
    @Override
    public boolean validMove(Movement move) {
        return (move.isStraightLine() || move.isDiagonalLine());
    }

    @Override
    public String toString() {
        return super.toString() + "Q";
    }
}
