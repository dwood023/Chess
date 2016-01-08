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

    @Override
    public Movement getMove() {
        System.out.println("Enter coordinates for piece to move (X,Y)");
        Position oldPos = getPositionInput();
        System.out.println("Enter coordinates to move to");
        Position newPos = getPositionInput();
        return new Movement(oldPos, newPos);

    }

    private Position getPositionInput() {
        Scanner in = new Scanner(System.in);
        String inStr = in.nextLine();
        String[] coords = inStr.split(",", 2);
        return new Position(Integer.parseInt(coords[0]),Integer.parseInt(coords[1]));
    }
}
