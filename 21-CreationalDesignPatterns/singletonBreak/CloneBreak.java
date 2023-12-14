package singletonBreak;

import singelton4.NaiveSingleton;
import singelton4.SingletonWithSafety;

public class CloneBreak {
    public static void main(String[] args) {
        NaiveSingleton originalSingleton = NaiveSingleton.getInstance();
        originalSingleton.printHash(); // Print the hashcode

        try {
            // Attempt to clone the singleton instance
            NaiveSingleton clonedSingleton = (NaiveSingleton) originalSingleton.clone();
            clonedSingleton.printHash(); // This will be reached
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }

        SingletonWithSafety originalSingleton2 = SingletonWithSafety.getInstance();
        originalSingleton2.printHash(); // Print the hashcode

        try {
            // Attempt to clone the singleton instance
            SingletonWithSafety clonedSingleton = (SingletonWithSafety) originalSingleton2.clone();
            clonedSingleton.printHash(); // This won't be reached due to the exception due to SAFETY
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}

