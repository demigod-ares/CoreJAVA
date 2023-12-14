// Step 1: Strategy interface
interface DiscountStrategy {
    double applyDiscount(double amount);
}

// Step 2: ConcreteStrategy classes
class NoDiscountStrategy implements DiscountStrategy {
    @Override
    public double applyDiscount(double amount) {
        return amount; // No discount applied
    }
}
class FixedDiscountStrategy implements DiscountStrategy {
    private double discountAmount;
    public FixedDiscountStrategy(double discountAmount) {
        this.discountAmount = discountAmount;
    }
    @Override
    public double applyDiscount(double amount) {
        return amount - discountAmount;
    }
}
class PercentageDiscountStrategy implements DiscountStrategy {
    private double discountPercentage;
    public PercentageDiscountStrategy(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }
    @Override
    public double applyDiscount(double amount) {
        return amount * (1 - discountPercentage / 100);
    }
}

// Step 3: Context class
class ShoppingCart {
    private DiscountStrategy discountStrategy;
    public void setDiscountStrategy(DiscountStrategy discountStrategy) {
        this.discountStrategy = discountStrategy;
    }
    public double checkout(double amount) {
        double discountedAmount = discountStrategy.applyDiscount(amount);
        System.out.println("Total amount after discount: $" + discountedAmount);
        return discountedAmount;
    }
}

// Step 4: Client code
public class Strategy10 {
    public static void main(String[] args) {
        // Create a shopping cart
        ShoppingCart cart = new ShoppingCart();

        // Use different discount strategies
        cart.setDiscountStrategy(new NoDiscountStrategy());
        cart.checkout(500.0);

        cart.setDiscountStrategy(new FixedDiscountStrategy(10.0));
        cart.checkout(500.0);

        cart.setDiscountStrategy(new PercentageDiscountStrategy(20.0));
        cart.checkout(500.0);
    }
}
