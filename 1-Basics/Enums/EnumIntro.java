package Enums;

import java.util.Random;

class DoWclass { // Without enum
  public static final int SUNDAY = 0;
  public static final int MONDAY = 1;
  public static final int TUESDAY = 2;
  public static final int WEDNESDAY = 3;
  public static final int THRUSDAY = 4;
  public static final int FRIDAY = 5;
  public static final int SATURDAY = 6;

  public static final boolean isWeekendClass(int day) {
    return (day == SATURDAY || day == SUNDAY);
  }

}

enum DayOfWeek { // Enum are specialied classes that deals with number of constants
  SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THRUSDAY, FRIDAY, SATURDAY
}

class EnumIntro {
  static final boolean isWeekend(DayOfWeek day) {
    return (day == DayOfWeek.SATURDAY || day == DayOfWeek.SUNDAY);
  }
  public static void main(String[] args) {
    System.out.println(EnumIntro.isWeekend(DayOfWeek.SUNDAY));
    System.out.println(DoWclass.isWeekendClass(4));
    
    DayOfWeek[] array = DayOfWeek.values();
    for (int i = 0; i < 10; i++) {
      int random = new Random().nextInt(7); // Enum methods name() and ordinal()
      System.out.println(random + " and " + array[random] + " | " + array[random].name() + " : " + array[random].ordinal());
      switch (array[random]) {
        case FRIDAY:
          System.out.println("FRIDAY");
          break;
        case MONDAY:
          System.out.println("MONDAY");
          break;
        case SATURDAY:
          System.out.println("SATURDAY");
          break;
        case SUNDAY:
          System.out.println("SUNDAY");
          break;
        case THRUSDAY:
          System.out.println("THRUSDAY");
          break;
        case TUESDAY:
          System.out.println("TUESDAY");
          break;
        case WEDNESDAY:
          System.out.println("WEDNESDAY");
          break;
        default:
          System.out.println("INVALID");
          break;

      }
    }
  }
}