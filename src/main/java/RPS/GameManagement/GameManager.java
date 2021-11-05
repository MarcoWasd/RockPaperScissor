package RPS.GameManagement;


import RPS.PlayerManagement.PlayerStrategy;
import RPS.Result.Result;
import RPS.Result.ResultType;

import java.util.LinkedList;

/**
 * Manager for game state and round executor
 */
public class GameManager {

    private IGameState gameState;
    private PlayerStrategy player1;
    private PlayerStrategy player2;


    public GameManager(PlayerStrategy player1, PlayerStrategy player2) {
        gameState = new GameState(new LinkedList<>(), 1);
        this.player1 = player1;
        this.player2 = player2;
    }


    public Result play() {
        Move player1Move = player1.getMove(gameState);
        Move player2Move = player2.getMove(gameState);
        ResultType resultType = player1Move.getResult(player2Move);
        Result result = new Result(player1.getPlayerName(), player2.getPlayerName(), resultType, gameState.getRoundNumber(), player1Move, player2Move);
        gameState.addResult(result);
        return result;
    }

    public String getWinner() {
        return gameState.getWinner();
    }
}
