package jediGalaxy;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

            int[] dimestions = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
            int x = dimestions[0];
            int y = dimestions[1];
            Galaxy galaxy = new Galaxy(x, y);

            String command = scanner.nextLine();
            long sum = 0;
            while (!command.equals("Let the Force be with you"))
            {
                int[] ivoS = Arrays.stream(command.split(" ")).mapToInt(Integer::parseInt).toArray();
                int[] evil = Arrays.stream(scanner.nextLine().split(" ")).mapToInt(Integer::parseInt).toArray();
                Player playerEvil = new Player(evil[0], evil[1]);
                while (playerEvil.getPlayerPositionX() >= 0 && playerEvil.getPlayerPositionY() >= 0)
                {
                    if (playerEvil.ifPlayerInGalaxy(galaxy.getMatrix()))
                    {
                        galaxy.evilStarsDestroy(playerEvil.getPlayerPositionX(), playerEvil.getPlayerPositionY());
                    }
                    playerEvil.movePositionX(false);
                    playerEvil.movePositionY(false);
                }

                Player playerIvo = new Player(ivoS[0], ivoS[1]);
                while (playerIvo.getPlayerPositionX() >= 0 && playerIvo.getPlayerPositionY() < galaxy.getMatrix()[1].length)
                {
                    if (playerIvo.ifPlayerInGalaxy(galaxy.getMatrix()))
                    {
                        sum += galaxy.starValue(playerIvo.getPlayerPositionX(), playerIvo.getPlayerPositionY());
                    }

                    playerIvo.movePositionY(true);
                    playerIvo.movePositionX(false);
                }

                command = scanner.nextLine();
            }

        System.out.println(sum);
    }

}
