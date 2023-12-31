public class MethodOverloadEx {
// Create a method called calcFeetAndInchesToCentimeters
// It needs to have two parameters. feet is the first parameter, inches is the 2nd parameter
    // validate that the first parameter feet is >= 0
    // validate that the 2nd parameter inches is >=0 and <=12
    // return -1 from the method if either of the above is not true
// If the parameters are valid, then return how many centimetres comprise the feet and inches passed to this method

// Create a 2nd method of the same name but with only one parameter inches is the parameter
    // validate that its >=0
    // return -1 if it is not true
// But if its valid, then return how many feet are in the inches
        // hints: Use double for your number datatypes is probably a good idea
        // 1 inch = 2.54cm  and one foot = 12 inches
    public static void main(String[] args) {
        double centimeters = calcFeetAndInchesToCentimeters(6,0);
        if(centimeters <0.0) {
            System.out.println("Invalid parameters");
        }
        calcFeetAndInchesToCentimeters(157);
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if((feet <0) || ((inches <0) || (inches >12))) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if(inches < 0) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }
        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and " + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }
}
