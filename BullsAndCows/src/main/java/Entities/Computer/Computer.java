package Entities.Computer;
import Entities.Number.GeneralNumber;
import Entities.Number.NumberFactory;

public interface Computer {
    String checkPlayersNumber(String playersNumber, int bulls, int cows);
    String getComputerName();
    NumberFactory getGeneralNumber();
}
