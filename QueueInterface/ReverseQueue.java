package Day2.QueueInterface;

import java.util.*;

public class ReverseQueue {
    public static void main(String[] args) {
        Deque<Integer> deque= new ArrayDeque<>(Arrays.asList(10,20,30));
        Queue<Integer> queue = new ArrayDeque<>();
        while(!deque.isEmpty()){
            queue.add(deque.pollLast());
        }
        System.out.print("Reversed queue is : ");
        while(!queue.isEmpty()){
            System.out.print(queue.poll()+ " ");
        }



    }
}
