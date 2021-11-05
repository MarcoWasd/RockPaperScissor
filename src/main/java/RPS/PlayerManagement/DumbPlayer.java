package RPS.PlayerManagement;



import RPS.GameManagement.IGameState;
import RPS.GameManagement.Move;

/**
 * AI bot
 */
public class DumbPlayer implements PlayerStrategy {

    private String playerName = null;
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
        return Move.PAPER;
    }
}
