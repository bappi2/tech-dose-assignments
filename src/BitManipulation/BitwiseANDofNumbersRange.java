package BitManipulation;

public class BitwiseANDofNumbersRange {
    // Given two integers left and right that represent the range [left, right],
    // return the bitwise AND of all numbers in this range, inclusive.
    public int rangeBitwiseAnd(int left, int right) {
        int shift = 0;
        while (left < right) {
            left >>= 1;
            right >>=1;
            shift++;
        }
        return left << shift;
    }

    public int rangeBitwiseAnd2(int m, int n) {
        while (m < n) {
            // turn off rightmost 1-bit
            n = n & (n - 1);
        }
        return m & n;
    }
}
