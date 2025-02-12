package Day2.SetInterface;

import java.util.Arrays;
import java.util.HashSet;

public class FindSubsets {
    public static boolean findSubsets(HashSet<Integer> set, HashSet<Integer>set1){
        for(Integer num : set1){
            if(set.contains(num)){
                return true;
            }
        }
        return false;
    }
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,4));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(10,9));
        boolean ans = findSubsets(set1, set2);
        System.out.println("One set is subset of another set :" + ans);


    }
}
