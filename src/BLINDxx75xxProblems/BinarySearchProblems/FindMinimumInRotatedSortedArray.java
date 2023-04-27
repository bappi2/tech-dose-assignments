package BLINDxx75xxProblems.BinarySearchProblems;

import java.util.Arrays;

public class FindMinimumInRotatedSortedArray {
    // brute force
    public int findMinBruteForce(int[] nums) {
        int min = nums[0];
        for (int i =1; i < nums.length; i++) {
            min = Math.min(min, nums[i]);
        }
        return min;
    }

    public int findMinSort(int[] nums) {
        Arrays.sort(nums);
        return nums[0];
    }

    public int findMinBinarySearch(int[] nums) {
        //Understand the problem:
        // The problem looks like the search in rotated sorted array.
        // It is clearly that we need to use the binary search.
        // The key is to decide which half we wanna go in each iteration.
        // There are three cases to consider:
        //-- Case 1: nums[lo] < nums[mid] && nums[mid] < nums[hi].
        // It indicates that the array is sorted. So the first element must be the minimum. So return nums[lo].
        //-- Case 2: nums[lo] < nums[mid] && nums[mid] > nums[hi].
        // e.g.. 4 5 6 7 0 1 2. In this case the minimum number must be in the right half. So lo = mid + 1;
        //-- Case 3: nums[lo] > nums[mid] && nums[mid] < nums[hi].
        // e..g. 5 6 7 0 1 2 4. In this case, the minimum must be in the left half,
        // but including the mid. So hi = mid;
        //-- Case 4 (NOT EXISTED): nums[lo] > nums[mid] && nums[mid] > nums[hi]. 7 6 5 4 2 1 0.
        //This case does not exist since there is no way to rotate the array like this.

        int lo = 0;
        int hi = nums.length -1;

        while (lo +1< hi) {
            int mid = lo + (hi - lo) /2;
            if (nums[lo] < nums[mid] && nums[mid] < nums[hi]) {
                return nums[lo];
            }
            else if (nums[lo] < nums[mid] && nums[mid] > nums[hi]) {
                lo = mid + 1;
            }
            else if (nums[lo] > nums[mid] && nums[mid] < nums[hi]) {
                hi = mid;
            }
        }
        // end condition lo + 1 == hi -- two element we did not check
        if (nums[lo] <= nums[hi]) {
            return nums[lo];
        }
        else {
            return nums[hi];
        }

    }

}
