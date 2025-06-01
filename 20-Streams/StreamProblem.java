import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class StreamProblem {

    public static void main(String[] args) {
        // // Stream .generate() and iterate()
        // // 1. Generating 10 Even Numbers
        // List<Integer> evenNumbers = Stream.iterate(0, n -> n + 2) // Start at 0, add 2 to get the next
        //                                   .limit(10).collect(Collectors.toList());
        // System.out.println("evenNumbers: " + evenNumbers); // Output: [0, 2, 4, 6, 8, 10, 12, 14, 16, 18]
        // // 2. Generating first 7 odd numbers starting from 1
        // List<Integer> oddNumbers = Stream.iterate(1, n -> n + 2) // Start at 1, add 2 for the next
        //                                  .limit(7).collect(Collectors.toList());
        // System.out.println(oddNumbers); // Output: [1, 3, 5, 7, 9, 11, 13]
        // // 3. Generating first 5 powers of 2
        // List<Integer> powersOfTwo = Stream.iterate(1, n -> n * 2) // Start at 1, multiply by 2 for the next
        //                                    .limit(5).collect(Collectors.toList());
        // System.out.println("powersOfTwo: " + powersOfTwo); // Output: [1, 2, 4, 8, 16]
        // // Below is Java 9+ addition: iterate with a predicate (useful for 'while' like conditions)
        // // Note: For Java 8, you'd use limit and then a filter, which might not be as efficient
        // // 4. Generating numbers while less than 20 (Java 9+)
        // List<Integer> lessThan20 = Stream.iterate(1, n -> n <= 20, n -> n + 3) // Start at 1, condition n <= 20, increment by 3
        //                                  .collect(Collectors.toList());
        // System.out.println("lessThan20: " + lessThan20); // Output: [1, 4, 7, 10, 13, 16, 19]
        // // 1. Generating 5 Random Integers (0-99)
        // Random random = new Random();
        // int[] randomNumbers = Stream.generate(() -> random.nextInt(100)) // Supplier: generates a random int
        //                                     .limit(5).mapToInt(Integer::intValue).toArray();
        // System.out.println("randomNumbers: "+ Arrays.toString(randomNumbers)); // Output: e.g., [84, 10, 77, 42, 6] (will be different each time)
        // // 2. Generating 3 UUIDs
        // List<String> uuids = Stream.generate(() -> java.util.UUID.randomUUID().toString()) // Supplier: generates a UUID string
        //                            .limit(3).collect(Collectors.toList());
        // System.out.println("uuids: " + uuids); // Output: e.g., [c7d0a..., 8e2b..., d1f3...]
        // // 3. Generating 4 constant strings
        // List<String> constantStrings = Stream.generate(() -> "Hello World!") // Supplier: always returns "Hello World!"
        //                                     .limit(4).collect(Collectors.toList());
        // System.out.println("constantStrings: " + constantStrings);

        // // concat() : combine two or more streams
        // Stream<Integer> stream1 = Stream.of(1, 2, 3);
        // Stream<Integer> stream2 = Stream.of(4, 5, 6);
        // Stream<Integer> combinedIntegerStream = Stream.concat(stream1, stream2);
        // System.out.println("Combined Integers: " + combinedIntegerStream.collect(Collectors.toList())); // Output: [1, 2, 3, 4, 5, 6]
        // Stream<String> streamA = Stream.of("apple", "banana");
        // Stream<String> streamB = Stream.of("cherry", "date", "elderberry");
        // Stream<String> combinedStringStream = Stream.concat(streamA, streamB);
        // System.out.println("Combined Strings: " + combinedStringStream.collect(Collectors.toList())); // Output: [apple, banana, cherry, date, elderberry]
        // // short-circuiting operations (findFirst, findAny, anyMatch, allMatch, noneMatch)
        // List<String> names = Arrays.asList("Alice", "Bob", "Elvis", "Charlie", "David", "Eve", "Frank");
        // // 1. findFirst() - Find the first name that starts with 'D'
        // String firstDName = names.stream()
        //     .filter(name -> {
        //         System.out.println("Checking (findFirst): " + name);
        //         return name.startsWith("D"); // Notice that "Eve" and "Frank" are not printed by the filter.
        //     }).findFirst().orElse(null); // Short-circuits after "David"
        // System.out.println("Found first name starting with 'D': " + firstDName); // Output: David
        // // 2. findAny() - Find any name that starts with 'E'
        // String anyEName = names.parallelStream() // Using parallelStream to demonstrate findAny
        //     // In a parallel stream, 'findAny' is often faster than 'findFirst' because it doesn't need to maintain order.
        //     .filter(name -> {
        //         System.out.println("Checking (findAny): " + name); // Order might vary
        //         return name.startsWith("E");
        //     }).findAny().orElse(null); // Can short-circuit on any matching element
        // System.out.println("Found any name starting with 'E': " + anyEName); // Output: Eve (or similar)
        // // 3. anyMatch() : Check if any number is odd
        // List<Integer> numbers = Arrays.asList(2, 4, 6, 7, 8, 10);
        // boolean hasOdd = numbers.stream().peek(System.out::println)
        //     .anyMatch(n -> n % 2 != 0); // process stream elements without waiting
        // System.out.println("Does the list contain any odd number? " + hasOdd);
        // // 4. allMatch() : Check if all numbers are even in numbers1 and numbers2
        // List<Integer> numbers1 = Arrays.asList(2, 4, 6, 8, 10);
        // List<Integer> numbers2 = Arrays.asList(2, 4, 5, 8, 10);
        // boolean allEven1 = numbers1.stream().peek(System.out::println)
        //     .allMatch(n -> n % 2 == 0); // Processes all elements
        // System.out.println("Are all numbers in " + numbers1 + " even? " + allEven1); // Output: true
        // boolean allEven2 = numbers2.stream().peek(System.out::println)
        //     .allMatch(n -> n % 2 == 0); // Short-circuits at 5, process stream elements without waiting
        // System.out.println("Are all numbers in " + numbers2 + " even? " + allEven2); // Output: false
        // // 5. noneMatch() : Check if none of the words start with 'd' in words1 and words2
        // List<String> words1 = Arrays.asList("apple", "banana", "cherry");
        // List<String> words2 = Arrays.asList("rat", "dog", "cat", "elephant");
        // boolean noneStartWithD1 = words1.stream().peek(System.out::println)
        //     .noneMatch(s -> s.startsWith("d")); // Processes all elements
        // System.out.println("None of the words in " + words1 + " start with 'd'? " + noneStartWithD1); // Output: true
        // boolean noneStartWithD2 = words2.stream().peek(System.out::println)
        //     .noneMatch(s -> s.startsWith("d")); // Short-circuits at "dog", , process stream elements without waiting
        // System.out.println("None of the words in " + words2 + " start with 'd'? " + noneStartWithD2); // Output: false
        // 6. takeWhile() : Java 9+ based intermediate short-circuiting operation
        // List<Integer> numbers = Arrays.asList(1, 4, 2, 5, 3, 4, 5, 6, 7, 1, 2);
        // List<Integer> takenWhile = numbers.stream()
        // .takeWhile(n -> {
        //     System.out.println("Checking (takeWhile): " + n);
        //     return n < 6; // stops at 6
        // }).collect(Collectors.toList());
        // System.out.println("Taken while < 6: " + takenWhile);
        // // 7. dropWhile() : Java 9+ based intermediate short-circuiting operation
        // List<Integer> droppedWhile = numbers.stream()
        // .dropWhile(n -> {
        //     System.out.println("Checking (dropWhile): " + n);
        //     return n < 6;
        // }).collect(Collectors.toList());
        // System.out.println("Dropped while < 6: " + droppedWhile);
        // // 6. Example with sorted data (where takeWhile() is most effective)
        // List<Integer> sortedNumbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        // List<Integer> prefix = sortedNumbers.stream()
        // .takeWhile(n -> n < 7)
        // .collect(Collectors.toList());
        // System.out.println("takeWhile (sorted data, n < 7): " + prefix);
        // // 7. Example with sorted data (where dropWhile() is most effective)
        // System.out.println("\n--- dropWhile (sorted data, n < 7) ---");
        // List<Integer> suffix = sortedNumbers.stream()
        //         .dropWhile(n -> n < 7)
        //         .collect(Collectors.toList());
        // System.out.println("Suffix: " + suffix);

        // // ---------- int/Integer --------------
        // int[] intArr = new int[]{1, 27, 1, 15, 2, 2, 8, 3, 24, 4, 5, 6, 7, 7, 10, 12, 17, 23};
        // List<Integer> intList = List.of(1, 27, 1, 15, 2, 2, 8, 3, 24, 4, 5, 6, 7, 7, 10, 12, 17, 23);
        // int max = Arrays.stream(intArr).max().orElse(0); // orElse
        // System.out.println("Maximum: " + max);
        // int min = intList.stream().mapToInt(Integer::intValue).min().orElse(0);  // mapToInt
        // System.out.println("Minimum: " + min); // efficient
        // Integer maxInteger = intList.stream().max(Integer::compare).orElse(0);
        // System.out.println("Maximum Integer: " + maxInteger);
        // int avg = (int) Arrays.stream(intArr).average().orElse(0.0); // orElse
        // System.out.println("Average: " + avg);
        // avg = (int) intList.stream().mapToInt(Integer::intValue).average().orElse(0.0); // mapToInt & orElse
        // System.out.println("Average: " + avg);
        // int sumOfEven = Arrays.stream(intArr).filter(num -> num % 2 == 0).sum();
        // System.out.println("SumOfEven: " + sumOfEven);
        // sumOfEven = intList.stream().mapToInt(Integer::intValue).filter(num ->  num % 2 == 0).sum(); // mapToInt
        // System.out.println("SumOfEven: " + sumOfEven);
        // int sumOfOdd = Arrays.stream(intArr).filter(num -> num %2 != 0).sum();
        // System.out.println("SumOfOdd: " + sumOfOdd);
        // int[] distinctArr = Arrays.stream(intArr).distinct().toArray(); // toArray
        // System.out.println("distinctArr: " + Arrays.toString(distinctArr));
        // List<Integer> distinctList = intList.stream().distinct().collect(Collectors.toList()); // collect
        // System.out.println("distinctList: " + distinctList);
        // // Square each number in the list and collect the result
        // int[] squareArr = Arrays.stream(intArr).distinct().map(x -> x*x).toArray();
        // System.out.println("Squared Array: " + Arrays.toString(squareArr));
        // List<Integer> squareList = intList.stream().distinct().map(x -> x*x).collect(Collectors.toList());
        // System.out.println("Squared List: " + squareList);
        // // MEDIUM LEVEL PROBLEM
        // // 1. find 2nd min and 2nd max
        // int secondMin = Arrays.stream(intArr).distinct().sorted().skip(1).findFirst().orElse(0);
        // System.out.println("Second minimum: " + secondMin); // skip and findFirst
        // int secondMax = Arrays.stream(intArr).distinct().boxed().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0); // boxed
        // System.out.println("Second maximum: " + secondMax); // Comparator.reverseOrder AND boxed
        // secondMax = intList.stream().distinct().sorted(Comparator.reverseOrder()).skip(1).findFirst().orElse(0);
        // System.out.println("Second maximum: " + secondMax); // Comparator.reverseOrder AND boxed
        // 2. Create jagged array, print contents and flatten using streams
        // int[][] jaggedArr = new int[3][]; // size of outer array
        // for (int i = 0; i < jaggedArr.length; i++) {
        //     int size = (int) (Math.random() * 10) + 1; // random size between 1 and 10
        //     jaggedArr[i] = new int[size];
        //     for (int j = 0; j < size; j++) {
        //         jaggedArr[i][j] = (int) (Math.random() * 10); // random int between 0 and 9
        //     }
        // }
        // Arrays.stream(jaggedArr).forEach(arr -> System.out.println("Contents of arr : " + Arrays.toString(arr)));
        // System.out.println("int[] from jaggedArr : " + Arrays.stream(jaggedArr).map(Arrays::toString)
        //     .collect(Collectors.toList()));
        // int[] flattenedArr = Arrays.stream(jaggedArr)
        //     .flatMapToInt(Arrays::stream) // flatMapToInt
        //     // .distinct().count()); // long value
        //     .distinct().toArray();
        // System.out.println("Flattened Array: " + Arrays.toString(flattenedArr));
        // List<Integer> flattenedList = Arrays.stream(jaggedArr)
        //     .flatMapToInt(Arrays::stream).distinct()
        //     .boxed().collect(Collectors.toList()); // boxed
        // System.out.println("Flattened List: " + flattenedList.toString());
        // 3. Create jagged List of int[], print contents and flatten using streams
        // List<int[]> jaggedList = Arrays.asList(jaggedArr);
        // System.out.println("List of int[] from jaggedList: " + jaggedList.stream()
        //     .map((arr) -> Arrays.toString(arr))
        //     .collect(Collectors.toList()));
        // List<Integer> flattenedList = jaggedList.stream()
        //     .flatMap(arr -> Arrays.stream(arr).boxed())
        //     .distinct()
        //     .collect(Collectors.toList());
        // System.out.println("Flattened List: " + flattenedList);
        // int[] flattenedArr = jaggedList.stream()
        //     .flatMapToInt(Arrays::stream) // flatMapToInt
        //     .distinct()
        //     .toArray();
        // System.out.println("Flattened Array: " + Arrays.toString(flattenedArr));
        // 3. Create jagged List of List, print contents and flatten using streams
        // List<List<Integer>> jaggedLoL = Arrays.stream(jaggedArr)
        //     .map(arr -> Arrays.stream(arr).boxed().collect(Collectors.toList()))
        //     .collect(Collectors.toList());
        // System.out.println("List of int[] from jaggedLoL: " + jaggedLoL.stream()
        //     .map(list -> list.toString()).collect(Collectors.toList()));
        // List<Integer> flattenedList = jaggedLoL.stream()
        //     .flatMap(Collection::stream)
        //     .distinct().collect(Collectors.toList());
        // System.out.println("Flattened List: " + flattenedList);
        // int[] flattenedArr = jaggedLoL.stream()
        //     .flatMap(Collection::stream).distinct()
        //     .mapToInt(Integer::intValue).toArray(); // mapToInt
        // System.out.println("Flattened Array: " + Arrays.toString(flattenedArr));
        // // ------------ String -----------------
        // List<String> words = Arrays.asList("Apple", "banana", "CHERRY", "date", "Elderberry", "apple", "Banana");
        // List<String> upperCaseWords = words.stream().map(String::toUpperCase).collect(Collectors.toList());
        // System.out.println("UpperCaseWords: " + upperCaseWords);
        // List<String> distinctWords = words.stream().map(String::toLowerCase).distinct().collect(Collectors.toList());
        // System.out.println("DistinctWords (transformed to lowercase): " + distinctWords); // distinct
        // List<String> fruits = Arrays.asList("Apple", "Banana", "Apricot", "Orange", "Grape", "Avocado", "Blueberry", "Cherry", "Elderberry");
        // long startsWithA = fruits.stream()
        //     // .map(String::toLowerCase) // increases time complexity
        //     .filter(str -> str.toLowerCase().startsWith("a")).count();
        // System.out.println("Count of string starting with A: " + startsWithA);
        // List<String> sortedFruits = fruits.stream().sorted().collect(Collectors.toList());
        // System.out.println("Fruits sorted: " + sortedFruits); // sorted
        // sortedFruits = fruits.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        // System.out.println("Fruits reverse sorted: " + sortedFruits); // Comparator.reverseOrder
        // MEDIUM LEVEL PROBLEM
        // 1. longest string and it's size
        // int longestStringSize = fruits.stream().mapToInt(String::length).max().orElse(0);
        // System.out.println("Longest String Size: " + longestStringSize); // mapToInt
        // String longestString = fruits.stream().max(Comparator.comparingInt(String::length)).orElse(null);
        // System.out.println("Longest String: " + longestString);// Comparator.comparingInt
        // // 2. find distinct words using stream flatMap
        // List<String> sentences = Arrays.asList(
        //     "Hello world, this is Java.",
        //     "Java is awesome. World is vast.",
        //     "This is a test. Hello World!"
        // );
        // // Example with sentences containing only punctuation/spaces
        // List<String> punctuationSentences = Arrays.asList(".,", "  ", "!!! Hello World !!!");
        // System.out.println("Unique words in sentences: " + findDistinctWords(sentences));
        // System.out.println("Unique words in sentences with punctuation: " + findDistinctWords(punctuationSentences));
        // // 3. ofNullable() Java 9+ based static method
        // String user1 = "Alice";
        // String user2 = null;
        // String user3 = "Bob";
        // List<String> validUsers = Stream.of(user1, user2, user3).flatMap(Stream::ofNullable).collect(Collectors.toList());
        // System.out.println("Valid users: " + validUsers); // Output: [Alice, Bob]
        // 3. Find Palindrome
        List<String> words = Arrays.asList(
            "madam", "hello", "level", "world", "Deified", "Racecar", "Java", "noon", "A", "", "Was it a car or a cat I saw"
        );
        List<String> palindromes = words.stream()
            .filter(StreamProblem::isPalindrome) // Filter using the isPalindrome method
            .collect(Collectors.toList());           // Collect the palindromes into a list
        System.out.println("Palindromes Found: " + palindromes); // last item normailsed with spaces removed
        List<String> palindromesStream = words.stream()
            .map(String::toLowerCase)
            .filter(str -> str.isEmpty() ||
                IntStream.range(0, str.length() / 2) // Stream of indices from 0 up to (length/2 - 1)
                        .allMatch(i -> str.charAt(i) == str.charAt(str.length() - 1 - i))
            ).collect(Collectors.toList());           // Collect the palindromes into a list
        System.out.println("Palindromes Found: " + palindromesStream); // last item not normalised
    }

// public static List<String> findDistinctWords(List<String> sentences) {
//     return sentences.stream()
//         // Define a pattern to split words by non-alphanumeric characters. Below will handle spaces, commas, periods, etc.
//         .flatMap(sentence -> Arrays.stream(sentence.split("[\\s.,!?]+")))
//         .filter(str -> !str.isBlank()).map(String::toLowerCase)
//         .distinct().collect(Collectors.toList());
// }

public static boolean isPalindrome(String str) {
    if (str == null) return false; // Null strings are not palindromes
    if (str.isEmpty()) return true; // Empty string is typically considered a palindrome
    // 1. Normalize the string: convert to lowercase and remove non-alphanumeric characters
    String normalizedStr = str.toLowerCase().replaceAll("[^a-z0-9]", "");
    if (normalizedStr.isEmpty()) return true;
    int left = 0;
    int right = normalizedStr.length() - 1;
    while (left < right) {
        if (normalizedStr.charAt(left) != normalizedStr.charAt(right)) return false; // Characters don't match, not a palindrome
        left++; right--;
    }
    return true; // All characters matched
}
}
