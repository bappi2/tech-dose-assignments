package ArrayProblems;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        int[] result = {-1, -1};
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int left = target - nums[i];

            if (map.containsKey(left)) {
                result[0] = map.get(left);
                result[1] = i;
                return result;
            }
            else {
                map.put(nums[i], i);
            }

        }
        return result;
    }
}
