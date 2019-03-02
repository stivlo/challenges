package math.prime_sum;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

// https://www.interviewbit.com/problems/prime-sum/
public class Solution {

    public ArrayList<Integer> primesum(int a) {
        List<Integer> primes = findPrimes(a);
        return findPrimePair(a, primes);
    }

    private List<Integer> findPrimes(int n) {
        boolean[] isPrime = new boolean[n];
        for (int i = 2; i < n; i++) isPrime[i] = true;
        for (int i = 2; i * i < n; i++) {
            if (isPrime[i]) {
                for (int k = 2 * i; k < n; k += i) {
                    isPrime[k] = false;
                }
            }
        }
        List<Integer> primes = new ArrayList<>();
        for (int i = 1; i < n; i++) {
            if (isPrime[i]) primes.add(i);
        }
        return primes;
    }

    private ArrayList<Integer> findPrimePair(int a, List<Integer> primes) {
        Set<Integer> primeSet = new HashSet<>(primes);
        for (int firstPrime : primes) {
            int second = a - firstPrime;
            if (primeSet.contains(second)) {
                ArrayList<Integer> result = new ArrayList<>();
                result.add(firstPrime);
                result.add(second);
                return result;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        System.out.println(new Solution().findPrimes(50));
        for (int i = 2; i < 50; i += 2) {
            System.out.println(i + ": " + new Solution().primesum(i));
        }
    }

}
