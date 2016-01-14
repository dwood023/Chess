package Chess.Board;

import Chess.Data.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 08/01/2016.
 */
public class CompositeBitBoardTest {

    CompositeBitBoard comp;
    Position board1Pos = new Position(4, 5);
    Position board2Pos = new Position(4, 4);
    Position board3Pos = new Position(4, 6);
    BitBoard board1 = new BitBoard();
    BitBoard board2 = new BitBoard();
    BitBoard board3 = new BitBoard();

    @After
    public void tearDown() throws Exception {
        comp = null;
    }

    @Before
    public void setUp() throws Exception {

        board1.setPositionToOne(board1Pos);
        board2.setPositionToOne(board2Pos);
        board3.setPositionToOne(board3Pos);

        comp = new CompositeBitBoard(board1, board2);

    }

    @Test
    public void testUpdate() throws Exception {

        assertFalse(comp.isPositionEmpty(board1Pos));
        assertFalse(comp.isPositionEmpty(board2Pos));

    }

    @Test
    public void testUpdate2() {

        comp.update(board1, board3);

        assertFalse(comp.isPositionEmpty(board1Pos));
        assertFalse(comp.isPositionEmpty(board3Pos));
    }
}