package RPS.PlayerManagement;

import RPS.GameManagement.AbstractFactory;

public class PlayerFactory implements AbstractFactory<PlayerStrategy> {
    @Override
    public PlayerStrategy create(int factoryType) throws Exception {

        switch (factoryType) {
            case 0:
                return new HumanPlayer();
            case 1:
                return new DumbPlayer();
            case 2:
                return new RandomPlayer();
            default:
                throw new Exception("Option not available, buy DLC and restart the game");
        }
    }
}
