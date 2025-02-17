package Reflection.AdvancedProblems;
import java.lang.reflect.Field;

class JsonSerializer {

    public static String toJson(Object obj) {
        // StringBuilder to build the JSON string
        StringBuilder jsonString = new StringBuilder();

        // Get the class of the object
        Class<?> objClass = obj.getClass();

        // Start JSON object
        jsonString.append("{");

        // Get all fields in the class
        Field[] fields = objClass.getDeclaredFields();

        // Iterate through the fields and add them to the JSON string
        for (int i = 0; i < fields.length; i++) {
            Field field = fields[i];
            field.setAccessible(true); // Allow access to private fields

            try {
                // Get field name and value
                String fieldName = field.getName();
                Object fieldValue = field.get(obj);

                // Append field name and value in JSON format
                jsonString.append("\"").append(fieldName).append("\": ");

                // Handle null and different types of fields
                if (fieldValue == null) {
                    jsonString.append("null");
                } else if (fieldValue instanceof String) {
                    jsonString.append("\"").append(fieldValue).append("\"");
                } else {
                    jsonString.append(fieldValue);
                }

                // Add a comma if it's not the last field
                if (i < fields.length - 1) {
                    jsonString.append(", ");
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }

        // End JSON object
        jsonString.append("}");

        return jsonString.toString();
    }
}

// Example class to test the JsonSerializer
class Person {
    private String name;
    private int age;
    private double salary;

    public Person(String name, int age, double salary) {
        this.name = name;
        this.age = age;
        this.salary = salary;
    }
}

public class JSONGenerator {
    public static void main(String[] args) {
        // Create an instance of the Person class
        Person person = new Person("John Doe", 30, 50000.5);

        // Convert the object to a JSON string using the JsonSerializer
        String json = JsonSerializer.toJson(person);

        // Print the JSON representation
        System.out.println(json);
    }
}

