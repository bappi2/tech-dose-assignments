package BitManipulation;

public class CountingBits {
    public int[] countBits(int num) {
        int [] ans = new int [num +1];
        for (int i=0; i <= num; i++) {
            ans[i] = countSetBit(i);
        }
        return ans;
    }
    private int countSetBit(int x) {
        int count = 0;
        while (x !=0) {
            count++;
            x = x & x-1;
        }
        return count;
    }
}
