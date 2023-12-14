package SubClassingIssues;

public class DogMain {
    public static void main(String[] args) {
        Labrador rover = new Labrador("Rover");
        Dog rover2 = new Dog("Rover");

        System.out.println(rover2.equals(rover)); // true
        System.out.println(rover.equals(rover2)); // false when we had overridden equals() method
    }
}
