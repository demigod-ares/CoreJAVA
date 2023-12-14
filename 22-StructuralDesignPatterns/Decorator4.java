// Component interface
interface Coffee {
    String getDescription();
    double cost();
}

// Concrete Component
class SimpleCoffee implements Coffee {
    @Override
    public String getDescription() {
        return "Simple Coffee";
    }
    @Override
    public double cost() {
        return 2.0;
    }
}

// Decorator Abstract class: This is the abstract class that also implements the Component interface and has a reference to a Component instance.
// Decorators have the same interface as the components they decorate, allowing them to add or override behavior.
abstract class CoffeeDecorator implements Coffee {
    protected Coffee decoratedCoffee; // Coffee
    public CoffeeDecorator(Coffee decoratedCoffee) {
        this.decoratedCoffee = decoratedCoffee;
    }
    @Override
    public String getDescription() {
        return decoratedCoffee.getDescription();
    }
    @Override
    public double cost() {
        return decoratedCoffee.cost();
    }
}

// Concrete Decorator 1
class MilkDecorator extends CoffeeDecorator {
    public MilkDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", with Milk";
    }
    @Override
    public double cost() {
        return super.cost() + 0.5;
    }
}

// Concrete Decorator 2
class SugarDecorator extends CoffeeDecorator {
    public SugarDecorator(Coffee decoratedCoffee) {
        super(decoratedCoffee);
    }
    @Override
    public String getDescription() {
        return super.getDescription() + ", with Sugar";
    }
    @Override
    public double cost() {
        return super.cost() + 0.2;
    }
}

// Client code
public class Decorator4 {
    public static void main(String[] args) {
        // Create a simple coffee
        Coffee coffee = new SimpleCoffee();
        System.out.println("Cost: " + coffee.cost() + ", Description: " + coffee.getDescription());

        // Add milk to the (coffee)
        Coffee milkCoffee = new MilkDecorator(coffee);
        System.out.println("Cost: " + milkCoffee.cost() + ", Description: " + milkCoffee.getDescription());

        // Add sugar to the (milk coffee)
        Coffee sugarMilkCoffee = new SugarDecorator(milkCoffee);
        System.out.println("Cost: " + sugarMilkCoffee.cost() + ", Description: " + sugarMilkCoffee.getDescription());

        // Add sugar to the (coffee)
        Coffee sugarCoffee = new SugarDecorator(coffee);
        System.out.println("Cost: " + sugarCoffee.cost() + ", Description: " + sugarCoffee.getDescription());

        // Add milk to the (sugar coffee)
        Coffee milkSugarCoffee = new MilkDecorator(sugarCoffee);
        System.out.println("Cost: " + milkSugarCoffee.cost() + ", Description: " + milkSugarCoffee.getDescription());
    }
}
