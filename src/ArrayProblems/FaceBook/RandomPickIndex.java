package ArrayProblems.FaceBook;

import java.util.Random;

class RandomPickIndex {
    private int[] nums;
    private Random random;

    public RandomPickIndex(int[] nums) {
        this.nums = nums;
        this.random = new Random();
    }

    public int pick(int target) {
        int count = 0;  // Count of occurrences of the target value
        int result = -1;  // The randomly picked index

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target) {
                // Increment the count of occurrences
                count++;

                // With probability 1/count, update the result to the current index
                if (random.nextInt(count) == 0) {
                    result = i;
                }
            }
        }

        return result;
    }
}
