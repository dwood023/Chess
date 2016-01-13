package Chess.Board;

import Chess.Data.Colour;
import Chess.Piece.*;

/**
 * Created by dwood on 08/01/2016.
 */
public class Board {

    /**
     * Constructs a board with all pieces in their correct start positions
     */
    public Board() {

        for (int i = 0; i < 8; ++i) {
            board[i][1] = new Pawn(Colour.WHITE);
            board[i][6] = new Pawn(Colour.BLACK);
        }

        board[0][0] = new Rook(Colour.WHITE);
        board[1][0] = new Knight(Colour.WHITE);
        board[2][0] = new Bishop(Colour.WHITE);
        board[3][0] = new Queen(Colour.WHITE);
        board[4][0] = new King(Colour.WHITE);
        board[5][0] = new Bishop(Colour.WHITE);
        board[6][0] = new Knight(Colour.WHITE);
        board[7][0] = new Rook(Colour.WHITE);

        board[0][7] = new Rook(Colour.BLACK);
        board[1][7] = new Knight(Colour.BLACK);
        board[2][7] = new Bishop(Colour.BLACK);
        board[3][7] = new Queen(Colour.BLACK);
        board[4][7] = new King(Colour.BLACK);
        board[5][7] = new Bishop(Colour.BLACK);
        board[6][7] = new Knight(Colour.BLACK);
        board[7][7] = new Rook(Colour.BLACK);

    }

    public Piece[][] board = new Piece[8][8];

    /**
     * Prints board to console in numbered grid layout
     * Pieces are displayed according to their toString() method
     */
    public void print() {

        System.out.println("----------------------------------");
        System.out.print("    ");
        // Number the columns...
        for (int i = 0; i < 8; ++i)
            System.out.print(i + "   ");

        System.out.println();

        for (int y = 0; y < board.length; ++y) {
            // Number the rows...
            System.out.print(y + "   ");
            for (int x = 0; x < board.length; ++x) {

                if (board[x][y] != null)
                    System.out.print(board[x][y].toString());
                else
                    System.out.print("  ");

                System.out.print("  ");

            }
            System.out.println("\n");
        }
        System.out.println("----------------------------------");
    }

}
