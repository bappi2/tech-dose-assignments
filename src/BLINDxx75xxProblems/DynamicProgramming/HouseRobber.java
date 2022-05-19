package BLINDxx75xxProblems.DynamicProgramming;

public class HouseRobber {
    int maxLoot(int *hval, int n)
    {
        // base case
        if(n < 0){
            return 0 ;
        }
        // base case one element ... so pick it
        if(n == 0){
            return hval[0] ;
        }
        //if current element is pick then previous cannot be picked
        int pick = hval[n] +  maxLoot(hval, n-2) ;
        //if current element is not picked then previous element is picked
        int notPick = maxLoot(hval, n-1)  ;

        // return max of picked and not picked
        return max(pick, notPick) ;

    }

    public int rob(int[] nums) {
        if(nums.length == 1) return nums[0];

        int[] dp = new int[nums.length];
        dp [0] = nums[0];
        dp [1] = Math.max(nums[0], nums[1]);

        for(int i=2; i<nums.length; i++){
            dp[i] = Math.max(nums[i]+dp[i-2], dp[i-1]);
        }

        return dp[nums.length-1];
    }
}
