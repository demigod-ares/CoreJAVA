/*
 * @lc app=leetcode id=283 lang=java
 *
 * [283] Move Zeroes
 */

// @lc code=start
class Solution {
    public void moveZeroes(int[] nums) {
        int windowSize = 0;
        for(int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                windowSize++;
            } else if(windowSize > 0) {
                int k = nums[i];
                nums[i] = 0;
                nums[i - windowSize] = k;
            }
        }
    }
}
// @lc code=end

