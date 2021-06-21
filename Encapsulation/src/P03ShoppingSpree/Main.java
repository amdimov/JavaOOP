package P03ShoppingSpree;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] people = scanner.nextLine().split(";");
        String[] products = scanner.nextLine().split(";");

        HashSet<Person> personList = new LinkedHashSet<>(List.of(splitter(Person.class, people)));
        HashSet<Product> productList = new HashSet<>(List.of(splitter(Product.class, products)));

        String[] purchase = scanner.nextLine().split("\\s+");
        while (!purchase[0].equals("END")){
            //TODO: Problems - getPerson & getProduct are too expensive. Other solution with Map
            Person person = getPerson(personList, purchase[0]);
            Product product = getProduct(productList, purchase[1]);
            person.buyProduct(product);
            purchase = scanner.nextLine().split("\\s+");
        }

        for (Person person : personList) {
            System.out.println(person);
        }

    }
    private static <T> T[] splitter(Class<T> clazz, String[] input){
        @SuppressWarnings("unchecked")
        T[] persons = (T[])Array.newInstance(clazz,input.length);
        for (int i = 0; i < input.length; i++) {
            String[] splitter = input[i].split("=");
            String name = splitter[0];
            String money = splitter[1];
            if (clazz == Person.class) {
                persons[i] = (T) new Person(name, Double.parseDouble(money));
            }
            if(clazz == Product.class) {
                persons[i] = (T) new Product(name, Double.parseDouble(money));
            }
        }
        return persons;
    }
    private static Product getProduct(HashSet<Product> products, String name){
//        for (Product product : products) {
//            if (product.getName().equals(name)){
//                return product;
//            }
//        }
//        return null;
        return products.stream().filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }
    private static Person getPerson(HashSet<Person> personList, String name){
        return personList.stream().filter(e -> e.getName().equals(name)).findAny().orElse(null);
    }

}
