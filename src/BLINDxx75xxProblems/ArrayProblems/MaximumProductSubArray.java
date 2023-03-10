package BLINDxx75xxProblems.ArrayProblems;

public class MaximumProductSubArray {
    /*
    Input: nums = [2,3,-2,4]
Output: 6
Explanation: [2,3] has the largest product 6.

Constraints:

1 <= nums.length <= 2 * 104
-10 <= nums[i] <= 10
The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.

     */

    // brute force
    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max = nums[0];

        for (int i = 0; i < nums.length; i++) {
            int currPro = 1;
            for (int j = i; j < nums.length; j++) {
                currPro *= nums[j];
                max = Math.max(max, currPro);
            }
        }

        return max;
    }

    public int maxProduct(int[] nums) {
        if (nums.length == 0) return 0;

        int max_so_far = nums[0];
        int min_so_far = nums[0];
        int result = max_so_far;

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            int temp_max = Math.max(curr, Math.max(max_so_far * curr, min_so_far * curr));
            min_so_far = Math.min(curr, Math.min(max_so_far * curr, min_so_far * curr));

            max_so_far = temp_max;

            result = Math.max(max_so_far, result);
        }

        return result;
    }
}
