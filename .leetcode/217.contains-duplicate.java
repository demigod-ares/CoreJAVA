
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=217 lang=java
 *
 * [217] Contains Duplicate
 */

// @lc code=start
class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> set = Arrays.stream(nums)
                .boxed()
                .collect(Collectors.toSet());
        return set.size() != nums.length;
    }
}
// @lc code=end

