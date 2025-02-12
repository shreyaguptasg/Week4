package Day2.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

public class GenearateBinaryNumber {
    public static void main(String[] args) {
        Queue<String> queue = new LinkedList<>();
        int n = 3;
        System.out.println("Binary NUmbers till " + n + " is : ");
        queue.add("1");
        while(n-->0){
            String s1 = queue.peek();
            queue.remove();
            System.out.println(s1);
            String s2 = s1;
            queue.add(s1 + "0");
            queue.add(s2 + "1");
        }



    }
}
