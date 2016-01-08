package Chess.Piece;

import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Piece.Knight;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 06/01/2016.
 */
public class KnightTest {

    Knight knight = new Knight(Colour.BLACK);

    @Test
    public void testValidMove() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(5, 3);

        Movement move = new Movement(oldPos, newPos);

        assertTrue(knight.validMove(move));

    }

    @Test
    public void testValidMove2() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 2);

        Movement move = new Movement(oldPos, newPos);

        assertTrue(knight.validMove(move));
    }

    @Test
    public void testValidMove3() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 6);

        Movement move = new Movement(oldPos, newPos);

        assertTrue(knight.validMove(move));
    }

    @Test
    public void testValidMoveFalse() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 4);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(knight.validMove(move));
    }

    @Test
    public void testValidMoveFalse2() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(1, 7);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(knight.validMove(move));
    }
}