package flyweight;

public class AnimalClient {
    public static void main(String[] args){
        Animal catAnimal = AnimalFactory.getCat("myCAT");
        catAnimal.printAnimalAttributes();
        
        Animal catAnimal2 = AnimalFactory.getCat("yourCAT");
        catAnimal2.printAnimalAttributes();
        
        Animal cowAnimal = AnimalFactory.getCow("myCOW");
        cowAnimal.printAnimalAttributes();
        
        Animal dogAnimal = AnimalFactory.getDog("myDOG");
        dogAnimal.printAnimalAttributes();
        
        System.out.println(catAnimal.hashCode());
        System.out.println(catAnimal2.hashCode()); // HashCode is same, saves memory, Code for this is in Factory
        System.out.println(cowAnimal.hashCode());
        System.out.println(dogAnimal.hashCode());
    }
}
