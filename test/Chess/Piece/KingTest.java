package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Piece.King;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 07/01/2016.
 */
public class KingTest {

    King king = new King(Colour.BLACK);

    @Test
    public void testValidMove() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 3);

        assertTrue(king.validMove(new Movement(oldPos, newPos)));
    }

    @Test
    public void testValidMove2() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(2, 4);

        assertTrue(king.validMove(new Movement(oldPos, newPos)));
    }

    @Test
    public void testValidMoveFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(5, 4);

        assertFalse(king.validMove(new Movement(oldPos, newPos)));
    }
}