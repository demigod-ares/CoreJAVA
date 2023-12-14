// Adaptee class
// This is the class that has the functionality that the client code wants to use.
// However, its interface is incompatible with the target interface.
class Adaptee {
    void specificRequest() {
        System.out.println("Adaptee's specific request");
    }
}

// Target interface
// This is the interface that the client code expects.
// It defines the domain-specific interface that the client code interacts with.
interface Target {
    void request();
}

// Adapter class
// This is the class that bridges the gap between the target and the adaptee.
// It implements the target interface and contains an instance of the adaptee.
// The adapter converts the calls made by the client code on the target interface into calls on the adaptee.
class Adapter implements Target {
    private Adaptee adaptee;
    public Adapter(Adaptee adaptee) {
        this.adaptee = adaptee;
    }
    @Override
    public void request() {
        adaptee.specificRequest();
    }
}

// Client code
public class Adapter1 {
    public static void main(String[] args) {
        Adaptee adaptee = new Adaptee();
        Target adapter = new Adapter(adaptee);
        adapter.request(); // Calls the specificRequest method of Adaptee through Adapter
    }
}
