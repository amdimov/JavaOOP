package P03ShoppingSpree;

import java.util.stream.Collectors;

public class Product {
    private String name;
    private double cost;

    public Product(String name, double cost){
        setCost(cost);
        setName(name);
    }
    private void setCost(double cost){
        if (cost < 0){
            throw new IllegalStateException("Money cannot be negative");
        }
        else{
            this.cost = cost;
        }
    }
    private void setName(String name) {
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name;
    }
    public String getName() {
        return name;
    }
    public double getCost() {
        return cost;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
