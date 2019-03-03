package recursion.climbing_stairs;

// https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1662/
class Solution {

    public int climbStairs(int n) {
        return climbStairs(n, new int[n + 1]);
    }

    private int climbStairs(int n, int[] memo) {
        if (memo[n] > 0) return memo[n];
        if (n <= 1) return 1;
        int result = climbStairs(n - 1, memo) + climbStairs(n - 2, memo);
        memo[n] = result;
        return result;
    }

    public static void main(String[] args) {
        int result = new Solution().climbStairs(44);
        System.out.println(result);
    }

}