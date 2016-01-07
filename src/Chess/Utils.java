package Chess;

import java.util.Scanner;

/**
 * Created by dwood on 21/12/2015.
 */
public class Utils {

    public static byte getBitAtPosition(int x) {
        return (byte) (0b10000000 >>> x);
    }

    public static Position getPositionInput() {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] coords = inStr.split(",", 2);
        return new Position(Integer.parseInt(coords[0]),Integer.parseInt(coords[1]));
    }
}
