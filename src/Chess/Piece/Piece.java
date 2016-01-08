package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;

/**
 * Created by dwood on 21/12/2015.
 */
public abstract class Piece {

    // CONSTRUCTOR

    public Piece(Colour colour) {
        this.colour = colour;
    }
    // DATA

    private Colour colour;

    // BEHAVIOUR

    public abstract boolean validMove(Movement move);

    public Colour getColour() {
        return colour;
    }

    // Override in Knight
    public boolean canJump() {
        return false;
    }

    @Override
    public String toString() {
        String pieceStr = (getColour() == Colour.BLACK) ? "B" : "W";

        return pieceStr;
    }
}
