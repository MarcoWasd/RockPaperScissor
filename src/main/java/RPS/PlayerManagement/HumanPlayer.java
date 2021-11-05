package RPS.PlayerManagement;

import RPS.GameManagement.IGameState;
import RPS.GameManagement.Move;

import java.util.Scanner;


/**
 * Structure of a Human player
 */
public class HumanPlayer implements PlayerStrategy{
    private Scanner keyboard = new Scanner(System.in);
    private String playerName = null;
    private static final PlayerType playerType = PlayerType.Human;


    @Override
    public String getPlayerName() {
        return playerName;
    }

    @Override
    public PlayerType getPlayerType() {
        return playerType;
    }

    @Override
    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    @Override
    public Move getMove(IGameState state) {
        String input;
        Move move = Move.UNKNOWN;
        while (move == Move.UNKNOWN) {
            System.out.print("Choose your symbol: type 'r' for Rock, 's' for Scissor, 'p' for paper ");
            input = keyboard.next();
            move = move.getMove(input);
        }
        return move;
    }
}
