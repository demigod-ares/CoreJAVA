package FinalStaticInitializer;

public class Main {
    public static void main(String[] args) {
        System.out.println("Main method called");
        SIBTest test = new SIBTest();
        test.someMethod();
        System.out.println("Owner is " + SIBTest.owner);
    }
}
