package SetMethods;

import java.util.HashSet;
import java.util.Set;

/**
Question:
When overriding the equals() method in the HeavenlyBody class, we were careful to make sure that it would not return true if a HeavenlyBody was compared to a subclass of itself.
We did that to demonstrate that method, but it was actually unnecessary in the HeavenlyBody class. Why was it unnecessary?
Answer:
The HeavenlyBody class is declared final, so cannot be subclassed.
The Java String class is also final, which is why it can safely use the instanceof() method without having to worry about comparisons with a subclass.
**/

public final class HeavenlyBody {
    private final String name;
    private final double orbitalPeriod;
    private final Set<HeavenlyBody> satellites;

    public HeavenlyBody(String name, double orbitalPeriod) {
        this.name = name;
        this.orbitalPeriod = orbitalPeriod;
        this.satellites = new HashSet<>();
    }
    public String getName() {
        return name;
    }
    public double getOrbitalPeriod() {
        return orbitalPeriod;
    }
    public boolean addMoon(HeavenlyBody moon) {
        return this.satellites.add(moon);
    }
    public Set<HeavenlyBody> getSatellites() {
        return new HashSet<>(this.satellites);
    }

    @Override
    public boolean equals(Object obj) { // String class already overrides equals()
        if(this == obj) {
            System.out.println("This equals Obj"); // never happens until same
            return true;
        }
        System.out.println("obj.getClass() is " + obj.getClass());
        System.out.println("this.getClass() is " + this.getClass());
        if ((obj == null) || (obj.getClass() != this.getClass())) { // Comparing with Null is important to avoid numm pointer exception
            return false;
        }
        String objName = ((HeavenlyBody) obj).getName();
        return this.name.equals(objName);
    }

    @Override
    public int hashCode() { // Change the bucket of objects to identify similar items
        System.out.println("hashcode called");
        return this.name.hashCode() + 57;
    }
}
