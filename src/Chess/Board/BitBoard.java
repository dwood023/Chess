package Chess.Board;

import Chess.Position;
import Chess.Utils;

/**
 * Created by dwood on 21/12/2015.
 */
public class BitBoard {

    // DATA
    public byte[] board = new byte[8];

    // BEHAVIOUR

    public boolean isPositionEmpty(Position pos) {

        return (Utils.getBitAtPosition(pos.x) & board[pos.y]) == 0;
    }

    public void setPositionToZero(Position pos) {

        board[pos.y] ^= Utils.getBitAtPosition(pos.x);
    }

    public void setPositionToOne(Position pos) {

        board[pos.y] |= Utils.getBitAtPosition(pos.x);
    }

}

