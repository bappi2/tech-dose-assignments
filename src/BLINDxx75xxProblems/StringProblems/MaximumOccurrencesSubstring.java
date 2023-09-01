package BLINDxx75xxProblems.StringProblems;

import java.util.HashMap;
import java.util.Map;

public class MaximumOccurrencesSubstring {
    public int maxFreq(String s, int maxLetters, int minSize, int maxSize) {
        Map<String, Integer> stringCount = new HashMap<>();
        int max = 0;
        for (int size = minSize; size <= maxSize; size++) {
            for (int i = 0; i <= s.length() - size; i++) {
                String window = s.substring(i, i + size);
                int charCount  = uniqueCharCount(window);
                if (charCount <= maxLetters) {
                    System.out.println(window + " i: " + i);
                    stringCount.put(window, stringCount.getOrDefault(window, 0) + 1);
                    max = Math.max(max, stringCount.get(window));
                }
            }
        }
        return max;

    }

    private int uniqueCharCount(String window) {
        char [] freq = new char[26];
        int unique = 0;
        for (int i = 0; i < window.length(); i++) {
            if (freq[ window.charAt(i) - 'a'] == 0) {
                unique++;
            }
            freq[window.charAt(i)- 'a']++;
        }
        return unique;
    }

    public static void main(String[] args) {
        MaximumOccurrencesSubstring solution = new MaximumOccurrencesSubstring();

        // Example 1
        String s1 = "aababcaab";
        int maxLetters1 = 2;
        int minSize1 = 3;
        int maxSize1 = 4;
        System.out.println(solution.maxFreq(s1, maxLetters1, minSize1, maxSize1)); // Output: 2

        // Example 2
        String s2 = "aaaa";
        int maxLetters2 = 1;
        int minSize2 = 3;
        int maxSize2 = 3;
        System.out.println(solution.maxFreq(s2, maxLetters2, minSize2, maxSize2)); // Output: 2

    }
}
