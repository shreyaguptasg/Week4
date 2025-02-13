package Day3.FliterStreams;

import java.io.*;
import java.nio.charset.StandardCharsets;

public class ConvertUpperCaseToLowerCase {
    public static void main(String[] args) {
       try(
        FileReader fr = new FileReader("input.txt", StandardCharsets.UTF_8);
        BufferedReader br = new BufferedReader(fr);
        FileWriter fw = new FileWriter("output.txt", StandardCharsets.UTF_8);
        BufferedWriter bw = new BufferedWriter(fw)){
            String line;
            while((line = br.readLine())!=null){
                bw.write(line.toLowerCase());
                bw.newLine();
            }
           System.out.println("File conversion successfull");
       }
       catch(IOException e){
           e.printStackTrace();
       }


    }
}
