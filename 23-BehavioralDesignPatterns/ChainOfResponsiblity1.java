class Purchase {
    private int number;
    private double amount;
    public Purchase(int number, double amount) {
        this.number = number;
        this.amount = amount;
    }
    public int getNumber() {
        return number;
    }
    public double getAmount() {
        return amount;
    }
}

interface Approver { // Handeler interface
    void processRequest(Purchase purchase);
}

// 3 concrete classes
class Manager implements Approver {
    private Approver successor;
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }
    public void processRequest(Purchase purchase) {
        if (purchase.getAmount() <= 1000) {
            System.out.println("Manager approves purchase #" + purchase.getNumber());
        } else {
            // Pass to the next approver
            successor.processRequest(purchase);
        }
    }
}
class Director implements Approver {
    private Approver successor;
    public void setSuccessor(Approver successor) {
        this.successor = successor;
    }
    public void processRequest(Purchase purchase) {
        if (purchase.getAmount() <= 5000) {
            System.out.println("Director approves purchase #" + purchase.getNumber());
        } else {
            // Pass to the next approver
            successor.processRequest(purchase);
        }
    }
}
class VicePresident implements Approver {
    public void processRequest(Purchase purchase) {
        if (purchase.getAmount() <= 10000) {
            System.out.println("Vice President approves purchase #" + purchase.getNumber());
        } else {
            System.out.println("Purchase #" + purchase.getNumber() + " requires executive approval.");
        }
    }
}

// In this example, the Manager, Director, and VicePresident are the concrete handlers forming a chain.
// Understand 1. Request Propogation 2. Handeler Interaction 3. Dynamic Chain

public class ChainOfResponsiblity1 {
    public static void main(String[] args) {
        Manager manager = new Manager();
        Director director = new Director();
        Approver vp = new VicePresident(); // Class VP

        // Build the successor chain
        manager.setSuccessor(director);
        director.setSuccessor(vp);

        // Make requests
        Purchase p1 = new Purchase(123, 800);
        Purchase p2 = new Purchase(456, 5000);
        Purchase p3 = new Purchase(236, 6000);
        Purchase p4 = new Purchase(789, 12000);

        manager.processRequest(p1); // 1000
        manager.processRequest(p2); // 5000
        manager.processRequest(p3); // 10000
        manager.processRequest(p4); // over 10000
    }
}

