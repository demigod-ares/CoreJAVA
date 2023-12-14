// A record in Java is a compact way to define a class that is mainly used to encapsulate data. It was introduced as a preview feature in Java 14 and became a permanent feature in Java 16.
// A record is declared using the record keyword, followed by the class name and a list of components in parentheses. For example:

public record CarRecord(String model, int wheels) { }
// This declares a record named Person that has two components: name of type String and age of type int. The record implicitly defines the following:
// 1. A constructor that initializes the components.
// 2. Getters for each component.
// 3. equals(), hashCode(), and toString() methods that are based on the components.
// Records are commonly used in place of simple data transfer objects or POJOs (Plain Old Java Objects). They provide a concise and expressive way to define classes that primarily hold data, and their compact syntax can make code easier to read and understand.

// Records are immutable by default, meaning that once an object is created, its state/components cannot be changed.
// it is possible to make a record mutable by declaring it with the "open" keyword instead of final. For example:
// open record Person(String name, int age) { }
// In this example, the open keyword is used to declare the Person record as mutable. This means that you can change the state of a Person instance after it is created.
// To modify the state of a mutable record instance, you can use its setter methods, which are automatically generated based on the components of the record. For example:
// Person john = new Person("John", 25);
// john = john.withAge(26);
// In this example, the withAge() method is used to create a new Person instance with the same name as john but with an age of 26.
// It's important to note that making a record mutable goes against the design principles of records, which are meant to be used as immutable data containers. In general, it's a good practice to use immutable objects whenever possible to avoid unexpected side effects and make your code easier to reason about.