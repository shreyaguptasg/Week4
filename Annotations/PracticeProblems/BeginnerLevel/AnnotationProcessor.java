package Annotations.PracticeProblems.BeginnerLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface ImportantMethod {
    String level() default "HIGH";
}

class TaskManager {
    @ImportantMethod(level = "CRITICAL")
    public void processData() {
        System.out.println("Processing data...");
    }

    @ImportantMethod
    public void generateReport() {
        System.out.println("Generating report...");
    }

    public void normalTask() {
        System.out.println("Performing a normal task.");
    }
}

public class AnnotationProcessor {
    public static void main(String[] args) {
        Method[] methods = TaskManager.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(ImportantMethod.class)) {
                ImportantMethod annotation = method.getAnnotation(ImportantMethod.class);
                System.out.println("Method: " + method.getName() + ", Importance Level: " + annotation.level());
            }
        }
    }
}
