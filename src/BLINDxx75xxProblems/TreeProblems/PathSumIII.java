package BLINDxx75xxProblems.TreeProblems;

import java.util.HashMap;

public class PathSumIII {
    public int subarraySum(int[] nums, int k) {
        int count = 0, currSum = 0;
        HashMap<Integer, Integer> h = new HashMap();

        for (int num : nums) {
            // current prefix sum
            currSum += num;

            // situation 1:
            // continuous subarray starts
            // from the beginning of the array
            if (currSum == k)
                count++;

            // situation 2:
            // number of times the curr_sum − k has occured already,
            // determines the number of times a subarray with sum k
            // has occured upto the current index
            count += h.getOrDefault(currSum - k, 0);

            // add the current sum
            h.put(currSum, h.getOrDefault(currSum, 0) + 1);
        }

        return count;
    }
}
