package Entities.Player;

import java.util.HashMap;
import java.util.Map;

public class PlayerImpl implements Player {
    private Map<String, String> triesHistory;
    private String playerName;
    private String playerNumber;

    public PlayerImpl(String playerName){
        if (playerName == null || playerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Invalid Player Name!");
        }
        this.playerName = playerName;
        this.triesHistory = triesHistory();
    }

    @Override
    public Map<String, String> triesHistory() {
        return new HashMap<>();
    }

    @Override
    public void addToTries(String number, String result) {
        this.triesHistory.put(number, result);
    }

    @Override
    public String getName() {
        return this.getName();
    }


    @Override
    public String getPlayerNumber() {
        return this.playerNumber;
    }

    @Override
    public String getStatistics() {
        StringBuilder result = new StringBuilder();
        for (Map.Entry<String, String> stringStringEntry : triesHistory.entrySet()) {
            result.append(String.format("Your num: [%s] -> %s", stringStringEntry.getKey(), stringStringEntry.getValue()));
            result.append(System.lineSeparator());
        }
        return result.toString().trim();
    }
}
