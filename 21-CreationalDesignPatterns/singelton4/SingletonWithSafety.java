package singelton4;

import java.io.Serializable;

public class SingletonWithSafety implements Serializable, Cloneable {
    private SingletonWithSafety() {
        // Check if an instance already exists to prevent reflection-based instantiation[2]
        if (singletonInstance != null) {
            throw new RuntimeException("Singleton instance already exists. Use getInstance() method.");
        }
    }
    // The volatile keyword ensures that multiple threads[1] handle the singletonInstance variable correctly during instance creation
    private static volatile SingletonWithSafety singletonInstance;

    public static SingletonWithSafety getInstance() {
        // The double-check locking pattern is used to synchronize[1] the creation of the instance, reducing the overhead of synchronization after the first time.
        if (singletonInstance == null) {
            synchronized (SingletonWithSafety.class) {
                if (singletonInstance == null) {
                    singletonInstance = new SingletonWithSafety();
                }
            }
        }
        return singletonInstance;
    }
    public void printHash() {
        System.out.println("Hashcode of singleton object: " + singletonInstance.hashCode());
    }

    // Ensure the same instance is returned during De-serialization[3]
    protected Object readResolve() {
        return singletonInstance;
    }

    // Override [4] clone to prevent cloning
    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException("Cloning of singleton instance is not allowed");
    }
}