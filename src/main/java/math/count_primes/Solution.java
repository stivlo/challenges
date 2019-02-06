package math.count_primes;

// count primes
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/102/math/744/
class Solution {

    public int countPrimes(int n) {
        int nPrimes = 0;
        if (n > 2) nPrimes++;
        for (int i = 3; i < n; i += 2) {
            if (isOddNumberPrime(i)) nPrimes++;
        }
        return nPrimes;
    }

    private boolean isOddNumberPrime(int n) {
        int max = (int) Math.sqrt(n);
        for (int i = 3; i <= max; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

}