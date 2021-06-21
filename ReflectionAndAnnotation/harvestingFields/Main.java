package harvestingFields;

import java.lang.module.ModuleFinder;
import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		String command = scanner.nextLine();
		Field[] declaredFields = RichSoilLand.class.getDeclaredFields();

		while (!command.equalsIgnoreCase("HARVEST")){
			final String finalCommand = command;
			if (!command.equalsIgnoreCase("all")){
				Field[] fields = Arrays.stream(declaredFields).filter(e -> Modifier.toString(e.getModifiers()).equals(finalCommand))
						.toArray(Field[]::new);
				printFields(fields);
			}else {
				printFields(declaredFields);
			}
			command = scanner.nextLine();
		}
	}
	private static void printFields(Field[] fields){
		Arrays.stream(fields)
				.forEach(e -> System.out.printf("%s %s %s%n",
						Modifier.toString(e.getModifiers()),
						e.getType().getSimpleName(),
						e.getName()));
	}
}
