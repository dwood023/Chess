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

    public Movement(Movement move) {
        this.oldP = move.oldP;
        this.newP = move.newP;
    }

    /**
     * @return True, if either (not both) y pos or x pos are unchanged by movement
     */
    public boolean isStraightLine() {
        return oldP.y == newP.y ^ oldP.x == newP.x;
    }

    /**
     * @return True, if movement on x and y axis are proportional to each other
     */
    public boolean isDiagonalLine() {
        return getYDiff() == getXDiff();
    }

    /**
     * @return Absolute value of difference between old and new y pos
     */
    public int getYDiff() {
        return Math.abs(newP.y - oldP.y);
    }

    /**
     * @return Absolute value of difference between old and new x pos
     */
    public int getXDiff() {
        return Math.abs(newP.x - oldP.x);
    }

    /**
     * Reflects direction of y movement (positive for up, negative for down)
     * @return Non absolute value of difference between old and new y pos
     */
    public int getSignedYDiff() {
        return newP.y - oldP.y;
    }

    /**
     * Reflects direction of x movement (positive for up, negative for down)
     * @return Non absolute value of difference between old and new x pos
     */
    public int getSignedXDiff() {
        return newP.x - oldP.x;
    }

    /**
     * Movements can't capture, use Capture for that
     * @return always false
     */
    public boolean isCapture() {
        return false;
    }

}
