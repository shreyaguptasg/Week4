package Reflection.AdvancedProblems;

import java.lang.reflect.Field;
import java.util.Map;

class CustomObjectMapper {

    public static <T> T toObject(Class<T> clazz, Map<String, Object> properties) {
        try {
            // Create a new instance of the class
            T object = clazz.getDeclaredConstructor().newInstance();

            // Iterate through each entry in the properties map
            for (Map.Entry<String, Object> entry : properties.entrySet()) {
                // Get the field corresponding to the property name
                String fieldName = entry.getKey();
                Object value = entry.getValue();

                // Try to get the field from the class
                Field field = clazz.getDeclaredField(fieldName);
                field.setAccessible(true); // Allow access to private fields

                // Set the value of the field if the type matches
                if (field.getType().isAssignableFrom(value.getClass())) {
                    field.set(object, value);
                } else {
                    System.out.println("Type mismatch for field: " + fieldName);
                }
            }

            return object;
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}

// Example class to test the CustomObjectMapper
class Person {
    private String name;
    private int age;
    private double salary;

    public Person() {
        // Default constructor
    }

    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", salary=" + salary + '}';
    }
}

public class CustomObject {
    public static void main(String[] args) {
        // Example Map with property names and values
        Map<String, Object> properties = Map.of(
                "name", "John Doe",
                "age", 30,
                "salary", 50000.50
        );

        // Use the CustomObjectMapper to map properties to a Person object
        Person person = CustomObjectMapper.toObject(Person.class, properties);

        // Print the resulting Person object
        System.out.println(person);
    }
}

