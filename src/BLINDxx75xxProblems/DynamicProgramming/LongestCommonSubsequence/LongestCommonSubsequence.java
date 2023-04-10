package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

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

    public int longestCommonSubsequenceBack(String A, String B) {
        int m = A.length();
        int n = B.length();
        if (m == 0 || n == 0) {
            return 0;
        }
        if (A.charAt(m-1) == B.charAt(n-1)) {
            return longestCommonSubsequenceBack(A.substring(0, m-1), B.substring(0, n-1)) + 1;
        }
        return Math.max(longestCommonSubsequenceBack(A.substring(0, m-1), B),
                longestCommonSubsequenceBack(A, B.substring(0, n-1)) );

    }

}
