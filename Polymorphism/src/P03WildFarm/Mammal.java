package P03WildFarm;

import java.text.DecimalFormat;

public class Mammal extends Animal{
    private String livingRegion;

    public Mammal(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight);
        this.livingRegion = livingRegion;
    }

    @Override
    public void makeSound() {
        switch (super.animalType) {
            case "Cat":
                System.out.println("Meowwww");
                break;
            case "Tiger":
                System.out.println("ROAAR!!!");
                break;
            case "Mouse":
                System.out.println("SQUEEEAAAK!");
                break;
            case "Zebra":
                System.out.println("Zs");
                break;

        }
    }

    @Override
    public void eatFood(Food food) {
        switch (super.animalType) {
            case "Cat":
                this.makeSound();
                super.foodEaten += food.getQuantity();
                break;
            case "Tiger":
                this.makeSound();
                if (food instanceof Meat){
                    super.foodEaten += food.getQuantity();
                }else {
                    System.out.println(super.animalType+"s are not eating that type of food!");
                }
                break;
            case "Mouse":
                this.makeSound();
                if (food instanceof Vegetable){
                    super.foodEaten += food.getQuantity();
                }else {
                    System.out.println("Mice are not eating that type of food!");
                }
                break;
            case "Zebra":
                this.makeSound();
                if (food instanceof Vegetable){
                    super.foodEaten += food.getQuantity();
                }else {
                    System.out.println(super.animalType+"s are not eating that type of food!");
                }
                break;
        }
    }

    public String getLivingRegion() {
        return livingRegion;
    }

    @Override
    public String toString() {
        DecimalFormat weight = new DecimalFormat("##.##");
        return String.format("%s[%s, %s, %s, %d]", super.animalType, super.animalName,
                weight.format(super.animalWeight), this.getLivingRegion(),
                super.getFoodEaten());
    }
}
