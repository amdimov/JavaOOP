package P04PizzaCalories;

public class Topping {
    private final static double MEAT_CALORIES = 1.2;
    private final static double VEGGIES_CALORIES = 0.8;
    private final static double CHEESE_CALORIES = 1.1;
    private final static double SAUCE_CALORIES = 0.9;

    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        this.setToppingType(toppingType);
        this.setWeight(weight);
    }

    private void setToppingType(String toppingType) {
        switch (toppingType) {
            case "Meat":
                this.toppingType = toppingType;
                break;
            case "Veggies":
                this.toppingType = toppingType;
                break;
            case "Cheese":
                this.toppingType = toppingType;
                break;
            case "Sauce":
                this.toppingType = toppingType;
                break;

            default:
                validateToppings(toppingType);
                break;
        }
    }

    private String getToppingType() {
        return this.toppingType;
    }

    private void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            validateWeight(this.toppingType);
        }

        this.weight = weight;
    }

    public double calculateCalories() {
        return (this.weight * 2) * toppingModifiers(this.getToppingType());
    }

    private double toppingModifiers(String toppingType) {
        double toppingModifier = 0d;
        switch (toppingType) {
            case "Meat":
                toppingModifier = MEAT_CALORIES;
                break;
            case "Veggies":
                toppingModifier = VEGGIES_CALORIES;
                break;
            case "Cheese":
                toppingModifier = CHEESE_CALORIES;
                break;
            case "Sauce":
                toppingModifier = SAUCE_CALORIES;
                break;
        }
        return toppingModifier;
    }

    private void validateToppings(String input) {
        throw new IllegalArgumentException(String.format(
                "Cannot place %s on top of your pizza.",
                input));
    }

    private void validateWeight(String toppingType) {
        throw new IllegalArgumentException(String.format(
                "%s weight should be in the range [1..50].",
                toppingType));
    }
}
