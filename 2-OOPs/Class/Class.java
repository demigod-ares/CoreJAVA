

public class Class {
    public static void main(String[] args) {
        new Car(); // Car class provides a blueprint, object created in memory but we can't access it. will be elligible for garbage collection
	    Car porsche = new Car(); // new Car() creates an "object"/"instance" of class Car
        // porsche is an instanceVariable which stores the "reference" of memory location to this new object
        Car porscheCopy = porsche; // new instanceVariable which stores same "reference" to old object
        System.out.println("Model is " + porsche.getModel() + " and wheels are " + porsche.getWheels());
        System.out.println("Model is " + porscheCopy.getModel() + " and wheels are " + porscheCopy.getWheels());
        porsche.setModel("Commodore");
        porsche.setWheels(4);
        System.out.println("Model is " + porsche.getModel() + " and wheels are " + porsche.getWheels());
        System.out.println("Model is " + porscheCopy.getModel() + " and wheels are " + porscheCopy.getWheels()); // Confirms both have same reference
        Car holden = new Car();
        holden.setModel("Carrera");
        System.out.println("Model is " + holden.getModel() + " and wheels are " + holden.getWheels());
        porscheCopy = holden; // reference changed
        System.out.println("Model is " + porscheCopy.getModel() + " and wheels are " + porscheCopy.getWheels()); // Confirms both have same reference
        holden.setModel("911");
        System.out.println("Model is " + holden.getModel() + " and wheels are " + holden.getWheels());

        CarRecord recordCar = new CarRecord("MyModel", 4);
        System.out.println(recordCar); // toString()
        System.out.println("Model is " + recordCar.model() + " and wheels are " + recordCar.wheels());
    }
}
