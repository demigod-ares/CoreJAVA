package prototype5;

public abstract class Profession implements Cloneable {

	public int id;
	public String name;

	abstract void print(); // abstract

	public Object cloningMethod() { // concrete
		Object clone = null;
		try {
			clone = super.clone(); // Cloneable.clone() ****
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return clone;
	}

}
