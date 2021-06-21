package P04PizzaCalories;

public class Dough {
    private final static double WHITE_DEFAULT_CALORIES = 1.5;
    private final static double WHOLEGRAIN_DEFAULT_CALORIES = 1.0;
    private final static double CRISPY_DEFAULT_CALORIES = 0.9;
    private final static double CHEWY_DEFAULT_CALORIES = 1.1;
    private final static double HOMEMADE_DEFAULT_CALORIES = 1.0;

    private String flourType;
    private String bakingTechnique;
    private double weight;
    private double typeModifier;
    private double techniqueModifier;

    public Dough(String flourType, String bakingTechnique, double weight) {
        this.setFlourType(flourType);
        this.setBakingTechnique(bakingTechnique);
        this.setWeight(weight);
    }

    private void setFlourType(String flourType) {
        switch (flourType) {
            case "White":
                typeModifier = WHITE_DEFAULT_CALORIES;
                break;
            case "Wholegrain":
                typeModifier = WHOLEGRAIN_DEFAULT_CALORIES;
                break;
            default:
                validateFlourType();
                break;

        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        switch (bakingTechnique) {
            case "Crispy":
                techniqueModifier = CRISPY_DEFAULT_CALORIES;
                break;
            case "Chewy":
                techniqueModifier = CHEWY_DEFAULT_CALORIES;
                break;
            case "Homemade":
                techniqueModifier = HOMEMADE_DEFAULT_CALORIES;
                break;
            default:
                validateFlourType();
        }

        this.bakingTechnique = bakingTechnique;

    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            validateDoughWeight();
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        double calories = (this.getWeight() * 2);

        calories *= this.typeModifier;
        calories *= this.techniqueModifier;

        return calories;
    }

    private double getWeight() {
        return this.weight;
    }

    private void validateDoughWeight() {
        throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
    }

    private void validateFlourType() {
        throw new IllegalArgumentException("Invalid type of dough.");
    }


}
