package ArrayProblems;

import java.util.Arrays;

public class ThreeSumClosest {
    public int threeSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("invalid input");
        }
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i=0; i < nums.length; i++) {
            int left = i+1;
            int right = nums.length -1;

            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];

                if (Math.abs(sum- target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    left++;
                }
                else {
                    right--;
                }
            }
        }
        return closest;
    }
}
