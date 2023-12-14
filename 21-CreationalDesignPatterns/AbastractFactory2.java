// Abstract Product A
interface ProductA {
    void create();
}

// Concrete Product A1
class ProductA1 implements ProductA {
    @Override
    public void create() {
        System.out.println("Product A1 created");
    }
}

// Concrete Product A2
class ProductA2 implements ProductA {
    @Override
    public void create() {
        System.out.println("Product A2 created");
    }
}

// Abstract Product B
interface ProductB {
    void create();
}

// Concrete Product B1
class ProductB1 implements ProductB {
    @Override
    public void create() {
        System.out.println("Product B1 created");
    }
}

// Concrete Product B2
class ProductB2 implements ProductB {
    @Override
    public void create() {
        System.out.println("Product B2 created");
    }
}

// Abstract Factory
interface AbstractFactory {
    ProductA createProductA();
    ProductB createProductB();
}

// Concrete Factory 1
class ConcreteFactory1 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}

// Concrete Factory 2
class ConcreteFactory2 implements AbstractFactory {
    @Override
    public ProductA createProductA() {
        return new ProductA2();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB2();
    }
}

// Client code
public class AbastractFactory2 { // OR Factory of Factory
    public static void main(String[] args) {
        // Creating a factory for Product family 1
        AbstractFactory factory1 = new ConcreteFactory1();
        ProductA productA1 = factory1.createProductA();
        ProductB productB1 = factory1.createProductB();

        productA1.create();  // Output: Product A1 created
        productB1.create();  // Output: Product B1 created

        // Creating a factory for Product family 2
        AbstractFactory factory2 = new ConcreteFactory2();
        ProductA productA2 = factory2.createProductA();
        ProductB productB2 = factory2.createProductB();

        productA2.create();  // Output: Product A2 created
        productB2.create();  // Output: Product B2 created
    }
}

