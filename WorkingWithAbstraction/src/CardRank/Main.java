package CardRank;

public class Main {
    static {
        System.out.println("Card Ranks:");
    }
    public static void main(String[] args) {
        CardRanks[] values = CardRanks.values();
        for (CardRanks value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }
    }
}
