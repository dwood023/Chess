package Chess.Data;

import Chess.Data.Movement;
import Chess.Data.Position;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 06/01/2016.
 */
public class MovementTest {

    @Test
    public void testIsStraightLineUD() throws Exception {

        Position oldPos = new Position(3, 4);
        for (int y = 0; y < 8; ++y)
            if (y != oldPos.y) {
                Position newPos = new Position(oldPos.x, y);

                Movement moveUpDown = new Movement(oldPos, newPos);

                assertTrue(moveUpDown.isStraightLine());
            }
    }

    @Test
    public void testIsStraightLineLR() throws Exception {

        Position oldPos = new Position(3, 4);

        for (int x = 0; x < 8; ++x)
            if (x != oldPos.x) {
                Position newPos = new Position(x, oldPos.y);

                Movement moveLeftRight = new Movement(oldPos, newPos);

                assertTrue(moveLeftRight.isStraightLine());
            }
    }

    @Test
    public void testIsStraightLineFalse() {

        Position oldPos = new Position(3, 4);

        Position newPos = new Position(5, 5);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(move.isStraightLine());
    }

    @Test
    public void testIsDiagonalLineUL() throws Exception {

        Position oldPos = new Position(3, 4);

        for (int x = oldPos.x+1, y = oldPos.y+1; x < 8 && y < 8; ++x, ++y) {

            Position newPos = new Position(x, y);

            Movement move = new Movement(oldPos, newPos);

            assertTrue(move.isDiagonalLine());
        }

        for (int x = oldPos.x-1, y = oldPos.y-1; x >= 0 && y >= 0; --x, --y) {

            Position newPos = new Position(x, y);

            Movement move = new Movement(oldPos, newPos);

            assertTrue(move.isDiagonalLine());
        }
    }

    @Test
    public void testIsDiagonalLineDR() throws Exception {

        Position oldPos = new Position(3, 4);

        for (int x = oldPos.x+1, y = oldPos.y-1; x < 8 && y >= 0; ++x, --y) {

            Position newPos = new Position(x, y);

            Movement move = new Movement(oldPos, newPos);

            assertTrue(move.isDiagonalLine());
        }

        for (int x = oldPos.x-1, y = oldPos.y+1; x >= 0 && y < 8; --x, ++y) {

            Position newPos = new Position(x, y);

            Movement move = new Movement(oldPos, newPos);

            assertTrue(move.isDiagonalLine());
        }
    }

    @Test
    public void testIsDiagonalLineFalse() {

        Position oldPos = new Position(3, 4);

        Position newPos = new Position(5, 7);

        Movement move = new Movement(oldPos, newPos);

        assertFalse(move.isDiagonalLine());

    }

}