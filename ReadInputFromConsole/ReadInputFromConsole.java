package Day3.ReadInputFromConsole;

import java.io.*;

public class ReadInputFromConsole {
    public static void main(String[] args) {
        try(BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            FileWriter fw = new FileWriter("output.txt")){
            int b ;
            while((b= br.read())!=-1){
                fw.write((char)b);
            }
            System.out.println("File wrote successfully");

        }catch(FileNotFoundException f){
            System.out.println("Error: File does not exist! Please create one");
        }
        catch (IOException e) {
            e.printStackTrace();
        }
    }
}
