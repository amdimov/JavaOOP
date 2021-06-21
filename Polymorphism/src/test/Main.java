package test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        printArea((a, b) -> a * b, 5, 5);
    }
    private static int add(int a, int b){
        return a+b;
    }
    private static int add(int a, int b, int c){
        return add(add(a, b), c);
    }
    private static void printArea(Shape shape, int a, int b){
        System.out.println(shape.area(a, b));
    }
}
