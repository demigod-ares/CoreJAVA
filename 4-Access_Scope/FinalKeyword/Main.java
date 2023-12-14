package FinalInitializer;

public class Main {

    public static void main(String[] args) {
	SomeClass one = new SomeClass("one");
        SomeClass two = new SomeClass("two");
        SomeClass three = new SomeClass("three");

        System.out.println(one.getInstanceNumber());
        System.out.println(two.getInstanceNumber());
        System.out.println(three.getInstanceNumber());

//        one.instanceNumber = 4; // final variable
        System.out.println(Math.PI);
//        Math m = new Math(); // constructor is private

        int pw = 674312;
        Password password = new Password(pw);
        password.storePassword();

        password.letMeIn(1);
        password.letMeIn(523266);
        password.letMeIn(9773);
        password.letMeIn(0);
        password.letMeIn(-1);
        password.letMeIn(674312);

        int pw2 = 674312;
        Password password2 = new ExtendedPassword(pw2);
        password2.storePassword();
    }
}
