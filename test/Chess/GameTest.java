package Chess;

import Chess.Board.King;
import Chess.Board.Queen;
import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 06/01/2016.
 */
public class GameTest {

    Game game;

    @Before
    public void setUp() {
        game = new Game();
    }

    @After
    public void tearDown() {
        game = null;
    }

    @Test
    public void testValidMoveBlack() throws Exception {

        Position oldPos = new Position(3, 6);
        Position newPos = new Position(3, 5);

        assertTrue(game.validMove(Colour.BLACK, oldPos, newPos));

    }

    @Test
    public void testValidMoveWhite() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 2);

        assertTrue(game.validMove(Colour.WHITE, oldPos, newPos));

    }

    @Test
    public void testValidMoveKnight() {

        Position oldPos = new Position(1, 0);
        Position newPos = new Position(2, 2);

        assertTrue(game.validMove(Colour.WHITE, oldPos, newPos));

    }

    @Test
    public void testIsBlocked() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 7);

        Movement move = new Movement(oldPos, newPos, false);

        assertTrue(game.isBlocked(move));

    }

    @Test
    public void testIsBlockedFalse() throws Exception {

        Position oldPos = new Position(4, 3);
        Position newPos = new Position(4, 5);

        Movement move = new Movement(oldPos, newPos, false);

        assertFalse(game.isBlocked(move));

    }

    @Test
    public void testMove() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 3);

        game.move(oldPos, newPos);

        assertTrue(game.whiteOccupied.isPositionEmpty(oldPos));
        assertFalse(game.whiteOccupied.isPositionEmpty(newPos));
    }

    @Test
    public void testSyncBoards() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 3);

        game.move(oldPos, newPos);

        assertTrue(game.spacesOccupied.isPositionEmpty(oldPos));
        assertFalse(game.spacesOccupied.isPositionEmpty(newPos));
    }

}