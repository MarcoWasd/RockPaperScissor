package Result;

import RPS.GameManagement.Move;
import RPS.Result.Result;
import RPS.Result.ResultType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

@Test
public class ResultTest {

    @DataProvider
    public Object[][] data() {
        return new Object[][]{
                {"Marco", "Sander", ResultType.WIN, 5, Move.ROCK, Move.SCISSOR, "Marco won the round 5 over Sander with move ROCK over move SCISSOR"},
                {"qqqq", "4444", ResultType.WIN, 1000, Move.PAPER, Move.ROCK, "qqqq won the round 1000 over 4444 with move PAPER over move ROCK"},
                {"", " ", ResultType.WIN, 5, Move.ROCK, Move.SCISSOR, " won the round 5 over   with move ROCK over move SCISSOR"},
                {"aaaaaaaaaaaaaaa", "bbbbbbbbbbbbbbbb~", ResultType.LOSS, 5, Move.ROCK, Move.SCISSOR, "bbbbbbbbbbbbbbbb~ won the round 5 over aaaaaaaaaaaaaaa with move SCISSOR over move ROCK"},
                {"Marco", "IMCBot", ResultType.TIE, 1, Move.ROCK, Move.PAPER, "Round 1 ended in Tie for Marco and IMCBot with move ROCK"},
                {"Marco", "IMCBot", ResultType.TIE, 1, Move.PAPER, Move.PAPER, "Round 1 ended in Tie for Marco and IMCBot with move PAPER"},
                {"Marco", "IMCBot", ResultType.TIE, 1, Move.PAPER, Move.PAPER, "Round 1 ended in Tie for Marco and IMCBot with move PAPER"}

        };
    }


    @Test(dataProvider = "data")
    public void testToString(String player1, String player2, ResultType resultType, int roundNumber, Move player1Move, Move player2Move, String expected) {
        Result result = new Result(player1, player2, resultType, roundNumber, player1Move, player2Move);
        Assert.assertEquals(result.toString(), expected);
    }

}
