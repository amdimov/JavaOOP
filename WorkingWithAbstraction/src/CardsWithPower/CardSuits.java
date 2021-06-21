package CardsWithPower;

public enum CardSuits {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    private int suitPowers;
    CardSuits(int suitPowers){
        this.suitPowers = suitPowers;
    }

    public int getSuitPowers() {
        return suitPowers;
    }
}
