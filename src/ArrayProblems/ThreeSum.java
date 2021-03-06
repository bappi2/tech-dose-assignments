package ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i =0; i < nums.length; i++) {
            if (nums[i] > 0 ) break;
            if (i == 0 || nums[i] > nums[i-1]) {
                int left = i+ 1;
                int right = nums.length -1;
                while (left < right) {
                    int sum = nums[i] + nums[left] + nums[right];
                    if (sum == 0) {
                        List<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[left]);
                        curr.add(nums[right]);

                        result.add(curr);

                        int leftValue = nums[left];
                        while (left < nums.length && nums[left] == leftValue) {
                            left++;
                        }
                        int rightValue = nums[right];
                        while (left < right && nums[right] == rightValue) {
                            right--;
                        }


                    }
                    else if (sum < 0) {
                        left++;
                    }
                    else {
                        right--;
                    }
                }
            }
        }
        return result;
    }
}
