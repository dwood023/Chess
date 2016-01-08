package Chess.Data;

/**
 * Created by dwood on 22/12/2015.
 */
public class Movement {

    public final Position oldP;
    public final Position newP;

    public Movement(Position oldPos, Position newPos) {
        this.oldP = oldPos;
        this.newP = newPos;
    }

    // Copy constructor
    public Movement(Movement move) {
        this.oldP = move.oldP;
        this.newP = move.newP;
    }

    public boolean isStraightLine() {
        return oldP.y == newP.y ^ oldP.x == newP.x;
    }

    public boolean isDiagonalLine() {
        return getYDiff() == getXDiff();
    }

    public int getYDiff() {
        return Math.abs(newP.y - oldP.y);
    }

    public int getXDiff() {
        return Math.abs(newP.x - oldP.x);
    }

    public int getSignedYDiff() {
        return newP.y - oldP.y;
    }

    public int getSignedXDiff() {
        return newP.x - oldP.x;
    }

    public boolean isCapture() {
        return false;
    }

}
