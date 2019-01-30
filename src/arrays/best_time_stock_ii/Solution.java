package arrays.best_time_stock_ii;

// Best Time to Buy and Sell Stock II
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/564/
class Solution {
    public int maxProfit(int[] prices) {
        int buyPrice = 0;
        int maxProfit = 0;
        boolean holding = false;
        for (int i = 0; i < prices.length - 1; i++) {
            if (!holding && prices[i] < prices[i + 1]) {
                holding = true;
                buyPrice = prices[i];
            }
            if (holding && prices[i] > prices[i + 1]) {
                holding = false;
                maxProfit += prices[i] - buyPrice;
            }
        }
        if (holding) maxProfit += prices[prices.length - 1] - buyPrice;
        return maxProfit;
    }
}