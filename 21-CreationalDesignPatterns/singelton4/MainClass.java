package singelton4;

import factory.Teacher;

public class MainClass {
	public static void main(String[] args) {
		// Hashcode is same
		NaiveSingleton naiveSingelton = NaiveSingleton.getInstance();
		naiveSingelton.printHash();
		NaiveSingleton naiveSingelton2 = NaiveSingleton.getInstance();
		naiveSingelton2.printHash();

		// Hashcode is same
		EagerSingleton eagerSingelton = EagerSingleton.getInstance();
		eagerSingelton.printHash();
		EagerSingleton eagerSingelton2 = EagerSingleton.getInstance();
		eagerSingelton2.printHash();

		// Hashcode is same
		LazySingleton lazySingelton = LazySingleton.getInstance();
		lazySingelton.printHash();
		LazySingleton lazySingelton2 = LazySingleton.getInstance();
		lazySingelton2.printHash();

		// Hashcode is different
		Teacher teacher = new Teacher();
		System.out.println(teacher);
		Teacher teacher2 = new Teacher();
		System.out.println(teacher2);
	}

}
