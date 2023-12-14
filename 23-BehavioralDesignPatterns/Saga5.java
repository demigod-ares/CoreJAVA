import java.util.Arrays;
import java.util.List;

// Step 1: Define a generic interface for a saga step
interface SagaStep {
    void execute();
    void compensate();
}

// Step 2: Implement concrete saga steps
// Step 2.1: OrderService handles order placement
class OrderService implements SagaStep {
    @Override
    public void execute() {
        System.out.println("Order placed successfully");
    }
    @Override
    public void compensate() {
        System.out.println("Compensating for Order placement");
    }
}
// Step 2.2: PaymentService handles payment processing
class PaymentService implements SagaStep {
    @Override
    public void execute() {
        System.out.println("Payment processed successfully");
    }
    @Override
    public void compensate() {
        System.out.println("Compensating for Payment processing");
    }
}
// Step 2.3: ShippingService handles shipping
class ShippingService implements SagaStep {
    @Override
    public void execute() {
        throw new RuntimeException("Simulated error in payment processing");
        // System.out.println("Order shipped successfully");
    }
    @Override
    public void compensate() {
        System.out.println("Compensating for Shipping");
    }
}

// Step 3: Implement a Saga orchestrator
class OrderSaga {
    private List<SagaStep> steps;
    private int currentStep;
    public OrderSaga(List<SagaStep> steps) {
        this.steps = steps;
        this.currentStep = 0;
    }
    public void executeSaga() {
        try {
            // Execute each step in the saga
            while (steps.size() - currentStep > 0) {
                steps.get(currentStep).execute();
                currentStep++;
            }
        } catch (Exception e) {
            // If an exception occurs, compensate for completed steps
            compensateForFailedSaga();
        }
    }
    private void compensateForFailedSaga() {
        System.out.println("Saga execution failed. Initiating compensation...");
        // Compensate for each completed step in reverse order
        while (currentStep >= 0) {
            steps.get(currentStep).compensate();
            currentStep--;
        }
    }
}

// Step 4: Client code
public class Saga5 {
    public static void main(String[] args) {
        // Create a saga with order, payment, and shipping steps
        List<SagaStep> steps = Arrays.asList(
                new OrderService(),
                new PaymentService(),
                new ShippingService()
        );
        // Create and execute the saga
        OrderSaga orderSaga = new OrderSaga(steps);
        orderSaga.executeSaga();
    }
}
