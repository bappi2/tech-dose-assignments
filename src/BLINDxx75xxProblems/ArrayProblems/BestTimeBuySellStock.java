package BLINDxx75xxProblems.ArrayProblems;


/*
Input: prices = [7,1,5,3,6,4]
Output: 5
Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

Constraints:

1 <= prices.length <= 105
0 <= prices[i] <= 104
 */
public class BestTimeBuySellStock {
// We need to find out the maximum difference (which will be the
// maximum profit) between two numbers in the given array. Also,
// the second number (selling price) must be larger than the first
// one (buying price).
//
//In formal terms, we need to find max(prices[j]−prices[i], for every i and j such that j > i.
    // Time complexity: O(n^2)
    public int maxProfit(int prices[]) {
        int maxprofit = 0;
        for (int i = 0; i < prices.length - 1; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                int profit = prices[j] - prices[i];
                if (profit > maxprofit)
                    maxprofit = profit;
            }
        }
        return maxprofit;
    }

    // Time complexity: O(n)
    // The points of interest are the peaks and valleys in the given graph.
    // We need to find the largest peak following the smallest valley.
    // We can maintain two variables - minprice and maxprofit corresponding to the
    // smallest valley and maximum profit (maximum difference between
    // selling price and minprice) obtained so far respectively.
    public int maxProfit2(int prices[]) {
        int minprice = Integer.MAX_VALUE;
        int maxprofit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (prices[i] < minprice)
                minprice = prices[i];
            else {
                int profit = prices[i] - minprice;
                if (profit > maxprofit) {
                    maxprofit = profit;
                }
            }
        }
        return maxprofit;
    }
}
