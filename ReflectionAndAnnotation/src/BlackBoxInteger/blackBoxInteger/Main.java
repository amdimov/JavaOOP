package BlackBoxInteger.blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("_");
        Class blackBoxIntClass = BlackBoxInt.class;
        int value;
        try {
            @SuppressWarnings("unchecked")
            Constructor constructor = blackBoxIntClass.getDeclaredConstructor();
            constructor.setAccessible(true);
            BlackBoxInt blackBoxInt = (BlackBoxInt) constructor.newInstance();
            while (!input[0].equalsIgnoreCase("END")) {
                if (input[0].equals("add")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                } else if (input[0].equalsIgnoreCase("subtract")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                } else if (input[0].equalsIgnoreCase("divide")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                } else if (input[0].equalsIgnoreCase("multiply")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                } else if (input[0].equalsIgnoreCase("leftShift")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                } else if (input[0].equalsIgnoreCase("rightShift")) {
                    invokeMethod(input, blackBoxIntClass, blackBoxInt);
                }
                Field innerValue = blackBoxIntClass.getDeclaredField("innerValue");
                innerValue.setAccessible(true);
                value = (int) innerValue.get(blackBoxInt);
                System.out.println(value);
                input = scanner.nextLine().split("_");
            }
        } catch (NoSuchMethodException | InvocationTargetException | InstantiationException | IllegalAccessException | NoSuchFieldException e) {
            e.printStackTrace();
        }
    }
    public static void invokeMethod(String[] input, Class clazz, Object object) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        @SuppressWarnings("unchecked")
        Method add = clazz.getDeclaredMethod(input[0], int.class);
        add.setAccessible(true);
        add.invoke(object, Integer.parseInt(input[1]));
    }
}
