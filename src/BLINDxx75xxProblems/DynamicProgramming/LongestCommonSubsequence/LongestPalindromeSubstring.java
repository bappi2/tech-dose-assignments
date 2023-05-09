package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

public class LongestPalindromeSubstring {
    public String longestPalindrome(String s) {
        String longestStr = null;
        int maxLen = 0;

        if (s == null || s.isEmpty()) return s;

        int len = s.length();
        boolean[][] palin = new boolean[len][len];

        for (int i = len - 1; i >= 0; i--) {
            for (int j = i; j < len; j++) {
                if ((s.charAt(i) == s.charAt(j) && (j - i) < 2)
                        || (s.charAt(i) == s.charAt(j) && palin[i + 1][j - 1])) {
                    palin[i][j] = true;
                    int temp = j - i + 1;
                    if (temp > maxLen) {
                        maxLen = temp;
                        longestStr = s.substring(i, j + 1);
                    }
                }
            }
        }
        return longestStr;
    }
}
