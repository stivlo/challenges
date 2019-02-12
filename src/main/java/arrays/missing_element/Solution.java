package arrays.missing_element;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

public class Solution {
    public int solution(int[] nums) {
        long len = nums.length;
        long sumWithMissing = (len + 1) * (len + 2) / 2;
        long actualSum = sum(nums);
        return (int) (sumWithMissing - actualSum);
    }

    private long sum(int[] nums) {
        long sum = 0L;
        for (int num : nums) sum += num;
        return sum;
    }

    public static void main(String[] args) {
        assertThat(new Solution().solution(new int[]{}), is(1));
        assertThat(new Solution().solution(new int[]{2, 3, 1, 5}), is(4));
    }
}
