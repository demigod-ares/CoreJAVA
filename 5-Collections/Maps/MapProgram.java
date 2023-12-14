package Maps;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {

  public static void main(String[] args) {
    Map<String, String> languages = new HashMap<>();
    languages.put("Java", "incorrect defination of JAVA language");
    if (languages.containsKey("Java")) {
        System.out.println("Java already exists in the map");
    } else {
        languages.put("Java", "a compiled high level, object-oriented, platform independent language");
        System.out.println("Java added successfully");
    }
    System.out.println(
      languages.put("Java", "a compiled high level, object-oriented, platform independent language")); // prints old defination

    languages.put("Python",
            "an interpreted, object-oriented, high-level programming language with dynamic semantics");
    languages.put("Algol", "an algorithmic language");
    System.out.println(languages.put("BASIC", "Beginners All Purposes Symbolic Instruction Code")); // returns null
    System.out.println(languages.put("Lisp", "Therein lies madness")); // returns null

    System.out.println("================================================");
    // for (String key : languages.keySet()) {
    //     System.out.println(key + " : " + languages.get(key));
    // }
    languages.keySet().forEach(key -> {
        System.out.println(key + " : " + languages.get(key));
    });
    System.out.println("================================================");
    languages.entrySet().forEach(entry -> {
        System.out.println(entry.getKey() + " : " + entry.getValue());
    });
    System.out.println("================================================");

    // languages.remove("Lisp"); // Matches exact key only
    if (languages.remove("Algol", "an algorithmic language")) { // Matches exact key value pair
        System.out.println("Algol removed");
    } else {
        System.out.println("Algol not removed, key/value pair not found");
    }
    // languages.replace("Lisp", "this will be added"); // Matches exact key only
    if (languages.replace("Lisp", "Therein lies madness", "a functional programming language with imperative features")) {  // Matches exact key value pair
        System.out.println("Lisp replaced");
    } else {
        System.out.println("Lisp was not replaced");
    }
    System.out.println(languages.replace("Scala", "this will not be added")); // returns null
    for (String key : languages.keySet()) {
        System.out.println(key + " : " + languages.get(key));
    }
  }
}