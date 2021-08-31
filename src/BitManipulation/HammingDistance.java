package BitManipulation;

public class HammingDistance {
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
