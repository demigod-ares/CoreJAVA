/*
 * @lc app=leetcode id=242 lang=java
 *
 * [242] Valid Anagram
 */

// @lc code=start

import java.util.Arrays;

class Solution {
    public boolean isAnagram(String s, String t) {
        if(s.length() != t.length()) return false;
        // Map<Character, Integer> map = new HashMap<>();
        // for(char ch: s.toCharArray()) {
        //     map.put(ch, map.getOrDefault(ch, 0) + 1);
        // }
        // for(char ch: t.toCharArray()){
        //     if(!map.containsKey(ch) || map.get(ch) == 0) {
        //         return false;
        //     }
        //     map.put(ch, map.get(ch) - 1);
        // }
        // return true;
        int[] charCountS = new int[26];
        int[] charCountT = new int[26];
        for(char ch: s.toCharArray()) charCountS[ch-'a']++;
        for(char ch: t.toCharArray()) charCountT[ch-'a']++;
        return Arrays.equals(charCountS, charCountT);
    }
}
// @lc code=end

