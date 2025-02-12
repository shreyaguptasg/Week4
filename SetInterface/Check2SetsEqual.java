package Day2.SetInterface;

import java.util.HashSet;

public class Check2SetsEqual {
    public static boolean check2SetsEqual(HashSet<Integer> set, HashSet<Integer>set1){
        //return set.equals(set1);
        if(set.size()!= set1.size()) return false;
        for(Integer num: set){
            if(!set1.contains(num)){
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        HashSet<Integer> set1 = new HashSet<>();
        set1.add(1);
        set1.add(2);
        set1.add(3);
        HashSet<Integer> set2 = new HashSet<>();
        set2.add(3);
        set2.add(2);
        set2.add(1);
       boolean ans= check2SetsEqual(set1,set2);
        System.out.println(ans);
    }
}
