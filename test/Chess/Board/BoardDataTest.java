package Chess.Board;

import Chess.Data.Movement;
import Chess.Data.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 08/01/2016.
 */
public class BoardDataTest {

    BoardData data;
    Position piece = new Position(4, 4);
    Position blocking = new Position(5, 5);
    Position blocking2 = new Position(2, 4);
    Movement blockedMove = new Movement(piece, new Position(6, 6));
    Movement blockedMove2 = new Movement(piece, new Position(1, 4));
    Movement clearMove = new Movement(piece, new Position(3, 5));

    @Before
    public void setUp() {
        data = new BoardData(new BitBoard());
        data.occupied.setPositionToOne(piece);
        data.occupied.setPositionToOne(blocking);
        data.occupied.setPositionToOne(blocking2);
    }

    @After
    public void tearDown() {
        data = null;
    }

    @Test
    public void testHasPieceAt() throws Exception {
        assertTrue(data.hasPieceAt(piece));
    }

    @Test
    public void testIsBlocked() throws Exception {
        assertTrue(data.isBlocked(blockedMove));
        assertTrue(data.isBlocked(blockedMove2));
        assertFalse(data.isBlocked(clearMove));
    }

    @Test
    public void testMove() throws Exception {
        data.move(clearMove);
        assertFalse(data.occupied.isPositionEmpty(clearMove.newP));
    }

    @Test
    public void testRemoveAtPosition() throws Exception {

        assertFalse(data.occupied.isPositionEmpty(piece));
        data.removeAtPosition(piece);
        assertTrue(data.occupied.isPositionEmpty(piece));

    }
}