package Chess.Player;

import Chess.Board.BitBoard;
import Chess.Data.Colour;
import Chess.Data.Movement;
import Chess.Data.Position;

import java.util.Scanner;

/**
 * Created by dwood on 08/01/2016.
 */
public class HumanPlayer extends Player {

    public HumanPlayer(Colour colour, BitBoard occupied) {
        super(colour, occupied);
    }

    /**
     * Prompts user to input old and new positions
     * @exception ArrayIndexOutOfBoundsException, recalls method
     * @exception IllegalArgumentException, recalls method
     * @return new Movement from input positions
     */
    @Override
    public Movement getMove() {
        try {
            System.out.println("Enter coordinates for piece to move (X,Y)");
            Position oldPos = getPositionInput();
            System.out.println("Enter coordinates to move to");
            Position newPos = getPositionInput();
            return new Movement(oldPos, newPos);
        }
        catch (ArrayIndexOutOfBoundsException | IllegalArgumentException e) {
            System.out.println("Invalid Position");
            return getMove();
        }
    }

    /**
     * @return new position from System.in input in the form (x,y)
     * @throws IllegalArgumentException, if position is out of board range, derived from boardData.occupied length
     * @throws ArrayIndexOutOfBoundsException, arguments in wrong format
     */
    private Position getPositionInput() throws ArrayIndexOutOfBoundsException {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] coords = inStr.split(",", 2);
        int x = Integer.parseInt(coords[0]);
        int y = Integer.parseInt(coords[1]);
        if (x >= boardData.getBoard().getLength() || y >= boardData.getBoard().getLength())
            throw new IllegalArgumentException();
        return new Position(x,y);
    }
}
