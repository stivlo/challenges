package arrays.max_non_adjecent_sum;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * Given a list of integers, write a function that returns the largest sum of non-adjacent numbers.
 * Numbers can be 0 or negative.
 *
 * For example, [2, 4, 6, 2, 5] should return 13, since we pick 2, 6, and 5. [5, 1, 1, 5] should
 * return 10, since we pick 5 and 5.
 */
public class Solution {

    private int maxSum(int[] nums) {
        int incl = 0;
        int excl = 0;
        for (int n : nums) {
            int prevExcl = excl;
            excl = Math.max(excl, incl);
            incl = Math.max(incl, prevExcl + n);
        }
        return Math.max(incl, excl);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.maxSum(new int[]{4, 1, 1, 4, 2, 1}), is(9));
        assertThat(solution.maxSum(new int[]{2, 4, 6, 2, 5}), is(13));
        assertThat(solution.maxSum(new int[]{}), is(0));
        assertThat(solution.maxSum(new int[]{5, 1, 1, 5}), is(10));
        assertThat(solution.maxSum(new int[]{1, -100, 20, 100}), is(101));
    }
}
