public class Variable {

    static int staticVar = 2; // static
    int instanceVar = 3; // instance

    public static void main(String args[]) {
        int localVar = 1; // local
        System.out.println("LocalVariable: " + localVar);
        Variable obj = new Variable();
        System.out.println("Instance: " + ++obj.instanceVar);
        System.out.println("Static: " + ++Variable.staticVar);
        obj.method();
        staticMethod(obj); // Same as Variable.staticMethod(obj); here
    }

    public void method() {
        System.out.println("Inside method()");
        int localVar = 1; // local
        System.out.println("LocalVariable: " + localVar);
        System.out.println("OldInstanceVariable: " + ++this.instanceVar);
        System.out.println("Static: " + ++Variable.staticVar);
    }

    public static void staticMethod(Variable obj) {
        System.out.println("Inside staticMethod()");
        int localVar = 1; // local
        System.out.println("LocalVariable: " + localVar);
        // System.out.println("Instance" + ++this.instanceVar); // Cannot use this in a static context
        System.out.println("OldInstanceVariable: " + ++obj.instanceVar);
        System.out.println("NewInstanceVariable: " + ++new Variable().instanceVar);
        System.out.println("StaticVariable: " + ++Variable.staticVar);
    }
}
