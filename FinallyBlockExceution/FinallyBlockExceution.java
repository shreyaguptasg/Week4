package Day4.FinallyBlockExceution;

import java.util.InputMismatchException;
import java.util.Scanner;

public class FinallyBlockExceution {
    public static void divide(int number1, int number2){
        int result=0;
        try{
            if(number1<0 || number2<0){
                throw new InputMismatchException("Exception : user enters non-numeric value");
            }
            result = number1/number2;
            System.out.println("Result of division is : " + result);
        }
        catch (ArithmeticException e){
            System.out.println("ArithmeticException division by zero occurs");
        } catch (InputMismatchException e1) {
            System.out.println(e1.getMessage());
        }
        finally{
            System.out.println("Operation completed");
        }

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the  first number");
        int number1 = sc.nextInt();
        System.out.println("Enter the second number");
        int number2 = sc.nextInt();
       divide(number1,number2);
    }
}
