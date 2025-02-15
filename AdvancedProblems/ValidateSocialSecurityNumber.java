package Day5.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateSocialSecurityNumber {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\b\\d{3}\\-\\d{2}\\-\\d{4}\\b");
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a text");
        String input = cs.nextLine();
        Matcher m = p.matcher(input);
        if(m.matches()){
            System.out.println("Valid ");
        }
        else{
            System.out.println("Invalid");
        }
    }
}
