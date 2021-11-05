package RPS.GameModes;


import RPS.GameManagement.AbstractFactory;
import RPS.GameManagement.FactoryProvider;
import RPS.GameManagement.GameManager;
import RPS.GameManagement.GameStrategy;
import RPS.PlayerManagement.PlayerStrategy;
import RPS.Result.Result;

import java.util.Scanner;

/**
 * Single player Game, Human vs AI
 */
public class SinglePlayerGame implements GameStrategy {

    private static SinglePlayerGame game = null;
    private SinglePlayerGame() {};
    /**
     * The method loads human and AI players, gets the moves and updates the game state through the game manager
     */
    @Override
    public void start(String playerName, int rounds) {

        Scanner keyboard = new Scanner(System.in);

        // Loading AI player
        PlayerStrategy bot = null;
        AbstractFactory<PlayerStrategy> gameFactory = FactoryProvider.getFactory("DifficultyMode");;
        do {
            System.out.println("Choose the difficulty mode, 1 for easy, 2 for hard");
            try {
                int difficultyMode = keyboard.nextInt();
                bot = gameFactory.create(difficultyMode);
            } catch (Exception e) {
                System.out.println(e);
                keyboard.next();//buffer flush
            }
        } while (bot == null);

        // Loading Human player
        PlayerStrategy human = null;
        try {
            human = gameFactory.create(0);
        } catch (Exception e) {
            e.printStackTrace();
        }

        bot.setPlayerName("IMCBot");
        human.setPlayerName(playerName);
        System.out.println("You are starting a game with " + bot.getPlayerName());
        GameManager gameManager = new GameManager(human, bot);

        // Game Loop
        do {
            Result result = gameManager.play();
            System.out.println(result);
        } while (--rounds > 0);

        System.out.println(gameManager.getWinner());
    }


    public static SinglePlayerGame getGame() {
        if (game == null) {
            game = new SinglePlayerGame();
        }
        return game;
    }
}
