package RPS.GameManagement;

import RPS.Result.Result;

/**
 * Interface definition for the RPS game state
 */
public interface IGameState {

    public int getRoundNumber();

    public void addResult(Result result);

    public String getWinner();
}
