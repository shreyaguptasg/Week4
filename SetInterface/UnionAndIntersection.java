package Day2.SetInterface;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class UnionAndIntersection {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));
        HashSet<Integer> unionSet = new HashSet<>();
        HashSet<Integer> intersectionSet = new HashSet<>();
        unionSet.addAll(set1);
        unionSet.addAll(set2);
        System.out.println("Union of sets is : " + unionSet);
        for(Integer num : set2){
            if(set1.contains(num)){
                intersectionSet.add(num);
            }
        }
        System.out.println("Intersection of sets is : " + intersectionSet);




    }
}
