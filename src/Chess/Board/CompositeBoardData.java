package Chess.Board;

/**
 * Created by dwood on 08/01/2016.
 */
public class CompositeBoardData extends BoardData {
    public CompositeBoardData(BitBoard board1, BitBoard board2) {
        super(new BitBoard());

        update(board1, board2);
    }

    public void update(BitBoard board1, BitBoard board2) {
        for (int i = 0; i < board1.board.length; i++)
            occupied.board[i] = (byte) (board1.board[i] | board2.board[i]);
    }
}
