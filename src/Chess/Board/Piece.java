package Chess.Board;

import Chess.*;

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

}
