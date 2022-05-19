package BinarySearch;


  /*  Given two integers dividend and divisor, divide two integers without using multiplication,
        division and mod operator.
        Return the quotient after dividing dividend by divisor.
        The integer division should truncate toward zero.
        Example 1:
        Input: dividend = 10, divisor = 3
        Output: 3
        Example 2:
        Input: dividend = 7, divisor = -3
        Output: -2
        Note:
        •	Both dividend and divisor will be 32-bit signed integers.
        •	The divisor will never be 0.
   */

class DivideTwoIntegers { // time < o(logn), space < o(logn) because we use (sum+sum) <= dividend， binary search
    public int divide(int dividend, int divisor) {
        int sign = 1;
        if (dividend < 0 && divisor > 0 || dividend > 0 && divisor < 0) {
            sign = -1;
        }
        long newDividend = Math.abs((long)dividend);
        long newDivisor = Math.abs((long)divisor);
        long res = helper(newDividend, newDivisor);
        if (res > Integer.MAX_VALUE) {
            return sign==1? Integer.MAX_VALUE:Integer.MIN_VALUE;
        }
        return (int) res*sign;
    }
    public long helper(long dividend, long divisor) {
        if (dividend < divisor) {
            return 0;
        }
        long sum = divisor;
        long multiple = 1;
        while (sum+sum <= dividend) { //if using <= time < logn, if using < time will be logn, eg 8/2
            sum += sum; //sum += sum; sum <<=1
            multiple += multiple ; //multiple += multiple;
        }
        return multiple + helper(dividend-sum, divisor);
    }
}
