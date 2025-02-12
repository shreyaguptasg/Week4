package Day2.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public class ReverseList {
    public static  void reverseList(List<Integer> list){
        int j = list.size()-1;
        for(int i =0;i<j; i++ ){
            list.add(i,list.remove(j));
        }
        System.out.println("Reversed list from arraylist :" + list);
    }

    public static void reverseByLinkedList(LinkedList<Integer> list){
        for(int i=0; i<list.size()/2; i++){
            int temp = list.get(i);
            list.set(i, list.get(list.size()-i-1));
            list.set(list.size()-i-1, temp);

        }
        System.out.println("Reverse List through LinkedList :" + list);

    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4,5,67,7));
        reverseList(list);
        LinkedList<Integer> list2 = new LinkedList<>();
        list2.add(2);
        list.add(3);
        list2.add(4);
        list.add(6);
        list2.add(8);
        list.add(10);
        reverseList(list);



    }
}
