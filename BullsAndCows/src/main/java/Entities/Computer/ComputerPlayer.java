package Entities.Computer;

import Entities.Number.GeneralNumber;
import Entities.Number.NumberFactory;

public class ComputerPlayer implements Computer {
    private String computerName;
    private NumberFactory generalNumber;

    public ComputerPlayer(String computerName, String difficulty){
        this.computerName = computerName;
        this.generalNumber = new GeneralNumber(difficulty);
        try {
            this.generalNumber.generateNumber();
        } catch (IllegalAccessException e) {
            System.out.println("Number already generated!");
        }

    }

    @Override
    public String checkPlayersNumber(String playersNumber, int bulls, int cows) {
        StringBuilder respondMessage = new StringBuilder();
        if (bulls == 0
                && cows == 0){
            return String.format("You didn't guess any number! You have %d tries left!", this.generalNumber.triesLeft());
        }
        if (generalNumber.isNumberGuessed()){
            return String.format("Bravo!!! YOU GUESSED THE NUMBER - %s with %d tries!", this.generalNumber.getNumber(), this.generalNumber.getTries());
        }
        if(generalNumber.isMaximumTriesAchieved()){
            return "Game Over! Your tries are exhausted!";
        }
        respondMessage.append(String.format("Nice Try! You guessed %d cow",  cows));
        if (cows > 1){
            respondMessage.append("s");
        }
        respondMessage.append(String.format(" and %d bull", bulls));
        if (bulls > 1){
            respondMessage.append("s");
        }
        respondMessage.append("!");
        return respondMessage.toString();
    }


    @Override
    public String getComputerName() {
        return this.computerName;
    }

    public NumberFactory getGeneralNumber() {
        return generalNumber;
    }

}
