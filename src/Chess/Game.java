package Chess;

import Chess.Board.BitBoard;
import Chess.Board.Board;
import Chess.Board.CompositeBoardData;
import Chess.Data.Capture;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Player.HumanPlayer;
import Chess.Player.Player;

/**
 * Created by dwood on 21/12/2015.
 */
public class Game {

    public Game() {
        BitBoard blackBoard = new BitBoard();
        BitBoard whiteBoard = new BitBoard();

        for (int y = 0; y < board.board.length; ++y)
            for (int x = 0; x < board.board.length; ++x)
                if (board.board[x][y] != null) {
                    if (board.board[x][y].getColour() == Colour.BLACK)
                        blackBoard.setPositionToOne(new Position(x, y));
                    else
                        whiteBoard.setPositionToOne(new Position(x,y));
                }

        whitePlayer = new HumanPlayer(Colour.WHITE, whiteBoard);
        blackPlayer = new HumanPlayer(Colour.BLACK, blackBoard);

        sharedBoard = new CompositeBoardData(whiteBoard, blackBoard);
    }


    private Board board = new Board();
    private CompositeBoardData sharedBoard;

    protected Player whitePlayer;
    protected Player blackPlayer;

    // BEHAVIOUR

    public void play() {

        boolean checkmate = false;

        while (!checkmate) {
            board.print();
            playTurn(whitePlayer);
            board.print();
            playTurn(blackPlayer);
        }
    }

    private void playTurn(Player player) {

        boolean hasMoved = false;

        System.out.println(player.toString() + "'s turn");

        do {
            Movement move = player.getMove();

            if (validMove(player, move)) {
                move(move);
                hasMoved = true;
            }
        } while (!hasMoved);

    }

    public boolean validMove(Player player, Movement move) {

        if (!player.hasPieceAt(move.oldP) || player.hasPieceAt(move.newP))
            return false;
        else if (sharedBoard.isBlocked(move) && !board.board[move.oldP.x][move.oldP.y].canJump())
            return false;
        else if (sharedBoard.hasPieceAt(move.newP))
            move = new Capture(move);

        return board.board[move.oldP.x][move.oldP.y].validMove(move);

    }

    public void move(Movement move) {
        if (board.board[move.oldP.x][move.oldP.y] != null) {
            board.board[move.newP.x][move.newP.y] = board.board[move.oldP.x][move.oldP.y];
            board.board[move.oldP.x][move.oldP.y] = null;

            updatePlayerData(move, board.board[move.newP.x][move.newP.y].getColour());
            sharedBoard.update(whitePlayer.boardData.getBoard(), blackPlayer.boardData.getBoard());
        }
    }

    private void updatePlayerData(Movement move, Colour colour) {

        if (board.board[move.newP.x][move.newP.y].getColour() == Colour.BLACK) {
            blackPlayer.boardData.move(move);
            if (move.isCapture())
                whitePlayer.boardData.removeAtPosition(move.newP);
        }
        else {
            whitePlayer.boardData.move(move);
            if (move.isCapture())
                blackPlayer.boardData.removeAtPosition(move.newP);
        }
    }

}
