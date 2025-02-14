package Day4.ThrowVsThrows;

import java.util.Scanner;

public class ThrowVsThrows  {
    public static double calculateInterest(double amount, double rate, double years){
        if(amount<=0 || rate<=0) {
            throw new IllegalArgumentException("Invalid input: Amount and rate must be positive");
        }
        else{
            return (amount*rate*years)/100;
        }
    }

    public static void main(String[] args) throws IllegalArgumentException{
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter amount");
        double amt = sc.nextDouble();
        System.out.println("Enter rate");
        double rate = sc.nextDouble();
        System.out.println("Enter years");
        double years = sc.nextDouble();
        System.out.println("Interest :" + calculateInterest(amt,rate,years));
        
    }
}
