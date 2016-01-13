package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class King extends Piece {

    public King(Colour colour) {
        super(colour);
    }

    /**
     * @param move
     * @return True, if new position is less than two squares away
     */
    @Override
    public boolean validMove(Movement move) {
        return move.getXDiff() < 2 && move.getYDiff() < 2;
    }

    @Override
    public String toString() {
        return super.toString() + "$";
    }
}
