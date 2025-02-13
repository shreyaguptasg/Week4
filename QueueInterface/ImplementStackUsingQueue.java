package Day2.QueueInterface;

import java.util.LinkedList;
import java.util.Queue;
class Stack{
    Queue<Integer> q1 = new LinkedList<>();
   public void push(int data){
       q1.add(data);
       for(int i=0;i<q1.size()-1; i++){
           q1.add(q1.remove());
       }
   }
   public int pop() {
       if (q1.isEmpty()) {
           return -1;
       }
       return q1.remove();
   }

   public int peek(){
       if(q1.isEmpty()) return -1;
       return q1.peek();
   }
}
public class ImplementStackUsingQueue {
    public static void main(String[] args) {
        Stack s= new Stack();
        s.push(1);
        s.push(2);
        s.push(3);
        System.out.println("Stack  poped element is :"+  s.pop());




    }
}
