package RPS.GameManagement;

import RPS.GameModes.SinglePlayerGame;

public class GameModeFactory implements AbstractFactory<GameStrategy> {

    @Override
    public GameStrategy create(int mode) throws Exception {

        switch (mode) {
            case 1:
                return SinglePlayerGame.getGame();
            default:
                throw new Exception("Option not available, buy DLC and restart the game");
        }

    }
}
