package arrays.two_sum;

import java.util.HashMap;
import java.util.Map;

// Two Sum
// https://leetcode.com/explore/interview/card/top-interview-questions-easy/92/array/546/
class Solution {

    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            Integer complementIdx = numMap.get(complement);
            if (complementIdx != null) {
                return new int[]{complementIdx, i};
            }
            numMap.put(nums[i], i);
        }
        throw new IllegalArgumentException("Invalid Input");
    }
}