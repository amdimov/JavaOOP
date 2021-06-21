package P03ShoppingSpree;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Person {
    private String name;
    private double money;
    private List<Product> products;

    public Person(String name, double money) {
        setName(name);
        setMoney(money);
        this.products = new ArrayList<>();
    }

    private void setName(String name) {
        name = name.replaceAll("\\s+", "");
        if (name.isEmpty()){
            throw new IllegalStateException("Name cannot be empty");
        }
        this.name = name.trim();
    }

    private void setMoney(double money) {
        if (money < 0){
            throw new IllegalStateException("Money cannot be negative");
        }
        else{
            this.money = money;
        }

    }
    public void buyProduct(Product product){
        if (product.getCost() <= this.money){
            this.products.add(product);
            this.money -= product.getCost();
            System.out.printf("%s bought %s%n", this.name, product.getName());
        }else {
            String e = String.format("%s can't afford %s%n", this.name, product.getName());
            throw new IllegalArgumentException(e);
        }
    }
    public String getName() {
        return this.name;
    }

    public List<Product> getProducts() {
        return Collections.unmodifiableList(products);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(this.name + " - ");
        if (products.isEmpty()){
            stringBuilder.append("Nothing bought");
            return stringBuilder.toString();
        }
        for (int i = 0; i < products.size(); i++) {
            if (i < products.size()-1){
                stringBuilder.append(products.get(i).getName()).append(", ");
            }else {
                stringBuilder.append(products.get(i).getName());
            }
        }
        return stringBuilder.toString();
    }
}
