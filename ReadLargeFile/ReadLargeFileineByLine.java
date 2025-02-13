package Day3.ReadLargeFile;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadLargeFileineByLine{

    public static void checkErrorLines(String filePath) {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                if (line.toLowerCase().contains("error")) {
                    System.out.println(line);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading the file: " + e.getMessage());
        }
    }

    public static void main(String[] args) {
        String filePath = "input.txt";
        System.out.println("Success");
        checkErrorLines(filePath);
    }
}