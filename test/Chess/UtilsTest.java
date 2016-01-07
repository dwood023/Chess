package Chess;

import Chess.Utils;
import org.junit.Test;

import javax.rmi.CORBA.Util;

import static org.junit.Assert.*;

/**
 * Created by dwood on 21/12/2015.
 */
public class UtilsTest {

    @Test
    public void testGetBitAtPosition() throws Exception {

        for (int i = 0, expected = 128; i < 8; ++i, expected /= 2)
            assertEquals(expected, Math.abs(Utils.getBitAtPosition(i)));

    }
}