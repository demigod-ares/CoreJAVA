import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StreamFile {
    private static final String FILE_NAME = "sample.txt";
    // Helper method to create a sample file if it doesn't exist
    private static void createSampleFile() {
        Path filePath = Paths.get(FILE_NAME);
        if (!Files.exists(filePath)) {
            try {
                List<String> initialLines = Arrays.asList(
                    "Apple", "Banana", "Apricot", "Orange", "Grape", "Avocado", "Blueberry", "Cherry", "Elderberry"
                );
                Files.write(filePath, initialLines);
                System.out.println("Created sample file: " + FILE_NAME);
            } catch (IOException e) {
                System.err.println("Failed to create sample file: " + e.getMessage());
            }
        }
    }
    public static void main(String[] args) {
        createSampleFile();
        System.out.println("---1. All lines from " + FILE_NAME + " ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            lines.forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\n--- 2. Lines starting with 'A' ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            List<String> aFruits = lines.filter(line -> line.startsWith("A")).collect(Collectors.toList());
            System.out.println(aFruits);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\n--- 3. Count of lines (transformed to uppercase) ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            long count = lines.map(String::toUpperCase).peek(System.out::println).count(); // Terminal operation
            System.out.println("Total lines (after mapping to uppercase): " + count);
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\n--- 4. Longest line ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            Optional<String> longestLine = lines.max(Comparator.comparingInt(String::length)); // Using max with a comparator
            longestLine.ifPresent(line -> System.out.println("Longest line: " + line));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        System.out.println("\n--- 5. Group lines by first letter ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            Map<Character, List<String>> groupedByFirstLetter = lines.collect(Collectors.groupingBy(line -> line.charAt(0)));
            groupedByFirstLetter.forEach((key, value) -> System.out.println(key + ": " + value));
        } catch (IOException e) {
            System.err.println("Error reading file: " + e.getMessage());
        }
        
        // --- Example 6: Process and write filtered lines to a new file ---
        String outputFileName = "filtered_fruits.txt";
        System.out.println("\n--- 6. Filtering and writing to " + outputFileName + " ---");
        try (Stream<String> lines = Files.lines(Paths.get(FILE_NAME))) {
            List<String> processedLines = lines.filter(line -> line.length() > 5) // Filter lines longer than 5 chars
                                            .map(String::trim) // Remove leading/trailing whitespace
                                            .sorted().collect(Collectors.toList());
            Files.write(Paths.get(outputFileName), processedLines);
            System.out.println("Filtered and sorted lines written to " + outputFileName);
            System.out.println("Content of " + outputFileName + ":");
            Files.lines(Paths.get(outputFileName)).forEach(System.out::println);
        } catch (IOException e) {
            System.err.println("Error processing or writing file: " + e.getMessage());
        }
    }
}
