package RPS.GameManagement;

import RPS.PlayerManagement.PlayerFactory;

public class FactoryProvider {
    public static AbstractFactory getFactory(String factoryType){

        if("GameMode".equalsIgnoreCase(factoryType)){
            return new GameModeFactory();
        }
        else if("DifficultyMode".equalsIgnoreCase(factoryType)){
            return new PlayerFactory();
        }
        return null;
    }
}