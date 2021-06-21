package Test;

import Test.Demo.DemoClass;

import java.lang.reflect.*;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //String findClass = scanner.nextLine();

        try {
            Class newClass = Class.forName("Test.Demo."+"DemoClass");
            Class superclass = newClass.getSuperclass();
            Field[] declaredFields = newClass.getDeclaredFields();
            System.out.println(Modifier.isPublic(declaredFields[0].getModifiers()));
            Set<Field> set = new TreeSet<>(new Comparator<Field>() {
                @Override
                public int compare(Field o1, Field o2) {
                    return o1.getName().compareTo(o2.getName());
                }
            });
            set.addAll(Arrays.asList(declaredFields));
            set.forEach(e -> System.out.println(e.getName()));
            System.out.println("****");
            DemoClass a = new DemoClass("A");
            DemoClass b = new DemoClass("A");
            System.out.println(DemoClass.class == a.getClass());
            System.out.println(a == b);
            if (superclass == Object.class){
                System.out.println("No Superclasses!");

            }else {
                //Field[] declaredSuperFields = superclass.getDeclaredFields();
//                for (Field declaredSuperField : declaredSuperFields) {
//                    System.out.println(declaredSuperField.getName() +" of type *" + declaredSuperField.getType().getSimpleName());
//                }
                String name = "Alex";
                Integer id = 3;
                @SuppressWarnings("unchecked")
                Constructor declaredConstructor = newClass.getDeclaredConstructor(String.class);
                DemoClass test2 = (DemoClass)declaredConstructor.newInstance("ASDW");
                @SuppressWarnings("unchecked")
                DemoClass demoClass = (DemoClass)newClass.getDeclaredConstructor(String.class)
                        .newInstance( "Alex");
                System.out.println(demoClass.getName());
                System.out.println(test2.getName());

            }
//            for (Field declaredField : declaredFields) {
//                System.out.println(declaredField.getName() + " of type *" + declaredField.getType().getSimpleName());
//            }

        } catch (ClassNotFoundException | NoSuchMethodException
                | IllegalAccessException | InstantiationException
                | InvocationTargetException e) {
            System.out.println("Missing class - " + e.getCause());
        }

    }
}
