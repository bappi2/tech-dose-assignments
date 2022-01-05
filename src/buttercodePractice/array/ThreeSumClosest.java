package buttercodePractice.array;

import java.util.Arrays;

public class ThreeSumClosest {

    public int threeSumClosest(int[] nums, int target) {
        Arrays.sort(nums);
        int closest = nums[0] + nums[1] + nums[2];

        for (int i = 0; i < nums.length-2; i++) {
            int lo = i+ 1;
            int hi = nums.length -1;
            while (lo < hi) {
                int sum = nums[i] + nums[lo] + nums[hi];
                if (Math.abs(sum - target) < Math.abs(closest - target)) {
                    closest = sum;
                }
                if (closest == target) {
                    return closest;
                }
                else if (sum < target) {
                    lo++;
                }
                else {
                    hi--;
                }

            }
        }
        return closest;
    }

    public static void main(String[] args) {
        int [] nums = {0, 0 , 0};
        ThreeSumClosest tsc = new ThreeSumClosest();
        System.out.println( tsc.threeSumClosest(nums, 1));


    }
    /*
    Given an integer array nums of length n and an integer target, find three integers in nums such that the sum is closest to target.

Return the sum of the three integers.

You may assume that each input would have exactly one solution.



Example 1:

Input: nums = [-1,2,1,-4], target = 1
Output: 2
Explanation: The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
Example 2:

Input: nums = [0,0,0], target = 1
Output: 0
     */
}
