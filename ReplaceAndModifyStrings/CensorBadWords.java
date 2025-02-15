package Day5.ReplaceAndModifyStrings;
import java.util.Scanner;

public class CensorBadWords {
    public static void main(String[] args) {
        Scanner cs = new Scanner(System.in);
        System.out.println("Enter a text");
        String input = cs.nextLine();
        String[] badWords = {"damn", "stupid" };
        for(String s: badWords){
            input = input.replaceAll("(?i)\\b" + s + "\\b","****");
        }
        System.out.println(input);
    }
}
