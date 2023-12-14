package flyweight;

public class Cow implements Animal {

    private String name = null;
    
    @Override
    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void printAnimalAttributes() {
        System.out.println("Name of animal is " + this.name);
        System.out.println("Number of eyes of animal is " + CommonShareableClass.eyes);
        System.out.println("Number of legs of animal is " + CommonShareableClass.legs);
        System.out.println("Number of nose of animal is " + CommonShareableClass.nose);
        System.out.println("Number of tail of animal is " + CommonShareableClass.tail);
    }
}
