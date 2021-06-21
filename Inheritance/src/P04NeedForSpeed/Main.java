package P04NeedForSpeed;

public class Main {
    public static void main(String[] args) {
        Car motorcycle = new Car(30, 150);
        motorcycle.drive(10);
        System.out.println(motorcycle.getFuel());
        System.out.println(motorcycle.getFuelConsumption());
    }
}
