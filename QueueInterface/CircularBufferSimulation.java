package Day2.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;

class CircularQueue{
   private Queue<Integer>q ;
   private int capacity;

   CircularQueue(int capacity){
       this.q= new LinkedList<>();
       this.capacity=capacity;
   }

   public void add(int data){
       if(q.size()==capacity){
            q.remove();
       }
       q.add(data);

   }

   public int remove(){
       if(q.isEmpty()) return -1;
       return q.remove();
   }

   public int peek(){
       if(q.isEmpty()) return -1;
       return q.peek();
   }

   public int size(){
      return q.size();
   }
   public boolean isEmpty(){
       return q.isEmpty();
   }
}
public class CircularBufferSimulation {
    public static void main(String[] args) {
        CircularQueue cq= new CircularQueue(3);
        cq.add(1);
        cq.add(2);
        cq.add(3);
        cq.add(4);
        cq.add(5);
        while(!cq.isEmpty()){
            System.out.println(cq.remove());

        }
    }
}
