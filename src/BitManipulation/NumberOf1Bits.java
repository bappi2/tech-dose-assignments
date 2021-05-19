package BitManipulation;

public class NumberOf1Bits {
    public int hammingWeight(int n) {
        int bits = 0;
        for (int i = 0; i < Integer.SIZE; i++) {
            if ((n & (1 << i)) != 0) {
                bits++;
            }
        }
        return bits;
    }

    public int hammingWeightBetter(int n) {
        int sum = 0;
        while (n != 0) {
            sum++;
            n = n & (n - 1);
        }
        return sum;
    }
}
