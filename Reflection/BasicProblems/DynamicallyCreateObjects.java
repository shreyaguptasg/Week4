package Reflection.BasicProblems;
import java.lang.reflect.Constructor;

public class DynamicallyCreateObjects {

    // Student class with a constructor and a field
    static class Student {
        private String name;
        private int age;

        // Constructor
        public Student(String name, int age) {
            this.name = name;
            this.age = age;
        }

        // Method to display student details
        public void displayDetails() {
            System.out.println("Student Name: " + name);
            System.out.println("Student Age: " + age);
        }
    }

    public static void main(String[] args) {
        try {
            // Get the Student class from the Class object
            Class<?> studentClass = Class.forName("ReflectionExample$Student");

            // Get the constructor with parameters (String, int)
            Constructor<?> constructor = studentClass.getConstructor(String.class, int.class);

            // Dynamically create an instance of Student using the constructor
            Object studentObj = constructor.newInstance("John Doe", 20);

            // Cast the Object to Student and call displayDetails method
            Student student = (Student) studentObj;
            student.displayDetails();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

