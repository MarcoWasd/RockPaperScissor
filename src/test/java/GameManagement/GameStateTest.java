package GameManagement;

import RPS.GameManagement.GameState;
import RPS.GameManagement.Move;
import RPS.Result.Result;
import RPS.Result.ResultType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.LinkedList;

public class GameStateTest {


    @DataProvider
    public Object[][] winners() {
        return new Object[][]{
                {getResults(3, true),  "player1 won the game over player2 with 2 wins over 1"},
                {getResults(7, true), "player1 won the game over player2 with 4 wins over 3"},
                {getResults(11, true), "player1 won the game over player2 with 6 wins over 5"},
                {getResults(9, true), "player1 won the game over player2 with 5 wins over 4"},
                {getResults(8, true), "The game ended in Tie for player1 and player2 with 4 wins each"},
                {getResults(44, true), "The game ended in Tie for player1 and player2 with 22 wins each"},
                {getResults(3, false),  "player2 won the game over player1 with 2 wins over 1"},
                {getResults(7, false), "player2 won the game over player1 with 4 wins over 3"},
                {getResults(11, false), "player2 won the game over player1 with 6 wins over 5"},
                {getResults(9, false), "player2 won the game over player1 with 5 wins over 4"}
        };
    }

    @Test(dataProvider = "winners")
    public void testGetWinners (LinkedList<Result> list, String expected) {
        GameState gameState = new GameState(list, 1);
        Assert.assertEquals(gameState.getWinner(), expected);
    }

    private LinkedList<Result> getResults(int number, boolean win) {
        LinkedList<Result> list = new LinkedList<>();
        for (int i=0;i<number;++i) {
            if (win) {
                list.add(new Result("player1", "player2",
                        i%2==0? ResultType.WIN:ResultType.LOSS, i, null, null));
            } else {
                list.add(new Result("player1", "player2",
                        i%2==0? ResultType.LOSS:ResultType.WIN, i, null, null));
            }

        }
        return list;
    }

}
