package Day2.ListInterface;

import java.util.*;

public class FrequencyCounting {
    public static void findFrequency(List<String> list){
        HashMap<String,Integer> map = new HashMap<>();
        for(int i=0; i<list.size(); i++){
            if(!map.containsKey(list.get(i))){
                map.put(list.get(i),1);
            }
            else{
                map.put( list.get(i), map.get(list.get(i))+1);
            }
        }
        System.out.println("Frequency of elemnets in list :" + map);
    }
    public static void main(String[] args) {
        List<String> list = new ArrayList<>(Arrays.asList("Apple","Banana","Apple","Orange","Orange","Banana"));
        findFrequency(list);
    }
}
