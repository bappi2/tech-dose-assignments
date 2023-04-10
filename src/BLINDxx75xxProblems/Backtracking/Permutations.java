package BLINDxx75xxProblems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        permuteHelper(nums, 0, result);
        return result;

    }
    void permuteHelper(int [] nums, int start, List<List<Integer>> result) {
        if (nums.length == start) {
            addToList(nums, result);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, i, start);
            permuteHelper(nums, start + 1, result);
            swap(nums, i, start);

        }

    }
    void swap (int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    void addToList(int[] nums, List<List<Integer>> result) {
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
