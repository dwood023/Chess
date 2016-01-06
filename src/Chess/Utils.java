package Chess;

/**
 * Created by dwood on 21/12/2015.
 */
public class Utils {

    public static byte getBitAtPosition(int x) {
        return (byte) (0b10000000 >>> x);
    }
}
