package RPS.PlayerManagement;

import RPS.GameManagement.IGameState;
import RPS.GameManagement.Move;

import java.util.Random;

/**
 * Structure of a Dumb player
 */
public class RandomPlayer implements PlayerStrategy {

    private  Random ran = new Random();
    private String playerName;
    private static final PlayerType playerType = PlayerType.AI;


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

    /**
     * AI decision maker
     * @param state It can be used to base the decision
     * @return Move
     */
    @Override
    public Move getMove(IGameState state) {

        int decision = ran.nextInt(3);
        switch (decision) {
            case 0:
                return Move.ROCK;
            case 1:
                return Move.PAPER;
            default:
                return Move.SCISSOR;
        }
    }
}
