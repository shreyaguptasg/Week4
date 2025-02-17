package Reflection.BasicProblems;
import java.lang.reflect.Field;

public class  AccessPrivateField {

    // Person class with private field 'age'
    static class Person {
        private int age;

        public Person(int age) {
            this.age = age;
        }

        // Getter for age
        public int getAge() {
            return age;
        }

        // Setter for age
        public void setAge(int age) {
            this.age = age;
        }
    }

    public static void main(String[] args) {
        try {
            // Create a Person object
            Person person = new Person(25);

            // Print original age
            System.out.println("Original Age: " + person.getAge());

            // Access the private field 'age' using reflection
            Field ageField = Person.class.getDeclaredField("age");

            // Make the field accessible (as it's private)
            ageField.setAccessible(true);

            // Modify the value of the private field 'age'
            ageField.set(person, 30);

            // Print modified age
            System.out.println("Modified Age: " + person.getAge());

            // Retrieve the value of the private field 'age'
            int retrievedAge = (int) ageField.get(person);
            System.out.println("Retrieved Age via Reflection: " + retrievedAge);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
