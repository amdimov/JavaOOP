package P04FoodShortage;

import java.util.HashMap;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HashMap<String ,Buyer> persons = new HashMap<>();

        int n = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split("\\s+");
            Buyer buyer = persons.get(input[0]);
            if (input.length == 4) {
                if (buyer == null) {
                    persons.put(input[0], new Citizen(input[0], Integer.parseInt(input[1]), input[2], input[3]));
                }
            }else if(input.length == 3 && !Character.isDigit(input[0].charAt(0))){
                if (buyer == null) {
                    persons.put(input[0], new Rebel(input[0], Integer.parseInt(input[1]), input[2]));
                }
            }
        }
        String input = scanner.nextLine();
        while (!input.equalsIgnoreCase("End")){
            Buyer buyer = persons.get(input);
            if (buyer != null) {
                buyer.buyFood();
            }
            input = scanner.nextLine();
        }
        int allFoods = 0;
        for (Buyer value : persons.values()) {
            allFoods += value.getFood();
        }
        System.out.println(allFoods);
    }
}
