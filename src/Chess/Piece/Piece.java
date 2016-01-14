package Chess.Piece;

import Chess.Board.Threat;
import Chess.Data.Colour;
import Chess.Data.Movement;

import java.util.ArrayList;

/**
 * Created by dwood on 21/12/2015.
 */
public abstract class Piece {

    // CONSTRUCTOR

    public Piece(Colour colour) {
        this.colour = colour;
    }
    // DATA

    public final Colour colour;

    // BEHAVIOUR

    /**
     * Validates move against piece-specific movement rules
     * <b>Note -- Pieces don't know about the board they're on
     * Therefore, call this method in addition to validating the state of the board</b>
     * @param move
     * @return
     */
    public abstract boolean validMove(Movement move);

    /**
     * Default false, overridden in Knight
     * @return always false
     */
    // Override in Knight
    public boolean canJump() {
        return false;
    }

    /**
     * @return "W"/"B" depending on colour, should prefix subclass overrides
     */
    @Override
    public String toString() {
        String pieceStr = (colour == Colour.BLACK) ? "B" : "W";

        return pieceStr;
    }
}
