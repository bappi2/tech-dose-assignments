package ArrayProblems.TwoPointers;

import java.util.Arrays;

public class SquaresSortedArray {

    // brute force
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int [] result = new int[len];
        for (int i=0; i < len; i++) {
            result[i] = nums[i]* nums[i];
        }
        Arrays.sort(result);
        return result;
    }

    // two pointers
    public int[] sortedSquares(int[] nums) {
        int len = nums.length;
        int [] result = new int[len];

        int lo = 0;
        int hi = len - 1;
        for (int i=len -1; i>= 0; i--) {
            if (Math.abs(nums[lo]) < Math.abs(nums[hi])) {
                result[i] = nums[hi] * nums[hi];
                hi--;
            }
            else {
                result[i] = nums[lo] * nums[lo];
                lo++;
            }
        }
        return result;
    }
}
