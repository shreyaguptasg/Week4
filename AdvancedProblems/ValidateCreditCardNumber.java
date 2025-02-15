package Day5.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateCreditCardNumber {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b4[0-9]{15}|5[0-9]{15}\\b");
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a text");
        String input = cs.nextLine();
        Matcher m = p.matcher(input);
        boolean matches = m.matches();
       if(matches){
           System.out.println("Valid card number");
       }
       else{
           System.out.println("Invalid card");
       }
    }
}
