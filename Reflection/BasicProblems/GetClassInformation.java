package Reflection.BasicProblems;


import java.lang.reflect.*;
import java.util.Scanner;

    public class GetClassInformation {
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            System.out.print("Enter the fully qualified class name: ");
            String className = scanner.nextLine();
            scanner.close();

            try {
                // Load the class
                Class<?> clazz = Class.forName(className);

                // Display class name
                System.out.println("\nClass: " + clazz.getName());

                // Display constructors
                System.out.println("\nConstructors:");
                Constructor<?>[] constructors = clazz.getConstructors();
                for (Constructor<?> constructor : constructors) {
                    System.out.println("  " + constructor);
                }

                // Display fields
                System.out.println("\nFields:");
                Field[] fields = clazz.getDeclaredFields();
                for (Field field : fields) {
                    System.out.println("  " + field);
                }

                // Display methods
                System.out.println("\nMethods:");
                Method[] methods = clazz.getDeclaredMethods();
                for (Method method : methods) {
                    System.out.println("  " + method);
                }
            } catch (ClassNotFoundException e) {
                System.out.println("Class not found: " + e.getMessage());
            }
        }
    }

