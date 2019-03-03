package math.gcd;

public class Solution {

    // gcd(48,18), divide 48 by 18 to get a quotient of 2 and a remainder of 12.
    // Then divide 18 by 12 to get a quotient of 1 and a remainder of 6.
    // Then divide 12 by 6 to get a remainder of 0, which means that 6 is the gcd.
    public int gcd(int a, int b) {
        if (a == 0 || b == 0) return Math.max(a, b);
        return gcdHelper(Math.max(a, b), Math.min(a, b));
    }

    private int gcdHelper(int n, int prevRemainder) {
        int remainder = n % prevRemainder;
        if (remainder == 0) return prevRemainder;
        return gcdHelper(prevRemainder, remainder);
    }

}
