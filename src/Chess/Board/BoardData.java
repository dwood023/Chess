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

    public boolean hasPieceAt(Position pos) {

        return !occupied.isPositionEmpty(pos);

    }

    public boolean isBlocked(Movement move) {

        // Increments towards new x and y positions
        // Will be -1 for left/down, 1 for right/up or 0 for no movement on that axis
        int xMove = (move.getXDiff() == 0) ? 0 : move.getSignedXDiff() / move.getXDiff();
        int yMove = (move.getYDiff() == 0) ? 0 : move.getSignedYDiff() / move.getYDiff();

        // Is there anything in the way of the move?
        // This won't work if the movement isn't in a straight line of some kind
        // Only knights move this way though, and they shouldn't call this method
        for (int x = move.oldP.x + xMove, y = move.oldP.y + yMove; x != move.newP.x || y != move.newP.y; x += xMove, y += yMove)
            if (!occupied.isPositionEmpty(new Position(x, y)))
                return true;

        return false;
    }

    public void move(Movement move) {
        occupied.setPositionToOne(move.newP);
        occupied.setPositionToZero(move.oldP);
    }

    public void removeAtPosition(Position pos) {
        occupied.setPositionToZero(pos);
    }

    public BitBoard getBoard() {
        return occupied;
    }
}
