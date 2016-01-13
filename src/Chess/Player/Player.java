package Chess.Player;

import Chess.Board.BitBoard;
import Chess.Board.BoardData;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;

/**
 * Created by dwood on 07/01/2016.
 */
public abstract class Player {

    public Player(Colour colour, BitBoard occupied) {

        boardData = new BoardData(occupied);
        this.colour = colour;

    }

    public final Colour colour;

    public BoardData boardData;

    /**
     * @return new Movement
     */
    public abstract Movement getMove();

    /**
     * @param pos
     * @return True, if boardData.occupied is 1 at pos
     */
    public boolean hasPieceAt(Position pos) {

        return boardData.hasPieceAt(pos);
    }

    /**
     * @return String describing player in terms of their colour
     */
    @Override
    public String toString() {
        String playerStr = ((colour == Colour.BLACK) ? "Black" : "White") + " player";
        return playerStr;
    }

}
