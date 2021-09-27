package buttercodePractice.array;

import buttercodePractice.string.ReverseWordsString;

import java.util.HashMap;
import java.util.Map;

public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        int [] result = { -1, -1};

        for (int i=0; i < numbers.length -1; i++) {
            for (int j = i+1; j < numbers.length; j++) {
                if (numbers[i] + numbers[j] == target) {
                    result[0] = i;
                    result[1] = j;
                    return result;
                }
            }
        }

        return result;
    }

    public int[] twoSum2(int []nums, int target) {
        int[] result = { -1, -1};
        Map<Integer, Integer> myMap = new HashMap<>();

        for (int i=0; i<nums.length; i++) {
            int other = target - nums[i];
            if (myMap.containsKey(other)) {
                result[0] = myMap.get(other);
                result[1] = i;
                return result;
            }
            else {
                myMap.put(nums[i], i);
            }
        }


        return result;
    }

    public static void main(String[] args) {
        int [] nums = {2, 5, 3, 1, 7, 8};
        TwoSum ts = new TwoSum();
        int [] res = ts.twoSum(nums, 20);
        System.out.println(res[0] + " " + res[1]);
        res = ts.twoSum2(nums, 20);
        System.out.println(res[0] + " " + res[1]);

    }
}
