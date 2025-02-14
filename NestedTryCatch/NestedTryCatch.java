package Day4.NestedTryCatch;

import java.util.Arrays;
import java.util.Scanner;

public class NestedTryCatch {
    public static void divideArrayElements(int[] arr, int divisor,int ind){
        try{
            int index=0;
             try{
                  index = arr[ind];
                 int res = index/divisor;
                 System.out.println(res);
             }
             catch (ArrayIndexOutOfBoundsException e){
                 System.out.println("Invalid Array Index");
             }
        }
        catch (ArithmeticException e){
            System.out.println("Exception: Cannot divide by zero");
        }
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the array size");
        int n = sc.nextInt();
        System.out.println("Enter array elements");
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i]= sc.nextInt();
        }
        System.out.println("Enter the divisor");
        int divisor = sc.nextInt();
        System.out.println("Index element you want to divide");
        int index = sc.nextInt();
        divideArrayElements(arr,divisor,index);
    }
}
