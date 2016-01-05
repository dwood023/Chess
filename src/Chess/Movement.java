package Chess;

/**
 * Created by dwood on 22/12/2015.
 */
public class Movement {

    public final int oldX;
    public final int oldY;
    public final int newX;
    public final int newY;
    public final boolean isCapture;

    public Movement(Position oldPos, Position newPos, boolean isCapture) {
        this.oldX = oldPos.x;
        this.oldY = oldPos.y;
        this.newX = newPos.x;
        this.newY = newPos.y;
        this.isCapture = isCapture;
    }

    public boolean isStraightLine() {
        return oldY == newY ^ oldX == newX;
    }

    public boolean isDiagonalLine() {
        return getYDiff() == getXDiff();
    }

    public int getYDiff() {
        return Math.abs(newY - oldY);
    }

    public int getXDiff() {
        return Math.abs(newX - oldX);
    }

    public int getSignedYDiff() {
        return newY - oldY;
    }

    public int getSignedXDiff() {
        return newX - oldX;
    }

}
