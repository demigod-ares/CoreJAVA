import java.util.ArrayList;
import java.util.List;

// Component interface: This is the common interface for all concrete classes, both leaf and composite.
interface Component {
    void operation();
}

// Leaf class: This represents the individual objects that do not have any child elements.
class Leaf implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation 1");
    }
}
class Leaf2 implements Component {
    @Override
    public void operation() {
        System.out.println("Leaf operation 2");
    }
}

// Composite class
class Composite implements Component {
    private List<Component> children = new ArrayList<>();
    public void add(Component component) {
        children.add(component);
    }
    @Override
    public void operation() {
        System.out.println("Composite operation");
        for (Component child : children) {
            child.operation();
        }
    }
}

// Client code
public class Composite3 {
    public static void main(String[] args) {
        Component leaf = new Leaf();
        Component leaf2 = new Leaf2();
        Component composite = new Composite();
        ((Composite) composite).add(leaf);
        ((Composite) composite).add(leaf2);
        Component composite2 = new Composite();
        ((Composite) composite2).add(leaf);
        ((Composite) composite).add(composite2); // Forms tree like structure ******
        composite.operation(); // Executes operation on both Leafs and Composite. Hierarchy of components maintained
    }
}
