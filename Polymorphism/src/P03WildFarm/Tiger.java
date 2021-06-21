package P03WildFarm;

public class Tiger extends Feline {
    private String livingRegion;
    public Tiger(String animalName, String animalType, Double animalWeight, String livingRegion) {
        super(animalName, animalType, animalWeight, livingRegion);
        this.livingRegion = livingRegion;
    }
    public String getLivingRegion(){
        return this.livingRegion;
    }
}
