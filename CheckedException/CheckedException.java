package Day4.CheckedException;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class CheckedException {
    public static  void checkFile(){
        try(FileReader fr = new FileReader("data.txt")){
            int line;
            while((line = fr.read())!=-1){
                System.out.println((char)line);
            }
            System.out.println("Successful read!");
        }
        catch (IOException e){
            System.out.println("IOException : File not found");
        }
    }
    public static void main(String[] args) {
        checkFile();
    }
}
