package RPS.GameManagement;

import RPS.Result.ResultType;

/**
 * Rock Paper Scissor Move
 */
public enum Move {
    ROCK,
    PAPER,
    SCISSOR,
    UNKNOWN;

    public ResultType getResult(Move opponentMove) {
        if (this == opponentMove)
            return ResultType.TIE;
        else if ((this == Move.ROCK && opponentMove == Move.SCISSOR) ||
                (this == Move.SCISSOR && opponentMove == Move.PAPER) ||
                (this == Move.PAPER && opponentMove == Move.ROCK)) {
            return ResultType.WIN;
        } else {
            return ResultType.LOSS;
        }
    }

    public Move getMove(String stringMove) {
        switch (stringMove.toLowerCase()) {
            case "r":
                return ROCK;
            case "p":
                return PAPER;
            case "s":
                return SCISSOR;
            default:
                return UNKNOWN;
        }
    }

}
