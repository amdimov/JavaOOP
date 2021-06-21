package Entities.Number;

public interface NumberFactory {
    String generateNumber() throws IllegalAccessException;
    int throwBulls(String playersNumber);
    int throwCows(String playersNumber);
    String getNumber();
    void incrementTry();
    boolean isMaximumTriesAchieved();
    boolean isNumberGuessed();
    int getTries();
    int getCows();
    int getBulls();
    int triesLeft();

}
