package BLINDxx75xxProblems.HashMapProblems;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

public class LongestSubstringAtMostTwoDistinctCharacters {
    // https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/description/
    /*
    Example 1:

    Input: s = "eceba"
    Output: 3
    Explanation: The substring is "ece" which its length is 3.
    Example 2:

    Input: s = "ccaabbb"
    Output: 5
    Explanation: The substring is "aabbb" which its length is 5.
     */
    public int lengthOfLongestSubstringTwoDistinct(String s) {
        if (s.length() < 3) {
            return s.length();
        }
        int left = 0;
        int max = 2;
        Map<Character, Integer> map = new HashMap<>();
        for (int right = 0; right < s.length(); right++) {
            map.put(s.charAt(right), right);
            if (map.size() > 2) {
                int del_index = Collections.min(map.values());
                map.remove(s.charAt(del_index));
                left = del_index + 1;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
