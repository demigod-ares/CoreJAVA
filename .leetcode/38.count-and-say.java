/*
 * @lc app=leetcode id=38 lang=java
 *
 * [38] Count and Say
 */

// @lc code=start
class Solution {
    public String countAndSay(int n) {
        if (n == 1) return "1";
        String prev = countAndSay(n - 1); // will execute until (n-1 == 1)
        StringBuilder sb = new StringBuilder(); // ***no mutation***
        for (int i = 0; i < prev.length(); i++) {
            int count = 1;
            char say = prev.charAt(i);
            while (i < prev.length() - 1 && say == prev.charAt(i + 1)) {
                count++;
                i++;
            }
            sb.append(count).append(say);
        }
        return sb.toString();
    }
}
// @lc code=end

