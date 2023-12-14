import java.util.ArrayList;

class IntClass {
  private int myValue;
  public IntClass(int myValue) {
    this.myValue = myValue;
  }
  public int getMyValue() {
    return myValue;
  }
  public void setMyValue(int myValue) {
    this.myValue = myValue;
  }
}

public class AutoBoxUnbox {
  public static void main(String[] args) {
    String[] strArray = new String[10];
    int[] intArray = new int[10];
    // int[] intArray = new Integer[10]; // Type Mismatch
    strArray[0] = "WTF?";
    intArray[0] = 123;

    ArrayList<String> strArrayList = new ArrayList<String>();
    strArrayList.add("Tim");

    ArrayList<IntClass> intClassArrayList = new ArrayList<IntClass>();
    intClassArrayList.add(new IntClass(54));
    Integer integer = new Integer(54); // Depricated
    Double doubleValue = new Double(12.25); // Depricated
    doubleValue += integer;
    
    // ArrayList<int> intArrayList = new ArrayList<int>();
    ArrayList<Integer> intArrayList = new ArrayList<Integer>();
    for (int i = 0; i <= 10; i++) {
      intArrayList.add(i);
    } // Integer.valueOf(i) // Depricated / not needed now

    for (int i = 0; i <= 10; i++) {
      System.out.println(i + " --> " + intArrayList.get(i));
    } // intArrayList.get(i).intValue() // Depricated / not needed now

    Integer myIntValue = 56; // Integer.valueOf(56);
    int myInt = myIntValue; // myIntValue.intValue(); Depricated / not needed now
    System.out.println("Line 45 " + myInt);

    ArrayList<Double> myDoubleValues = new ArrayList<Double>();
    for (double dbl = 0.0; dbl <= 10.0; dbl += 0.5) {
      myDoubleValues.add(dbl); // auto box
    }

    for (int i = 0; i < myDoubleValues.size(); i++) {
      double value = myDoubleValues.get(i); // auto unbox
      System.out.println(i + "  --> " + value);
    }

    // *** NullPointerException ***
    final Long value = null; // Long accepts null
    printLong(value); // long don't
  }
  
  public static void printLong(final long num){
    System.out.println("long value is : " + num);
  }
}
