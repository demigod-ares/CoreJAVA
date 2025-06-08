
import java.util.*;

/*
 * @lc app=leetcode id=347 lang=java
 *
 * [347] Top K Frequent Elements
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // freq map
        Map<Integer, Integer> frequencyMap = new HashMap<>();
        for(int num : nums) frequencyMap.put(num, frequencyMap.getOrDefault(num, 0) + 1);
        // bucket sort on freq
        @SuppressWarnings("unchecked") // Fixed length array of List
        List<Integer>[] buckets = (List<Integer>[]) new List[nums.length + 1]; // for [1],1
        for (int key : frequencyMap.keySet()) {
            int frequency = frequencyMap.get(key);
            if (buckets[frequency] == null) {
                buckets[frequency] = new ArrayList<>();
            }
            buckets[frequency].add(key);
        }
        // gather result by going in reverse direction of bucket
        int[] res = new int[k];
        for(int i = buckets.length - 1, index = 0; i >= 0 ; i--) {
            if (index >= k) break;
            if (buckets[i] != null) {
                for(int item : buckets[i]) {
                    if (index >= k) break;
                    res[index] = item;
                    index++;
                }
            }
        }
        return res;
    }
}
// @lc code=end

