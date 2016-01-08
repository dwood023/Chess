package Chess.Data;

/**
 * Created by dwood on 07/01/2016.
 */
public class Capture extends Movement {

    public Capture(Position oldPos, Position newPos) {
        super(oldPos, newPos);
    }

    public Capture(Movement move) {
        super(move);
    }

    @Override
    public boolean isCapture() {
        return true;
    }
}
