package BitManipulation;

public class PowerofTwo {
    public boolean isPowerOfTwo(int n) {
        if (n == 0) return false;
        while (n % 2 == 0) n /= 2;
        return n == 1;
    }

    public boolean isPowerOfTwoBetter(int n) {
        if (n == 0) return false;

        return (n & (n - 1)) == 0;
    }


    boolean isPowerOfTwo2(int n) {
        if(n==0)
            return false;

        return Math.floor(Math.log(n))==Math.ceil(Math.log(n))?true:false;
    }

}
