package arrays.counting_elements;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

// https://app.codility.com/programmers/lessons/4-counting_elements/perm_check/
public class Solution {

    public int solution(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                swap(nums,  i, nums[i] - 1);
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) return 0;
        }
        return 1;
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        assertThat(new Solution().solution(new int[]{3, 7, 2, 4, 6, 1, 5}), is(1));
        assertThat(new Solution().solution(new int[]{3, 7, 2, 4, 6, 1, 34}), is(0));
        assertThat(new Solution().solution(new int[]{4, 1, 3}), is(0));
    }

}
