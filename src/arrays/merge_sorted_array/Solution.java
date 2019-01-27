package arrays.merge_sorted_array;

/**
 * https://leetcode.com/explore/interview/card/top-interview-questions-easy/96/sorting-and-searching/587/
 */
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int i1 = 0;
        for (int i2 = 0; i2 < n; i2++) {
            while (i1 < m && nums1[i1] <= nums2[i2]) i1++;
            insertAt(nums1, nums2[i2], i1, m++);
        }
    }

    private void insertAt(int[] nums, int num, int i1, int m) {
        for (int i = m; i > i1; i--) nums[i] = nums[i - 1];
        nums[i1] = num;
    }
}