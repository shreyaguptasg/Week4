package Reflection.BasicProblems;
import java.lang.reflect.Method;

public class InvokePrivateMethod {

    // Calculator class with a private multiply method
    static class Calculator {

        // Private method multiply
        private int multiply(int a, int b) {
            return a * b;
        }
    }

    public static void main(String[] args) {
        try {
            // Create an instance of the Calculator class
            Calculator calculator = new Calculator();

            // Get the 'multiply' method from the Calculator class using reflection
            Method multiplyMethod = Calculator.class.getDeclaredMethod("multiply", int.class, int.class);

            // Make the private method accessible
            multiplyMethod.setAccessible(true);

            // Invoke the private multiply method with parameters (5, 10)
            int result = (int) multiplyMethod.invoke(calculator, 5, 10);

            // Print the result
            System.out.println("Multiplication Result: " + result);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

