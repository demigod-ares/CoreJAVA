// Step 1: AbstractExpression interface
interface Expression {
    int interpret(Context context);
}

// Step 2: TerminalExpression classes
class NumberExpression implements Expression {
    private int number;
    public NumberExpression(int number) {
        this.number = number;
    }
    public int interpret(Context context) {
        System.out.println(context + " inside Terminal Expression with num: " + number);
        return number;
    }
}

// Step 3: NonterminalExpression classes (Add/Sub)
class AddExpression implements Expression {
    private Expression left;
    private Expression right;
    public AddExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public int interpret(Context context) { // input is Context
        return left.interpret(context) + right.interpret(context);
    }
}
class SubtractExpression implements Expression {
    private Expression left;
    private Expression right;
    public SubtractExpression(Expression left, Expression right) {
        this.left = left;
        this.right = right;
    }
    public int interpret(Context context) { // input is Context
        return left.interpret(context) - right.interpret(context);
    }
}

// Step 4: Context class
class Context {
    private String input;
    public Context(String input) {
        this.input = input;
    }
    public String getInput() {
        return input;
    }
}

// Step 5: Client code
public class Interpreter3 {
    public static void main(String[] args) {
        // Build an abstract syntax tree representing the expression: 5 + 3 - 2
        Expression expression = new SubtractExpression(
            new AddExpression(new NumberExpression(5), new NumberExpression(3)),
            new NumberExpression(2)
        );
        // Create a context
        Context context = new Context("Interpreter Pattern Example");
        // Interpret the expression
        int result = expression.interpret(context);
        System.out.println("Result: " + result);
    }
}
