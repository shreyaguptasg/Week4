package Day5.AdvancedProblems;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ExtractCureencyValue {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("\\$\\d+(\\.\\d{2})?| \\b\\d+\\.\\d{2}\\b");
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a text");
        String input = cs.nextLine();
        Matcher m = p.matcher(input);
        while(m.find()){
            System.out.println("Matches : " + m.group());
        }
    }
}
