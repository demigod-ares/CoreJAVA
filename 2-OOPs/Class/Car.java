
// Constructor is better option than this!
public class Car { // encapsulation, getter and setter (POJO without constructor)
    private int wheels = 0;
    private String model;
    public void setModel(String model) {
        String validModel = model.toLowerCase();
        if(validModel.equals("carrera") || validModel.equals("commodore")) {
            this.model = model;
        } else {
            this.model = "Unknown";
        }
    }
    public void setWheels(int wheels){
        this.wheels = wheels;
    }
    public String getModel() {
        return this.model;
    }
    public int getWheels(){
        return this.wheels;
    }
}
