package Annotations.PracticeProblems.IntermediateLevel;
import java.lang.annotation.*;
import java.lang.reflect.Method;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@interface LogExecutionTime {
    String value() default "Execution time: ";
}

class MethodExecution {

    @LogExecutionTime
    public void slowMethod() {
        try {
            Thread.sleep(2000); // Simulate a time-consuming task
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @LogExecutionTime
    public void fastMethod() {
        // Simulate a fast task
        System.out.println("Fast method executed.");
    }
}

public class LogExecutionTimeProcessor {
    public static void main(String[] args) throws Exception {
        MethodExecution methodExecution = new MethodExecution();
        Method[] methods = MethodExecution.class.getDeclaredMethods();

        for (Method method : methods) {
            if (method.isAnnotationPresent(LogExecutionTime.class)) {
                LogExecutionTime annotation = method.getAnnotation(LogExecutionTime.class);

                long startTime = System.nanoTime();

                // Invoke the method
                method.invoke(methodExecution);

                long endTime = System.nanoTime();
                long executionTime = endTime - startTime;

                System.out.println(annotation.value() + executionTime + " nanoseconds for method: " + method.getName());
            }
        }
    }
}
