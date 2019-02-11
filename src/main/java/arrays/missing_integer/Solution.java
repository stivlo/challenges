package arrays.missing_integer;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

class Solution {

    public int firstMissingPositive(int[] nums) {
        bucketSort(nums);
        for (int i = 0; i < nums.length; i++)
            if (nums[i] != i + 1) return i + 1;
        return nums.length + 1;
    }

    private void bucketSort(int[] nums) {
        for (int i = 0; i < nums.length; i++)
            while (nums[i] > 0 && nums[i] <= nums.length && nums[i] != i + 1 && nums[nums[i] - 1] != nums[i])
                swap(nums, i, nums[i] - 1);
    }

    private void swap(int[] nums, int a, int b) {
        int temp = nums[b];
        nums[b] = nums[a];
        nums[a] = temp;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        assertThat(solution.firstMissingPositive(new int[]{1, 2, 0}), is(3));
        assertThat(solution.firstMissingPositive(new int[]{3, 4, -1, 1}), is(2));
        assertThat(solution.firstMissingPositive(new int[]{7, 8, 9, 11, 12}), is(1));
        assertThat(solution.firstMissingPositive(new int[]{-1, 4, 2, 1, 9, 10}), is(3));
        assertThat(solution.firstMissingPositive(new int[]{-3, 9, 16, 4, 5, 16, -4, 9, 26, 2,
                1, 19, -1, 25, 7, 22, 2, -7, 14, 2, 5, -6, 1, 17, 3, 24, -4, 17, 15}), is(6));
        assertThat(solution.firstMissingPositive(new int[]{99, 94, 96, 11, 92, 5, 91, 89, 57,
                85, 66, 63, 84, 81, 79, 61, 74, 78, 77, 30, 64, 13, 58, 18, 70, 69, 51, 12,
                32, 34, 9, 43, 39, 8, 1, 38, 49, 27, 21, 45, 47, 44, 53, 52, 48, 19, 50, 59,
                3, 40, 31, 82, 23, 56, 37, 41, 16, 28, 22, 33, 65, 42, 54, 20, 29, 25, 10,
                26, 4, 60, 67, 83, 62, 71, 24, 35, 72, 55, 75, 0, 2, 46, 15, 80, 6, 36, 14,
                73, 76, 86, 88, 7, 17, 87, 68, 90, 95, 93, 97, 98}), is(100));
        assertThat(solution.firstMissingPositive(new int[]{1, 1}), is(2));
    }

}