// Implementor interface
interface DrawingAPI {
    void drawCircle(int x, int y, int radius);
}

// Concrete Implementor
class DrawingAPI1 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.printf("API 1 .circle at %d:%d radius %d\n", x, y, radius);
    }
}
class DrawingAPI2 implements DrawingAPI {
    @Override
    public void drawCircle(int x, int y, int radius) {
        System.out.printf("API 2 .circle at %d:%d radius %d\n", x, y, radius);
    }
}

// Abstraction: This is the high-level interface that defines the abstraction's functionality.
// It maintains a reference to an object of type Implementor ***********************************
abstract class Shape {
    protected DrawingAPI drawingAPI;
    protected Shape(DrawingAPI drawingAPI) {
        this.drawingAPI = drawingAPI;
    }
    public abstract void draw();
}

// Refined Abstraction: This is a subclass of Abstraction that further customizes the abstraction.
class Circle extends Shape {
    private int x, y, radius;

    public Circle(int x, int y, int radius, DrawingAPI drawingAPI) {
        super(drawingAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    @Override
    public void draw() { // overriding protected method of super
        drawingAPI.drawCircle(x, y, radius);
    }
}

// Client code
public class Bridge2 {
    public static void main(String[] args) {
        DrawingAPI api1 = new DrawingAPI1();
        DrawingAPI api2 = new DrawingAPI2();
        Shape circle1 = new Circle(1, 2, 3, api1);
        Shape circle2 = new Circle(5, 7, 11, api2);
        circle1.draw(); // Calls API1.drawCircle
        circle2.draw(); // Calls API2.drawCircle
    }
}

