package Chess.Board;

import Chess.Colour;
import Chess.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class Knight extends Piece {

    public Knight(Colour colour) {
        super(colour);
    }

    @Override
    public boolean validMove(Movement move) {
        return ((move.getXDiff() == 2 && move.getYDiff() == 1) || (move.getXDiff() == 1 && move.getYDiff() == 2));
    }
}
