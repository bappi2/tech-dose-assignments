package BitManipulation;
import java.util.Arrays;

public class SingleNumberII {
    public int singleNumberSort(int[] nums) {
        if (nums.length < 2) {
            return nums[0];
        }
        int len = nums.length;
        Arrays.sort(nums);
        if (nums[0] != nums[1]) {
            return nums[0];
        }
        int i =1;
        while (i < len) {
            if (nums[i -1] != nums[i]) {
                return nums[i-1];
            }
            i += 3;
        }
        return nums[len-1];
    }

    public int singleNumberBit(int[] nums) {
        int ans = 0;
        int shift = 1;
        for(int i=0; i < Integer.SIZE; i++) {
            int count = 0;
            for (int num: nums) {
                if ((num & shift) != 0) {
                    count++;
                }
            }
            if (count % 3 != 0) {
                ans += shift;
            }
            shift = shift << 1;
        }
        return ans;
    }
}
