package Chess.Board;

import Chess.Colour;
import Chess.Movement;
import Chess.Position;
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

        Movement move = new Movement(oldPos, newPos, false);

        assertTrue(knight.validMove(move));

    }

    @Test
    public void testValidMove2() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 2);

        Movement move = new Movement(oldPos, newPos, false);

        assertTrue(knight.validMove(move));
    }

    @Test
    public void testValidMove3() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 6);

        Movement move = new Movement(oldPos, newPos, false);

        assertTrue(knight.validMove(move));
    }

    @Test
    public void testValidMoveFalse() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(4, 4);

        Movement move = new Movement(oldPos, newPos, false);

        assertFalse(knight.validMove(move));
    }

    @Test
    public void testValidMoveFalse2() {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(1, 7);

        Movement move = new Movement(oldPos, newPos, false);

        assertFalse(knight.validMove(move));
    }
}