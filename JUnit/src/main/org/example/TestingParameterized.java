package org.example;

public class TestingParameterized {
    public static boolean isEven2(int number){
       return number%2==0;
    }
    public static void main(String[] args) {
        boolean ans = isEven2(2);
        if(ans){
            System.out.println("Number is even");
        }
        else{
            System.out.println("Number is not even");
        }
    }
}
