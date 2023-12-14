package Strings;

public class Strings {
  public static void printInformation(String string) {
    int length = string.length();
    System.out.printf("Length = %d %n", length);
    if (string.isEmpty()) {
      System.out.println("String is Empty");
      return;
    }
    if (string.isBlank()) {  // String.isBlank() java 11 and above
      System.out.println("String is Blank");
    }
    System.out.printf("First char = %c %n", string.charAt(0));
    System.out.printf("Last char = %c %n", string.charAt(length - 1));
  }

  public static void main(String[] args) {
    // String Inspection
    printInformation("");
    printInformation("\t   \n");
    String helloWorld = "Hello World";
    printInformation(helloWorld);
    System.out.printf("index of r = %d %n", helloWorld.indexOf('r'));
    System.out.printf("index of World = %d %n", helloWorld.indexOf("World"));
    System.out.printf("index of l = %d %n", helloWorld.indexOf('l'));
    System.out.printf("index of l = %d %n", helloWorld.lastIndexOf('l'));
    System.out.printf("index of l after index 3 = %d %n", helloWorld.indexOf('l', 3));
    System.out.printf("index of l after index 8 = %d %n", helloWorld.lastIndexOf('l', 8));
    // String comparision
    String helloWorldLower = helloWorld.toLowerCase();
    if (helloWorld.equals(helloWorldLower)) {
      System.out.println("Values match exactly");
    }
    if (helloWorld.equalsIgnoreCase(helloWorldLower)) {
      System.out.println("Values match ignoring case");
    }
    if (helloWorld.startsWith("Hello")) {
      System.out.println("String starts with Hello");
    }
    if (helloWorld.endsWith("World")) {
      System.out.println("String ends with World");
    }
    if (helloWorld.contains("World")) {
      System.out.println("String contains World");
    }

    if (helloWorld.contentEquals("Hello World")) {
      System.out.println("Values match exactly");
    }
  }
  // Strings are immutable objects, represnted in UTF-16 format. Every string operation creates a new instance of String class, which is highly inefficient. To solve this we have:
  // 1. String.format() for simple string manipulation
  // 2. StringBuilder for complex string manipulation without thread safety
  // 3. StringBuffer for complex string manipulation with thread safety
}
