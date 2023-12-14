package factory;

public class FactoryPatternMainClass {
	
	public static void main(String[] args) {
		ProfessionFactory professionFactory = new ProfessionFactory();
		// new keyword is not used to create a instance of an object which satisfies Profession interface
		// Since constructor is not called directly, this design pattern is also called Virtual Constructor.
		Profession doc = professionFactory.getProfession("Doctor");
		doc.print();
		
	}

}
