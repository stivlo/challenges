package recursion.fibonacci;

// https://leetcode.com/explore/learn/card/recursion-i/255/recursion-memoization/1661/
public class Solution {
    public int fib(int N) {
        int[] memo = new int[N + 1];
        return fib(N, memo);
    }

    private int fib(int N, int[] memo) {
        if (memo[N] > 0) return memo[N];
        if (N <= 1) return N;
        int result = fib(N - 1, memo) + fib(N - 2, memo);
        memo[N] = result;
        return result;
    }
}
