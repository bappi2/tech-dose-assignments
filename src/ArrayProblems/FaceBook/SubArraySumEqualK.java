package ArrayProblems.FaceBook;

class SubArraySumEqualK {
    public boolean subarraySum(int[] nums, int k) {
        int sum = 0;
        int start = 0;

        for (int end = 0; end < nums.length; end++) {
            sum += nums[end];

            while (sum > k) {
                // If the current sum is greater than k, move the start pointer
                sum -= nums[start];
                start++;
            }

            if (sum == k) {
                // If the current sum equals k, we found a subarray
                return true;
            }
        }

        // No subarray found
        return false;
    }

    public static void main(String[] args) {
        SubArraySumEqualK solution = new SubArraySumEqualK();

        int[] numbers1 = {1, 2, 3, 4, 5};
        int target1 = 9;
        System.out.println(solution.subarraySum(numbers1, target1)); // true

        int[] numbers2 = {1, 3, 2, 5, 7, 2};
        int target2 = 14;
        System.out.println(solution.subarraySum(numbers2, target2)); // true

        int[] numbers3 = {4, 3, 2, 7, 1, 2};
        int target3 = 10;
        System.out.println(solution.subarraySum(numbers3, target3)); // true

        int[] numbers4 = {4, 3, 2, 7, 1, 2};
        int target4 = 11;
        System.out.println(solution.subarraySum(numbers4, target4)); // false
    }
}
