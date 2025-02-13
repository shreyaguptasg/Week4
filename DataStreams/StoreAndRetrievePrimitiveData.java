package Day3.DataStreams;

import java.io.*;

class Student{
    int rollnumber;
    String name;
    double gpa;

    public Student(int rollnumber, String name, double gpa) {
        this.rollnumber = rollnumber;
        this.name = name;
        this.gpa = gpa;
    }
}
public class StoreAndRetrievePrimitiveData {
    private static void writeData(Student [] students){
        try(DataOutputStream dos = new DataOutputStream(new FileOutputStream("input.txt"))){
            for(Student s: students){
                dos.writeInt(s.rollnumber);
                dos.writeUTF(s.name);
                dos.writeDouble(s.gpa);
            }
            System.out.println("File wriitten operation successfull");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void readData(){
        try(DataInputStream dis = new DataInputStream(new FileInputStream("input.txt"))){
            while(dis.available()>0){
                int rollNumber = dis.readInt();
                String name = dis.readUTF();
                double gpa = dis.readDouble();
                System.out.println("RollNumber :" + rollNumber + "\n Name : " + name + "\n GPA : " + gpa);
            }
            System.out.println("File reading operation successfull");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static void main(String[] args) {
        Student[] students = {
                new Student(1,"Alice",8),
                new Student(2,"Bob",9),
                new Student(3,"Carol", 6.9)
        };
        writeData(students);
        readData();
    }
}
