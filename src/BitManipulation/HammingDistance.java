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
}
