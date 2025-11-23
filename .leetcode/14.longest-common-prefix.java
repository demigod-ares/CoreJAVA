/*
 * @lc app=leetcode id=14 lang=java
 *
 * [14] Longest Common Prefix
 */

// @lc code=start
class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) return "";
        String lcp = strs[0];
        for (int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(lcp) != 0) {
                if(lcp.isEmpty()) return "";
                lcp = lcp.substring(0, lcp.length() -1);
            }
        }
        return lcp;
    }
}
// @lc code=end

