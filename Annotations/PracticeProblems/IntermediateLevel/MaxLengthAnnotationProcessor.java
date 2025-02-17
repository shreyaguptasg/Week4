package Annotations.PracticeProblems.IntermediateLevel;
import java.lang.annotation.*;
import java.lang.reflect.Field;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface MaxLength {
    int value();
}

class User {
    @MaxLength(10)
    private String username;

    public User(String username) {
        // Validate username length using reflection
        try {
            Field field = this.getClass().getDeclaredField("username");
            MaxLength annotation = field.getAnnotation(MaxLength.class);
            if (annotation != null && username.length() > annotation.value()) {
                throw new IllegalArgumentException("Username exceeds maximum length of " + annotation.value());
            }
            this.username = username;
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
    }

    public String getUsername() {
        return username;
    }
}

public class MaxLengthAnnotationProcessor {
    public static void main(String[] args) {
        try {
            User user = new User("JohnDoe123");  // This should throw an exception
            System.out.println("User created: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

        try {
            User user = new User("JohnDoe");  // This should succeed
            System.out.println("User created: " + user.getUsername());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }
}
