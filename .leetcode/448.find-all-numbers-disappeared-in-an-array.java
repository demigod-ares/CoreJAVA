/*
 * @lc app=leetcode id=448 lang=java
 *
 * [448] Find All Numbers Disappeared in an Array
 */

// @lc code=start

import java.util.List;
import java.util.stream.IntStream;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
         // using boolean arrey instead of hash set
        boolean[] seen = new boolean[nums.length];
        for(int num: nums) {
            seen[num -1] = true;
        }
        
        return IntStream.rangeClosed(1, seen.length)
            .filter(n -> !seen[n -1])
            .boxed()
            .toList();
    }
}
// @lc code=end

