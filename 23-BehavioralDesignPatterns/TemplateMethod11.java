// Step 1: AbstractClass (Recipe)
abstract class Recipe {
    // Template method ========================= //
    public final void cook() {
        prepareIngredients();
        cookIngredients();
        plate();
        serve();
    }

    // Abstract methods to be implemented by subclasses
    protected abstract void prepareIngredients();
    protected abstract void cookIngredients();
    // Concrete methods (common steps)
    protected void plate() {
        System.out.println("Plating the dish");
    }
    protected void serve() {
        System.out.println("Serving the dish");
    }
}

// Step 2: ConcreteClass (SpaghettiBologneseRecipe)
class SpaghettiBologneseRecipe extends Recipe {
    @Override
    protected void prepareIngredients() {
        System.out.println("Gathering ingredients for Spaghetti Bolognese");
    }
    @Override
    protected void cookIngredients() {
        System.out.println("Cooking Spaghetti Bolognese sauce and pasta");
    }
}
// Step 3: ConcreteClass (GrilledChickenRecipe)
class GrilledChickenRecipe extends Recipe {
    @Override
    protected void prepareIngredients() {
        System.out.println("Gathering ingredients for Grilled Chicken");
    }
    @Override
    protected void cookIngredients() {
        System.out.println("Grilling chicken and preparing side dishes");
    }
}

// Step 4: Client code
public class TemplateMethod11 {
    public static void main(String[] args) {
        // Create recipes and execute the template method
        Recipe spaghettiBolognese = new SpaghettiBologneseRecipe();
        spaghettiBolognese.cook();
        System.out.println("==========="); // Separate output for better readability
        Recipe grilledChicken = new GrilledChickenRecipe();
        grilledChicken.cook();
    }
}
