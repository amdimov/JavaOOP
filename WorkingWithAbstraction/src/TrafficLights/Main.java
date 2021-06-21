package TrafficLights;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] lights = scanner.nextLine().toUpperCase().split("\\s+");
        int n = Integer.parseInt(scanner.nextLine());

        StringBuilder lightBuilder;
        for (int i = 0; i < n; i++) {
            lightBuilder = new StringBuilder();
            for (int j = 0; j < lights.length; j++) {
                processLight(lights, lightBuilder, j);
            }
            System.out.println(lightBuilder);
        }
    }
    public static void processLight(String[] lights, StringBuilder lightBuilder, int index){
        TrafficLights currentLight = TrafficLights.valueOf(lights[index]);
        lights[index] = currentLight.getNextLight(currentLight).toString();
        lightBuilder.append(lights[index]);
        lightBuilder.append(" ");
    }
}
