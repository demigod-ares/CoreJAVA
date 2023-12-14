package Strings;

public class StringBuilderClass {
  public static void main(String[] args) {
    // StringBuilder for complex string manipulation without thread safety

    String helloWorld = "Hello" + " World";
    helloWorld.concat(" and Goodbye");

    StringBuilder helloWorldBuilder = new StringBuilder("Hello" + " World");
    helloWorldBuilder.append(" and Goodbye");

    printInformation(helloWorld);
    printInformation(helloWorldBuilder); // 16 is the default capacity

    StringBuilder emptyStart = new StringBuilder();
    emptyStart.append("a".repeat(16)); // String.repeat() is available on Java 11 and above
    printInformation(emptyStart);
    emptyStart.append("a".repeat(10));
    printInformation(emptyStart);
    emptyStart.append("a".repeat(15));
    printInformation(emptyStart);
    // capacity is decided by JVM, it will increase like 16, 34, 70 ...

    StringBuilder emptyStart32 = new StringBuilder(32);
    emptyStart32.append("b".repeat(17)); // capacity 32 instead of 34

    printInformation(emptyStart32);

    StringBuilder builderPlus = new StringBuilder("Hello" + " World");
    builderPlus.append(" and Goodbye");

    builderPlus.deleteCharAt(16).insert(16, 'g');
    System.out.println(builderPlus);

    builderPlus.replace(16, 17, "G");
    System.out.println(builderPlus);

    builderPlus.reverse().setLength(7);
    System.out.println(builderPlus);
  }

  public static void printInformation(String string) { // polymorphism
    System.out.println("String = " + string);
    System.out.println("length = " + string.length());
  }

  public static void printInformation(StringBuilder builder) { // polymorphism
    System.out.println("StringBuilder = " + builder);
    System.out.println("length = " + builder.length());
    System.out.println("capacity = " + builder.capacity());
  }
}
