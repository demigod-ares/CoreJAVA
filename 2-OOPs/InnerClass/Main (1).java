package InnerClass;

public class Main {

    public static void main(String[] args) {
	    Gearbox mcLaren = new Gearbox(6);
        // Gearbox.Gear first = mcLaren.new Gear(1, 12.3); // works when inner class Gear is public
//        Gearbox.Gear second = new Gearbox.Gear(2, 15.4); // Never work
//        Gearbox.Gear third = new mcLaren.Gear(3, 17.8); // Never work
        // System.out.println(first.driveSpeed(1000)); // works when inner class Gear is public
        System.out.println(mcLaren.getGears());
        mcLaren.addGear(3, 15.9); // Problem
        System.out.println(mcLaren.getGears()); // ArrayList, not unique
        mcLaren.operateClutch(true);
        mcLaren.changeGear(2);
        System.out.println(mcLaren.wheelSpeed(200)); // Scream
        mcLaren.operateClutch(false);
        System.out.println(mcLaren.wheelSpeed(200)); // Succesful shift
        mcLaren.changeGear(3);
        System.out.println(mcLaren.wheelSpeed(300)); // Grind
    }
}
