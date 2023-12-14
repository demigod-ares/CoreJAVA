// Product interface
interface Product {
    void create();
}

// Concrete Product A
class ProductA implements Product {
    @Override
    public void create() {
        System.out.println("Product A created");
    }
}

// Concrete Product B
class ProductB implements Product {
    @Override
    public void create() {
        System.out.println("Product B created");
    }
}

// Factory interface
interface ProductFactory {
    Product createProduct();
}

// Concrete Factory for Product A
class ProductAFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductA();
    }
}

// Concrete Factory for Product B
class ProductBFactory implements ProductFactory {
    @Override
    public Product createProduct() {
        return new ProductB();
    }
}

// Client code
// We don't expose creation logic to the client (Virtual Constructor)
// A standard interface is used to refer to created object
public class FactoryMethod1 {
    public static void main(String[] args) {
        // Creating a factory for Product A
        ProductFactory factoryA = new ProductAFactory();
        Product productA = factoryA.createProduct();
        productA.create();  // Output: Product A created

        // Creating a factory for Product B
        ProductFactory factoryB = new ProductBFactory();
        Product productB = factoryB.createProduct();
        productB.create();  // Output: Product B created
    }
}
