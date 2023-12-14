package singletonBreak;

import java.io.*;

import singelton4.NaiveSingleton;

public class SerilizationBreak {
    public static void main(String[] args) {
        // Serialize the singleton
        serializeSingleton();

        // Deserialize the singleton
        NaiveSingleton deserializedSingleton = deserializeSingleton();
        deserializedSingleton.printHash(); // Print the hashcode of the deserialized instance
    }

    private static void serializeSingleton() {
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream("singleton.ser"))) {
            NaiveSingleton singleton = NaiveSingleton.getInstance();
            singleton.printHash(); // Print the hashcode before serialization
            outputStream.writeObject(singleton);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static NaiveSingleton deserializeSingleton() {
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream("singleton.ser"))) {
            return (NaiveSingleton) inputStream.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }
}
