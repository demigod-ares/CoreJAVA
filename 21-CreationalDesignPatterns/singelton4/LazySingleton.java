package singelton4;

public class LazySingleton {
    private LazySingleton() {}

	// Lazy loading
	private static LazySingleton singletonInstance;
	// Get the only object available
	public static synchronized LazySingleton getInstance() { // no final, no thread safe
        if (singletonInstance == null) {
            singletonInstance = new LazySingleton();
        }
		return singletonInstance;
	}
	public void printHash() {
		System.out.println("hashcode of singelton object" + singletonInstance);
	}
}
