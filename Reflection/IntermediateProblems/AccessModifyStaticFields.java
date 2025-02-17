package Reflection.IntermediateProblems;
import java.lang.reflect.Field;

class Configuration {
    private static String API_KEY = "InitialAPIKey";

    public static void printApiKey() {
        System.out.println("API Key: " + API_KEY);
    }
}

public class AccessModifyStaticFields {

    public static void main(String[] args) {
        try {
            // Get the Configuration class object
            Class<?> configClass = Configuration.class;

            // Get the private static field 'API_KEY' from Configuration class
            Field apiKeyField = configClass.getDeclaredField("API_KEY");

            // Set the field accessible to allow modification
            apiKeyField.setAccessible(true);

            // Modify the value of the private static field
            apiKeyField.set(null, "NewModifiedAPIKey");

            // Print the updated value
            Configuration.printApiKey();  // Output: API Key: NewModifiedAPIKey

        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

