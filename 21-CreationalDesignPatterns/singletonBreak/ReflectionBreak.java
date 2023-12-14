package singletonBreak;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import singelton4.NaiveSingleton;

public class ReflectionBreak {

    public static void main(String[] args) {
        // 1. Get the singleton instance using the public method
        NaiveSingleton singleton = NaiveSingleton.getInstance();
        singleton.printHash(); // Print the hashcode

        // Use reflection to break the singleton
        try {
            Class<NaiveSingleton> singletonClass = NaiveSingleton.class; // 2. Extract Class
            Constructor<NaiveSingleton> constructor = singletonClass.getDeclaredConstructor();
            
            // 3. Set the constructor accessible to break the private access modifier
            constructor.setAccessible(true);

            // 4. Create a second instance using reflection
            NaiveSingleton secondInstance = constructor.newInstance();
            secondInstance.printHash(); // Print the hashcode of the second instance

        } catch (NoSuchMethodException | IllegalAccessException | InstantiationException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}
