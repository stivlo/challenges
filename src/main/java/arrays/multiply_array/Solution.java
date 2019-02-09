package arrays.multiply_array;

import java.util.Arrays;

/**
 * Given an array of integers, return a new array such that each element
 * at index i of the new array is the product of all the numbers in the
 * original array except the one at i.
 *
 * For example, if our input was [1, 2, 3, 4, 5], the expected output
 * would be [120, 60, 40, 30, 24]. If our input was [3, 2, 1], the
 * expected output would be [2, 3, 6].
 *
 * Follow-up: what if you can't use division?
 */
public class Solution {

    public int[] multiply(int[] nums) {
        int[] fromHead = new int[nums.length];
        int[] fromTail = new int[nums.length];
        int acc = 1;
        for (int i = 0; i < nums.length; i++) {
            acc *= nums[i];
            fromHead[i] = acc;
        }
        acc = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            acc *= nums[i];
            fromTail[i] = acc;
        }
        int[] res = new int[nums.length];
        for (int i = 0; i < nums.length; i++) {
            int el = 1;
            if (i - 1 >= 0) el = fromHead[i - 1];
            if (i + 1 < nums.length) el *= fromTail[i + 1];
            res[i] = el;
        }
        return res;
    }

    public static void main(String[] args) {
        Solution instance = new Solution();
        System.out.println(Arrays.toString(instance.multiply(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(instance.multiply(new int[]{3, 2, 1})));
    }
}
