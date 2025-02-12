package Day2.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RemoveDuplicatesByPresevingOrder {
    public static void removeDuplicate(List<Integer>list){
        for(int i=0; i<list.size(); i++){
            for(int j =i+1; j<list.size(); j++){
                if(list.get(i)==list.get(j)){
                    list.remove(j);
                }
            }
        }
        System.out.println("Removed duplicates from list : " + list);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(3,1,2,2,3,4,6,8,8));
        removeDuplicate(list);


    }
}
