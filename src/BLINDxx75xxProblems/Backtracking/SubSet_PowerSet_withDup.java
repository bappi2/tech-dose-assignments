package BLINDxx75xxProblems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SubSet_PowerSet_withDup {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();
        result.add(new ArrayList<>(curr));
        Arrays.sort(nums);
        subsetsWithDupHelper(nums, 0, curr, result);
        return result;

    }
    void subsetsWithDupHelper(int [] nums, int start, List<Integer> curr, List<List<Integer>> result) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (i == start || nums[i-1] < nums[i]) {
                curr.add(nums[i]);
                result.add(new ArrayList<>(curr));
                subsetsWithDupHelper(nums, i + 1, curr, result);
                curr.remove(curr.size() -1);

            }

        }
    }
}
