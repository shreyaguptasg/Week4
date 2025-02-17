package Reflection.AdvancedProblems;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

@Retention(RetentionPolicy.RUNTIME)
public @interface Inject {
}


 class DIContainer {

    private Map<Class<?>, Object> instances = new HashMap<>();

    // Registers a class in the container and creates its instance
    public <T> void register(Class<T> clazz) throws IllegalAccessException, InstantiationException {
        // Create an instance of the class and store it
        T instance = clazz.newInstance();
        instances.put(clazz, instance);
    }

    // Injects dependencies into a class based on the @Inject annotation
    public void injectDependencies(Object object) throws IllegalAccessException {
        // Get all fields of the object
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            if (field.isAnnotationPresent(Inject.class)) {
                field.setAccessible(true); // make the field accessible
                Class<?> fieldType = field.getType();

                // Get the dependency from the container and inject it
                Object dependency = instances.get(fieldType);
                if (dependency != null) {
                    field.set(object, dependency);
                }
            }
        }
    }

    // Get an instance of the class from the container
    public <T> T getInstance(Class<T> clazz) {
        return clazz.cast(instances.get(clazz));
    }
}

class Engine {
    public void start() {
        System.out.println("Engine started!");
    }
}

class Car {

    @Inject
    private Engine engine;

    public void drive() {
        if (engine != null) {
            engine.start();
            System.out.println("Car is driving...");
        } else {
            System.out.println("Engine not injected!");
        }
    }
}

public class DependencyInjection {

    public static void main(String[] args) throws Exception {
        // Create an instance of the DI container
        DIContainer container = new DIContainer();

        // Register the Engine class and Car class in the container
        container.register(Engine.class);
        container.register(Car.class);

        // Create an instance of Car
        Car car = container.getInstance(Car.class);

        // Inject dependencies (in this case, the Engine dependency into Car)
        container.injectDependencies(car);

        // Now the Car instance has its Engine dependency injected
        car.drive(); // Output: Engine started! Car is driving...
    }
}




