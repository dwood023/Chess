package Chess;

import Chess.Board.*;

import java.util.Scanner;

/**
 * Created by dwood on 21/12/2015.
 */
public class Game {

    public Game() {
        for (int i = 0; i < 8; ++i) {
            masterBoard[i][1] = new Pawn(Colour.WHITE);
            masterBoard[i][6] = new Pawn(Colour.BLACK);
        }

        masterBoard[0][0] = new Rook(Colour.WHITE);
        masterBoard[1][0] = new Knight(Colour.WHITE);
        masterBoard[2][0] = new Bishop(Colour.WHITE);
        masterBoard[3][0] = new Queen(Colour.WHITE);
        masterBoard[4][0] = new King(Colour.WHITE);
        masterBoard[5][0] = new Bishop(Colour.WHITE);
        masterBoard[6][0] = new Knight(Colour.WHITE);
        masterBoard[7][0] = new Rook(Colour.WHITE);

        masterBoard[0][7] = new Rook(Colour.BLACK);
        masterBoard[1][7] = new Knight(Colour.BLACK);
        masterBoard[2][7] = new Bishop(Colour.BLACK);
        masterBoard[3][7] = new Queen(Colour.BLACK);
        masterBoard[4][7] = new King(Colour.BLACK);
        masterBoard[5][7] = new Bishop(Colour.BLACK);
        masterBoard[6][7] = new Knight(Colour.BLACK);
        masterBoard[7][7] = new Rook(Colour.BLACK);

        for (int y = 0; y < masterBoard.length; ++y)
            for (int x = 0; x < masterBoard.length; ++x)
                if (masterBoard[x][y] != null) {
                    if (masterBoard[x][y].getColour() == Colour.WHITE)
                        whiteOccupied.setPositionToOne(new Position(x, y));
                    else
                        blackOccupied.setPositionToOne(new Position(x, y));
                }

        syncBoards();

    }

    private Piece[][] masterBoard = new Piece[8][8];

    // Boards for query

    protected BitBoard whiteOccupied = new BitBoard();
    protected BitBoard blackOccupied = new BitBoard();
    protected BitBoard spacesOccupied = new BitBoard();

    // BEHAVIOUR

    public void play() {

        boolean checkmate = false;
        Scanner in = new Scanner(System.in);

        while (!checkmate) {
            print();
            playerTurn(Colour.WHITE);
            print();
            playerTurn(Colour.BLACK);
        }
    }

    private void playerTurn(Colour colour) {

        boolean hasMoved = false;
        String whoseTurn = (colour == Colour.BLACK) ? "Black's" : "Whites";

        System.out.println(whoseTurn + " turn");

        do {
            System.out.println("Enter coordinates for piece to move (X,Y)");
            Position oldPos = Utils.getPositionInput();
            System.out.println("Enter coordinates to move to");
            Position newPos = Utils.getPositionInput();
            if (validMove(colour, oldPos, newPos)) {
                move(oldPos, newPos);
                hasMoved = true;
            }
        } while (!hasMoved);

    }

    public boolean validMove(Colour playerColour, Position oldPos, Position newPos) {

        boolean isCapture = false;

        if (playerColour == Colour.BLACK) {
            // You don't have a piece there!
            if (blackOccupied.isPositionEmpty(oldPos))
                return false;
            // You can't capture your own piece!!
            else if (!blackOccupied.isPositionEmpty(newPos))
                return false;
            // Is there an enemy there?
            else if (!whiteOccupied.isPositionEmpty(newPos))
                isCapture = true;
        }
        else {
            if (whiteOccupied.isPositionEmpty(oldPos))
                return false;
            else if (!whiteOccupied.isPositionEmpty(newPos))
                return false;
            else if (!blackOccupied.isPositionEmpty(newPos))
                isCapture = true;
        }

        Movement move = new Movement(oldPos, newPos, isCapture);

        // If the piece can't jump
        if (isBlocked(move) && !(masterBoard[oldPos.x][oldPos.y] instanceof Knight))
            return false;

        return masterBoard[oldPos.x][oldPos.y].validMove(move);

    }

