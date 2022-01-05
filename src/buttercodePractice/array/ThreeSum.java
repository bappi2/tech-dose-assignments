package buttercodePractice.array;

import java.util.ArrayList;
import java.util.Arrays;

public class ThreeSum {
    /*Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.

    Notice that the solution set must not contain duplicate triplets.



    Example 1:

    Input: nums = [-1,0,1,2,-1,-4]
    Output: [[-1,-1,2],[-1,0,1]]*/

    public ArrayList<ArrayList<Integer>> threeSum(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int len = nums.length;
        for (int i=0; i< len -2; i++) {
            //if (nums[i] <= 0)
            for (int j=i+1; j < len-1; j++) {
                for (int k=j+1; k < len; k++) {
                    if (nums[i] + nums[j] + nums[k] == 0) {
                        ArrayList<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[j]);
                        curr.add(nums[k]);

                        if (!result.contains(curr)) result.add(curr);
                    }
                }
            }
        }

        return result;
    }
    public ArrayList<ArrayList<Integer>> threeSum2(int[] nums) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i-1] < nums[i]) {
                int lo = i+1;
                int hi = nums.length -1;
                while (lo < hi) {
                    if (nums[lo] + nums[hi] == 0 - nums[i]) {
                        ArrayList<Integer> curr = new ArrayList<>();
                        curr.add(nums[i]);
                        curr.add(nums[lo]);
                        curr.add(nums[hi]);
                        result.add(curr);
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo-1] == nums[lo]) lo++;
                        while (lo < hi && nums[hi+1] == nums[hi]) hi--;
                    }
                    else if (nums[lo] + nums[hi] < 0 - nums[i]) {
                        lo++;
                    }
                    else {
                        hi--;
                    }
                }
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int [] nums = {-1,0,1,2,-1,-4};
        ThreeSum ts = new ThreeSum();

        System.out.println(ts.threeSum(nums));
        System.out.println(ts.threeSum2(nums));

    }
}
