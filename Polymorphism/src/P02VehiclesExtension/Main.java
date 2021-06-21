package P02VehiclesExtension;

import java.text.DecimalFormat;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] inputCar = scanner.nextLine().split("\\s+");
        String[] inputTruck = scanner.nextLine().split("\\s+");
        String[] inputBus = scanner.nextLine().split("\\s+");
        int N = Integer.parseInt(scanner.nextLine());

        Vehicles[] vehicles = new Vehicles[3];
        vehicles[0] = new Car(Double.parseDouble(inputCar[1]), Double.parseDouble(inputCar[2]), Double.parseDouble(inputCar[3]));
        vehicles[1] = new Truck(Double.parseDouble(inputTruck[1]), Double.parseDouble(inputTruck[2]), Double.parseDouble(inputTruck[3]));
        vehicles[2] = new Bus(Double.parseDouble(inputBus[1]), Double.parseDouble(inputBus[2]), Double.parseDouble(inputBus[3]));
        for (int i = 0; i < N; i++) {
            String[] commandInput = scanner.nextLine().split("\\s+");
            if (commandInput[0].equalsIgnoreCase("Drive")){
                switch (commandInput[1]){
                    case "Car":
                        System.out.println(commandInput[1] + " "+vehicles[0].drive(Double.parseDouble(commandInput[2])));
                        break;
                    case "Truck":
                        System.out.println(commandInput[1] + " "+vehicles[1].drive(Double.parseDouble(commandInput[2])));
                        break;
                    case "Bus":
                        vehicles[2].setFuelConsumption(vehicles[2].getFuelConsumption()+1.4);
                        System.out.println(commandInput[1] + " "+vehicles[2].drive(Double.parseDouble(commandInput[2])));
                }
            }
            if (commandInput[0].equalsIgnoreCase("Refuel")){
                switch (commandInput[1]){
                    case "Car":
                        vehicles[0].refuel(Double.parseDouble(commandInput[2]));
                        break;
                    case "Truck":
                        vehicles[1].refuel(Double.parseDouble(commandInput[2]));
                        break;
                    case "Bus":
                        vehicles[2].refuel(Double.parseDouble(commandInput[2]));
                        break;
                }
            }
            //TODO
            if (commandInput[0].equalsIgnoreCase("DriveEmpty")){
                vehicles[2].setFuelConsumption(vehicles[2].getFuelConsumption());
                System.out.println(commandInput[1] + " "+vehicles[2].drive(Double.parseDouble(commandInput[2])));
            }
        }
        DecimalFormat f = new DecimalFormat("##.00");
        System.out.printf("Car: %s%n", f.format(vehicles[0].getFuelQuantity()));
        System.out.printf("Truck: %s%n", f.format(vehicles[1].getFuelQuantity()));
        System.out.printf("Bus: %s%n", f.format(vehicles[2].getFuelQuantity()));
    }
}
