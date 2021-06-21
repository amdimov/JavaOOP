package P03WildFarm;

import java.text.DecimalFormat;

public class Cat extends Feline{
    private String breed;
    public Cat(String animalName, String animalType, Double animalWeight,
               String livingRegion, String breed) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.breed = breed;
    }

    public String getBreed() {
        return breed;
    }

    @Override
    public String toString() {
       DecimalFormat weight = new DecimalFormat("##.##");
       return String.format("%s[%s, %s, %s, %s, %d]", super.animalType, super.animalName, this.getBreed(),
                weight.format(super.animalWeight), super.getLivingRegion(),
                super.getFoodEaten());
    }



}
