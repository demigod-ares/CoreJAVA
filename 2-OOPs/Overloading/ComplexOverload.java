public class ComplexOverload {
    public static void main(String[] args) {
        System.out.println(add(1));
        System.out.println(add(1, 2));
        System.out.println(add(1, 2, 3));
        System.out.println(add(1, 2, 3, 4));
        System.out.println(add(0.5f, 1, 2, 3, 4));
    }

    private static float add(float f1, int... ints) {
        float sum = f1;
        for (int i = 0; i < ints.length; i++) {
            sum += ints[i];
        }
        return sum;
    }
    private static int add(int... ints){ // comment this to see effect
        int sum = 0;
        for(int i =0;i<ints.length;i++){
            sum += ints[i];
        }
        return sum;
    }
    private static int add(int n1, int n2){
        return n1+n2;
    }
    private static int add(int n1){
        return n1;
    }
}
