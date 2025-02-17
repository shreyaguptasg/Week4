package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListOperations {
    public static void addElement(List<Integer> list, int element){
        list.add(element);
    }
    public static void removeElemnet(List<Integer>list, int elemenet){
        list.remove(elemenet);
    }
    public static int getSize(List<Integer> list){
        return list.size();
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(1,2,3,4));
        addElement(list,5);
        System.out.println("List after adding elements " + list);
        removeElemnet(list,2);
        System.out.println("List after removing elements " + list);
        System.out.println(getSize(list));

    }
}
