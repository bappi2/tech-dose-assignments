package DynamicProgramming.FibonacciSeries;

public class JumpGame {
    // Approach 1: Backtracking

    public boolean canJumpFromPosition(int position, int[] nums) {
        if (position == nums.length - 1) {
            return true;
        }

        int furthestJump = Math.min(position + nums[position], nums.length - 1);
        for (int nextPosition = position + 1; nextPosition <= furthestJump; nextPosition++) {
            if (canJumpFromPosition(nextPosition, nums)) {
                return true;
            }
        }

        return false;
    }

    public boolean canJump(int[] nums) {
        return canJumpFromPosition(0, nums);
    }

    // Amell Parelta

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
