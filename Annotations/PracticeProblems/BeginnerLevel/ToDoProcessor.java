package Annotations.PracticeProblems.BeginnerLevel;

import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface Todo {
    String task();
    String assignedTo();
    String priority() default "MEDIUM";
}

class ProjectTasks {
    @Todo(task = "Implement user authentication", assignedTo = "Alice", priority = "HIGH")
    public void userAuthentication() {
        System.out.println("User authentication logic.");
    }

    @Todo(task = "Optimize database queries", assignedTo = "Bob")
    public void optimizeQueries() {
        System.out.println("Optimizing database queries.");
    }

    @Todo(task = "Refactor payment module", assignedTo = "Charlie", priority = "LOW")
    public void refactorPaymentModule() {
        System.out.println("Refactoring payment module.");
    }
}

public class ToDoProcessor {
    public static void main(String[] args) {
        Method[] methods = ProjectTasks.class.getDeclaredMethods();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Todo.class)) {
                Todo todo = method.getAnnotation(Todo.class);
                System.out.println("Method: " + method.getName());
                System.out.println("Task: " + todo.task());
                System.out.println("Assigned To: " + todo.assignedTo());
                System.out.println("Priority: " + todo.priority());
                System.out.println("----------------------------");
            }
        }
    }
}

