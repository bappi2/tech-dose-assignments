package BLINDxx75xxProblems.DynamicProgramming.DPONGrid;

public class UniquePaths {
    // recursive
    // f(i, j) = 1 if i == 1 || j == 1
    // f(i, j) = f(i -1, j) + f (i, j -1)

    public int uniquePaths(int m, int n) {
        return f(m, n);
    }
    int f(int i, int j) {
        if (i == 1 ||  j == 1) {
            return 1;
        }
        return f(i-1, j) + f (i, j-1);
    }

    // DP
    public int uniquePaths2(int m, int n) {
        int[][] dp=new int[m][n];

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(i==0||j==0){
                    dp[i][j]=1;
                }
                else{
                    dp[i][j]=dp[i-1][j]+dp[i][j-1];
                }
            }
        }
        return dp[m-1][n-1];
    }
}
