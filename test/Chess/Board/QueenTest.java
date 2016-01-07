package Chess.Board;

import Chess.Colour;
import Chess.Movement;
import Chess.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 07/01/2016.
 */
public class QueenTest {

    Queen queen = new Queen(Colour.BLACK);

    @Test
    public void testValidMove() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(7, 4);

        assertTrue(queen.validMove(new Movement(oldPos, newPos, false)));
    }
    @Test
    public void testValidMove2() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(0, 1);

        assertTrue(queen.validMove(new Movement(oldPos, newPos, false)));
    }

    @Test
    public void testValidMoveFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(6, 3);

        assertFalse(queen.validMove(new Movement(oldPos, newPos, false)));
    }
}