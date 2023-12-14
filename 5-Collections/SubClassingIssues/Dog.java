package SubClassingIssues;

public class Dog {
    private final String name;
    public Dog(String name) {
        this.name = name;
    }
    public String getName() {
        return name;
    }
    @Override
    public final boolean equals(Object obj) { // made final to avoid overriding in child class
        if(this == obj) {
            System.out.println("This equals Obj");
            return true;
        }
        if(obj instanceof Dog) {
            String objName = ((Dog) obj).getName();
            return this.name.equals(objName);
        }
        return false;
    }
}
