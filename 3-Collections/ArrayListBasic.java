import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

record GroceryItem(String name, int quantity, String type) {
    GroceryItem(String name) {
        this(name, 1, "Unclassified");
    }

    @Override
    public String toString() { // Comment this to see the default view of record
        return "| item : " + name + " , quantity : " + quantity + " in category : " + type + " |";
    }
}

public class ArrayListBasic {
    public static void main(String[] args) {
        Object[] objectArr = new Object[3]; // static array
        objectArr[0] = "any object";
        objectArr[1] = new GroceryItem("Cover");
        objectArr[2] = new GroceryItem("Milk", 2, "Dairy");
        // System.out.println("Grocery Array looks like this, " + objectArr);
        // System.out.println("Grocery Array looks like this, " + objectArr.toString());
        System.out.println("Object Array looks like this, " + Arrays.toString(objectArr)); // VVI
        List<Object> objList = List.of(objectArr); // Converting array to Normal list, same for ArrayList
        // NOTE: Changes in the list will be reflected in array and vice versa, IMMUTABLE
        System.out.println("Object List looks like this, " + objList);
        System.out.println("Class: " + objList.getClass().getName()); // Imutable
        // objList.add("random string"); // java.lang.UnsupportedOperationException
        ArrayList<Object> arrList = new ArrayList<>(objList);
        System.out.println("Class: " + arrList.getClass().getName()); // Mutable
        arrList.add("random string");
        System.out.println("Array List looks like this, " + arrList);
        
        GroceryItem[] groceryArr = new GroceryItem[3]; // static array
        // groceryArr[0] = "any object"; // can't convert
        groceryArr[0] = new GroceryItem("Apple", 5, "Produce");
        groceryArr[1] = new GroceryItem("Cover");
        groceryArr[2] = new GroceryItem("Milk", 2, "Dairy");
        System.out.println("Grocery Array looks like this, " + Arrays.toString(groceryArr)); // VVI

        ArrayList<Object> objectList = new ArrayList<>();
        objectList.add("random object");
        objectList.add(new GroceryItem("Apple", 5, "Produce"));
        objectList.add(new GroceryItem("Milk", 2, "Dairy"));
        System.out.println("Object List looks like this, " + objectList); // VVI
        objectList.add(1, "another random string");
        System.out.println("Object List looks like this, " + objectList); // VVI
        objectList.set(1, "this is changed");
        System.out.println("Object List looks like this, " + objectList); // VVI
        objectList.remove(objectList.get(1));
        System.out.println("Object List looks like this, " + objectList); // VVI
        objectList.addAll(objList); // adding similar list to index
        objectList.addAll(1, objList); // adding similar list to index
        System.out.println("54: Object List looks like this, " + objectList); // VVI
        System.out.println("Contains: " + objectList.contains("random object"));
        System.out.println("indexOf: " + objectList.indexOf("any object"));
        System.out.println("lastIndexOf: " + objectList.lastIndexOf("any object"));
        objectList.removeAll(List.of("any object","any object")); // removing multiple elements
        System.out.println("59: Object List looks like this, " + objectList); // VVI
        objectList.retainAll(List.of("random object", new GroceryItem("Apple", 5, "Produce")));
        System.out.println("61: Object List looks like this, " + objectList); // VVI
        objectList.clear();
        System.out.println("Object : " + objectList + " is empty : " + objectList.isEmpty());
        ArrayList<String> strList = new ArrayList<>();
        strList.addAll(List.of("o1","i7","o2","i5", "o3"));
        strList.addAll(Arrays.asList("i3","o4","o5"));
        strList.sort(Comparator.naturalOrder()); // Can't perform this on objects
        System.out.println("69: String list is " + strList);
        strList.sort(Comparator.reverseOrder()); // Can't perform this on objects
        System.out.println("71: String list is " + strList);
        String[] strArr = strList.toArray(new String[strList.size()]); // Default method to convert List to Array
        System.out.println("73: String list is converted to Array " + Arrays.toString(strArr));
        var arr2List = Arrays.asList(strArr); // Again converting array to list
        // NOTE: Changes in the list will be reflected in array and vice versa MUTABLE, list has FIXED SIZE same as array
        System.out.println("75: String list is " + arr2List);


        ArrayList<GroceryItem> groceryList = new ArrayList<>();
        // groceryList.add("random object"); // can't convert
        groceryList.add(new GroceryItem("Apple", 5, "Produce"));
        groceryList.add(new GroceryItem("Cover"));
        groceryList.add(new GroceryItem("Milk", 2, "Dairy"));
        // System.out.println("Grocery Array looks like this, " +
        // groceryList.toString());
        System.out.println("Grocery List looks like this, " + groceryList); // VVI
    }
}