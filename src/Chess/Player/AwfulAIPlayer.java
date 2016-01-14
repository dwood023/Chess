package Chess.Player;

import Chess.Board.Board;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Created by dwood on 12/01/2016.
 */
public class AwfulAIPlayer extends Player {

    public AwfulAIPlayer(Colour colour, Board gameBoard) {
        super(colour, gameBoard);
    }

    /**
     * "Pawns can't move that way! Stupid arm..."
     * @return new Movement, with no respect for the game rules
     */
    @Override
    public Movement getMove() {
        Position oldPos = (Position) occupiedSet.toArray()[ThreadLocalRandom.current().nextInt(0, occupiedSet.size())];
        Position newPos = new Position(ThreadLocalRandom.current().nextInt(0, 8), ThreadLocalRandom.current().nextInt(0, 8));
        return new Movement(oldPos, newPos);
    }
}
