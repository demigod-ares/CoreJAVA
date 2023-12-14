package Constructor;

public class VipPerson {
    private String name;
    private double creditLimit;
    private String emailAddress;

    public VipPerson() { // Polimorphism
        this("Default name", 50000.00, "default@email.com");
    }
    public VipPerson(String name, double creditLimit) { // Polimorphism
        this(name, creditLimit, "unknown@email.com"); // a constructor can have super() or this()
        // Both can only be the first statement in the constructor
    }

    public VipPerson(String name, double creditLimit, String emailAddress) { // Polimorphism
        this.name = name;
        this.creditLimit = creditLimit;
        this.emailAddress = emailAddress;
    }

    public String getName() {
        return name;
    }

    public double getCreditLimit() {
        return creditLimit;
    }

    public String getEmailAddress() {
        return emailAddress;
    }
}
