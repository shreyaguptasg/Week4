package Day2.ListInterface;

import java.util.LinkedList;
import java.util.ListIterator;

public class NthElementFromEnd {
    public static  void findNthFromEnd(LinkedList<Character> list , int k){
        if(list == null || k<=0){
            System.out.println("Invalid Input");
            return;
        }
        ListIterator<Character> first = list.listIterator();
        ListIterator<Character> second = list.listIterator();

        for(int i=0; i<k; i++){
            if(!first.hasNext()) return;
            first.next();
        }
        while(first.hasNext()){
            first.next();
            second.next();
        }
        System.out.println(k + " element from the end is : " + second.next());
    }
    public static void main(String[] args) {
        LinkedList<Character> list = new LinkedList<>();
        list.add('A');
        list.add('B');
        list.add('C');
        list.add('D');
        list.add('E');
        int k =2;
        findNthFromEnd(list,k);


    }
}
