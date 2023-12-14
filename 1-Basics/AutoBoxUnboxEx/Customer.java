package AutoBoxUnboxEx;

import java.util.ArrayList;

public class Customer {
    private String name;
    private ArrayList<Double> transactions; // Note 1

    public Customer(String name, double initialAmount) {
        this.name = name;
        this.transactions = new ArrayList<Double>(); // Note 1
        addTransaction(initialAmount);
    }
    public void addTransaction(double amount) {
        this.transactions.add(amount); // Autoboxing
    }
    public String getName() {
        return name;
    }
    public ArrayList<Double> getTransactions() { // Note 1
        return transactions;
    }
}
// Note 1: "IntList", "DoubleList", and so on are classes from the "org.apache.commons.collections4 package", which provides resizable arrays specifically designed for storing primitive types. Generally, collections do not support primitive class because their objects are not resizable.
