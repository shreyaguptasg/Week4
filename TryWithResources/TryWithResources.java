package Day4.TryWithResources;

import java.io.*;

public class TryWithResources {
    public static void checkResources(){
        try(BufferedReader br = new BufferedReader(new FileReader("info.txt"))){
            String line;
            while((line = br.readLine())!=null){
                System.out.println(line);
            }
            System.out.println("Successful read");
        }catch(IOException e){
            System.out.println("Error: reading file");
        }
    }
    public static void main(String[] args) {
        checkResources();
    }
}
