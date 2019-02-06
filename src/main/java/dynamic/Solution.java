package dynamic;

import java.util.HashMap;
import java.util.Map;

// coin change problem - bottom down recursive solution, with memoization (dynamic programming)
// https://leetcode.com/problems/coin-change/
public class Solution {

    public int coinChange(int[] coins, int amount) {
        Map<Integer, Integer> changeToCoins = new HashMap<>();
        int numCoins = coinChange(amount, coins, changeToCoins);
        if (numCoins == Integer.MAX_VALUE) return -1;
        else return numCoins;
    }

    private int coinChange(int amount, int[] coins, Map<Integer, Integer> changeToCoins) {
        if (amount == 0) return 0;
        Integer minCoins = changeToCoins.get(amount);
        if (minCoins != null) {
            return minCoins;
        }
        minCoins = Integer.MAX_VALUE;
        for (int coin : coins) {
            if (amount >= coin) {
                int currCoins = coinChange(amount - coin, coins, changeToCoins);
                if (currCoins < Integer.MAX_VALUE) currCoins++;
                minCoins = Math.min(minCoins, currCoins);
            }
        }
        changeToCoins.put(amount, minCoins);
        return minCoins;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println(instance.coinChange(new int[]{8, 6, 1}, 289));
        System.out.println(instance.coinChange(new int[]{2}, 3));
    }
}
