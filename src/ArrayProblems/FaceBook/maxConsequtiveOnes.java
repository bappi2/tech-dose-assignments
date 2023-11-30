package ArrayProblems.FaceBook;

class maxConsequtiveOnes {
    public int longestOnes(int[] nums, int k) {
        int left = 0; // Left pointer of the sliding window
        int zeroCount = 0; // Count of zeros in the current window
        int maxConsecutiveOnes = 0; // Maximum consecutive ones

        for (int right = 0; right < nums.length; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }

            // If the number of zeros in the current window exceeds K, move the left pointer
            while (zeroCount > k) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }

            // Update the maximum consecutive ones
            maxConsecutiveOnes = Math.max(maxConsecutiveOnes, right - left + 1);
        }

        return maxConsecutiveOnes;
    }
}
