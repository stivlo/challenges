package math.prime_numbers;

import java.util.ArrayList;

// https://www.interviewbit.com/problems/prime-numbers/
public class Solution {
    public ArrayList<Integer> sieve(int A) {
        ArrayList<Integer> result = new ArrayList<>();
        boolean[] notPrime =  new boolean[A + 1];
        for (int i = 2; i * i <= A; i++) {
            for (int j = i + i; j <= A; j += i) {
                notPrime[j] = true;
            }
        }
        for (int i = 2; i <= A; i++) {
            if (!notPrime[i]) result.add(i);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sieve(100));
    }
}
