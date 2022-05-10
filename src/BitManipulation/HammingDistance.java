package BitManipulation;

public class HammingDistance {
    /*
    The Hamming distance between two integers is the number of
    positions at which the corresponding bits are different.

Given two integers x and y, return the Hamming distance between them.

Example 1:

Input: x = 1, y = 4
Output: 2
Explanation:
1   (0 0 0 1)
4   (0 1 0 0)
       ↑   ↑
The above arrows point to positions where the corresponding bits are different.
     */
    public int hammingDistance(int x, int y) {
        int result = 0;
        for (int i=0; i < Integer.SIZE; i++) {
            if ((x & (1 << i) ^ y & (1 << i)) != 0) {
                result++;
            }
        }
        return result;
    }
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public int hammingDistance3(int x, int y) {
        int xor = x ^ y;
        int distance = 0;
        while (xor != 0) {
            distance += 1;
            // remove the rightmost bit of '1'
            xor = xor & (xor - 1);
        }
        return distance;
    }
}
