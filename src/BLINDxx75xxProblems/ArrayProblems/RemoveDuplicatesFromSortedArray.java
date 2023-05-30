package BLINDxx75xxProblems.ArrayProblems;

public class RemoveDuplicatesFromSortedArray {
    // https://leetcode.com/problems/remove-duplicates-from-sorted-array/
    public int removeDuplicates(int[] nums) {
        int count = 1;
        int i = 1;

        for (int j = 1; j < nums.length; j++) {
            if (nums[j-1] == nums[j]) {
                count++;
            }
            else {
                count = 1;
            }
            if (count== 1) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }

    public int removeDuplicates2(int[] nums) {
        int insertIndex = 1;
        for(int i = 1; i < nums.length; i++){
            // We skip to next index if we see a duplicate element
            if(nums[i - 1] != nums[i]) {
                /* Storing the unique element at insertIndex index and incrementing
                   the insertIndex by 1 */
                nums[insertIndex++] = nums[i];
            }
        }
        return insertIndex;
    }
}
