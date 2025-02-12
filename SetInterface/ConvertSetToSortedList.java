package Day2.SetInterface;

import java.util.*;

public class ConvertSetToSortedList {
    public static void main(String[] args) {
        HashSet<Integer> set = new HashSet<>(Arrays.asList(11,5,3,9,1));
        TreeSet<Integer> tree = new TreeSet<>();
        tree.addAll(set);
        List<Integer> list = new ArrayList<>();
        list.addAll(tree);
        System.out.println("Sorted list is : " + list);

    }
}
