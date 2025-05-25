
import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode id=219 lang=java
 *
 * [219] Contains Duplicate II
 */

// @lc code=start
class Solution {
    public static boolean containsNearbyDuplicate(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        int numsLastInsertedIndex = 0;
        for (int i = 0; i < nums.length; i++) {
            if(!set.add(nums[i]))
                return true;
            if (set.size() > k) // size limit is k
                set.remove(nums[numsLastInsertedIndex++]); // removing and increasing
        }

        return false;
    }
}
// @lc code=end

