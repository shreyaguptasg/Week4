package Day2.MapInterface;

import java.util.HashMap;
import java.util.Map;

public class InvertMap {
    public static void main(String[] args) {
        Map<String, String> map = new HashMap<>();
        Map<String, String> map1 = new HashMap<>();
        map.put("A","1");
        map.put("B","2");
        map.put("C","1");
        for(Map.Entry<String,String> s: map.entrySet()){
            String value = s.getValue();
            String key = s.getKey();
            if(map1.containsKey(value)){
                map1.put(value, "[" + map1.get(value)+ "," + key + "]");
            }
            else{
                map1.put(value, key );
            }
        }
        System.out.println(map1);
    }
}
