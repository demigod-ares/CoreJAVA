package proxy;

//extends
public class ProxyClass extends RealSubjectClass {

    @Override
    public void method() {

        System.out.println("Hi, I am Proxy, i will perform authe~ntication ~and security checks");

        // Logic to check if user is authentic or not. If yes then call real object
        // method else dont call below method

        System.out.println("Calling real method of Real subject class implementing class after the call is authenticated");
        super.method();
    }
}