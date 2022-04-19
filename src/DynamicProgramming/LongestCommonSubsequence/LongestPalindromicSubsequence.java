package DynamicProgramming.LongestCommonSubsequence;

public class LongestPalindromicSubsequence {
    public int longestPalindromeSubseq(String s) {
        /*
            [0,1,2,3,4,5]
            dp[i][j] length = j - i + 1 -> j = length + i - 1
            length from 1 to n
            if (i == j)
                dp[i][i] = 1
            if s[i] == s[j]
              dp[i][j] = dp[i + 1][j - 1] + 2; // (i + 1, j - 1)'s length is (i, j)'s length - 2
            else
              dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j]);
              // both (i, j-1) and (i + 1, j)'s length equals (i, j)'s length - 1
        */
        int n = s.length();
        char[] arr = s.toCharArray();
        int[][] dp = new int[n][n];
        for (int l = 1; l <= n; l++) {
            for (int i = 0; i + l <= n; i++) {
                int j = l + i - 1;
                if (l == 1) {
                    dp[i][j] = 1;
                } else {
                    if (arr[i] == arr[j]) {
                        dp[i][j] = dp[i + 1][j - 1] + 2;
                    } else {
                        dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                    }
                }
            }
        }
        return dp[0][n - 1];
    }
    // Time: O(n2), Memory: O(n2)
    // TODO fill table
}
