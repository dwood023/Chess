package Chess.Board;

import Chess.Data.Movement;
import Chess.Data.Position;

/**
 * Created by dwood on 21/12/2015.
 */
public class BitBoard {

    // DATA
    protected byte[] board = new byte[8];

    // BEHAVIOUR

    /**
     * @param pos
     * @return true, if bit is zero at pos
     */
    public boolean isPositionEmpty(Position pos) {

        return (getBitAtPosition(pos.x) & board[pos.y]) == 0;
    }

    /**
     * Sets board bit to zero at row y, x bits along
     * only if bit is not already zero
     * @param pos
     */
    public void setPositionToZero(Position pos) {
        if (!isPositionEmpty(pos))
            board[pos.y] ^= getBitAtPosition(pos.x);
    }

    /**
     * Sets board bit to one at row y, x bits along
     * @param pos
     */
    public void setPositionToOne(Position pos) {

        board[pos.y] |= getBitAtPosition(pos.x);
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
            if (!isPositionEmpty(new Position(x, y)))
                return true;
            if (x != move.newP.x) x += xMove;
            if (y != move.newP.y) y += yMove;
        }
        return false;
    }

    /**
     * Prints each position in a grid layout in terms of 1's and 0's
     */
    public void print() {

        for (int y = 0; y < board.length; ++y) {
            if (y == 0) System.out.println("--------------------");
            for (int x = 0; x < board.length; ++x) {
                if (isPositionEmpty(new Position(x, y)))
                    System.out.print("  ");
                else
                    System.out.print("1 ");
            }
            System.out.println();
            if (y == board.length - 1) System.out.println("--------------------");
        }
    }

    /**
     * @param rowIndex byte to be set
     * @param val byte to set to
     */
    public void setRow(int rowIndex, byte val) {
        board[rowIndex] = val;
    }

    /**
     * @param rowIndex
     * @return a copy of the byte at rowIndex
     */
    public byte getRow(int rowIndex) {
        return board[rowIndex];
    }

    /**
     * @return y-length of board (should equal byte length)
     */
    public int getLength() {
        return board.length;
    }

    /**
     * Used for bit masking
     * @param x
     * @return a byte with only x bit set to 1
     */
    protected static byte getBitAtPosition(int x) {
        return (byte) (0b10000000 >>> x);
    }
}

