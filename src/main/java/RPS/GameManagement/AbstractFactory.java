package RPS.GameManagement;

public interface AbstractFactory <T>{
    T create(int factoryType) throws Exception;
}
