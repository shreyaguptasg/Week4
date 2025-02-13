package Day3.CountWordsinFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;

class MyComparator implements Comparator<Map.Entry<String, Integer>> {
    @Override
    public int compare(Map.Entry<String, Integer> entry1, Map.Entry<String, Integer> entry2) {
        return entry2.getValue().compareTo(entry1.getValue()); // Descending order
    }
}

public class CountWords {

    public static void readFile(String filePath) {
        HashMap<String, Integer> wordCount = new HashMap<>();

        try(
                BufferedReader br = new BufferedReader(new FileReader(filePath));
        ) {
            String line;
            while((line = br.readLine()) != null) {
                for(String word: line.toLowerCase().split("\\W+")) {
                    wordCount.put(word, wordCount.getOrDefault(word, 0) + 1);
                }
            }

            List<Map.Entry<String, Integer>> sortedWords = new ArrayList<>(wordCount.entrySet());

            Collections.sort(sortedWords, new MyComparator());

            System.out.println("Top 5 most frequent words:");
            int count = 0;
            for (Map.Entry<String, Integer> entry : sortedWords) {
                System.out.println(entry.getKey() + " : " + entry.getValue());
                if (++count == 5) break;
            }
        } catch (IOException e) {
            System.out.println("Invalid");
        }
    }
    public static void main(String[] args) {
        String filePath = "input.txt";

        readFile(filePath);
    }
}
