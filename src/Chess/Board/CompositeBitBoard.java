package Chess.Board;

/**
 * Created by dwood on 08/01/2016.
 */
public class CompositeBitBoard extends BitBoard {
    /**
     * Calls update after constructing a regular BitBoard
     * @param board1
     * @param board2
     */
    public CompositeBitBoard(BitBoard board1, BitBoard board2) {

        update(board1, board2);
    }

    /**
     * Assigns occupied to result of bitwise OR on board1 and board2
     * @param board1
     * @param board2
     */
    public void update(BitBoard board1, BitBoard board2) {
        for (int i = 0; i < board1.getLength(); i++)
            board[i] = (byte) (board1.getRow(i) | board2.getRow(i));
    }
}
