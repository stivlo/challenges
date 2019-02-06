package arrays.remove_duplicates;

// remove duplicates from sorted array
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/727/
class Solution {
    public int removeDuplicates(int[] nums) {
        int len = nums.length;
        for (int i = 1; i < len; i++) {
            while (nums[i - 1] == nums[i] && len > i) {
                len = removeElement(nums, i - 1, len);
            }
        }
        return len;
    }

    private int removeElement(int[] nums, int pos, int len) {
        for (int i = pos; i < len - 1; i++) {
            nums[i] = nums[i + 1];
        }
        return len - 1;
    }
}
