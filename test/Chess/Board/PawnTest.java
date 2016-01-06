package Chess.Board;

import Chess.Colour;
import Chess.Movement;
import Chess.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 06/01/2016.
 */
public class PawnTest {

    Pawn blackPawn = new Pawn(Colour.BLACK);
    Pawn whitePawn = new Pawn(Colour.WHITE);

    @Test
    public void testValidMoveBlack() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(3, 3);

        assertTrue(blackPawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveWhite() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(3, 5);

        assertTrue(whitePawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveBlackFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(3, 5);

        assertFalse(blackPawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveWhiteFalse() throws Exception {

        Position oldPos = new Position(3, 4);
        Position newPos = new Position(3, 3);

        assertFalse(whitePawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveWhiteDouble() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 3);

        assertTrue(whitePawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveBlackDouble() throws Exception {

        Position oldPos = new Position(3, 6);
        Position newPos = new Position(3, 4);

        assertTrue(blackPawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveBlackDoubleFalse() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 3);

        assertFalse(blackPawn.validMove(new Movement(oldPos, newPos, false)));

    }

    @Test
    public void testValidMoveWhiteDoubleFalse() throws Exception {

        Position oldPos = new Position(3, 6);
        Position newPos = new Position(3, 4);

        assertFalse(whitePawn.validMove(new Movement(oldPos, newPos, false)));

    }
}