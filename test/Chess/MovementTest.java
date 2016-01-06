package Chess;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by dwood on 06/01/2016.
 */
public class MovementTest {

    @Test
    public void testIsStraightLineUD() throws Exception {

        for (int oldY = 0; oldY < 8; ++oldY) {
            for (int oldX = 0; oldX < 8; ++oldX) {

                Position oldPos = new Position(oldX, oldY);

                for (int y = 0; y < 8; ++y) {

                    if (y != oldPos.y) {
                        Position newPos = new Position(oldPos.x, y);

                        Movement moveUpDown = new Movement(oldPos, newPos, false);

                        assertTrue(moveUpDown.isStraightLine());
                    }
                }
            }
        }
    }

    @Test
    public void testIsStraightLineLR() throws Exception {

        for (int oldY = 0; oldY < 8; ++oldY) {
            for (int oldX = 0; oldX < 8; ++oldX) {

                Position oldPos = new Position(oldX, oldY);

                for (int x = 0; x < 8; ++x) {

                    if (x != oldPos.x) {
                        Position newPos = new Position(x, oldPos.y);

                        Movement moveLeftRight = new Movement(oldPos, newPos, false);

                        assertTrue(moveLeftRight.isStraightLine());
                    }
                }
            }
        }
    }

    @Test
    public void testIsDiagonalLineUL() throws Exception {

        for (int oldY = 0; oldY < 8; ++oldY) {
            for (int oldX = 0; oldX < 8; ++oldX) {
                Position oldPos = new Position(oldX, oldY);

                for (int x = oldX+1, y = oldY+1; x < 8 && y < 8; ++x, ++y) {

                    Position newPos = new Position(x, y);

                    Movement move = new Movement(oldPos, newPos, false);

                    assertTrue(move.isDiagonalLine());
                }

                for (int x = oldX-1, y = oldY-1; x >= 0 && y >= 0; --x, --y) {

                    Position newPos = new Position(x, y);

                    Movement move = new Movement(oldPos, newPos, false);

                    assertTrue(move.isDiagonalLine());
                }
            }
        }
    }

    @Test
    public void testIsDiagonalLineDR() throws Exception {

        for (int oldY = 0; oldY < 8; ++oldY) {
            for (int oldX = 0; oldX < 8; ++oldX) {
                Position oldPos = new Position(oldX, oldY);

                for (int x = oldX+1, y = oldY-1; x < 8 && y >= 0; ++x, --y) {

                    Position newPos = new Position(x, y);

                    Movement move = new Movement(oldPos, newPos, false);

                    assertTrue(move.isDiagonalLine());
                }

                for (int x = oldX-1, y = oldY+1; x >= 0 && y < 8; --x, ++y) {

                    Position newPos = new Position(x, y);

                    Movement move = new Movement(oldPos, newPos, false);

                    assertTrue(move.isDiagonalLine());
                }
            }
        }
    }


}