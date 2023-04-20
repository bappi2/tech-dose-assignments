package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubstring {
    public int longestCommonSubstring(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        int[][] dp = new int[A.length() + 1][B.length() + 1];
        int lcs = 0;

        for (int i = 1; i <= A.length(); i++) {
            for (int j = 1; j <= B.length(); j++) {
                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = 0;
                }
                lcs = Math.max(lcs, dp[i][j]);
            }
        }
        return lcs;
    }
    public int lcs(int[] A, int[] B, int m, int n, int res) {
        if (m == -1 || n == -1) {
            return res;
        }
        if (A[m] == B[n]) {
            res = lcs(A, B, m - 1, n - 1, res + 1);
        }
        return Math.max(res, Math.max(lcs(A, B, m, n - 1, 0), lcs(A, B, m - 1, n, 0)));
    }

    public int longestCommonSubStringRecur(int[] A, int[] B) {

        return lcs(A, B, A.length - 1, B.length - 1, 0);
    }
}


