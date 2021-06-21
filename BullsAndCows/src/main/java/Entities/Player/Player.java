package Entities.Player;

import java.util.Collection;
import java.util.Map;

public interface Player {
    Map<String, String> triesHistory();
    void addToTries(String number, String result);
    String getName();
    String getPlayerNumber();
    String getStatistics();
}
