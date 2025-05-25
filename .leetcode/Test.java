
public class Test {
    public static int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];
        while (true) {
            slow = nums[slow];
            if(slow != nums[fast])
                fast = nums[nums[fast]];
            if (slow == fast)
                return slow;
        }
    }

    public static void main(String[] args) {
        System.out.println(findDuplicate(new int[]{2,5,9,6,9,3,8,9,7,1}));
    }
}