package Annotations.PracticeProblems.AdvancedLevel;


import java.util.Map;
import java.lang.reflect.Method;
import java.util.HashMap;


class CacheSystem {

    private static final Map<String, Object> cache = new HashMap<>();

    // This method checks if the @CacheResult annotation is present and handles caching
    public static Object getCachedResult(Object object, Method method, Object[] args) throws Exception {
        if (method.isAnnotationPresent(CacheResult.class)) {
            // Generate a cache key based on method name and arguments
            String cacheKey = generateCacheKey(method, args);

            // Check if result is in the cache
            if (cache.containsKey(cacheKey)) {
                return cache.get(cacheKey);  // Return the cached result
            } else {
                // If not in cache, invoke the method
                Object result = method.invoke(object, args);
                cache.put(cacheKey, result);  // Store result in cache
                return result;
            }
        } else {
            // If @CacheResult is not present, just invoke the method
            return method.invoke(object, args);
        }
    }

    // Generate a cache key based on method name and arguments
    private static String generateCacheKey(Method method, Object[] args) {
        StringBuilder key = new StringBuilder(method.getName());
        for (Object arg : args) {
            key.append("-").append(arg);
        }
        return key.toString();
    }
}
class MathOperations {

    @CacheResult
    public int expensiveComputation(int number) {
        System.out.println("Computing...");
        // Simulate a time-consuming task
        try {
            Thread.sleep(2000);  // Simulate delay
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        return number * number;  // Example computation
    }
}


public class CacheResult2 {
    public static void main(String[] args) throws Exception {
        MathOperations mathOperations = new MathOperations();

        // Get the method to cache
        Method method = MathOperations.class.getMethod("expensiveComputation", int.class);

        // First time, will compute and cache the result
        System.out.println("First call: " + CacheSystem.getCachedResult(mathOperations, method, new Object[]{5}));

        // Second time, will return the cached result
        System.out.println("Second call: " + CacheSystem.getCachedResult(mathOperations, method, new Object[]{5}));

        // Calling with a different argument, will compute and cache the result
        System.out.println("Third call: " + CacheSystem.getCachedResult(mathOperations, method, new Object[]{6}));
    }
}



