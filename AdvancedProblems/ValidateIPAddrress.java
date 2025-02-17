package Day5.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateIPAddrress {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                        + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                        + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\."
                        + "(25[0-5]|2[0-4][0-9]|1?[0-9][0-9]?)\\b");
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a text");
        String input = cs.nextLine();
        Matcher m = p.matcher(input);
       if(m.matches()){
           System.out.println("Valid IP4 address");
       }
       else{
           System.out.println("Invalid IP4 address");
       }
    }
}
