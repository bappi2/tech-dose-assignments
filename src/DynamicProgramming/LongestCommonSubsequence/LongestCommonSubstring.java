package DynamicProgramming.LongestCommonSubsequence;

/*
Given two strings, find the longest common substring.
Return the length of it.
Note
The characters in substring should occur continiously in original string. This is different with subsequnce.
Understand the problem:
In computer science, the longest common substring problem is to find the longest string (or strings) that is a substring (or are substrings) of two or more strings.

For example, ABCD, and EBCA, the LCS is BC, which has the length of 2.

A DP Solution:

Definition: dp[A.length() + 1][B.length() + 1] , where as dp[i][j] means the LCS ended with i and j
Initial state: all 0s
Transit function: if (A.charAt(i) == B.charAt(j)), dp[i][j] = dp[i - 1][j - 1] + 1. Else, dp[i][j] = 0
Final state: Math.max(dp[0 ... A.length()][0 ... B.length()]);

            j
       #  E  B  C  A
  #   0  0   0  0  0
  A  0   0  0  0  1
i B  0   0  1  0  0
  C  0   0  0  2  0
  D  0   0  0  0  0
 */

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
}
