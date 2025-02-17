package Annotations.PracticeProblems.AdvancedLevel;
import java.lang.annotation.*;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

// Define the @JsonField annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
@interface JsonField {
    String name();  // Custom JSON key name
}

// User class with annotated fields
class User2 {
    @JsonField(name = "user_name")
    private String username;

    @JsonField(name = "user_age")
    private int age;

    @JsonField(name = "user_email")
    private String email;

    public User2(String username, int age, String email) {
        this.username = username;
        this.age = age;
        this.email = email;
    }

    // Getters for the fields (not strictly necessary, but can be useful)
    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    public String getEmail() {
        return email;
    }
}

// Class to handle the serialization
class JsonSerializer {

    public static String serialize(Object object) {
        StringBuilder jsonBuilder = new StringBuilder();
        jsonBuilder.append("{");

        Field[] fields = object.getClass().getDeclaredFields();
        Map<String, Object> fieldMap = new HashMap<>();

        // Process each field with @JsonField annotation
        for (Field field : fields) {
            if (field.isAnnotationPresent(JsonField.class)) {
                JsonField annotation = field.getAnnotation(JsonField.class);
                String jsonKey = annotation.name();

                try {
                    field.setAccessible(true);  // Make private fields accessible
                    Object value = field.get(object);
                    fieldMap.put(jsonKey, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        // Build the JSON string
        for (Map.Entry<String, Object> entry : fieldMap.entrySet()) {
            jsonBuilder.append("\"").append(entry.getKey()).append("\": \"")
                    .append(entry.getValue()).append("\", ");
        }

        // Remove the last comma and space, if any
        if (jsonBuilder.length() > 1) {
            jsonBuilder.setLength(jsonBuilder.length() - 2);
        }

        jsonBuilder.append("}");
        return jsonBuilder.toString();
    }
}

public class Main2 {
    public static void main(String[] args) {
        // Create a User object
        User user = new User("JohnDoe", 30, "johndoe@example.com");

        // Serialize the object to JSON
        String json = JsonSerializer.serialize(user);

        // Output the JSON
        System.out.println(json);
    }
}

