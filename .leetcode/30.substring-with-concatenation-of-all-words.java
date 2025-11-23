/*
 * @lc app=leetcode id=30 lang=java
 *
 * [30] Substring with Concatenation of All Words
 */

// @lc code=start

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        
        // 1. PSEUDO CODE: Initialization and Edge Cases
        List<Integer> result = new ArrayList<>();
        if (words.length == 0 || s.length() == 0) {
            return result;
        }

        // 1.1. Determine fixed lengths
        int wordLength = words[0].length();
        int numWords = words.length;
        int totalLength = wordLength * numWords;
        if (s.length() < totalLength) {
            return result;
        }
        // 1.2. Create the reference frequency map (the 'needs' map)
        Map<String, Integer> wordCounts = new HashMap<>();
        for (String word : words) {
            wordCounts.put(word, wordCounts.getOrDefault(word, 0) + 1);
        }

        // 2. Outer Loop (Iterate through all possible starting offsets)
        for (int i = 0; i < wordLength; i++) {
            // 3. Inner Sliding Window (for the current offset i)
            Map<String, Integer> wordsFound = new HashMap<>(); // Map for the current window's content
            int wordsUsed = 0; // Counter for words found in the window
            int left = i; // Left pointer of the window
            // 3.1. Slide the right pointer 'right' across the string, advancing by 'wordLength'
            for (int right = i; right <= s.length() - wordLength; right += wordLength) {
                // 3.2. Extract the word segment
                String currentWord = s.substring(right, right + wordLength);
                // 3.3. Check if the word is a known word
                if (wordCounts.containsKey(currentWord)) {
                    // 3.3a. Add the word to the current window's map
                    wordsFound.put(currentWord, wordsFound.getOrDefault(currentWord, 0) + 1);
                    wordsUsed++;
                    // 3.4. Shrink the window if a word count is exceeded (invalid window). This moves the 'left' pointer forward by one word length at a time.
                    // *** "wordgoodgoodgoodbestword", ["word","good","best","word"] for this if() will fail but while() will not
                    while (wordsFound.get(currentWord) > wordCounts.get(currentWord)) {
                        String leftWord = s.substring(left, left + wordLength); // *** IMP ***
                        wordsFound.put(leftWord, wordsFound.get(leftWord) - 1); // this will save calculation time as we are not starting from begining
                        wordsUsed--;
                        left += wordLength;
                    }
                    // 3.5. Check for a valid concatenation
                    if (wordsUsed == numWords) { // The entire window is valid! Record the starting index 'left'.
                        result.add(left);
                        // 3.5a. Advance the window one step (by one word length) to continue searching
                        String leftWord = s.substring(left, left + wordLength); // *** IMP ***
                        wordsFound.put(leftWord, wordsFound.get(leftWord) - 1); // this will save calculation time as we are not starting from begining
                        wordsUsed--;
                        left += wordLength;
                    }
                } else {
                    // 3.6. If the word is NOT a known word, the whole window is invalid. Reset the window, clear the map, and move the left pointer past the current (bad) word.
                    wordsFound.clear();
                    wordsUsed = 0;
                    left = right + wordLength; // *** JUMP left pointer past the invalid word.
                }
            }
        }
        
        // 4. PSEUDO CODE: Return the result list
        return result;
    }
}
// @lc code=end

