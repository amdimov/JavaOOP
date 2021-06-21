package P03WildFarm;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] inputAnimal = scanner.nextLine().split("\\s+");
        String[] inputFood = scanner.nextLine().split("\\s+");
        List<Mammal> mammals = new ArrayList<>();
        Mammal mammal = null;
        Food food = null;
        while (!inputAnimal[0].equalsIgnoreCase("End")){
            if (inputAnimal[0].equalsIgnoreCase("Mouse")){
                mammal = new Mouse(inputAnimal[1], inputAnimal[0], Double.parseDouble(inputAnimal[2]),
                        inputAnimal[3]);
            }else if (inputAnimal[0].equalsIgnoreCase("Zebra")){
                mammal = new Zebra(inputAnimal[1], inputAnimal[0], Double.parseDouble(inputAnimal[2]),
                        inputAnimal[3]);
            }else if (inputAnimal[0].equalsIgnoreCase("Cat")){
                mammal = new Cat(inputAnimal[1], inputAnimal[0], Double.parseDouble(inputAnimal[2]),
                        inputAnimal[3], inputAnimal[4]);
            }else if (inputAnimal[0].equalsIgnoreCase("Tiger")){
                mammal = new Tiger(inputAnimal[1], inputAnimal[0], Double.parseDouble(inputAnimal[2]),
                        inputAnimal[3]);
            }
            if(inputFood[0].equalsIgnoreCase("Vegetable")){
                food = new Vegetable(Integer.parseInt(inputFood[1]));
            }else if (inputFood[0].equalsIgnoreCase("Meat")){
                food = new Meat(Integer.parseInt(inputFood[1]));
            }

            if (mammal != null) {
                mammal.eatFood(food);
                mammals.add(mammal);
            }

            inputAnimal = scanner.nextLine().split("\\s+");
            if (inputAnimal[0].equalsIgnoreCase("End")){
                break;
            }
            inputFood = scanner.nextLine().split("\\s+");
            mammal = null;
            food = null;
        }
        for (Mammal mammal1 : mammals) {
            System.out.println(mammal1.toString());
        }
    }
}
