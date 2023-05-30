package BLINDxx75xxProblems.ArrayProblems;

public class RemoveDuplicatesSortedArraII {
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
            if (count <= 2) {
                nums[i++] = nums[j];
            }
        }
        return i;
    }
}
