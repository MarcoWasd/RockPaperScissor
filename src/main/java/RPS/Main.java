package RPS;


import RPS.GameManagement.AbstractFactory;
import RPS.GameManagement.FactoryProvider;
import RPS.GameManagement.GameStrategy;

import java.util.Scanner;

/*
* Main is in charge of getting information needed to start the proper game
* player name
* game mode
* number of rounds
* */
public class Main {

    public static final int MAX_ROUNDS = 1000;
    public static final int MIN_ROUNDS = 0;
    public static void main(String[] args) throws InterruptedException {

        System.out.println("Rock paper scissor Game");
        final Scanner keyboard = new Scanner(System.in);
        System.out.println("Choose your name: ");
        final String playerName = keyboard.next();

        GameStrategy game = null;
        do {
            System.out.println("Choose the game mode (1 for Single Player, 2 for Multiplayer) ");
            try {
                int gameMode = keyboard.nextInt();
                if (gameMode != 1 && gameMode != 2) {throw new Exception("Wrong Input");}
                final AbstractFactory<GameStrategy> gameFactory = FactoryProvider.getFactory("GameMode");
                game = gameFactory.create(gameMode);
            } catch (Exception e) {
                System.out.println(e);
                keyboard.next();//buffer flush
            }
        } while (game == null);

        int rounds = 0;
        do {
            System.out.println("Choose the number of rounds you want to play: ");
            try {
                rounds = keyboard.nextInt();
            } catch (Exception e) {
                keyboard.next();//buffer flush
            }
        } while (rounds <= MIN_ROUNDS || rounds >= MAX_ROUNDS);

        game.start(playerName, rounds);
    }

}



