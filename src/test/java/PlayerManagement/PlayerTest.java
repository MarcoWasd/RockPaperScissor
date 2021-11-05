package PlayerManagement;

import RPS.GameManagement.Move;
import RPS.PlayerManagement.DumbPlayer;
import RPS.PlayerManagement.HumanPlayer;
import RPS.PlayerManagement.RandomPlayer;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import org.mockito.Mock;
import org.testng.Assert;
import org.testng.annotations.DataProvider;


import java.util.Random;
import java.util.Scanner;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.when;

public class PlayerTest {
    @Mock
    private Scanner keyboard;
    @InjectMocks
    private HumanPlayer humanPlayer;
    @Mock
    Random random;
    @InjectMocks
    RandomPlayer randomPlayer = new RandomPlayer();

    @BeforeMethod
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @DataProvider
    public Object[][] humanMoves() {
        return new Object[][]{
                {"r", Move.ROCK},
                {"p", Move.PAPER},
                {"s", Move.SCISSOR}
        };
    }
    @Test(dataProvider = "humanMoves")
    public void testHumanMove(String humanMove, Move expectedMove) throws Exception {
        when(keyboard.next()).thenReturn(humanMove);
        Assert.assertEquals(humanPlayer.getMove(null), expectedMove);
    }

    @DataProvider
    public Object[][] randomMoves() {
        return new Object[][]{
                {0, Move.ROCK},
                {1, Move.PAPER},
                {2, Move.SCISSOR},
                {3, Move.SCISSOR}
        };
    }

    @Test(dataProvider = "randomMoves")
    public void testRandomMove(int randomMove, Move expectedMove) {
        when(random.nextInt(anyInt())).thenReturn(randomMove);
        Move move = randomPlayer.getMove(null);
        Assert.assertEquals(move, expectedMove);
    }

    @DataProvider
    public Object[][] names() {
        return new Object[][]{
                {"Marco"},
                {" "},
                {" sdf3fdfh34gfg"},
                {""}
        };
    }

    @Test(dataProvider = "names")
    public void testGetterSetter(String playerName) {
        DumbPlayer dumbPlayer = new DumbPlayer();
        HumanPlayer humanPlayer = new HumanPlayer();
        RandomPlayer randomPlayer = new RandomPlayer();

        dumbPlayer.setPlayerName(playerName);
        humanPlayer.setPlayerName(playerName);
        randomPlayer.setPlayerName(playerName);

        Assert.assertEquals(dumbPlayer.getPlayerName(), playerName);
        Assert.assertEquals(humanPlayer.getPlayerName(), playerName);
        Assert.assertEquals(randomPlayer.getPlayerName(), playerName);
    }

    @Test
    public void testDumbMove() {
        DumbPlayer dumbPlayer = new DumbPlayer();
        Assert.assertEquals(dumbPlayer.getMove(null), Move.PAPER);
    }
}
