package Chess;

import Chess.Board.BitBoard;
import Chess.Board.Board;
import Chess.Board.CompositeBoardData;
import Chess.Data.Capture;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;
import Chess.Player.AwfulAIPlayer;
import Chess.Player.HumanPlayer;
import Chess.Player.Player;

/**
 * Created by dwood on 21/12/2015.
 */
public class Game {

    /**
     * Initialises players and populates their BitBoards
     * Initialises sharedBoard as a composite of the players' boards
     */
    public Game() {
        BitBoard blackBoard = new BitBoard();
        BitBoard whiteBoard = new BitBoard();

        for (int y = 0; y < board.board.length; ++y)
            for (int x = 0; x < board.board.length; ++x)
                if (board.board[x][y] != null) {
                    if (board.board[x][y].colour == Colour.BLACK)
                        blackBoard.setPositionToOne(new Position(x, y));
                    else
                        whiteBoard.setPositionToOne(new Position(x,y));
                }

        whitePlayer = new AwfulAIPlayer(Colour.WHITE, whiteBoard);
        blackPlayer = new AwfulAIPlayer(Colour.BLACK, blackBoard);

        sharedBoard = new CompositeBoardData(whiteBoard, blackBoard);
    }


    private Board board = new Board();
    /**
     * Amalgamation of both players' BitBoards
     */
    private CompositeBoardData sharedBoard;

    protected Player whitePlayer;
    protected Player blackPlayer;

    // BEHAVIOUR

    /**
     * Game loop, calls playTurn until checkmate is reached
     */
    public void play() {

        boolean checkmate = false;
        int turn = 1;

        while (!checkmate) {
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

        boolean hasMoved = false;

        System.out.println(player.toString() + "'s turn");

        while (!hasMoved) {
            Movement move = player.getMove();

            if (validMove(player, move)) {
                move(player, move);
                hasMoved = true;
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
        else if (sharedBoard.hasPieceAt(move.newP))
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
                blackPlayer.boardData.move(move);
                whitePlayer.boardData.removeAtPosition(move.newP);
            } else if (player.colour == Colour.WHITE) {
                whitePlayer.boardData.move(move);
                blackPlayer.boardData.removeAtPosition(move.newP);
            }

            sharedBoard.update(whitePlayer.boardData.getBoard(), blackPlayer.boardData.getBoard());
        }
    }

/*    *//**
     * Updates player BitBoards with move
     * @param move
     * @param colour, which player moved (the other player's pieces get taken)
     *//*
    private void updatePlayerData(Movement move, Colour colour) {

        if (board.board[move.newP.x][move.newP.y].colour == Colour.BLACK) {
            blackPlayer.boardData.move(move);
            whitePlayer.boardData.removeAtPosition(move.newP);
        }
        else {
            whitePlayer.boardData.move(move);
            blackPlayer.boardData.removeAtPosition(move.newP);
        }
    }*/

}
