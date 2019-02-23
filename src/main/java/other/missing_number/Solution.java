package other.missing_number;

// https://leetcode.com/explore/interview/card/top-interview-questions-easy/99/others/722/
public class Solution {
    public int missingNumber(int[] nums) {
        bucketSort(nums);
        return findMissing(nums);
    }

    private int findMissing(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i) return i;
        }
        return nums.length;
    }

    private void bucketSort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] >= 0 && nums[i] < nums.length && nums[i] != i) swap(nums, i, nums[i]);
        }
    }

    private void swap(int[] nums, int i, int j) {
        int numsI = nums[i];
        nums[i] = nums[j];
        nums[j] = numsI;
    }
}
