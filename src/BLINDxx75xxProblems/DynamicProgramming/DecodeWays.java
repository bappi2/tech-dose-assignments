package BLINDxx75xxProblems.DynamicProgramming;

import java.util.Arrays;

public class DecodeWays {
    public int numDecodings(String s) {
        int [] dp = new int[s.length() +1];
        Arrays.fill(dp, -1);
        dp[0] = 1;

        if (s.charAt(0) == '0') {
            return 0;
        }
        return helper(s, dp, s.length());
    }
    int helper(String s, int [] dp, int n) {
        if (dp[n] != -1) {
            return dp[n];
        }
        else {
            if (n == 0 || n ==1 ) {
                return 1;
            }
            int count = s.charAt(n-1) != '0' ? helper(s, dp, n-1) : 0;
            if (s.charAt(n-2) == '1' || (s.charAt(n-2) == '2' && s.charAt(n-1) < '7')) {
                count += helper(s, dp, n-2);
            }
            dp[n] = count;
            return count;
        }


    }

    static int countDecoding(char[] digits, int n)
    {
        // base cases
        if (n == 0 || n == 1)
            return 1;

        // for base condition "01123" should return 0
        if (digits[0] == '0')
            return 0;

        // Initialize count
        int count = 0;

        // If the last digit is not 0, then
        // last digit must add to
        // the number of words
        if (digits[n - 1] > '0')
            count = countDecoding(digits, n - 1);

        // If the last two digits form a number
        // smaller than or equal to 26,
        // then consider last two digits and recur
        if (digits[n - 2] == '1'
                || (digits[n - 2] == '2'
                && digits[n - 1] < '7'))
            count += countDecoding(digits, n - 2);

        return count;
    }

    // Given a digit sequence of length n,
    // returns count of possible decodings by
    // replacing 1 with A, 2 with B, ... 26 with Z
    static int countWays(char[] digits, int n)
    {
        if (n == 0 || (n == 1 && digits[0] == '0'))
            return 0;
        return countDecoding(digits, n);
    }
}
