package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Piece.Rook;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 07/01/2016.
 */
public class RookTest {

    Rook rook = new Rook(Colour.BLACK);

    @Test
    public void testValidMove() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(7, 4);

        assertTrue(rook.validMove(new Movement(oldPos, newPos)));
    }
    @Test
    public void testValidMove2() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(3, 1);

        assertTrue(rook.validMove(new Movement(oldPos, newPos)));
    }

    @Test
    public void testValidMoveFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(6, 3);

        assertFalse(rook.validMove(new Movement(oldPos, newPos)));
    }
}