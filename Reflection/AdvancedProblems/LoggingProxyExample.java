package Reflection.AdvancedProblems;
import java.lang.reflect.*;

interface Greeting {
    void sayHello(String name);
}

class GreetingImpl implements Greeting {
    @Override
    public void sayHello(String name) {
        System.out.println("Hello, " + name + "!");
    }
}

class LoggingInvocationHandler implements InvocationHandler {
    private Object target;

    public LoggingInvocationHandler(Object target) {
        this.target = target;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        // Log method invocation
        System.out.println("Method " + method.getName() + " is being called with arguments: " + (args != null ? args[0] : "None"));

        // Invoke the original method on the target object
        Object result = method.invoke(target, args);

        // Log after method execution
        System.out.println("Method " + method.getName() + " execution completed.");
        return result;
    }
}

public class LoggingProxyExample {
    public static void main(String[] args) {
        // Create an instance of the target object (GreetingImpl)
        Greeting greeting = new GreetingImpl();

        // Create a dynamic proxy for Greeting interface with LoggingInvocationHandler
        Greeting proxyInstance = (Greeting) Proxy.newProxyInstance(
                Greeting.class.getClassLoader(),
                new Class[]{Greeting.class},
                new LoggingInvocationHandler(greeting)
        );

        // Call methods on the proxy instance
        proxyInstance.sayHello("John");
    }
}
