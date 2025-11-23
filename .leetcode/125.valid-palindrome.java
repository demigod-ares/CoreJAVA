/*
 * @lc app=leetcode id=125 lang=java
 *
 * [125] Valid Palindrome
 */

// @lc code=start
class Solution {
    public boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while(left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if(!Character.isLetterOrDigit(leftChar)) left++;
            else if(!Character.isLetterOrDigit(rightChar)) right--;
            else {
                if(Character.toLowerCase(leftChar) != Character.toLowerCase(rightChar)) return false;
                left++;
                right--;
            }
        }
        return true;
    }
}
// @lc code=end

