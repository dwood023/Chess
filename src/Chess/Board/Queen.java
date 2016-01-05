package Chess.Board;

import Chess.Colour;
import Chess.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class Queen extends Piece {

    public Queen(Colour colour) {
        super(colour);
    }

    @Override
    public boolean validMove(Movement move) {
        return (move.isStraightLine() || move.isDiagonalLine());
    }
}
