package CardsWithPower;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputRank = scanner.nextLine().toUpperCase();
        String inputSuit = scanner.nextLine().toUpperCase();
        CardRanks cardRanks = CardRanks.valueOf(inputRank);
        CardSuits cardSuits = CardSuits.valueOf(inputSuit);
        System.out.printf("Card name: %s of %s; Card power: %d",
                cardRanks, cardSuits, cardRanks.getRankPowers() + cardSuits.getSuitPowers());
    }
}
