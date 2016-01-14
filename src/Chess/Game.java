package Chess;

import Chess.Board.Board;
import Chess.Board.CompositeBitBoard;
import Chess.Data.Capture;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Piece.Pawn;
import Chess.Piece.Queen;
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

        if (!player.getOccupiedSet().isEmpty())
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

            // Check for promotions...
            for (int x = 0; x < board.board.length; ++x)
                if (board.board[x][0] instanceof Pawn)
                    board.board[x][0] = new Queen(Colour.BLACK);
                else if (board.board[x][7] instanceof Pawn)
                    board.board[x][7] = new Queen(Colour.WHITE);
        }
    }

    private boolean isCheckMate() {
        // TODO
        // Needs to know all the "threatened" positions for either player
        // To know which positions are threatened, need to generate all possible moves
        // for each piece. This requires the Player class to know the game rules, which
        // is infringing on the behaviour of the Piece and Game classes.
        // Either the Rules are made more general and passed to everyone somehow, or
        // the AI will need it's own copy of a lot of board and piece data
        // Either way, implementing checkmate is going to be a mess. This ties in with
        // the AI problems.
        // For now, this will have to do.
        if (whitePlayer.getOccupiedSet().isEmpty()) {
            System.out.println("BLACK PLAYER WINS");
            return true;
        }
        else if (blackPlayer.getOccupiedSet().isEmpty()) {
            System.out.println("WHITE PLAYER WINS");
            return true;
        }
        else return false;
    }

}
