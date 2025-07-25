package BLINDxx75xxProblems.DynamicProgramming.LongestCommonSubsequence;

public class LongestCommonSubsequenceALL {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            return helper(text1,text2,0,0);
        }

        int helper(String s1,String s2,int index1,int index2){
            if(index1==s1.length() || index2== s2.length()){
                return 0;
            }

            if(s1.charAt(index1) == s2.charAt(index2)){
                return 1 + helper(s1,s2,index1+1,index2+1);
            }

            return Math.max(helper(s1,s2,index1+1,index2),helper(s1,s2,index1,index2+1));
        }
    }

    class Solution3 {
        int[][] dp;
        public int longestCommonSubsequence(String text1, String text2) {
            dp = new int[text1.length()][text2.length()];
            for(int i=0;i<text1.length();i++){
                for(int j=0;j<text2.length();j++){
                    dp[i][j]=-1;
                }
            }
            return helper(text1,text2,0,0);
        }

        int helper(String s1,String s2,int index1,int index2){
            if(index1==s1.length() || index2== s2.length()){
                return 0;
            }

            if(dp[index1][index2] >=0){
                return dp[index1][index2];
            }

            if(s1.charAt(index1) == s2.charAt(index2)){
                dp[index1][index2]= 1 + helper(s1,s2,index1+1,index2+1);
            }
            else{
                dp[index1][index2] = Math.max(helper(s1,s2,index1+1,index2),helper(s1,s2,index1,index2+1));
            }

            return dp[index1][index2];
        }
    }

    class Solution2 {
        /*
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

          0 G X T X A Y B
        0 0 0 0 0 0 0 0 0
        A 0 0 0 0 0 1 1 1
        G 0 1 1 1 1 1 1 1
        G 0 1 1 1 1 1 1 1
        T 0 1 1 2 2 2 2 2
        A 0 1 1 2 2 3 3 3
        B 0 1 1 2 2 3 3 4
         */

        int[][] dp;
        public int longestCommonSubsequence(String text1, String text2) {
            dp = new int[text1.length()+1][text2.length()+1];
            for(int i=0;i<=text1.length();i++){
                for(int j=0;j<=text2.length();j++){
                    if(i==0 || j==0){
                        continue;
                    }

                    if(text1.charAt(i-1)==text2.charAt(j-1)){
                        dp[i][j] = 1 + dp[i-1][j-1];
                    }
                    else{
                        dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                    }
                }
            }
            return dp[text1.length()][text2.length()];
        }
    }
}
