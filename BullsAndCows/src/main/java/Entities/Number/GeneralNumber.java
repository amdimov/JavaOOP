package Entities.Number;

import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Random;
import java.util.Set;

public class GeneralNumber implements NumberFactory {
    private static final int NUMBER_RANGE = 9;
    private static final int NUMBER_SIZE = 4;
    private static boolean checkIfNumberAlreadyGenerated = false;
    private String number;
    private int tries;
    private String difficulty;
    private static final int HARD_DIFFICULTY_NUM_OF_TRIES = 10;
    private static final int EASY_DIFFICULTY_NUM_OF_TRIES = 25;
    private int currentCows;
    private int currentBulls;

    public GeneralNumber(String difficulty){
        switch (difficulty){
            case "hard":
            case "easy":
                this.difficulty = difficulty;
                break;
            default:
                throw new IllegalArgumentException("Invalid difficulty type");
        }
        this.currentBulls = 0;
        this.currentCows = 0;
    }

    @Override
    public String generateNumber(){
        if (checkIfNumberAlreadyGenerated){
            throw new NullPointerException("Number already generated");
        }
        Random random = new Random();
        StringBuilder number = new StringBuilder();
        Set<Character> digitsArray = new HashSet<>();
        for (int i = 0; i < NUMBER_SIZE; i++) {
            int currentDigit = random.nextInt(NUMBER_RANGE);
            while (i == 0 && currentDigit == 0){
                currentDigit = random.nextInt(NUMBER_RANGE);
            }
            while (!digitsArray.add((char)currentDigit)){
                currentDigit = random.nextInt(NUMBER_RANGE);
            }
            number.append(currentDigit);
        }
        this.number = number.toString();
        //this.number = DEBUG_NUMBER;
        checkIfNumberAlreadyGenerated = true;
        return number.toString();
    }

    @Override
    public int throwBulls(String playersNumber) {
        char[] playerNumToArray = playersNumber.toCharArray();
        char[] generalNumberToArray = getNumber().toCharArray();
        int bulls = 0;
        for (int i = 0; i < playerNumToArray.length; i++) {
            if (playerNumToArray[i] == generalNumberToArray[i]){
                bulls++;
            }
        }
        this.currentBulls = bulls;
        return bulls;
    }

    @Override
    public int throwCows(String playersNumber) {
        char[] playerNumToArray = playersNumber.toCharArray();
        char[] generalNumberToArray = getNumber().toCharArray();
        int cows = 0;
        for (int i = 0; i < playerNumToArray.length; i++) {
            char playersCurrentChar = playerNumToArray[i];
            for (int j = 0; j < generalNumberToArray.length; j++) {
                if (playersCurrentChar == generalNumberToArray[j] && i != j){
                    cows++;
                }
            }
        }
        this.currentCows = cows;
        return cows;
    }

    @Override
    public String getNumber() {
        return this.number;
    }

    @Override
    public void incrementTry() {
        this.tries++;
    }

    @Override
    public boolean isMaximumTriesAchieved() {
        if (this.difficulty.equalsIgnoreCase("hard")){
            return tries == HARD_DIFFICULTY_NUM_OF_TRIES;
        }
        if (this.difficulty.equalsIgnoreCase("easy")){
            return tries == EASY_DIFFICULTY_NUM_OF_TRIES;
        }
        return false;
    }

    @Override
    public boolean isNumberGuessed() {
        return this.currentBulls == NUMBER_SIZE;
    }

    @Override
    public int getTries() {
        return this.tries;
    }

    @Override
    public int getCows() {
        return this.currentCows;
    }

    @Override
    public int getBulls() {
        return this.currentBulls;
    }

    @Override
    public int triesLeft() {
        if (this.difficulty.equalsIgnoreCase("hard")){
            return HARD_DIFFICULTY_NUM_OF_TRIES - tries;
        }
        if (this.difficulty.equalsIgnoreCase("easy")){
            return EASY_DIFFICULTY_NUM_OF_TRIES - tries;
        }
        return -1;
    }


}
