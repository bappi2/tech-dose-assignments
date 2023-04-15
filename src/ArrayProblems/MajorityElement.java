package ArrayProblems;

import java.util.Arrays;

public class MajorityElement {
    // https://leetcode.com/problems/majority-element/description/
    public int majorityElementSort(int[] nums) {
        Arrays.sort(nums);
        return nums[nums.length/2];
    }

    public int majorityElement(int[] nums) {
        int count = 0;
        Integer candidate = null;

        for (int num : nums) {
            if (count == 0) {
                candidate = num;
            }
            count += (num == candidate) ? 1 : -1;
        }

        return candidate;
    }

    public int majorityElement2(int[] nums) {

        int majority_index = 0;
        int count = 1;

        for(int i = 1; i < nums.length; i++) {

            count += nums[i] == nums[majority_index] ? 1 : -1;

            if(count==0){
                majority_index=++i;
                count++;
            }
        }

        return nums[majority_index];
    }

}

