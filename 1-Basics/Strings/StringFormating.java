package Strings;

import java.util.Date;

public class StringFormating {
  static int ObjectCound = 0;
  int instanceVariable;

  public static void main(String arges[]) {
    for (int i = 1; i <= 10; i++) {
      for (int j = 1; j <= 10; j++) {
        System.out.printf("%4d", i * j);
      }
      System.out.println();
    }
    System.out.println("\n\n\n");

    // double Formating
    double value = 123.123456d;
    System.out.printf("%.20e|\n", value);
    System.out.printf("%14e|\n", value);
    System.out.printf("%15e|\n", value);
    System.out.printf("%-15e|\n", value);
    System.out.printf("%10.2e|\n", value);
    System.out.printf("%15.10e|\n", value);
    // %s %d %f %e %b

    // Static Helper method String.format() for simple string manipulation
    System.out.println(String.format("%4d", 1));
    System.out.println(String.format("%.4f", 111.1234567890f));
    System.out.println(String.format("%tR", new Date()));
    System.out.println(String.format("%tF", new Date()));
    System.out.println(String.format("%d%%", 90));
  }
}
