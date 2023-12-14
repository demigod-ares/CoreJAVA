package singelton4;

public class EagerSingleton {
	private EagerSingleton() {}

	// Eager loading
	private static EagerSingleton singletonInstance = new EagerSingleton();
	// Get the only object available
	public static final EagerSingleton getInstance() { // static final makes it thread safe
		return singletonInstance;
	}
	public void printHash() {
		System.out.println("hashcode of singelton object" + singletonInstance);
	}

}
