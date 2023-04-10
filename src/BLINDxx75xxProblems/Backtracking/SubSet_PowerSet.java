package BLINDxx75xxProblems.Backtracking;

import java.util.ArrayList;
import java.util.List;

public class SubSet_PowerSet {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        result.add(new ArrayList(curr));
        subsetsHelper(nums, 0, curr, result);
        return result;

    }
    void subsetsHelper(int []nums, int start, List<Integer> curr, List<List<Integer>> result) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            curr.add(nums[i]);
            result.add(new ArrayList(curr));
            subsetsHelper(nums, i + 1, curr, result);
            curr.remove(curr.size() -1);
        }
    }
}
