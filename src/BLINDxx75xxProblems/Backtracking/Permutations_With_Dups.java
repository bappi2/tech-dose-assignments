package BLINDxx75xxProblems.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Permutations_With_Dups {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        permuteUniqueHelper(nums, 0, result);
        return result;
    }
    void permuteUniqueHelper(int [] nums, int start, List<List<Integer>> result) {
        if (start >= nums.length) {
            addToList(nums, result);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            if (!containsDup(nums, start, i)) {
                swap(nums, i, start);
                permuteUniqueHelper(nums, start+1, result);
                swap(nums, i, start);
            }
        }
    }
    void swap (int [] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    boolean containsDup(int [] nums, int start, int end) {
        for (int i = start; i <= end - 1; i++) {
            if (nums[i] == nums[end]) {
                return true;
            }
        }
        return false;
    }

    void addToList(int []nums, List<List<Integer>> result) {
        result.add(Arrays.stream(nums).boxed().collect(Collectors.toList()));
    }
}
