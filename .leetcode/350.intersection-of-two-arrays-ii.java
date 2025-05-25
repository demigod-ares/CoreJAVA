/*
 * @lc app=leetcode id=350 lang=java
 *
 * [350] Intersection of Two Arrays II
 */

// @lc code=start

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Map<Integer, Long> freqMap = Arrays.stream(nums1)
            .boxed()
            .collect(Collectors.groupingBy(i -> i, Collectors.counting()));
        List<Integer> result = new ArrayList<>();
        for(int num : nums2) {
            if(freqMap.containsKey(num) && freqMap.get(num) > 0) {
                result.add(num);
                freqMap.put(num, freqMap.get(num) - 1);
            }
        }
        return result.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
}
// @lc code=end

