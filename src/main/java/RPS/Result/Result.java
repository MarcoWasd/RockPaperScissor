package RPS.Result;


import RPS.GameManagement.Move;

/**
 * Result is made of players names, resultType and round number
 */
public class Result {

    private String player1;
    private String player2;
    private ResultType resultType;
    private int roundNumber;
    private Move player1Move;
    private Move player2Move;

    public Result(String player1, String player2, ResultType resultType, int roundNumber, Move player1Move, Move player2Move) {
        this.player1 = player1;
        this.player2 = player2;
        this.resultType = resultType;
        this.roundNumber = roundNumber;
        this.player1Move = player1Move;
        this.player2Move = player2Move;
    }

    @Override
    public String toString() {
        switch (resultType) {
            case WIN :  return player1 + " won the round " + roundNumber + " over " + player2 + " with move " + player1Move + " over move " + player2Move;
            case TIE :  return "Round " + roundNumber + " ended in Tie for " + player1 + " and " + player2 + " with move " + player1Move;
            case LOSS : return player2 + " won the round " + roundNumber + " over " + player1 + " with move " + player2Move + " over move " + player1Move;
            default :   return "Unknown result for round " + roundNumber;
        }
    }
    public String getPlayer1() {
        return player1;
    }

    public void setPlayer1(String player1) {
        this.player1 = player1;
    }

    public String getPlayer2() {
        return player2;
    }

    public void setPlayer2(String player2) {
        this.player2 = player2;
    }

    public ResultType getResultType() {
        return resultType;
    }

    public void setResultType(ResultType resultType) {
        this.resultType = resultType;
    }

    public int getRoundNumber() {
        return roundNumber;
    }

    public void setRoundNumber(int roundNumber) {
        this.roundNumber = roundNumber;
    }
}
