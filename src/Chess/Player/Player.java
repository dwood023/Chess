package Chess.Player;

import Chess.Board.BitBoard;
import Chess.Board.Board;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;

import java.util.*;

/**
 * Created by dwood on 07/01/2016.
 */
public abstract class Player {

    public Player(Colour colour, Board gameBoard) {

        occupied = new BitBoard();
        occupiedSet = new HashSet<>();

        for (int y = 0; y < gameBoard.board.length; ++y)
            for (int x = 0; x < gameBoard.board.length; ++x)
                if (gameBoard.board[x][y] != null && gameBoard.board[x][y].colour == colour)
                    occupiedSet.add(new Position(x, y));

        occupiedSet.forEach(occupied::setPositionToOne);
        this.colour = colour;

    }

    public final Colour colour;

    protected BitBoard occupied;

    protected Set<Position> occupiedSet;

    /**
     * @return new Movement
     */
    public abstract Movement getMove();

    /**
     * @param pos
     * @return True, if boardData.occupied is 1 at pos
     */
    public boolean hasPieceAt(Position pos) {
        return !occupied.isPositionEmpty(pos);
    }

    public void move(Movement move) {
        occupiedSet.add(move.newP);
        occupiedSet.remove(move.oldP);
        occupied.setPositionToOne(move.newP);
        occupied.setPositionToZero(move.oldP);
    }

    public void removePiece(Position pos) {
        occupiedSet.remove(pos);
        occupied.setPositionToZero(pos);
    }
    /**
     * @return String describing player in terms of their colour
     */
    @Override
    public String toString() {
        return ((colour == Colour.BLACK) ? "Black" : "White") + " player";
    }

    public BitBoard getOccupied() {
        return occupied;
    }
}
