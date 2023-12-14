import java.util.HashMap;

public class Test {
    public static void main(String[] args) {

        Integer[] intArr = {1,2,3,4,5,5,7,9,2,2};
        HashMap<Integer, Integer> intMap = new HashMap<>();
        for (Integer i: intArr) {
            if(intMap.containsKey(i)) intMap.put(i, intMap.get(i) + 1);
            else intMap.put(i, 1);
        }
        System.out.println(intMap);

        char[] myStr = "My name is Siddharth Singh, This is my string.".toCharArray(); // converting to char array
        HashMap<Character, Integer> strMap = new HashMap<>();
        for (char c: myStr){
            if (strMap.containsKey(c)) strMap.put(c, strMap.get(c) + 1);
            else strMap.put(c, 1);
        }
        System.out.println(strMap);
    }
}