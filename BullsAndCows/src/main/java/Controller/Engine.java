package Controller;

import java.util.Scanner;

public class Engine {
    private Playground playground;

    public void run(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your name: ");
        String playerName = scanner.nextLine();
        System.out.println("Pick up difficulty [EASY or HARD]: ");
        String difficulty = scanner.nextLine().toLowerCase();
        this.playground = new Playground(playerName, difficulty);
        String playerNumber = "";
        while (!this.playground.isGameOver() && !this.playground.isPlayerWinner()){
            System.out.println("Guess a number: ");
            playerNumber = scanner.nextLine();
            String response = this.playground.playerTurn(playerNumber);
            if (playground.playerWins() || playground.gameOver()){
                break;
            }
            System.out.println(response);
        }
        System.out.println("Would you like to check out your tries [yes/no]: ");
        String yesNo = scanner.nextLine().toLowerCase();
        if ("yes".equalsIgnoreCase(yesNo)){
            System.out.println(this.playground.statistics());
        }
    }
}
