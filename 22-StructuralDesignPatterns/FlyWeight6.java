import java.util.HashMap;
import java.util.Map;

// Flyweight Interface
interface Shape {
    void draw(int x, int y);
}

// Concrete Flyweight
class Circle implements Shape {
    private int radius;
    public Circle(int radius) {
        this.radius = radius;
    }
    @Override
    public void draw(int x, int y) {
        System.out.println("Drawing a circle with radius " + this.radius + " at coordinates (" + x + ", " + y + ")");
    }
}

// Flyweight Factory
class ShapeFactory {
    private static final Map<Integer, Shape> circleMap = new HashMap<>();
    public static Shape getCircle(int radius) {
        // Check if a circle with the given radius already exists
        if (!circleMap.containsKey(radius)) {
            // If not, create a new (circle) and put it in the map *****
            circleMap.put(radius, new Circle(radius)); // *****
        }
        // Return the existing or newly created circle
        return circleMap.get(radius);
    }
}

// Client code
public class FlyWeight6 {
    public static void main(String[] args) {
        // Client stores or computes extrinsic state
        int[] xCoordinates = {1, 2, 3, 1, 2, 3};
        int[] yCoordinates = {4, 4, 4, 5, 5, 5};
        // Using the flyweight factory to get and draw circles
        for (int i = 0; i < xCoordinates.length; i++) {
            Shape circle = ShapeFactory.getCircle(2); // Assuming a common radius of 2 (Intrinsic/Shared Attribute/Property)
            circle.draw(xCoordinates[i], yCoordinates[i]);
        }
    }
}