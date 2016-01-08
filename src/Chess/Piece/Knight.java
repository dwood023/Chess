package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

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

    @Override
    public boolean canJump() {
        return true;
    }

    @Override
    public String toString() {
        return super.toString() + "K";
    }
}
