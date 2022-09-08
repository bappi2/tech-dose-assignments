package BLINDxx75xxProblems.BinarySearchProblems;

public class KokoEatingBananas {

    public static int binarySearch(int[] nums, int target){
        if(nums == null || nums.length == 0)
            return -1;

        int left = 0, right = nums.length;
        while(left < right){
            // Prevent (left + right) overflow
            int mid = left + (right - left) / 2;
            if(nums[mid] == target){ return mid; }
            else if(nums[mid] < target) { left = mid + 1; }
            else { right = mid; }
        }

        // Post-processing:
        // End Condition: left == right
        if(left != nums.length && nums[left] == target) return left;
        return -1;
    }

    public static void main(String[] args) {
        int [] nums = new int[] {1, 2, 3, 4, 5};
        KokoEatingBananas.binarySearch(nums, 4);


    }
}
