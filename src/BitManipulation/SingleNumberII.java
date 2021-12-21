package BitManipulation;
import java.util.Arrays;

public class SingleNumberII {
    /*
Given an integer array nums where every element appears three times except for one, which appears exactly once. Find the single element and return it.

You must implement a solution with a linear runtime complexity and use only constant extra space.



Example 1:

Input: nums = [2,2,3,2]
Output: 3
Example 2:

Input: nums = [0,1,0,1,0,1,99]
Output: 99
     */
    public int singleNumberSort(int[] nums) {
        // 1;
        // 1 2 2 2;
        // 1 1 1 2;
        // 1 1 1 2 3 3 3;
        // 1 1 1 2 2 2 3

        if (nums.length < 2) {
            return nums[0]; // 1;
        }
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0]; // 1 2 2 2;
        }
        int i =1;
        while (i < len) {
            if (nums[i -1] != nums[i]) {
                return nums[i-1]; // 1 1 1 2 3 3 3;
            }
            i += 3;
        }
        return nums[len-1]; // 1 1 1 2; // 1 1 1 2 2 2 3
    }

    public int singleNumberBit(int[] nums) {
        int ans = 0;
        int shift = 1;
        for(int i=0; i < Integer.SIZE; i++) {
            int count = 0;
            for (int num: nums) {
                if ((num & shift) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += shift;
            }
            shift = shift << 1;
        }
        return ans;
    }
}
