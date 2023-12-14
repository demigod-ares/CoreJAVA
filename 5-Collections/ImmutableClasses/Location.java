package ImmutableClasses;

import java.util.HashMap;
import java.util.Map;

public class Location {
    private final int locationID;
    private final String description;
    private final Map<String, Integer> exits;

    public Location(int locationID, String description, Map<String, Integer> exits) {
        this.locationID = locationID;
        this.description = description;
        // Created fully immutable class by using private/ final/ remove addExit() method/ line 15 modified to 16
        // this.exits = exits;
        // this.exits = new HashMap<String, Integer>(exits); // Corrected the bug but still NullPointerException can happen at runtime
        if(exits != null) {
            this.exits = new HashMap<String, Integer>(exits);
        } else {
            this.exits = new HashMap<String, Integer>();
        }
        this.exits.put("Q", 0);
    }
    // Removed addExit() method
    public int getLocationID() {
        return locationID;
    }
    public String getDescription() {
        return description;
    }
    public Map<String, Integer> getExits() {
        return new HashMap<String, Integer>(exits);
    }
}
