package Day2.ListInterface;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class RotateElements {
    public static void rotateElements(List<Integer>list, int k){
        if(k>list.size()|| k<0){
            System.out.println("Rotation not possible");
            return;
        }
        int n = list.size();
        int index = k%n;
        for(int i=0; i<index; i++){
            int temp = list.get(list.size()-1);
           for(int j=list.size()-1; j>0;j--){
               list.set(j, list.get(j-1));
           }
           list.set(0,temp);
        }
        System.out.println("Roatated Elements of list by " + k + " places is :" + list);
    }
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>(Arrays.asList(10,20,30,40,50));
        int k =3;
        rotateElements(list,k);

    }
}
