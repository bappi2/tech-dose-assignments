package BitManipulation;

public class CountingBits {
    // https://leetcode.com/problems/counting-bits/

    // Given an integer n, return an array ans of length n + 1 such that for each
    // i (0 <= i <= n), ans[i] is the number of 1's in the binary representation of i.
    // Input: n = 5
    // Output: [0,1,1,2,1,2]

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

    public int[] countBitsFast(int num) {
        int [] ans = new int [num +1];
        ans[0] = 0;
        for (int i=1; i <= num; i++) {
            ans[i] = ans[i/2] + i % 2;
        }
        return ans;
    }

    // Last set bit is the rightmost set bit. Setting that bit to zero with
    // the bit trick, x &= x - 1, leads to the following transition function:
    //
    //P(x) = P(x \mathrel{\&} (x - 1)) + 1P(x)=P(x&(x−1))+1

    public int[] countBits2(int num) {
        int[] ans = new int[num + 1];
        for (int x = 1; x <= num; ++x) {
            ans[x] = ans[x & (x - 1)] + 1;
        }
        return ans;
    }

}
