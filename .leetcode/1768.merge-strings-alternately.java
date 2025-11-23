/*
 * @lc app=leetcode id=1768 lang=java
 *
 * [1768] Merge Strings Alternately
 */

// @lc code=start
class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder sb = new StringBuilder();
        int max = Math.max(word1.length(), word2.length());
        for(int i=0; i < max; i++) {
            if(i<word1.length() && i<word2.length())
                sb.append(word1.charAt(i)).append(word2.charAt(i));
            else if(i < word1.length()) sb.append(word1.charAt(i));
            else sb.append(word2.charAt(i));
        }
        return sb.toString();
    }
}
// @lc code=end

