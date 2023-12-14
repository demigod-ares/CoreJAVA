public class ControlFlowFor {
    public static void main(String[] args) {
        // using the for statement, call the calculateInterest method with the amount of
        // 10000 with an interestRate of 2 to 8 and print
        for (int i = 2; i < 9; i++) {
            System.out
                    .println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        // \start from 8% and work back to 2%
        for (int i = 8; i >= 2; i--) {
            System.out
                    .println("10,000 at " + i + "% interest = " + String.format("%.2f", calculateInterest(10000.0, i)));
        }
        // Create a for statement using any range of numbers
        // Determine if the number is a prime number using the isPrime method
        // if it is a prime number, print it out AND increment a count of the number of
        // prime numbers found
        // if that count is 3 exit the for loop
        // hint: Use the break; statement to exit
        int count = 0;
        for (int i = 10; i < 50; i++) {
            if (isPrime(i)) {
                count++;
                System.out.println("Number " + i + " is a prime number");
                if (count == 3) {
                    System.out.println("Exiting for loop");
                    break;
                }
            }
        }
    }

    public static boolean isPrime(int n) {
        if (n == 1) {
            return false;
        }
        for (int i = 2; i <= n / 2; i++) {
            System.out.println("Looping " + i + "and" + n);
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }

    public static double calculateInterest(double amount, double interestRate) {
        return (amount * (interestRate / 100));
    }
}
