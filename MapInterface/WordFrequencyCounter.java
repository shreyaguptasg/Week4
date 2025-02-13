package Day2.MapInterface;
import java.util.HashMap;
import java.util.Map;

public class WordFrequencyCounter {
    public static void main(String[] args) {
        String str = "Hello world, hello java";
        str = str.toLowerCase();
        String [] strArray = str.replaceAll("[^a-zA-Z0-9\\s]","").split("\\s+");
        Map<String, Integer> map = new HashMap<>();
        for(String s: strArray){
            if(!map.containsKey(s)){
                map.put(s, 1);
            }
            else{
                map.put(s, map.get(s)+1);
            }
        }

        System.out.println(map);



    }
}
