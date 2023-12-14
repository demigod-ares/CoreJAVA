// Product: Meal
class Meal {
    private String burger;
    private String drink;
    private String dessert;

    public void setBurger(String burger) {
        this.burger = burger;
    }

    public void setDrink(String drink) {
        this.drink = drink;
    }

    public void setDessert(String dessert) {
        this.dessert = dessert;
    }

    public void display() {
        System.out.println("Burger: " + burger);
        System.out.println("Drink: " + drink);
        System.out.println("Dessert: " + dessert);
    }
}

// Builder interface
interface MealBuilder {
    void buildBurger();
    void buildDrink();
    void buildDessert();
    Meal getMeal();
}

// Concrete Builder for a Veg Meal
class VegMealBuilder implements MealBuilder {
    private Meal meal = new Meal();

    @Override
    public void buildBurger() {
        meal.setBurger("Veg Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Coke");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Ice Cream");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

// Concrete Builder for a Non-Veg Meal
class NonVegMealBuilder implements MealBuilder {
    private Meal meal = new Meal();

    @Override
    public void buildBurger() {
        meal.setBurger("Chicken Burger");
    }

    @Override
    public void buildDrink() {
        meal.setDrink("Pepsi");
    }

    @Override
    public void buildDessert() {
        meal.setDessert("Chocolate Cake");
    }

    @Override
    public Meal getMeal() {
        return meal;
    }
}

// Director
class Waiter {
    private MealBuilder mealBuilder;

    public void setMealBuilder(MealBuilder mealBuilder) {
        this.mealBuilder = mealBuilder;
    }

    public Meal constructMeal() {
        mealBuilder.buildBurger();
        mealBuilder.buildDrink();
        mealBuilder.buildDessert();
        return mealBuilder.getMeal();
    }
}

// Client code
// Step by step creating final object by combining smaller object
public class BuilderObject3 {
    public static void main(String[] args) {
        Waiter waiter = new Waiter();

        // Creating a Veg Meal
        MealBuilder vegMealBuilder = new VegMealBuilder();
        waiter.setMealBuilder(vegMealBuilder);
        Meal vegMeal = waiter.constructMeal(); // constructs final object

        System.out.println("Veg Meal:");
        vegMeal.display(); // uses final object

        // Creating a Non-Veg Meal
        MealBuilder nonVegMealBuilder = new NonVegMealBuilder();
        waiter.setMealBuilder(nonVegMealBuilder);
        Meal nonVegMeal = waiter.constructMeal();

        System.out.println("\nNon-Veg Meal:");
        nonVegMeal.display();
    }
}
