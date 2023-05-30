package BLINDxx75xxProblems.ArrayProblems;

import java.util.Arrays;

public class LongestConsecutiveSequence {
    // https://leetcode.com/problems/longest-consecutive-sequence/
    public int longestConsecutive(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        int max = 1;
        int count = 1;
        Arrays.sort(nums);
        for (int i = 1; i < nums.length; i++) {
            if (nums[i-1] + 1 == nums[i]) {
                count++;
                max = Math.max(max, count);
            }
            else if (nums[i-1] == nums[i]) {
                continue;
            }
            else {
                count = 1;
            }
        }
        return max;
    }
}
