package Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the custom annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface TaskInfo {
    String priority();  // High, Medium, Low
    String assignedTo();
}

// Step 2: Apply @TaskInfo annotation to a method
class TaskManager {

    @TaskInfo(priority = "High", assignedTo = "Alice")
    public void completeTask() {
        System.out.println("Completing the task...");
    }
}

// Step 3: Retrieve and print annotation details using reflection
public class CustomAnnotation {
    public static void main(String[] args) {
        try {
            // Get method reference
            Method method = TaskManager.class.getMethod("completeTask");

            // Fetch and print annotation details
            if (method.isAnnotationPresent(TaskInfo.class)) {
                TaskInfo taskInfo = method.getAnnotation(TaskInfo.class);
                System.out.println("Task Priority: " + taskInfo.priority());
                System.out.println("Assigned To: " + taskInfo.assignedTo());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}

