package org.example;

public class Calculator {
    public int add(int number1, int number2){
        return number1+number2;
    }
    public int subtract(int number1, int number2){
        return number1-number2;
    }
    public int multiply(int number1, int number2){
        return number1*number2;
    }
    public int divide(int number1, int number2){
        if(number2==0)
            throw new ArithmeticException("divide by zero");

        return number1/number2;
    }
    public static void main(String[] args) {
        Calculator c = new Calculator();
        System.out.println(c.add(12,3));
        System.out.println(c.subtract(12,3));
        System.out.println(c.divide(6,0));
        System.out.println(c.multiply(2,3));
    }
}