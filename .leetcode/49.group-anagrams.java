/*
 * @lc app=leetcode id=49 lang=java
 *
 * [49] Group Anagrams
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // we want m.n and not m.n.(log n) and so no sorting
        Map<String, List<String>> map = new HashMap<>();
        for(String word : strs) {
            int[] charFreq = new int[26];
            for(char ch: word.toCharArray()) {
                charFreq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder(); // Step 2 "b2c1g3"
            for(int i = 0; i < 26; i++) {
                if(charFreq[i] > 0) {
                    sb.append((char) i - 'a').append(charFreq[i]);
                }
            }
            String key = sb.toString();
            // char[] chars = word.toCharArray();
            // Arrays.sort(chars);  // sorting string will add n.(log n) time complexity
            // String key = new String(chars);

            // if (!map.containsKey(key)) {
            //     map.put(key, new ArrayList<>());
            // }
            // map.get(key).add(word);
            map.computeIfAbsent(key, k -> new ArrayList<>()).add(word);
        }
        return new ArrayList<>(map.values());
    }
}
// @lc code=end

