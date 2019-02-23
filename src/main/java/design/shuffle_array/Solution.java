package design.shuffle_array;

import java.util.Arrays;
import java.util.Random;

class Solution {

    private int[] nums;
    private Random random = new Random();

    public Solution(int[] nums) {
        this.nums = nums;
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        int[] dest = Arrays.copyOf(nums, nums.length);
        for (int i = dest.length - 1; i > 0; i--) {
            int k = random.nextInt(i + 1);
            swap(dest, i, k);
        }
        return dest;
    }

    private void swap(int[] nums, int i, int k) {
        if (i != k) {
            int temp = nums[i];
            nums[i] = nums[k];
            nums[k] = temp;
        }
    }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */