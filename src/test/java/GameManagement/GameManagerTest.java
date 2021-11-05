package GameManagement;

import RPS.GameManagement.GameManager;
import RPS.PlayerManagement.DumbPlayer;
import RPS.Result.ResultType;
import org.testng.Assert;
import org.testng.annotations.Test;

public class GameManagerTest {

    @Test
    public void playTest () {
        GameManager gameManager = new GameManager(new DumbPlayer(), new DumbPlayer());
        Assert.assertEquals(gameManager.play().getResultType(), ResultType.TIE);
    }
}
