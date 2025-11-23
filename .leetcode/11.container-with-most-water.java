/*
 * @lc app=leetcode id=11 lang=java
 *
 * [11] Container With Most Water
 */

// @lc code=start
class Solution {
    public int maxArea(int[] height) {
        int res = 0, i = 0, j = height.length - 1;
        while(i < j) {
            res = Math.max(res, (j - i) * Math.min(height[i], height[j]));
            if(height[i] > height[j]) j--;
            else i++;
        }
        return res;
    }
}
// @lc code=end

