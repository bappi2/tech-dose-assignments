package BLINDxx75xxProblems.ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    /*
        Input: nums = [2,7,11,15], target = 9
        Output: [0,1]
        Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].

        Constraints:

        2 <= nums.length <= 104
        -109 <= nums[i] <= 109
        -109 <= target <= 109
        Only one valid answer exists.
   */

    public int[] twoSum(int[] nums, int target) {
        for (int i=0; i < nums.length - 1; i++) {
            for (int j=i+1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int [] {i, j};
                }
            }

        }
        return new int [] {-1, -1};
    }

    public int[] twoSum2(int[] nums, int target) {
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i < nums.length; i++) {
            int other = target - nums[i];
            if (myMap.containsKey(other)) {
                return new int [] {myMap.get(other), i};
            }
            else {
                myMap.put(nums[i], i);
            }
        }
        return new int[] {-1, -1};
    }


}
