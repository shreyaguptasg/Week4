package Day4.ExceptionPropagationMethods;

import java.util.Scanner;

public class ExceptionPropagationMethods {
    public static int method1(int number1, int number2){
        System.out.println("Method1 called");
        return number1/number2;
    }
    public static int method2(int number1, int number2){
        System.out.println("Method2 called");
        return method1(number1,number2);
    }
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        try{
            System.out.println("Division of numbers is : " + method2(cs.nextInt(), cs.nextInt()));
        }
        catch (ArithmeticException e){
            System.out.println("Cannot divide by zero");
        }
        finally {
            System.out.println("Handled exception in main");
        }
    }
}
