package BLINDxx75xxProblems.SlidingWindowTechnique;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringwithAtMostKDistinctCharacters {
    public static int lengthOfLongestSubstringKDistinct(String s, int k) {
        if (s == null || s.length() == 0 || k == 0) {
            return 0;
        }

        int maxLen = 0;
        int left = 0;
        Map<Character, Integer> charCount = new HashMap<>();

        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            charCount.put(c, charCount.getOrDefault(c, 0) + 1);

            while (charCount.size() > k) {
                char leftChar = s.charAt(left);
                charCount.put(leftChar, charCount.get(leftChar) - 1);
                if (charCount.get(leftChar) == 0) {
                    charCount.remove(leftChar);
                }
                left++;
            }

            maxLen = Math.max(maxLen, right - left + 1);
        }

        return maxLen;
    }

    public static void main(String[] args) {
        String s1 = "eceba";
        int k1 = 2;
        int result1 = lengthOfLongestSubstringKDistinct(s1, k1);
        System.out.println("Example 1: " + result1);  // Output: 3

        String s2 = "aa";
        int k2 = 1;
        int result2 = lengthOfLongestSubstringKDistinct(s2, k2);
        System.out.println("Example 2: " + result2);  // Output: 2
    }
}
