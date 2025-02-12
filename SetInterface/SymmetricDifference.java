package Day2.SetInterface;

import java.util.Arrays;
import java.util.HashSet;

public class SymmetricDifference {
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>(Arrays.asList(1,2,3,7,9));
        HashSet<Integer> set2 = new HashSet<>(Arrays.asList(3,4,5));
        HashSet<Integer> differnce = new HashSet<>();
        for(Integer num : set1){
            if(!set2.contains(num)){
                differnce.add(num);
            }
        }
        for(Integer num : set2){
            if(!set1.contains(num)){
                differnce.add(num);
            }
        }
        System.out.println("Symmetric differnec of sets is :" + differnce);
    }
}
