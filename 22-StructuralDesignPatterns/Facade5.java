// Subsystem class 1
class Engine {
    public void start() {
        System.out.println("Engine started");
    }
    public void stop() {
        System.out.println("Engine stopped");
    }
}

// Subsystem class 2
class Lights {
    public void turnOn() {
        System.out.println("Lights turned on");
    }
    public void turnOff() {
        System.out.println("Lights turned off");
    }
}

// Subsystem class 3
class FuelSystem {
    public void pumpFuel() {
        System.out.println("Fuel pumped");
    }
    public void stopPumpingFuel() {
        System.out.println("Stopped pumping fuel");
    }
}

// Facade class: class that provides a simplified interface for Client to access the subsystems.
// It knows which subsystem classes are responsible for a request and delegates the client requests to appropriate objects within the subsystem.
class CarFacade {
    private Engine engine;
    private Lights lights;
    private FuelSystem fuelSystem;
    public CarFacade() {
        this.engine = new Engine();
        this.lights = new Lights();
        this.fuelSystem = new FuelSystem();
    }
    public void startCar() {
        engine.start();
        lights.turnOn();
        fuelSystem.pumpFuel();
        System.out.println("Car started and ready to go");
    }
    public void stopCar() {
        engine.stop();
        lights.turnOff();
        fuelSystem.stopPumpingFuel();
        System.out.println("Car stopped");
    }
}

// Client code
public class Facade5 {
    public static void main(String[] args) {
        // Using the facade to start and stop the car
        CarFacade carFacade = new CarFacade();
        carFacade.startCar();
        carFacade.stopCar();
    }
}

