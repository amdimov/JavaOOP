package Controller;

import Entities.Computer.Computer;
import Entities.Computer.ComputerPlayer;
import Entities.Player.Player;
import Entities.Player.PlayerImpl;

public class Playground {
    private Computer computer;
    private Player player;
    private boolean isGameOver;
    private boolean isPlayerWinner;

    public Playground(String playerName, String difficulty){
        this.computer = new ComputerPlayer("MyComputer", difficulty);
        this.player = new PlayerImpl(playerName);
        //System.out.println(computer.getGeneralNumber().getNumber());
    }

    public String playerTurn(String playerNumber){
        String response = "";
        computer.getGeneralNumber().incrementTry();
//        if (!playerWins() && !gameOver()){
            int cows = computer.getGeneralNumber().throwCows(playerNumber);
            int bulls = computer.getGeneralNumber().throwBulls(playerNumber);
            response = computer.checkPlayersNumber(playerNumber, bulls, cows);
            player.addToTries(playerNumber, response);
//        }
        return response;
    }
    public boolean playerWins(){
        if (computer.getGeneralNumber().isNumberGuessed()){
            this.isPlayerWinner = true;
        }
        return false;
    }
    public boolean gameOver(){
        if (computer.getGeneralNumber().isMaximumTriesAchieved()){
            this.isGameOver = true;
        }
        return false;
    }

    public boolean isGameOver() {
        return isGameOver;
    }

    public boolean isPlayerWinner() {
        return isPlayerWinner;
    }
    public String statistics(){
       return this.player.getStatistics();
    }
}
