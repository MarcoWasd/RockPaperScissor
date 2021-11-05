package RPS.GameManagement;

//Java imports

import RPS.Result.Result;
import RPS.Result.ResultType;

import java.util.List;

/**
 * Game state manages the game history and returns the game winner at the call time (at the end of the match or even in
 * the middle to get current winner)
 */
public class GameState implements IGameState {

    private List<Result> results;
    private int roundNumber;

    /**
     *
     */
    public GameState(List<Result> results, int roundNumber) {
        this.results = results;
        this.roundNumber = roundNumber;
    }

    @Override
    public int getRoundNumber() {
        return roundNumber;
    }

    @Override
    public void addResult(Result result) {
        results.add(result);
        roundNumber++;
    }

    @Override
    public String getWinner() {
        int player1Win = 0;
        int player2Win = 0;

        for(Result result: results) {
            ResultType resultType = result.getResultType();
            switch (resultType) {
                case WIN:
                    player1Win++;
                break;
                case LOSS:
                    player2Win++;
                break;
            }
        }
        if (player1Win == player2Win) {
            return "The game ended in Tie for " + results.get(0).getPlayer1() + " and " + results.get(0).getPlayer2() + " with " + player1Win + " wins each";
        }
        else if (player1Win > player2Win) {
            return results.get(0).getPlayer1() + " won the game over " + results.get(0).getPlayer2() + " with " + player1Win + " wins over " + player2Win;
        }
        else {
            return results.get(0).getPlayer2() + " won the game over " + results.get(0).getPlayer1() + " with " + player2Win + " wins over " + player1Win;
        }
    }



}
