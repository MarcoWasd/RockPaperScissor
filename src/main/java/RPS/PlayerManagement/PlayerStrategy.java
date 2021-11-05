package RPS.PlayerManagement;

//Project imports
import RPS.GameManagement.IGameState;
import RPS.GameManagement.Move;

/**
 * Structure of a player
 */
public interface PlayerStrategy {

    /**
     * Get player name
     * @return
     */
    public String getPlayerName();


    /**
     * Get player type
     * @return
     */
    public PlayerType getPlayerType();

    public void setPlayerName(String playerName);

    /**
     * AI decision maker
     * It is dependent by the GameState as game history may impact the decision
     * Move returned must be a legal move (i.e. not an UNKNOWN)
     *
     * @return
     * @param state
     */
    public Move getMove(IGameState state);
}
