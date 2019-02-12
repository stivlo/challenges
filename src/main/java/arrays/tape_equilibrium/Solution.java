package arrays.tape_equilibrium;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/3-time_complexity/tape_equilibrium/
public class Solution {
    public int solution(int[] a) {
        int minDiff = Integer.MAX_VALUE;
        int totSum = sum(a);
        int leftSum = 0;
        for (int p = 1; p < a.length; p++) {
            leftSum += a[p - 1];
            int diff = Math.abs(2 * leftSum - totSum);
            if (diff < minDiff) minDiff = diff;
        }
        return minDiff;
    }

    private int sum(int[] nums) {
        int sum = 0;
        for (int num : nums) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        assertThat(new Solution().solution(new int[]{1, 1}), is(0));
        assertThat(new Solution().solution(new int[]{3, 1, 2, 4, 3}), is(1));
    }
}
