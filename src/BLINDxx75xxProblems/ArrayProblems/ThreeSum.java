package BLINDxx75xxProblems.ArrayProblems;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/*
Example 1:

Input: nums = [-1,0,1,2,-1,-4]
Output: [[-1,-1,2],[-1,0,1]]

0 <= nums.length <= 3000
-105 <= nums[i] <= 105
 */

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

                        // Remove duplicated results
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

    public List<List<Integer>> threeSumTest(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] > 0) break;

            if (i == 0 || nums[i] > nums[i-1]) {
                int lo = i+1;;
                int hi = nums.length -1;

                while (lo < hi) {
                    int sum = nums[i] + nums[lo] + nums[hi];

                    if (sum == 0) {
                        List<Integer> curr = new ArrayList<>();

                        curr.add(nums[i]);
                        curr.add(nums[lo]);
                        curr.add(nums[hi]);

                        result.add(curr);
                        lo++;
                        hi--;
                        while (lo < hi && nums[lo-1] == nums[lo] ) lo++;
                        while (lo < hi && nums[hi+1] == nums[hi]) hi--;


                    }
                    if (sum < 0) {
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

    public List<List<Integer>> threeSumBrute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);

        for (int i = 0; i < nums.length -2; i++) {
            if (i == 0 || nums[i-1] < nums[i]) {
                for (int j = i+1; j < nums.length -1; j++) {
                    if (j-1 == i || nums[j-1] < nums[j]) {
                        for (int k = j +1 ; k < nums.length; k++) {
                            if (k - 1 == j || nums[k-1] < nums[k]) {
                                if (nums[i] + nums[j] + nums[k] == 0) {
                                    List<Integer> curr = new ArrayList<>();
                                    curr.add(nums[i]);
                                    curr.add(nums[j]);
                                    curr.add(nums[k]);

                                    result.add(curr);
                                }

                            }

                        }

                    }

                }
            }
        }
        return result;

    }

    public static void main(String[] args) {
        ThreeSum ts = new ThreeSum();
        int [] nums = {-1,0,1,2,-1,-4};

        System.out.println(ts.threeSumBrute(nums));
    }
}
