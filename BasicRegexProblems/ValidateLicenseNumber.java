package Day5.BasicRegexProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateLicenseNumber {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[A-Z]{2}[0-9]{4}");
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a license number");
        String input = cs.next();
        Matcher m = p.matcher(input);
        boolean matches = m.matches();
        if(matches){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid, Try again!user");
        }
    }
}
