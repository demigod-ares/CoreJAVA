package singletonBreak;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import singelton4.SingletonWithSafety;

public class ReflectionSafe {

    public static void main(String[] args) {
        // Get the singleton instance using the public method
        SingletonWithSafety singleton = SingletonWithSafety.getInstance();
        singleton.printHash(); // Print the hashcode

        // Use reflection to break the singleton
        try {
            Class<SingletonWithSafety> singletonClass = SingletonWithSafety.class;
            Constructor<SingletonWithSafety> constructor = singletonClass.getDeclaredConstructor();

            // Set the constructor accessible to break the private access modifier
            constructor.setAccessible(true);

            // Attempt to create a second instance using reflection
            SingletonWithSafety secondInstance = constructor.newInstance();
            secondInstance.printHash(); // This should not be reached

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
