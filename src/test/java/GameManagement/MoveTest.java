package GameManagement;

import RPS.GameManagement.Move;
import RPS.Result.ResultType;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class MoveTest {

    @DataProvider
    public Object[][] results() {
        return new Object[][]{
                {Move.ROCK, Move.ROCK, ResultType.TIE},
                {Move.ROCK, Move.SCISSOR, ResultType.WIN},
                {Move.ROCK, Move.PAPER, ResultType.LOSS},
                {Move.PAPER, Move.ROCK, ResultType.WIN},
                {Move.PAPER, Move.SCISSOR, ResultType.LOSS},
                {Move.PAPER, Move.PAPER, ResultType.TIE},
                {Move.SCISSOR, Move.PAPER, ResultType.WIN},
                {Move.SCISSOR, Move.ROCK, ResultType.LOSS},
                {Move.SCISSOR, Move.SCISSOR, ResultType.TIE}
        };
    }
    @Test(dataProvider = "results")
    public void getResultTest(Move move1, Move move2, ResultType expectedResultType) {
        Assert.assertEquals(move1.getResult(move2), expectedResultType);
    }
}
