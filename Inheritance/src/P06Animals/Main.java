package P06Animals;

import P06Animals.animals.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String name = scanner.nextLine();;

        while (!name.equals("Beast!")){
            String[] animalInput = scanner.nextLine().split("\\s+");
            addNewAnimal(name, animalInput, animals);
            name = scanner.nextLine();
        }
        for (Animal animal : animals) {
            System.out.println(animal);
        }
    }
    private static void addNewAnimal(String name, String[] animalInput, List<Animal> animals){
        String animalName = animalInput[0];
        int animalAge = Integer.parseInt(animalInput[1]);
        String animalGender = animalInput[2];
        if (name.equalsIgnoreCase("P06Animals.animals.Cat")){
            animals.add(new Cat(animalName, animalAge, animalGender));
        }else if (name.equalsIgnoreCase("P06Animals.animals.Dog")){
            animals.add(new Dog(animalName, animalAge, animalGender));
        }else if (name.equalsIgnoreCase("P06Animals.animals.Frog")){
            animals.add(new Frog(animalName, animalAge, animalGender));
        }else if(name.equalsIgnoreCase("P06Animals.animals.Kitten")){
            animals.add(new Kitten(animalName, animalAge));
        }else if (name.equalsIgnoreCase("P06Animals.animals.Tomcat")){
            animals.add(new Tomcat(animalName, animalAge));
        }
    }
}
