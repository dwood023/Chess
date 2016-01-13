package Chess.Board;

import Chess.Data.Position;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.*;


/**
 * Created by dwood on 06/01/2016.
 */
public class BitBoardTest {

    @Test
    public void testIsPositionEmptyFalse() {

        BitBoard board = new BitBoard();

        for (int y = 0; y < board.board.length; ++y){
            for (int x = 0; x < board.board.length; ++x) {

                Position bitPos = new Position(x, y);

                board.board[y] = (byte) (0b10000000 >>> x);

                assertFalse(board.isPositionEmpty(bitPos));
            }
        }
    }

    @Test
    public void testIsPositionEmptyTrue() {

        BitBoard board = new BitBoard();

        for (int y = 0; y < board.board.length; ++y) {
            for (int x = 0; x < board.board.length; ++x) {

                Position emptyPos = new Position(x, y);

                assertTrue(board.isPositionEmpty(emptyPos));
            }
        }
    }

    @Test
    public void testSetPositionToZero() {

        BitBoard board = new BitBoard();

        Arrays.fill(board.board, (byte) 0b11111111);

        byte expected = (byte) 0b11101111;

        board.setPositionToZero(new Position(3, 4));

        assertEquals(expected, board.board[4]);

    }

    @Test
    public void testSetPositionToZero2() {

        BitBoard board = new BitBoard();
        Position pos = new Position(3,4);
        board.setPositionToZero(pos);

        assertTrue(board.isPositionEmpty(pos));
    }

    @Test
    public void testSetPositionToOne() {

        BitBoard board = new BitBoard();

        for (int y = 0; y < board.board.length; ++y)
            for (int x = 0; x < board.board.length; ++x) {

                byte expected = (byte) (0b10000000 >> x);

                board.setPositionToOne(new Position(x, y));

                assertEquals(expected, board.board[y]);

                // I shouldn't need to do this
                // Bit shifting on bytes shouldn't be this stupid
                board.board[y] = 0;

            }
    }

    @Test
    public void testGetBitAtPosition() throws Exception {

        for (int i = 0, expected = 128; i < 8; ++i, expected /= 2)
            assertEquals(expected, Math.abs(BitBoard.getBitAtPosition(i)));

    }
}
