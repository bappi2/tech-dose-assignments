package BLINDxx75xxProblems.SlidingWindowTechnique;

/*
76. Minimum Window Substring
https://leetcode.com/problems/minimum-window-substring/description/

Given two strings s and t of lengths m and n respectively, return the minimum window
substring
 of s such that every character in t (including duplicates) is included in the window. If there is no such substring, return the empty string "".

The testcases will be generated such that the answer is unique.

NOTES: Study this. Look at the comments and uncomment System.out.println to see debug outputs.
In this problem, we do not directly do
while (invalidWindow) {
move the window by moving left
}
We enter the while loop only when the window is valid in the larger context: all chars in t are in the window.
But here, we try to further shrink the window until a time comes, if you shrink further, we start eating up one of the
requiredCharacters in the t string. Eg: suppose window is "XYABC" t = "ABC". XYABC is valid window but not the smallest window and hence incorrect.
Hence, shrink and get the correct length right - length + 1.
 */

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {
    public static String minWindow(String s, String t) {
        if (s == null || t == null || s.length() < t.length()) {
            return "";
        }

        // Build character count for t string to check for counts in the window.
        Map<Character, Integer> tMap = new HashMap<>();
        for (char c : t.toCharArray()) {
            tMap.put(c, tMap.getOrDefault(c, 0) + 1);
        }

        int left = 0, right = 0; // window is right - left + 1

        // This makes sure we processed the entire length of t string inside the window.
        int requiredChars = t.length();

        int minWindowLength = Integer.MAX_VALUE;
        int minWindowStart = 0;

        Map<Character, Integer> windowMap = new HashMap<>();
        while (right < s.length()) {

            char currentChar = s.charAt(right);
            windowMap.put(currentChar, windowMap.getOrDefault(currentChar, 0) + 1);

            //System.out.println("Processing rightIndex = " + right + " char = " + currentChar + " RequiredChars = " + requiredChars + " windowMap = " + windowMap);

            // Check if the current character is part of t and make sure it takes care of the duplicates as well
            if (tMap.containsKey(currentChar) && windowMap.get(currentChar) <= tMap.get(currentChar)) {
                requiredChars--;
            }

            // If requiredChars is 0, then we have a window that has all the chars in t.
            // Try to minimize the window. Eg: s = "XABC" t = "ABC"
            while (requiredChars == 0) {
                //System.out.println("Processing left " + left + " char = " + s.charAt(left) + " in s = " + s);

                // Capture the window length and update if it is the min seen UNTIL now.
                if (right - left + 1 < minWindowLength) {
                    minWindowLength = right - left + 1;
                    minWindowStart = left;
                    // System.out.println("MinWinLength = " + minWindowLength + " minWinStart = " + minWindowStart);
                }

                char leftChar = s.charAt(left);

                // Try to Shrink further by removing the leftChar from window
                windowMap.put(leftChar, windowMap.get(leftChar) - 1);
                // System.out.println("Decremented char " + leftChar + " from WindowMap " + windowMap);

                /* Check if we shrunk too much. In the window, till now windowMap.get(leftChar) was EQUAL to tMap.get(leftChar).
                Now, after shrinking, it has become strictly less than the char count in tMap.
                That means, it was a requiredChar that got shrunk and hence we must stop shrinking further
                and search for other windows.
                */
                if (tMap.containsKey(leftChar) && windowMap.get(leftChar) < tMap.get(leftChar)) {

                    // NOTE: requiredChars++ : This will make sure the while loop is exited. Also, if we reach here, it means
                    // that we have the shrunk current window to max level, since shrinking caused a core char to be missing containing all chars in t.
                    requiredChars++; // this will make sure while loop to shrink window stops
                    // System.out.println("Incremented for char " + leftChar + " requiredChars " + requiredChars + ": WindowMap " + windowMap);
                }

                left++; // Make sure you increment left no matter what.
            }

            right++; // make sure you increment right no matter what
        }

        return minWindowLength == Integer.MAX_VALUE ? "" : s.substring(minWindowStart, minWindowStart + minWindowLength);
    }

    private static void print(String s, String t){
        String result = minWindow(s,t);
        result = result == "" ? "EMTPY_STRING" : result;
        System.out.println("Minimum Window Substring: " + result + " for s = " + s + ", t = " + t);
    }
    public static void main(String[] args) {
        print("XABCDYBACZ", "ABC");
        print("ADOBECODEBANC", "ABC");
        print("XABCDYBACZ", "PQR");
        print("X", "X");
        print("X", "XABC");
    }
}
