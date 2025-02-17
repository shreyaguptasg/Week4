package org.example;

public class TestingExceptionHandling {
    public static int divide(int number1,int number2){
        int res =0;
       if(number2==0){
           throw new ArithmeticException("divide by zero");
       }
       res= number1/number2;
       return res;
    }
    public static void main(String[] args) {
        int ans = divide(2,0);
        System.out.println(ans);
    }
}
