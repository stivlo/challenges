package math.pow;

// https://leetcode.com/explore/learn/card/recursion-i/256/complexity-analysis/2380/
public class Solution {
    public double myPow(double x, int n) {
        if (n == 0) return 1;
        if (n == Integer.MIN_VALUE) {
            return myPow(1 / (x * x), - (n / 2));
        }
        if (n < 0) {
            n = - n;
            x = 1 / x;
        }
        return n % 2 == 0 ? myPow(x * x, n / 2) : x * myPow(x * x, n / 2);
    }
}
