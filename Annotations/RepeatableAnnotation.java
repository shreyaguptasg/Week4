package Annotations;
import java.lang.annotation.*;
import java.lang.reflect.Method;

// Step 1: Define the repeatable annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Repeatable(BugReports.class)
@interface BugReport {
    String description();
}

// Step 2: Define the container annotation
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface BugReports {
    BugReport[] value();
}

// Step 3: Apply @BugReport multiple times on a method
class BugTracker {

    @BugReport(description = "Null pointer exception occurs when input is null")
    @BugReport(description = "Performance issue when processing large datasets")
    public void buggyMethod() {
        System.out.println("Executing buggy method...");
    }
}

// Step 4: Retrieve and print all bug reports using reflection
public class RepeatableAnnotation {
    public static void main(String[] args) {
        try {
            // Get method reference
            Method method = BugTracker.class.getMethod("buggyMethod");

            // Fetch and print bug reports
            BugReport[] bugReports = method.getAnnotationsByType(BugReport.class);
            for (BugReport bug : bugReports) {
                System.out.println("Bug Report: " + bug.description());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
