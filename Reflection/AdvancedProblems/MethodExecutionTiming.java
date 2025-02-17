package Reflection.AdvancedProblems;

import java.lang.reflect.Method;

 class SampleClass {

    public void method1() {
        try {
            Thread.sleep(2000);  // Simulating some work (sleeping for 2 seconds)
            System.out.println("Method 1 executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void method2() {
        try {
            Thread.sleep(1000);  // Simulating some work (sleeping for 1 second)
            System.out.println("Method 2 executed");
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}


 class ExecutionTimeLogger {

    public static void logExecutionTime(Object object, String methodName) throws Exception {
        // Get the class of the object
        Class<?> clazz = object.getClass();

        // Get the Method object for the method you want to call
        Method method = clazz.getDeclaredMethod(methodName);

        // Measure the start time
        long startTime = System.nanoTime();

        // Invoke the method dynamically using reflection
        method.setAccessible(true);  // Make sure the method is accessible if it's private
        method.invoke(object);  // Invoke the method

        // Measure the end time
        long endTime = System.nanoTime();

        // Calculate and print the time taken
        long duration = endTime - startTime;
        System.out.println("Execution time of " + methodName + " : " + duration + " nanoseconds");
    }
}

public class MethodExecutionTiming {

    public static void main(String[] args) throws Exception {
        // Create an instance of the SampleClass
        SampleClass sample = new SampleClass();

        // Measure the execution time of method1
        ExecutionTimeLogger.logExecutionTime(sample, "method1");

        // Measure the execution time of method2
        ExecutionTimeLogger.logExecutionTime(sample, "method2");
    }
}


