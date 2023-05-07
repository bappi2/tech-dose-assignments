package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

import java.util.Arrays;

public class LongestCommonSubsequence {
    // http://buttercola.blogspot.com/2014/11/lintcode-longest-common-subsequence-lcs.html
    // https://leetcode.com/problems/longest-common-subsequence/
    public int longestCommonSubsequence(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        int[][] dp = new int[A.length() + 1][B.length() + 1];

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        return dp[A.length()][B.length()];
    }

    // f(i, j) = 0 if i == text1.length || j == text2.length
    // f(i, j) = 1 + f(i+1, j + 1)
    // f(i, j) = max(f(i+1, j), f(i, j+1))

    public int longestCommonSubsequenceR(String text1, String text2) {
        return f(text1, text2, 0, 0);
    }

    int f(String text1, String text2, int i, int j) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        else if (text1.charAt(i) == text2.charAt(j)) {
            return 1 + f(text1, text2, i + 1, j + 1);
        }
        else {
            return Math.max(f(text1, text2, i+1, j), f(text1, text2, i, j+1));
        }
    }
    // DP
    public int longestCommonSubsequence3(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m][n];
        for(int i = 0; i < m; i++) {
            Arrays.fill(dp[i], -1);
        }

        return f(text1, text2, 0, 0, dp);
    }

    int f(String text1, String text2, int i, int j, int[][] dp) {
        if (i == text1.length() || j == text2.length()) {
            return 0;
        }
        else if (dp[i][j] != -1) {
            return dp[i][j];
        }
        else if (text1.charAt(i) == text2.charAt(j)) {
            dp[i][j] = 1 + f(text1, text2, i + 1, j + 1, dp);
            return dp[i][j];
        }
        else {
            dp[i][j] = Math.max(f(text1, text2, i+1, j, dp), f(text1, text2, i, j+1, dp));
            return dp[i][j];
        }
    }

    public int longestCommonSubsequence2(String text1, String text2) {
        int m = text1.length();
        int n = text2.length();
        int[][] dp = new int[m+1][n+1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (text1.charAt(i-1) == text2.charAt(j-1)) {
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                else {
                    dp[i][j] = Math.max(dp[i-1][j], dp[i][j-1]);
                }
            }
        }
        return dp[m][n];
    }
}
