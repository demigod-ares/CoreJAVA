package singelton4;

import java.io.Serializable;

public class NaiveSingleton  implements Serializable, Cloneable { // Note that it is serializable
	private NaiveSingleton() {}

	// Lazy loading
	private static NaiveSingleton singletonInstance;
	// Get the only object available
	public static NaiveSingleton getInstance() { // no final or synchronized, no thread safe
        if (singletonInstance == null) {
            singletonInstance = new NaiveSingleton();
        }
		return singletonInstance;
	}
	public void printHash() {
		System.out.println("hashcode of singelton object" + singletonInstance);
	}

	@Override
    public Object clone() throws CloneNotSupportedException {
        // Allow [4] cloning by creating a new instance
        return super.clone();
    }

}
