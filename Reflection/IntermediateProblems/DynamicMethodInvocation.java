package DynamicMethodInvocation;


import java.lang.reflect.Method;
import java.util.Scanner;

public class DynamicMethodInvocation {

        // MathOperations class with multiple public methods
        static class MathOperations {

            // Method to add two numbers
            public int add(int a, int b) {
                return a + b;
            }

            // Method to subtract two numbers
            public int subtract(int a, int b) {
                return a - b;
            }

            // Method to multiply two numbers
            public int multiply(int a, int b) {
                return a * b;
            }
        }

        public static void main(String[] args) {
            try {
                // Create a scanner object to take user input
                Scanner scanner = new Scanner(System.in);

                // Get user input for the operation
                System.out.println("Enter the operation (add, subtract, multiply): ");
                String operation = scanner.nextLine().toLowerCase();

                // Get user input for the two numbers
                System.out.println("Enter first number: ");
                int num1 = scanner.nextInt();
                System.out.println("Enter second number: ");
                int num2 = scanner.nextInt();

                // Get the MathOperations class and create an object
                Class<?> mathOpsClass = Class.forName("ReflectionExample$MathOperations");
                Object mathOpsObj = mathOpsClass.getDeclaredConstructor().newInstance();

                // Dynamically find and invoke the method based on user input
                Method method = mathOpsClass.getMethod(operation, int.class, int.class);

                // Invoke the method and print the result
                int result = (int) method.invoke(mathOpsObj, num1, num2);
                System.out.println("Result of " + operation + ": " + result);

            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
