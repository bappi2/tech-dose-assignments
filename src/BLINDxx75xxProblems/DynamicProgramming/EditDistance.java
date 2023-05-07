package BLINDxx75xxProblems.DynamicProgramming;


public class EditDistance {

    public int minDistance(String word1, String word2) {
        return f(word1, word2, 0, 0);
    }
    int f(String s1, String s2, int indx1, int indx2) {
        if (indx1 == s1.length() && indx2 == s2.length()) {
            return 0;
        }
        else if (s1.length() == indx1) {
            return s2.length() - indx2;
        }
        else if (s2.length() == indx2) {
            return s1.length() - indx1;
        }
        else if (s1.charAt(indx1) == s2.charAt(indx2)) {
            return f (s1, s2, indx1+1, indx2 + 1);
        }
        else {
            int insert = 1 + f(s1, s2, indx1, indx2 + 1);
            int delete = 1 + f(s1, s2, indx1+1, indx2);
            int replace = 1 + f(s1, s2, indx1+1, indx2+1);

            return Math.min(Math.min(insert, delete), replace);
        }
    }

    public int minDistance2(String word1, String word2) {
        int m = word1.length();
        int n = word2.length();

        int[][] dp = new int[m + 1][n + 1];
        // Fill d[][] in bottom up manner
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                // If first string is empty, only option is to
                // insert all characters of second string
                if (i == 0)
                    dp[i][j] = j; // Min. operations = j

                    // If second string is empty, only option is to
                    // remove all characters of second string
                else if (j == 0)
                    dp[i][j] = i; // Min. operations = i

                    // If last characters are same, ignore last char
                    // and recur for remaining string
                else if (word1.charAt(i - 1) == word2.charAt(j - 1))
                    dp[i][j] = dp[i - 1][j - 1];

                    // If the last character is different, consider all
                    // possibilities and find the minimum
                else
                    dp[i][j] = 1 + Math.min(Math.min(dp[i][j - 1], // Insert
                            dp[i - 1][j]), // Remove
                            dp[i - 1][j - 1]); // Replace
            }
        }
        return dp[m][n];
    }

}
