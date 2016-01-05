package Chess;

/**
 * Created by dwood on 21/12/2015.
 */
public class Utils {

    public static int getBitAtPosition(int x) {
        return 0b10000000 >>> x;
    }
}
