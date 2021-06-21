package CardSuit;
public class Main {
    static {
        System.out.println("Card Suits:");
    }
    public static void main(String[] args) {
        CardSuits[] values = CardSuits.values();
        for (CardSuits value : values) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", value.ordinal(), value);
        }
    }
}