    protected boolean isBlocked(Movement move) {

        // Increments towards new x and y positions
        // Will be -1 for left/down, 1 for right/up or 0 for no movement on that axis
        int xMove = (move.getXDiff() == 0) ? 0 : move.getSignedXDiff() / move.getXDiff();
        int yMove = (move.getYDiff() == 0) ? 0 : move.getSignedYDiff() / move.getYDiff();

        // Is there anything in the way of the move?
        // This won't work if the movement isn't in a straight line of some kind
        // Only knights move this way though, and they shouldn't call this method
        for (int x = move.oldX + xMove, y = move.oldY + yMove; x != move.newX || y != move.newY; x += xMove, y += yMove)
            if (!spacesOccupied.isPositionEmpty(new Position(x, y)))
                return true;

        return false;
    }

    private void syncBoards() {
        for (int i = 0; i < masterBoard.length; i++)
            spacesOccupied.board[i] = (byte) (whiteOccupied.board[i] | blackOccupied.board[i]);
    }

    public void move(Position oldPos, Position newPos) {
        if (masterBoard[oldPos.x][oldPos.y] != null) {

            masterBoard[newPos.x][newPos.y] = masterBoard[oldPos.x][oldPos.y];
            masterBoard[oldPos.x][oldPos.y] = null;
            // Update the boards...
            if (masterBoard[newPos.x][newPos.y].getColour() == Colour.WHITE) {
                whiteOccupied.setPositionToOne(newPos);
                blackOccupied.setPositionToZero(newPos);
                whiteOccupied.setPositionToZero(oldPos);
            } else {
                blackOccupied.setPositionToOne(newPos);
                whiteOccupied.setPositionToZero(newPos);
                blackOccupied.setPositionToZero(oldPos);
            }
        }
        syncBoards();
    }

    public void print() {

        System.out.print("    ");
        for (int i = 0; i < 8; ++i)
            System.out.print(i + "   ");
        System.out.println();

        for (int y = 0; y < masterBoard.length; ++y) {
            System.out.print(y + "   ");
            for (int x = 0; x < masterBoard.length; ++x) {

                if (masterBoard[x][y] != null) {

                    if (masterBoard[x][y].getColour() == Colour.WHITE) {
                        if (masterBoard[x][y] instanceof Pawn)
                            System.out.print("WP");
                        else if (masterBoard[x][y] instanceof Queen)
                            System.out.print("WQ");
                        else if (masterBoard[x][y] instanceof King)
                            System.out.print("WK");
                        else if (masterBoard[x][y] instanceof Knight)
                            System.out.print("WH");
                        else if (masterBoard[x][y] instanceof Rook)
                            System.out.print("WR");
                        else if (masterBoard[x][y] instanceof Bishop)
                            System.out.print("WB");
                    }
                    else {
                        if (masterBoard[x][y] instanceof Pawn)
                            System.out.print("BP");
                        else if (masterBoard[x][y] instanceof Queen)
                            System.out.print("BQ");
                        else if (masterBoard[x][y] instanceof King)
                            System.out.print("BK");
                        else if (masterBoard[x][y] instanceof Knight)
                            System.out.print("BH");
                        else if (masterBoard[x][y] instanceof Rook)
                            System.out.print("BR");
                        else if (masterBoard[x][y] instanceof Bishop)
                            System.out.print("BB");
                    }
                }
                else {
                    System.out.print("  ");
                }

                System.out.print("  ");


            }
            System.out.println("\n");
        }
    }

    public void printOccupied() {
        spacesOccupied.print();
    }
    public void printOccupiedBlack() {
        blackOccupied.print();
    }
    public void printOccupiedWhite() {
        whiteOccupied.print();
    }

}
