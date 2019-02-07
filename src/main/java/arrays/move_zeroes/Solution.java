package arrays.move_zeroes;

// move zeroes
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/567/
class Solution {

    public void moveZeroes(int[] nums) {
        int zp = nums.length;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0 && zp == nums.length) zp = i;
            if (nums[i] != 0 && zp < i) {
                nums[zp++] = nums[i];
                nums[i] = 0;
            }
        }
    }

}