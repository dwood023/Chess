package Chess;

import Chess.Data.Movement;
import Chess.Data.Position;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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

        Movement move = new Movement(oldPos, newPos);

        assertTrue(game.validMove(game.blackPlayer, move));

    }

    @Test
    public void testValidMoveWhite() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 2);

        Movement move = new Movement(oldPos, newPos);

        assertTrue(game.validMove(game.whitePlayer, move));

    }

    @Test
    public void testValidMoveKnight() {

        Position oldPos = new Position(1, 0);
        Position newPos = new Position(2, 2);

        Movement move = new Movement(oldPos, newPos);

        assertTrue(game.validMove(game.whitePlayer, move));

    }

    @Test
    public void testValidMoveObstructed() {

        Position oldPos = new Position(2, 0);
        Position newPos = new Position(4, 2);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(game.validMove(game.whitePlayer, move));

    }

    @Test
    public void testValidMoveWrongColour() {

        Position oldPos = new Position(6, 0);
        Position newPos = new Position(5, 2);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(game.validMove(game.blackPlayer, move));

    }

    @Test
    public void testMove() throws Exception {

        Position oldPos = new Position(3, 1);
        Position newPos = new Position(3, 6);

        Movement move = new Movement(oldPos, newPos);

        game.move(game.whitePlayer, move);

        assertFalse(game.whitePlayer.hasPieceAt(oldPos));
        assertTrue(game.whitePlayer.hasPieceAt(newPos));
        assertFalse(game.blackPlayer.hasPieceAt(newPos));
    }
}
