package Chess.Board;

/**
 * Created by dwood on 08/01/2016.
 */
public class CompositeBoardData extends BoardData {
    /**
     * Calls update after constructing a regular BitBoard
     * @param board1
     * @param board2
     */
    public CompositeBoardData(BitBoard board1, BitBoard board2) {
        super(new BitBoard());

        update(board1, board2);
    }

    /**
     * Assigns occupied to result of bitwise OR on board1 and board2
     * @param board1
     * @param board2
     */
    public void update(BitBoard board1, BitBoard board2) {
        for (int i = 0; i < board1.getLength(); i++)
            occupied.setRow(i, (byte) (board1.getRow(i) | board2.getRow(i)));
    }
}
