
import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

/*
 * @lc app=leetcode id=349 lang=java
 *
 * [349] Intersection of Two Arrays
 */

// @lc code=start
class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.toSet());
        Set<Integer> finalSet = Arrays.stream(nums2)
            .boxed()
            .filter(num -> set1.contains(num))
            .collect(Collectors.toSet());
        
        return finalSet.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
// @lc code=end

