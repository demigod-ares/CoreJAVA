public class ConstructorOverload {
    private int n1 =1, n2 = 2;
    public ConstructorOverload() { // Comment this and see no effect
        System.out.println("Inside Default Constructor: " + n1 + " and " + n2);
    }
    public ConstructorOverload(int n1){
        this.n1 = n1;
        System.out.println("Inside Constructor with 1 parameter: " + n2);
    }
    public ConstructorOverload(int n1, int n2){
        this.n1 = n1;
        this.n2 = n2;
        System.out.println("Inside Constructor with 2 parameter");
    }
    public static void main(String args[]){
        ConstructorOverload obj1 = new ConstructorOverload();
        ConstructorOverload obj2 = new ConstructorOverload(10);
        ConstructorOverload obj3 = new ConstructorOverload(10, 20);
        System.out.println("For Constructor 1 n1=" + obj1.n1 + " n2=" + obj1.n2);
        System.out.println("For Constructor 2 n1=" + obj2.n1 + " n2=" + obj2.n2);
        System.out.println("For Constructor 3 n1=" + obj3.n1 + " n2=" + obj3.n2);
    }
}
