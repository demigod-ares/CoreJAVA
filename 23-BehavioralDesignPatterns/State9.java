// Step 1: State interface
interface State {
    void turnOn(LightSwitchContext context);
    void turnOff(LightSwitchContext context);
}

// Step 2: ConcreteState classes
class OnState implements State {
    @Override
    public void turnOn(LightSwitchContext context) {
        System.out.println("The light is already ON.");
    }
    @Override
    public void turnOff(LightSwitchContext context) {
        System.out.println("Turning OFF the light.");
        context.setState(new OffState()); // ------------ here
    }
}

class OffState implements State {
    @Override
    public void turnOn(LightSwitchContext context) {
        System.out.println("Turning ON the light.");
        context.setState(new OnState()); // ------------- here
    }
    @Override
    public void turnOff(LightSwitchContext context) {
        System.out.println("The light is already OFF.");
    }
}

// Step 3: Context class
class LightSwitchContext {
    private State state;
    public LightSwitchContext() {
        // Initial state is OFF
        state = new OffState();
    }
    public void setState(State state) {
        this.state = state;
    }
    public void turnOn() {
        state.turnOn(this);
    }
    public void turnOff() {
        state.turnOff(this);
    }
}

// Step 4: Client code
public class State9 {
    public static void main(String[] args) {
        // Create a light switch context
        LightSwitchContext lightSwitch = new LightSwitchContext();

        // Perform actions on the light switch
        lightSwitch.turnOn();
        lightSwitch.turnOff();
        lightSwitch.turnOff();
        lightSwitch.turnOn();
    }
}
