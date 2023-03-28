package BLINDxx75xxProblems.BinarySearchProblems;

public class FindMinimumInRotatedSortedArray {
    /*
    Example 1:

Input: nums = [3,4,5,1,2]
Output: 1
Explanation: The original array was [1,2,3,4,5] rotated 3 times.
Example 2:

Input: nums = [4,5,6,7,0,1,2]
Output: 0
Explanation: The original array was [0,1,2,4,5,6,7] and it was rotated 4 times.
Example 3:

Input: nums = [11,13,15,17]
Output: 116
Explanation: The original array was [11,13,15,17] and it was rotated 4 times.
     */
    public int findMin(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo + 1 < hi) {
            int mid = lo + (hi - lo) / 2;

            if (nums[lo] < nums[hi]) {
                return nums[lo];
            } else if (nums[mid] < nums[hi]) {
                hi = mid;
            } else if (nums[lo] < nums[mid]) {
                lo = mid;
            }
        }
        // end condition left + 1 == right
        return Math.min(nums[lo], nums[hi]);
    }

/*
Understand the problem:
The problem looks like the search in rotated sorted array.
It is clearly that we need to use the binary search. The key
is to decide which half we wanna go in each iteration. There
are three cases to consider:
  -- Case 1: nums[lo] < nums[mid] && nums[mid] < nums[hi].
  It indicates that the array is sorted. So the first element
  must be the minimum. So return nums[lo].

  -- Case 2: nums[lo] < nums[mid] && nums[mid] > nums[hi].
  e.g.. 4 5 6 7 0 1 2. In this case the minimum number must
  be in the right half. So lo = mid + 1;

  -- Case 3: nums[lo] > nums[mid] && nums[mid] < nums[hi].
  e..g. 5 6 7 0 1 2 4. In this case, the minimum must be in
  the left half, but including the mid. So hi = mid;

  -- Case 4 (NOT EXISTED): nums[lo] > nums[mid] && nums[mid] > nums[hi]. 7 6 5 4 2 1 0.
This case does not exist since there is no way to rotate the array like this.
 */


}
