package Chess.Board;

import Chess.Colour;
import Chess.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class King extends Piece {

    public King(Colour colour) {
        super(colour);
    }

    @Override
    public boolean validMove(Movement move) {
        return (Math.abs(move.oldX - move.newX) < 2 && Math.abs(move.oldY - move.newY) < 2);
    }
}
