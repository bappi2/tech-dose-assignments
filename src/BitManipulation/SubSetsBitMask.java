package BitManipulation;

import java.util.ArrayList;
import java.util.List;

public class SubSetsBitMask {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        int n = nums.length;

        for (int i = (int)Math.pow(2, n); i < (int)Math.pow(2, n +1); i++) {
            String bitmask = Integer.toBinaryString(i).substring(1);

            List<Integer> curr = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if (bitmask.charAt(j) == '1') {
                    curr.add(nums[j]);
                }
            }
            result.add(curr);
        }
        return result;
    }
}
