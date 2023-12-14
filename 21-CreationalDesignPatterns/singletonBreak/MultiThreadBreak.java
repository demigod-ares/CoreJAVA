package singletonBreak;

import singelton4.NaiveSingleton;

public class MultiThreadBreak {
    public static void main(String[] args) {
        // Create multiple threads that attempt to access the singleton simultaneously
        Thread thread1 = new Thread(() -> {
            NaiveSingleton singleton = NaiveSingleton.getInstance();
            singleton.printHash();
        });

        Thread thread2 = new Thread(() -> {
            NaiveSingleton singleton = NaiveSingleton.getInstance();
            singleton.printHash();
        });

        // Start the threads
        thread1.start();
        thread2.start();
    }
}
