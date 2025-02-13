package Day3.BufferedStreams;

import java.io.*;

public class FileCopy {
    public static void main(String[] args) {
        long startTime, endTime;
        startTime= System.nanoTime();
        try(BufferedInputStream bis= new BufferedInputStream(new FileInputStream("input.txt"));
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("output.txt"))){
                byte[] buffer = new byte[1024];
                int byteRead;
                while((byteRead= bis.read(buffer))!=-1){
                    bos.write(buffer,0,byteRead);
                }
            System.out.println("File buffering copied successfully");
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }
        endTime= System.nanoTime();
        System.out.println("Buffered Stream time is : " + (endTime-startTime));
        startTime= System.nanoTime();
        try (FileInputStream fis = new FileInputStream("input.txt");
             FileOutputStream fos = new FileOutputStream("output.txt")) {

            int byteData;
            while ((byteData = fis.read()) != -1) {
                fos.write(byteData);
            }
            System.out.println("File copied successfully.");
        } catch (IOException e) {
            e.printStackTrace();
        }
        endTime= System.nanoTime();
        System.out.println("Normal file time : " + (endTime-startTime));

    }
}
