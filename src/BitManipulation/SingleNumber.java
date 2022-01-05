package BitManipulation;

public class SingleNumber {
    public int singleNumber(int[] nums) {
        int result = 0;
        for (int num: nums) {
            result ^= num;
        }
        return result;
    }

    public static void main(String[] args) {
        SingleNumber sn = new SingleNumber();

        int[] nums = {5, 2, 3 , 4, 2, 3, 4};
        System.out.println(sn.singleNumber(nums));
    }

}