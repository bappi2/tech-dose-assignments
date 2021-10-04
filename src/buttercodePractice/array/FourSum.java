package buttercodePractice.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FourSum {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length < 3) {
            return result;
        }
        Arrays.sort(nums);
        for (int i =0; i < nums.length -3; i++) {
            if (i == 0 || nums[i-1] < nums[i]) {
                for (int j = i + 1; j < nums.length - 2; j++) {
                    if (j == i + 1 || nums[j - 1] < nums[j]) {
                        int lo = j + 1;
                        int hi = nums.length - 1;
                        int other = target - (nums[i] + nums[j]);
                        while (lo < hi) {
                            int sum = nums[lo] + nums[hi];
                            if (sum == other) {
                                List<Integer> curr = new ArrayList<>();
                                curr.add(nums[i]);
                                curr.add(nums[j]);
                                curr.add(nums[lo]);
                                curr.add(nums[hi]);
                                result.add(curr);
                                lo++;
                                hi--;
                                while (lo < hi && nums[lo - 1] == nums[lo]) lo++;
                                while (lo < hi && nums[hi + 1] == nums[hi]) hi--;
                            } else if (sum < other) {
                                lo++;
                            } else {
                                hi--;
                            }

                        }
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1, 1,0, 2, -2, -2, -1,-4};
        FourSum fs = new FourSum();
        System.out.println(fs.fourSum(nums, 0));
    }
}
