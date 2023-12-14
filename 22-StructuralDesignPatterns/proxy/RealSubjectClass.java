package proxy;

// Implementation Of Subject
public class RealSubjectClass implements Subject {

    @Override
    public void method() {
        System.out.println("I Am an actual implementation of Subject, rest all are proxies :D");
    }
}