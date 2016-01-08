package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

/**
 * Created by dwood on 29/12/2015.
 */
public class Rook extends Piece {

    public Rook(Colour colour) {
        super(colour);
    }

    @Override
    public boolean validMove(Movement move) {
        return move.isStraightLine();
    }

    @Override
    public String toString() {
        return super.toString() + "R";
    }
}
