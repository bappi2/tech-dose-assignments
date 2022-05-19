package BLINDxx75xxProblems.DynamicProgramming;

public class JumpGame {
    public boolean canJump(int[] nums) {
        int len = nums.length;
        int max = 0;

        for (int i =0; i < len; i++) {
            if (i > max || max >= len -1) {
                break;
            }
            max = Math.max(max, i + nums[i]);

        }
        return max >= len -1;
    }
}
