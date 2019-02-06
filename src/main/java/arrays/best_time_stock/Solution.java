package arrays.best_time_stock;

// Best Time to Buy and Sell Stock
// https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
class Solution {
    public int maxProfit(int[] prices) {
        int minPrice = Integer.MAX_VALUE;
        int maxProfit = 0;
        for (int i = 0; i < prices.length; i++) {
            if (minPrice > prices[i]) minPrice = prices[i];
            int profit = prices[i] - minPrice;
            if (maxProfit < profit) maxProfit = profit;
        }
        return maxProfit;
    }
}