// Step 1: Command interface
interface Command {
    void execute();
}

// Step 2: ConcreteCommand classes (Buy/Sell)
class BuyStock implements Command {
    private Stock stock;
    public BuyStock(Stock stock) {
        this.stock = stock;
    }
    public void execute() {
        stock.buy();
    }
}
class SellStock implements Command {
    private Stock stock;
    public SellStock(Stock stock) {
        this.stock = stock;
    }
    public void execute() {
        stock.sell();
    }
}

// Step 3: Receiver class
class Stock {
    private String name = "ABC";
    private int quantity = 10;
    public void buy() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] bought");
    }
    public void sell() {
        System.out.println("Stock [ Name: " + name + ", Quantity: " + quantity + " ] sold");
    }
}

// Step 4: Invoker class
class Broker {
    private Command command;
    public void setCommand(Command command) {
        this.command = command;
    }
    public void executeCommand() {
        command.execute();
    }
}

// Step 5: Client code
public class Command2 {
    public static void main(String[] args) {
        Stock stock = new Stock(); // reciever

        BuyStock buyStockOrder = new BuyStock(stock); // commands
        SellStock sellStockOrder = new SellStock(stock);

        Broker broker = new Broker(); // invoker
        broker.setCommand(buyStockOrder);
        broker.executeCommand();

        broker.setCommand(sellStockOrder);
        broker.executeCommand();
    }
}
