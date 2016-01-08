package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Piece.Bishop;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 07/01/2016.
 */
public class BishopTest {

    Bishop bishop = new Bishop(Colour.BLACK);

    @Test
    public void testValidMove() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(5, 6);

        assertTrue(bishop.validMove(new Movement(oldPos, newPos)));

    }

    @Test
    public void testValidMove2() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(1, 6);

        assertTrue(bishop.validMove(new Movement(oldPos, newPos)));

    }

    @Test
    public void testValidMoveFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(6, 6);

        assertFalse(bishop.validMove(new Movement(oldPos, newPos)));

    }
}