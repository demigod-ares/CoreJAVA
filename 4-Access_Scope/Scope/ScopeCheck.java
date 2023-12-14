package Scope;

public class ScopeCheck {
    public int publicVar = 0;
    private int privateVar = 1;
    public ScopeCheck() {
        System.out.println("ScopeCheck created, publicVar = " + publicVar + ": privateVar = " + privateVar);
    }
    public int getPrivateVar() {
        return privateVar;
    }
    public void timesTwo() {
        int privateVar = 2; // not this.privateVar
        for (int i=0; i<10; i++) {
            System.out.println(i + " times two is " + i * privateVar);
        }
    }
    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("Inner class should print variable 3: " + innerClass.privateVar);
    }
    public class InnerClass {
        public int privateVar = 3;
        public InnerClass() {
            System.out.println("InnerClass created, privateVar is " + privateVar);
        }
        public void timesThree() {
            ScopeCheck.this.timesTwo();
            // int privateVar = 4; // not inner class privateVar
            for (int i=0; i<10; i++) {
                System.out.println(i + " times three is " + i * privateVar);
                System.out.println(i + " times one is " + i * ScopeCheck.this.privateVar); // inner class can access privateVar of outer class
            }
        }
    }
}
