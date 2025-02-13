package Day2.MapInterface;

import java.util.HashMap;
import java.util.Map;

public class FindKeysHighestValue{
    public static void main(String[] args) {
        Map<String,Integer> map = new HashMap<>();
        map.put("A",10);
        map.put("B",20);
        map.put("C",15);
        int max= Integer.MIN_VALUE;
        for(Map.Entry<String,Integer> m: map.entrySet()) {
            if (m.getValue() > max) {
                max = m.getValue();
            }
        }
       for(Map.Entry<String,Integer> s: map.entrySet()){
           if(max == s.getValue()){
               System.out.println("Element with highest value is : " + s.getKey());
           }
       }
    }
}
