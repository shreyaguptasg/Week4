package Day2.MapInterface;

import java.util.HashMap;
import java.util.Map;

public class MergeTwoMaps {
    public static void main(String[] args) {
        Map<String,Integer> map1 = new HashMap<>();
        map1.put("A",1);
        map1.put("B",2);

        Map<String,Integer> map2 = new HashMap<>();
        map2.put("B",3);
        map2.put("C",2);

        Map<String,Integer> result = new HashMap<>();
        result.putAll(map1);
        for(Map.Entry<String,Integer> s: map2.entrySet()){
            String str = s.getKey();
            int value = s.getValue();
            if(result.containsKey(str)){
                result.put(str, value+result.get(str));
            }
            else{
                result.put(str,value);
            }
        }

        System.out.println(result);


    }
}
