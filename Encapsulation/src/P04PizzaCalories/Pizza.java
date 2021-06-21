package P04PizzaCalories;

import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        this.setName(name);
        this.setToppings(numberOfToppings);
    }

    private void setName(String name) {
        if (name == null || name.trim().isEmpty()
                || name.length() == 0 || name.length() > 15) {
            validatePizzaName();
        }

        this.name = name;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            validateNumberOfToppings();
        }

        this.toppings = new ArrayList<>(numberOfToppings);
    }

    public void setDough(Dough dough) {
        this.dough = dough;
    }

    public String getName() {
        return this.name;
    }

    public void addTopping(Topping topping) {
        if (this.toppings.size() > 10) {
            validateNumberOfToppings();
        }
        this.toppings.add(topping);
    }

    public double getOverallCalories() {
        double overallCalories = 0d;
        overallCalories += this.dough.calculateCalories();

        overallCalories += this.toppings
                .stream()
                .mapToDouble(Topping::calculateCalories)
                .sum();

        return overallCalories;
    }

    private void validatePizzaName() {
        throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
    }

    private void validateNumberOfToppings() {
        throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
    }
}
