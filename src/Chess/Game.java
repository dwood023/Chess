package Chess;

import Chess.Board.Board;
import Chess.Board.CompositeBitBoard;
import Chess.Data.Capture;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Player.AwfulAIPlayer;
import Chess.Player.HumanPlayer;
import Chess.Player.Player;

import java.util.ArrayList;

/**
 * Created by dwood on 21/12/2015.
 */
public class Game {

    /**
     * Initialises players and populates their BitBoards
     * Initialises sharedBoard as a composite of the players' boards
     */
    public Game() {
        whitePlayer = new AwfulAIPlayer(Colour.WHITE, board);
        blackPlayer = new HumanPlayer(Colour.BLACK, board);

        sharedBoard = new CompositeBitBoard(whitePlayer.getOccupied(), blackPlayer.getOccupied());
    }


    private Board board = new Board();
    /**
     * Amalgamation of both players' BitBoards
     */
    private CompositeBitBoard sharedBoard;

    protected Player whitePlayer;
    protected Player blackPlayer;

    // BEHAVIOUR

    /**
     * Game loop, calls playTurn until checkmate is reached
     */
    public void play() {

        int turn = 1;

        while (!isCheckMate()) {
            System.out.println("Turn " + turn++);
            board.print();
            playTurn(whitePlayer);
            board.print();
            playTurn(blackPlayer);
        }
    }

    /**
     * Gets moves from player until one is valid, which is passed to move()
     * @param player
     */
    private void playTurn(Player player) {

        System.out.println(player.toString() + "'s turn");

        while(true) {
            Movement move = player.getMove();
            if (validMove(player, move)) {
                move(player, move);
                break;
            }
        }
    }

    /**
     * Performs board specific, general validation, then if that checks out,
     * calls validMove on the piece itself
     * @param player
     * @param move
     * @return True, if the piece and board validation passes
     */
    public boolean validMove(Player player, Movement move) {

        if (!player.hasPieceAt(move.oldP) || player.hasPieceAt(move.newP))
            return false;
        else if (sharedBoard.isBlocked(move) && !board.board[move.oldP.x][move.oldP.y].canJump())
            return false;
        else if (!sharedBoard.isPositionEmpty(move.newP))
            move = new Capture(move);

        return board.board[move.oldP.x][move.oldP.y].validMove(move);
    }

    /**
     * Executes move, updates player BitBoards and sharedBoard
     * @param move
     */
    protected void move(Player player, Movement move) {
        if (board.board[move.oldP.x][move.oldP.y] != null) {
            board.board[move.newP.x][move.newP.y] = board.board[move.oldP.x][move.oldP.y];
            board.board[move.oldP.x][move.oldP.y] = null;

            if (player.colour == Colour.BLACK) {
                blackPlayer.move(move);
                whitePlayer.removePiece(move.newP);
            } else if (player.colour == Colour.WHITE) {
                whitePlayer.move(move);
                blackPlayer.removePiece(move.newP);
            }

            sharedBoard.update(whitePlayer.getOccupied(), blackPlayer.getOccupied());
        }
    }

    private boolean isCheckMate() {
        // TODO
        return false;
    }

}
