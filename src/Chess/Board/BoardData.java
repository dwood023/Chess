package Chess.Board;

import Chess.Data.Movement;
import Chess.Data.Position;

/**
 * Created by dwood on 08/01/2016.
 */
public class BoardData {

    public BoardData(BitBoard occupied) {
        this.occupied = occupied;
    }

    protected BitBoard occupied = new BitBoard();

    /**
     * @param pos
     * @return true, if occupied has a 1 at pos
     */
    public boolean hasPieceAt(Position pos) {

        return !occupied.isPositionEmpty(pos);

    }

    /**
     * Checks every square between move.oldPos and move.newPos
     * Will only work consistently if movement is either a straight or diagonal line
     * This is sufficient for standard chess pieces, as Knight shouldn't be subject to this method
     * @param move
     * @return true, if a position is 1 at any step in the movement
     */
    public boolean isBlocked(Movement move) {

        // Increments towards new x and y positions
        // Will be -1 for left/down, 1 for right/up or 0 for no movement on that axis
        int xMove = (move.getXDiff() == 0) ? 0 : move.getSignedXDiff() / move.getXDiff();
        int yMove = (move.getYDiff() == 0) ? 0 : move.getSignedYDiff() / move.getYDiff();

        for (int x = move.oldP.x + xMove, y = move.oldP.y + yMove; x != move.newP.x || y != move.newP.y;) {
            if (!occupied.isPositionEmpty(new Position(x, y)))
                return true;
            if (x != move.newP.x) x += xMove;
            if (y != move.newP.y) y += yMove;
        }


        return false;
    }

    /**
     * Sets move.oldPos to 0, move.newPos to 1
     * @param move
     */
    public void move(Movement move) {
        occupied.setPositionToOne(move.newP);
        occupied.setPositionToZero(move.oldP);
    }

    /**
     * Set pos to 0, called if a piece is taken
     * @param pos
     */
    public void removeAtPosition(Position pos) {
        occupied.setPositionToZero(pos);
    }

    /**
     * @return a copy of board
     */
    public BitBoard getBoard() {

        return occupied;
    }

    public void print() {
        occupied.print();
    }
}
