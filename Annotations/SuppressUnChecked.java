package Annotations;
import java.util.ArrayList;

public class SuppressUnChecked{

    @SuppressWarnings("unchecked") // Suppresses unchecked warnings
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");
        list.add(42);
        list.add(3.14);
        String str = (String) list.get(0);
        System.out.println("First element: " + str);


    }
}

