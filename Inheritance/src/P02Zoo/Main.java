package P02Zoo;

import P02Zoo.zoo.Animal;
import P02Zoo.zoo.Mammal;
import P02Zoo.zoo.Snake;

import java.util.*;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Animal snake = new Snake(scanner.nextLine());
        System.out.println(snake.getName());
        List<String> list = new ArrayList<>();


    }
}
