package Reflection.IntermediateProblems;
import java.lang.annotation.*;
import java.lang.reflect.*;

// Define the custom annotation @Author
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.TYPE) // Applied at the class level
public @interface Author {
    String name();
}

// Apply @Author annotation to a class
@Author(name = "John Doe")
class MyClass {
    public void display() {
        System.out.println("This is MyClass.");
    }
}

public class RetrieveAnnotations {

    public static void main(String[] args) {
        try {
            // Get the class object of MyClass
            Class<?> myClass = MyClass.class;

            // Check if the Author annotation is present on MyClass
            if (myClass.isAnnotationPresent(Author.class)) {
                // Retrieve the annotation
                Author authorAnnotation = myClass.getAnnotation(Author.class);

                // Print the name value of the annotation
                System.out.println("Author: " + authorAnnotation.name());
            } else {
                System.out.println("No Author annotation present.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

