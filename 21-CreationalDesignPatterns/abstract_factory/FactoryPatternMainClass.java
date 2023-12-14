package abstract_factory;

public class FactoryPatternMainClass {
	public static void main(String[] args) {
		AbstractFactory professionFactory = AbstractFactoryProducer.getProfession(false);
		Profession engineer = professionFactory.getProfession("engineer");
		engineer.print();
		AbstractFactory traineeFactory = AbstractFactoryProducer.getProfession(true);
		Profession traineeEngineer = traineeFactory.getProfession("engineer");
		traineeEngineer.print();
	}

}
