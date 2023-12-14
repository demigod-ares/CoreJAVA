import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class StreamsIntermediate {
    
    public static void main(String[] args) {
        List<Integer> intList = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        Stream<Integer> evenNumbers = intList.stream() // Stream created
            .filter(n -> n%2 == 0) // intermediate operation
            .peek(System.out::println); // intermediate operation
        int sumEven = evenNumbers.reduce(0, Integer::sum); // terminal method
        System.out.println("Sum of even numbers : " + sumEven);

        List<String> strList = Arrays.asList("John", "Jane", "Adam", "Eve");
        strList.stream()
            .filter(s -> s.startsWith("J"))
            .peek(System.out::println) // intermediate operation
            .map(String::toUpperCase) // intermediate operation
            .forEach(System.out::println); // terminal method Returns void

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5);
        // Using map and reduce to calculate the sum of squares of even numbers
        int sumOfSquaresOfEvenNumbers = numbers.stream()
                                                .filter(number -> number % 2 == 0)
                                                .map(number -> number * number)
                                                .reduce(0, (acc, number) -> acc + number);
        System.out.println(sumOfSquaresOfEvenNumbers); // Prints 20

    } // Collect terminal method is a bit complex
}