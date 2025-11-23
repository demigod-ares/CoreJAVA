
import java.util.Random;

/*
 * @lc app=leetcode id=528 lang=java
 *
 * [528] Random Pick with Weight
 */

// @lc code=start
class Solution {
    int[] sum; // cummulative sum
    int max;
    Random random = new Random();

    public Solution(int[] w) {
        sum = new int[w.length];
        sum[0] = w[0];
        for(int i = 1; i < w.length; i++) {
            sum[i] = w[i] + sum[i-1];
        }
        max = sum[sum.length - 1];        
    }
    
    public int pickIndex() { // returns index of cummulative sum
        int target = 1 + random.nextInt(max);
        int low = 0, high = sum.length - 1;
        while(low <= high) {
            int mid = low + (high - low)/2;
            if (sum[mid] == target) {
                return  mid;
            }
            if (sum[mid] > target) {
                high = mid - 1;
            } else {
                low = low + 1;
            }
        }
        return low;
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(w);
 * int param_1 = obj.pickIndex();
 */
// @lc code=end

